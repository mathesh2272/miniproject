package com.kce.sport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kce.sport.bean.BattingDetails;
import com.kce.sport.connect.DatabaseConnection;

public class BattingDAO {
	static Connection connect = DatabaseConnection.DataConnection();
	static PreparedStatement ps;
	static ResultSet rs;
	static Statement st;

	public static List<BattingDetails> displayAllPlayerBattingDetails() {
		List<BattingDetails> list = new ArrayList<>();
		String query = "select * from batting";
		try {
			ps = connect.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new BattingDetails(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void displayOnePlayerBattingDetail(BattingDetails batting) {
		try {
			int temp = batting.getJerseyNumber();
			String query = "select * from  batting where jerseynumber=?";
			ps = connect.prepareStatement(query);
			ps.setInt(1, temp);
			rs = ps.executeQuery();
			if (!rs.next()) {
				System.err.println("Please, Enter the correct Jersey Number to search..");
			} else {
				System.out.println(
						"**********************************************************************************************************************************************************************************************************************************");

				System.out.format("\t\t%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Player Name",
						"Jersey Number", "Matches", "Runs", "Highest Score", "Strike Rate", "Hundred", "Fifty", "Sixes",
						"Fours");
				System.out.println(
						"**********************************************************************************************************************************************************************************************************************************");
				System.out.format("\t\t%-20s%-20d%-20d%-20d%-20d%-20.2f%-20d%-20d%-20d%-20d\n", rs.getString(1),
						rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getFloat(6), rs.getInt(7),
						rs.getInt(8), rs.getInt(9), rs.getInt(10));
				System.out.println(
						"**********************************************************************************************************************************************************************************************************************************");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertBattingDetail(BattingDetails bat) {
		String query = "insert into batting values(?,?,?,?,?,?,?,?,?,?)";
		try {
			st = connect.createStatement();
			rs = st.executeQuery("select jerseynumber from batting where playername='" + bat.getName() + "'");
			if (rs.next()) {
				System.out.println();
				System.out.println();
				System.out.println("Player details already exists...");
				System.out.println();
				System.out.println();
				System.out.println();
			} else {
				ps = connect.prepareStatement(query);
				ps.setString(1, bat.getName());
				ps.setInt(2, bat.getJerseyNumber());
				ps.setInt(3, bat.getMatches());
				ps.setInt(4, bat.getRuns());
				ps.setInt(5, bat.getHighestScore());
				ps.setFloat(6, bat.getStrikeRate());
				ps.setInt(7, bat.getHundered());
				ps.setInt(8, bat.getFifty());
				ps.setInt(9, bat.getSixes());
				ps.setInt(10, bat.getFifty());
				ps.execute();
				System.out.println();
				System.out.println("\t\tPlayer batting details inserted succesfully...");
				System.out.println();
				System.out.println();
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateBattingDetails(BattingDetails batupdate) {
		try {
			st = connect.createStatement();
			rs = st.executeQuery("select * from batting where playername = '" + batupdate.getName() + "'");
			if (rs.next()) {
				ps = connect.prepareStatement("select highestscore from batting where playername = ?");
				ps.setString(1, batupdate.getName());
				rs = ps.executeQuery();
				rs.next();
				int score = rs.getInt(1);
				int high = batupdate.getRuns();
				if (high > score) {
					score = high;
				}
				ps = connect.prepareStatement(
						"update batting set matches = matches + ?, runs = runs + ?, hundred = hundred + ?, fifty = fifty + ?, sixes = sixes + ?, fours = fours + ? where playername = ? ");
				ps.setInt(1, 1);
				ps.setInt(2, batupdate.getRuns());
				ps.setInt(3, batupdate.getHundered());
				ps.setInt(4, batupdate.getFifty());
				ps.setInt(5, batupdate.getSixes());
				ps.setInt(6, batupdate.getFours());
				ps.setString(7, batupdate.getName());
				ps.execute();
				ps = connect.prepareStatement("update bowling set matches = matches + ? where playername = ?");
				ps.setInt(1, 1);
				ps.setString(2, batupdate.getName());
				ps.execute();
				System.out.println("\t\tSuccessfully updated player batting details");
			} else {
				System.out.println();
				System.out.println();
				System.out.println("\t\tPlease,Enter correct details to update player batting details");
				System.out.println();
				System.out.println();
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
