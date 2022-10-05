package com.colsubsidio.dotaciones.scheduled.config.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import lombok.extern.slf4j.Slf4j;


@Slf4j
public class JdbcUtil {
	
	public static void closeAll(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException ex) {
			log.error(JdbcUtil.class.getName() + "; closeAll; " + ex.getMessage());
		}
	}

}
