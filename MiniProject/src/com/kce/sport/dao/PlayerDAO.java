package com.kce.sport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kce.sport.bean.Player;
import com.kce.sport.connect.DatabaseConnection;

public class PlayerDAO {
	static Connection connect = DatabaseConnection.DataConnection();
	static PreparedStatement ps;
	static ResultSet rs;
	static Statement st;

	public static void displayAllPlayerDetails() {
		String query = "select * from player";
		try {
			ps = connect.prepareStatement(query);
			rs = ps.executeQuery();
			System.out.println(
					"*********************************************************************************************************"
							+ "********************************************************************************************************"
							+ "************************************");

			System.out.format("\t\t%-20s%-20s%-20s%-20s%-20s%-35s%-20s%-20s%-20s%-20s\n", "Player Name", "Birth Place",
					"Age", "Jersey Number", "Batting Type", "Bowling Type", "Role", "ICC Batting Rank",
					"ICC Bowling Type", "Status");
			System.out.println(
					"**********************************************************************************************************"
							+ "**********************************************************************************************************"
							+ "*********************************");

			while (rs.next()) {
				System.out.format("\t\t%-20s%-20s%-20d%-20d%-20s%-35s%-20s%-20d%-20d%-20s\n", rs.getString(1),
						rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getInt(8), rs.getInt(9), rs.getString(10));
			}
			System.out.println(
					"***********************************************************************************************************"
							+ "*********************************************************************************************************"
							+ "*********************************");
			System.out.println();
			System.out.println();
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void displayOnePlayerDetail(Player player) {
		try {
			int temp = player.getJerseyNumber();
			String query = "select * from  player where jerseynumber=?";
			ps = connect.prepareStatement(query);
			ps.setInt(1, temp);
			rs = ps.executeQuery();
			boolean flag = rs.next();
			if (!flag) {
				System.err.println("Please, Enter correct Jersey Number to search..");
			} else {
				System.out.println(
						"**********************************************************************************************************************************************************************************************************************************");

				System.out.format("\t\t%-20s%-20s%-20s%-20s%-20s%-35s%-20s%-20s%-20s%-20s\n", "Player Name",
						"Birth Place", "Age", "Jersey Number", "Batting Type", "Bowling Type", "Role",
						"ICC Batting Rank", "ICC Bowling Type", "Status");
				System.out.println(
						"**********************************************************************************************************************************************************************************************************************************");

				System.out.format("\t\t%-20s%-20s%-20d%-20d%-20s%-35s%-20s%-20d%-20d%-20s\n", rs.getString(1),
						rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getInt(8), rs.getInt(9), rs.getString(10));
				System.out.println(
						"**********************************************************************************************************************************************************************************************************************************");

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void insertPlayerDetails(Player insert) {
		String query = "insert into player values (?,?,?,?,?,?,?,?,?,?)";
		try {
			String check = "select jerseynumber from player where jerseynumber='" + insert.getJerseyNumber() + "'";
			st = connect.createStatement();
			rs = st.executeQuery(check);
			if (rs.next()) {
				System.out.println();
				System.out.println();
				System.out.println("\t\tPlayer Already Exists!!!!");
				System.out.println();
				System.out.println();
				System.out.println();
			} else {
				ps = connect.prepareStatement(query);
				ps.setString(1, insert.getPlayerName());
				ps.setString(2, insert.getBirthPlace());
				ps.setInt(3, insert.getAge());
				ps.setInt(4, insert.getJerseyNumber());
				ps.setString(5, insert.getBattingType());
				ps.setString(6, insert.getBowlingType());
				ps.setString(7, insert.getRole());
				ps.setInt(8, insert.getICCBattingRank());
				ps.setInt(9, insert.getICCBowlingRank());
				ps.setString(10, insert.getStatus());
				ps.execute();
				System.out.println();
				System.out.println();
				System.out.println("\t\tSuccessfully player details inserted");
				System.out.println();
				System.out.println();
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updatePlayerDetail(Player update) {
		try {
			String check = "select teamname from cricket where teamname='" + update.getPlayerName() + "'";
			st = connect.createStatement();
			rs = st.executeQuery(check);
			if (!rs.next()) {
				System.out.println();
				System.out.println();
				System.out.println("\t\tPlease,Enter correct details to update details of the player");
				System.out.println();
				System.out.println();
				System.out.println();
			} else {
				ps = connect.prepareStatement(
						"update player set age = ?, iccbattingrank = ?, iccbowlingrank = ?, playerstatus = ? where playername = ?");
				ps.setInt(1, update.getAge());
				ps.setInt(2, update.getICCBattingRank());
				ps.setInt(3, update.getICCBowlingRank());
				ps.setString(4, update.getStatus());
				ps.setString(5, update.getPlayerName());
				ps.execute();
				System.out.println();
				System.out.println("\t\tSuccessfully updated player details..");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}
}
