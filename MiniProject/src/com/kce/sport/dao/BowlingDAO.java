package com.kce.sport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kce.sport.bean.BowlingDetails;
import com.kce.sport.connect.DatabaseConnection;

public class BowlingDAO {
	static Connection connect = DatabaseConnection.DataConnection();
	static PreparedStatement ps;
	static ResultSet rs;
	static Statement st;

	public static List<BowlingDetails> displayAllPlayerBowlingDetails() {
		List<BowlingDetails> list = new ArrayList<>();
		String query = "select * from bowling";
		try {
			ps = connect.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new BowlingDetails(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5),
						rs.getInt(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void displayOnePlayerBowlingDetail(BowlingDetails bowling) {
		try {
			int temp = bowling.getJerseyNumber();
			String query = "select * from  bowling where jerseynumber=?";
			ps = connect.prepareStatement(query);
			ps.setInt(1, temp);
			rs = ps.executeQuery();
			if (!rs.next()) {
				System.err.println("Please, Enter correct Jersey Number to search..");
			} else {
				System.out.println(
						"************************************************************************************************************************************************************************");
				System.out.format("\t\t%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Player Name", "Jersey Number",
						"Matches", "Wickets", "Econamy", "Five Wickets", "Best Figure");
				System.out.println(
						"************************************************************************************************************************************************************************");
				System.out.format("\t\t%-20s%-20d%-20d%-20d%-20.2f%-20d%-20s\n", rs.getString(1), rs.getInt(2),
						rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6), rs.getString(7));
				System.out.println(
						"************************************************************************************************************************************************************************");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertBowlingDetails(BowlingDetails bowl) {
		String query = "insert into bowling values(?,?,?,?,?,?,?)";
		try {
			st = connect.createStatement();
			rs = st.executeQuery("select jerseynumber from bowling where playername='" + bowl.getName() + "'");
			if (rs.next()) {
				System.out.println("\t\tAlready player bowling exists...");
				System.out.println();
				System.out.println();
				System.out.println();
			} else {
				ps = connect.prepareStatement(query);
				ps.setString(1, bowl.getName());
				ps.setInt(2, bowl.getJerseyNumber());
				ps.setInt(3, bowl.getMatches());
				ps.setInt(4, bowl.getWickets());
				ps.setFloat(5, bowl.getEconamy());
				ps.setInt(6, bowl.getFiveWickets());
				ps.setString(7, bowl.getBestFigure());
				ps.execute();
				System.out.println("\t\tSuccesfully player bowling details...");
				System.out.println();
				System.out.println();
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateBowlingDetails(BowlingDetails bowlUpdate, String temp, int runs) {
		try {
			st = connect.createStatement();
			rs = st.executeQuery("select * from bowling where playername = '" + bowlUpdate.getName() + "'");
			if (rs.next()) {
				String best = "select bestfigure from bowling where playername = '" + bowlUpdate.getName() + "'";
				rs = st.executeQuery(best);
				rs.next();
				String figure = rs.getString(1);
				String change = "";
				if (figure.equals("-")) {
					change = "-";
				}
				String[] arr = figure.split("/");
				if (Integer.parseInt(arr[0]) < bowlUpdate.getWickets()) {
					change = String.valueOf(bowlUpdate.getWickets() + "/" + runs);
				} else {
					change = figure;
				}
				ps = connect.prepareStatement(
						"update bowling set wickets = wickets +  ?, bestfigure = ? ,econamy = econamy + ? where playername=?");
				ps.setInt(1, bowlUpdate.getWickets());
				ps.setString(2, change);
				ps.setFloat(3, (float) Math.random() - 0.09f);
				ps.setString(3, bowlUpdate.getName());
				ps.execute();
				System.out.println("\t\tSuccessfully updated player bowling detials");
				System.out.println();
				System.out.println();
			} else {
				System.out.println();
				System.out.println();
				System.out.println("\t\tPlease,Enter correct details to update player bowling details");
				System.out.println();
				System.out.println();
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}
}
