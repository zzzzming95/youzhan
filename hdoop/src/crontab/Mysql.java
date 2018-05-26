package crontab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dbc.JdbcUtil;

public class Mysql {
	public static void main(String[] args) throws Exception {
		JdbcUtil j = new JdbcUtil();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		try {
			conn = j.getConnection();
			preparedStatement = conn.prepareStatement("Select cityid from graded group by cityid");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				preparedStatement = conn.prepareStatement("Select * from graded where cityid="+rs.getString(1)+"fields terminated by ',' optionally enclosed by '\"' escaped by '\"' lines terminated by '\r\n'");
				rs1 = preparedStatement.executeQuery();
				while(rs1.next()){
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			j.free(rs, preparedStatement, conn);
		}
	}
}
