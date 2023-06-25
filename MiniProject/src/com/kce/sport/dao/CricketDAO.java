package com.kce.sport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kce.sport.bean.Cricket;
import com.kce.sport.connect.DatabaseConnection;

public class CricketDAO {
	static Connection connect = DatabaseConnection.DataConnection();
	static PreparedStatement ps;
	static ResultSet rs;
	static Statement st;

	public static List<Cricket> DisplayRecordsForUser() {
		String query = "select * from cricket";
		List<Cricket> list = new ArrayList<>();
		try {
			ps = connect.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Cricket(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void InsertTeam(Cricket cricket) {
		String query = "insert into Cricket values(?,?,?,?)";
		try {
			String check = "select teamname from cricket where teamname='" + cricket.getTeamName() + "'";
			st = connect.createStatement();
			rs = st.executeQuery(check);
			if (rs.next()) {
				System.out.println();
				System.out.println();
				System.out.println("\t\tPlease,Enter correct details\n\t\tTeamName Already Exists");
				System.out.println();
				System.out.println();
				System.out.println();
			} else {
				ps = connect.prepareStatement(query);
				ps.setString(1, cricket.getTeamName());
				ps.setInt(2, cricket.getWorldCupTest());
				ps.setInt(3, cricket.getWorldCupODI());
				ps.setInt(4, cricket.getWorldCupT20());
				ps.execute();
				System.out.println("-> -> -> -> Inserted Team Details successfully.....");

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void UpdateTeam(Cricket cricket) {
		try {
			String check = "select teamname from cricket where teamname='" + cricket.getTeamName() + "'";
			st = connect.createStatement();
			rs = st.executeQuery(check);
			System.out.println();
			if (!rs.next()) {
				System.out.println();
				System.out.println("\t\t\tPlease, Enter correct Team Name..");
				System.out.println("");
				System.out.println();
				System.out.println();
			} else {
				String update = "update cricket set worldcuptest = worldcuptest + ?, worldcupodi = worldcupodi + ?, worldt20 = worldt20 + ? where teamName = ?";
				ps = connect.prepareStatement(update);
				ps.setInt(1, cricket.getWorldCupTest());
				ps.setInt(2, cricket.getWorldCupODI());
				ps.setInt(3, cricket.getWorldCupT20());
				ps.setString(4, cricket.getTeamName());
				ps.execute();
				System.out.println();
				System.out.println("\t\t\tUpdate team detail successfully");
				System.out.println();
				System.out.println();
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
