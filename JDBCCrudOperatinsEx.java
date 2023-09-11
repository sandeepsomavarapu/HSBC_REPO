package com.hsbc.jdbcex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCCrudOperatinsEx {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// load the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		// create the connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hsbc", "root", "rpsconsulting");
		// create the statement
		Statement stmt = conn.createStatement();
		// execute the query DDL-->execute(),DML-->executeUpdate(),DRL-->executeQuery()
		// boolean result = stmt.execute("create table emps(eid int,ename
		// varchar(10),esal int)");

		// int result = stmt.executeUpdate("insert into emps
		// values(123,'mahesh',23232)");

//		int result = stmt.executeUpdate("update emps set ename='suresh' where eid=123");

//		int result = stmt.executeUpdate("delete from emps where eid=123");
		// close the connection

		ResultSet rs = stmt.executeQuery("select * from emps");

		while (rs.next()) {

			System.out.println(rs.getInt(1) + " " + rs.getString("ename") + " " + rs.getInt(3));
		}

		conn.close();

	}

}
