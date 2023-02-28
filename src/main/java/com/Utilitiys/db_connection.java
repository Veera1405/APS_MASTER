package com.Utilitiys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.Constant.Aps_project_constant;

public class db_connection {
	static Logger log = Logger.getLogger(db_connection.class);

	/* download the mssql-jdbc_auth-12.2.0.x64.dll and past in java bin folder */

	@Test
	public void name() throws Exception {

		String connectionUrl = Aps_project_constant.connectionUrl;
		String driver = Aps_project_constant.DBdriver;
		Connection connection = null;
		Statement statement = null;
		ResultSet Rs = null;

		try {
			Class.forName(driver);

			connection = DriverManager.getConnection(connectionUrl);
			System.out.println("connection established");
			log.info("connection established");
			statement = connection.createStatement();
			String SQL = "select * from [dbo].[Persons]";

			Rs = statement.executeQuery(SQL);
			while (Rs.next()) {
				System.out.println(Rs.getString(1) + " " + Rs.getString(2) + " " + Rs.getString(3) + " "
						+ Rs.getString(4) + " " + Rs.getString(5));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			log.error("error" + e);

		}
	}

	public static void main(String[] args) throws Exception {
		db_connection a = new db_connection();
		a.name();
	}
}
