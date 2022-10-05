package com.colsubsidio.dotaciones.scheduled.config;


import java.io.IOException;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

@Component
public class TokenFilter implements Filter {

	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";
	// private final String SECRET = "mySecretKey";

	@Value("${jwt.privateKey}")
	String privateKey;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest requestHttp = (HttpServletRequest) request;
		HttpServletResponse responseHttp = (HttpServletResponse) response;

		String pathInfo = ((HttpServletRequest) request).getRequestURI();
		if (!pathInfo.contains("login")) {

			try {

				if (existeJWTToken(requestHttp, responseHttp)) {
					Claims claims = validateToken(requestHttp);
					if (claims.get("authorities") != null) {
						setUpSpringAuthentication(claims);
					} else {
						SecurityContextHolder.clearContext();
					}
				} else {
					SecurityContextHolder.clearContext();
				}

			} catch (ExpiredJwtException e) {
				chain.doFilter(request, response);
			}

		} else {
			chain.doFilter(request, response);
			return;
		}

		chain.doFilter(request, response);

	}

	private void setUpSpringAuthentication(Claims claims) {

		List<String> authorities = (List) claims.get("authorities");

		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
				authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
		SecurityContextHolder.getContext().setAuthentication(auth);

	}

	private Claims validateToken(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		return Jwts.parser().setSigningKey(privateKey.getBytes()).parseClaimsJws(jwtToken).getBody();
	}

	private boolean existeJWTToken(HttpServletRequest request, HttpServletResponse res) {
		String authenticationHeader = request.getHeader(HEADER);
		if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
			return false;
		return true;
	}
}
