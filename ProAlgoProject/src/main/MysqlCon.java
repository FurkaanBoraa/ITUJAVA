package main;

import java.sql.*;

class MysqlCon {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/game", "root", "");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from `scores`");
			while (rs.next())
				System.out.println(rs);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}