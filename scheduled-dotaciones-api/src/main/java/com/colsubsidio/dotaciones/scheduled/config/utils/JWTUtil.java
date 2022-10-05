package com.colsubsidio.dotaciones.scheduled.config.utils;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.colsubsidio.dotaciones.scheduled.config.exceptions.DotacioneExeption;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	
	
	@Value("${jwt.privateKey}")
	String privateKey;
	
	
	public  String getJWTToken(String username,String[] roles) {
		
		//List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		
	for(String rol :  roles) {
		grantedAuthorities.add(new SimpleGrantedAuthority(rol));
	}
		
					
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 12000000))
				.signWith(SignatureAlgorithm.HS512,
						privateKey.getBytes()).compact();

		return "Bearer " + token;
	}
	
	
	public String getUsernameFromRequest(HttpServletRequest req) {
		String userName;
		try {
			 String token = req.getHeader(ValidationParameters.HEADER_STRING).replace(ValidationParameters.TOKEN_PREFIX,"");
			 userName = getClaimFromToken(token, Claims::getSubject);
		}catch (Exception e) {
			throw new DotacioneExeption(e.getMessage(), this.getClass().getName(),"getUsernameFromRequest() ","Error con el usuario");
		}	
	    return userName;
	}
	
	public String getUsernameFromToken(String token) {
	    return getClaimFromToken(token, Claims::getSubject);
	}

	public Date getExpirationDateFromToken(String token) {
	    return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
	    final Claims claims = getAllClaimsFromToken(token);
	    return claimsResolver.apply(claims);
	}



	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(privateKey.getBytes()).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
	    final Date expiration = getExpirationDateFromToken(token);
	    return expiration.before(new Date());
	}


}
