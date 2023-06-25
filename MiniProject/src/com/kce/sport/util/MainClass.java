package com.kce.sport.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.kce.sport.bean.BattingDetails;
import com.kce.sport.bean.BowlingDetails;
import com.kce.sport.bean.Cricket;
import com.kce.sport.bean.Player;
import com.kce.sport.dao.BattingDAO;
import com.kce.sport.dao.BowlingDAO;
import com.kce.sport.dao.CricketDAO;
import com.kce.sport.dao.PlayerDAO;

public class MainClass {
	public static void main(String[] args) {
		Scanner mk = new Scanner(System.in);
		System.out.println("Enter the Login Type : ");
		String login = mk.next();
		int count = 0;

		if (login.equalsIgnoreCase("Admin")) {
			while (true) {
				System.out.println("Enter the password :");
				String pass = mk.next();
				System.out.println();
				if (pass.equals("Admin@2004")) {
					while (true) {
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println(
								"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWelcome to Admin Login");
						System.out.println(
								"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.println("\t\t\t\t\t\t\t\t\t\t\t1. Insert Cricket Team Details");
						System.out.println("\t\t\t\t\t\t\t\t\t\t\t2. Update Cricket Team Details");
						System.out.println("\t\t\t\t\t\t\t\t\t\t\t3. Insert Player Details");
						System.out.println("\t\t\t\t\t\t\t\t\t\t\t4. Update Player Details");
						System.out.println("\t\t\t\t\t\t\t\t\t\t\t5. Insert Player Batting Details");
						System.out.println("\t\t\t\t\t\t\t\t\t\t\t6. Update Player Batting Details");
						System.out.println("\t\t\t\t\t\t\t\t\t\t\t7. Insert Player Bowling Details");
						System.out.println("\t\t\t\t\t\t\t\t\t\t\t8. Update Player Bowling Details");
						System.out.println("\t\t\t\t\t\t\t\t\t\t\t9. Enter 9  to exit the menu");
						System.out.println(
								"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.println();
						System.out.println();
						System.out.println("Enter the choice to insert and update the details of the player :");
						int adminChoce = mk.nextInt();
						System.out.println();
						System.out.println();
						switch (adminChoce) {
						case 1:
							Cricket insert = new Cricket();
							System.out.println("Enter the team name to add in database :");
							insert.setTeamName(mk.nextLine() + mk.nextLine());
							System.out.println();
							System.out.println("Enter 0 or 1 whether the team win world cup Test or not");
							insert.setWorldCupTest(mk.nextInt());
							System.out.println();
							System.out.println("Enter 0 or 1 whether the team win world cup ODI or not");
							insert.setWorldCupODI(mk.nextInt());
							System.out.println();
							System.out.println("Enter 0 or 1 whether the team win world cup T20 or not");
							insert.setWorldCupT20(mk.nextInt());
							CricketDAO.InsertTeam(insert);
							break;
						case 2:
							Cricket update = new Cricket();
							System.out.println("Enter the team name to add in database :");
							update.setTeamName(mk.nextLine() + mk.nextLine());
							System.out.println();
							System.out.println("Enter 0 or 1 whether the team win world cup Test or not");
							update.setWorldCupTest(mk.nextInt());
							System.out.println();
							System.out.println("Enter 0 or 1 whether the team win world cup ODI or not");
							update.setWorldCupODI(mk.nextInt());
							System.out.println();
							System.out.println("Enter 0 or 1 whether the team win world cup T20 or not");
							update.setWorldCupT20(mk.nextInt());
							CricketDAO.UpdateTeam(update);
							break;
						case 3:
							Player play = new Player();
							System.out.println("Enter player name : ");
							play.setPlayerName(mk.nextLine() + mk.nextLine());
							System.out.println("Enter player birth place : ");
							play.setBirthPlace(mk.nextLine());
							System.out.println("Enter player age : ");
							play.setAge(mk.nextInt());
							// Jersey Number can't be duplicate
							System.out.println("Enter player jersey number : ");
							play.setJerseyNumber(mk.nextInt());
							System.out.println("Enter player batting style : ");
							play.setBattingType(mk.nextLine() + mk.nextLine());
							System.out.println("Enter player bowling style : ");
							play.setBowlingType(mk.nextLine());
							System.out.println("Enter player role : ");
							play.setRole(mk.nextLine());
							System.out.println("Enter player ICCBattingRank : ");
							play.setICCBattingRank(mk.nextInt());
							System.out.println("Enter player ICCBowlingRank  : ");
							play.setICCBowlingRank(mk.nextInt());
							System.out.println("Enter player status : ");
							play.setStatus(mk.next());
							PlayerDAO.insertPlayerDetails(play);
							System.out.println();
							break;
						case 4:
							Player playUpdate = new Player();
							System.out.println("Enter the player name to update : ");
							playUpdate.setPlayerName(mk.nextLine() + mk.nextLine());
							System.out.println("Enter the player age(if the age doesn't change enter same age) : ");
							playUpdate.setAge(mk.nextInt());
							System.out.println("Enter the ICC batting rank(if doesn't change enter same rank) : ");
							playUpdate.setICCBattingRank(mk.nextInt());
							System.out.println(
									"Enter the ICC bowling rank(if doesn't change enter same rank || if a player not a bowler, enter 0) : ");
							playUpdate.setICCBowlingRank(mk.nextInt());
							System.out.println("Enter player status(Active / Retire) :");
							playUpdate.setStatus(mk.next());
							PlayerDAO.updatePlayerDetail(playUpdate);
							break;
						case 5:
							System.out.println();
							BattingDetails bat = new BattingDetails();
							System.out.println("Enter player name : ");
							bat.setName(mk.nextLine() + mk.nextLine());
							// Jersey Number can't be duplicate
							System.out.println("Enter player jersey number : ");
							bat.setJerseyNumber(mk.nextInt());
							System.out.println("Enter the Number of matches played : ");
							bat.setMatches(mk.nextInt());
							System.out.println("Enter runs : ");
							bat.setRuns(mk.nextInt());
							System.out.println("Enter highest score : ");
							bat.setHighestScore(mk.nextInt());
							System.out.println("Enter strike rate :");
							bat.setStrikeRate(mk.nextFloat());
							System.out.println("Enter number of hundreds : ");
							bat.setHundered(mk.nextInt());
							System.out.println("Enter number of fifty : ");
							bat.setFifty(mk.nextInt());
							System.out.println("Enter number of sixes : ");
							bat.setSixes(mk.nextInt());
							System.out.println("Enter number of fours : ");
							bat.setFours(mk.nextInt());
							BattingDAO.insertBattingDetail(bat);
							System.out.println();
							break;
						case 6:
							BattingDetails batupdate = new BattingDetails();
							System.out.println("Enter player name : ");
							batupdate.setName(mk.nextLine() + mk.nextLine());
							System.out.println("Enter number of runs scored in a match : ");
							int runs = mk.nextInt();
							batupdate.setRuns(runs);
							if (runs != 0) {
								if (runs >= 50 && runs <= 99) {
									batupdate.setFifty(1);
								} else if (runs >= 100) {
									batupdate.setHundered(1);
								}
								System.out.println("Enter how many sixes hit in the match : ");
								batupdate.setSixes(mk.nextInt());
								System.out.println("Enter how many fours hit in the match : ");
								batupdate.setFours(mk.nextInt());
							}
							BattingDAO.updateBattingDetails(batupdate);
							System.out.println();
							break;
						case 7:
							BowlingDetails bowl = new BowlingDetails();
							System.out.println("Enter player name : ");
							bowl.setName(mk.nextLine() + mk.nextLine());
							// Jersey Number can't be duplicate
							System.out.println("Enter player jersey number : ");
							bowl.setJerseyNumber(mk.nextInt());
							System.out.println("Enter number of matches palyed : ");
							bowl.setMatches(mk.nextInt());
							System.out.println("Enter number of wickets taken : ");
							bowl.setWickets(mk.nextInt());
							System.out.println("Enter econamy : ");
							bowl.setEconamy(mk.nextFloat());
							System.out.println("Enter number of five wikets taken : ");
							bowl.setFiveWickets(mk.nextInt());
							System.out.println("Enter best figure : ");
							bowl.setBestFigure(mk.next());
							BowlingDAO.insertBowlingDetails(bowl);
							System.out.println();
							break;
						case 8:
							BowlingDetails bowlUpdate = new BowlingDetails();
							System.out.println("Enter the player name to update bowling details : ");
							bowlUpdate.setName(mk.nextLine() + mk.nextLine());
							System.out.println("Enter number of wickets taken in the match : ");
							bowlUpdate.setWickets(mk.nextInt());
							System.out.println("Enter yes or no whether the best figure beaten or not");
							String temp = mk.next();
							int run = 0;
							if (temp.equals("yes")) {
								System.out.println("Enter runs(while bowling) : ");
								runs = mk.nextInt();
							}
							BowlingDAO.updateBowlingDetails(bowlUpdate, temp, run);
							System.out.println();
							System.out.println();
							break;
						case 9:
							System.out.println("\t\t\t------------Closed-------------");
							System.exit(0);
							break;
						default:
							System.err.println("Please, enter the correct choice(Admin)");
						}
					}
				} else {
					System.out.println();
					System.out.println("\t\t!!!Oops password wrong");
					System.out.println("\t\tEnter the correct password to Login ADMIN");
					System.out.println("\t\tTry Again!!!");
					System.out.println();
					count++;
					if (count == 2) {
						System.out.println("\t\t***********************Restart the Browser************************");
						System.out.println("\t\t*****************************And try******************************");
						System.exit(0);
					}
				}
			}
		} else if (login.equalsIgnoreCase("User")) {
			while (true) {
				// Only Display the values
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println(
						"****************************************************************************************************************************************************************************************************");
				System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWelcome to User Login");
				System.out.println(
						"********************************************************************************************!!!MENU!!!***********************************************************************************************");
				System.out.println("\t\t\t\t\t\t\t\t\t\t\t1. Cricket Team Details");
				System.out.println("\t\t\t\t\t\t\t\t\t\t\t2. Player Details");
				System.out.println("\t\t\t\t\t\t\t\t\t\t\t3. Player Batting Details");
				System.out.println("\t\t\t\t\t\t\t\t\t\t\t4. Player Bowling Details");
				System.out.println("\t\t\t\t\t\t\t\t\t\t\t5. Display One Player to Search For a Detail");
				System.out.println("\t\t\t\t\t\t\t\t\t\t\t6. Enter 6 to exit the menu");
				System.out.println(
						"****************************************************************************************************************************************************************************************************");
				System.out.println();
				System.out.println("Enter the choice from the menu,");
				int choice = mk.nextInt();
				System.out.println();
				System.out.println();
				System.out.println();
				switch (choice) {
				case 1:
					System.out.println();
					System.out.println("Displaying Cricket Team World Cup Details:");
					System.out.println();
					List<Cricket> list = new ArrayList<>();
					list = CricketDAO.DisplayRecordsForUser();
					System.out.println(
							"********************************************************************************************************************");
					System.out.format("\t\t%-20s%-20s%-20s%-20s\n", "Team Name", "WorldCupTest", "WorldCupODI",
							"WorldCupT20");
					System.out.println(
							"********************************************************************************************************************");
					for (Cricket cricket : list) {
						System.out.format("\t\t%-20s%-20d%-20d%-20d\n", cricket.getTeamName(),
								cricket.getWorldCupTest(), cricket.getWorldCupODI(), cricket.getWorldCupT20());
					}
					System.out.println(
							"********************************************************************************************************************");
					System.out.println();
					System.out.println();
					System.out.println();
					break;
				case 2:
					System.out.println();
					System.out.println("Displaying All Player Details:");
					System.out.println();
					PlayerDAO.displayAllPlayerDetails();
					System.out.println();
					System.out.println();
					System.out.println();
					break;
				case 3:
					System.out.println();
					System.out.println("Displaying All Player Batting Details:");
					List<BattingDetails> battingList = new ArrayList<>();
					System.out.println();
					System.out.println(
							"**********************************************************************************************************************************************************************************************************************************");
					System.out.format("\t\t%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Player Name",
							"Jersey Number", "Matches", "Runs", "Highest Score", "Strike Rate", "Hundred", "Fifty",
							"Sixes", "Fours");
					System.out.println(
							"**********************************************************************************************************************************************************************************************************************************");

					battingList = BattingDAO.displayAllPlayerBattingDetails();
					List<BattingDetails> battingSort = battingList.stream()
							.sorted(Comparator.comparingInt(BattingDetails::getRuns).reversed())
							.collect(Collectors.toList());
					for (BattingDetails batting : battingSort) {
						System.out.format("\t\t%-20s%-20d%-20d%-20d%-20d%-20.2f%-20d%-20d%-20d%-20d\n",
								batting.getName(), batting.getJerseyNumber(), batting.getMatches(), batting.getRuns(),
								batting.getHighestScore(), batting.getStrikeRate(), batting.getHundered(),
								batting.getFifty(), batting.getSixes(), batting.getFours());
					}
					System.out.println(
							"**********************************************************************************************************************************************************************************************************************************");

					System.out.println();
					System.out.println();
					System.out.println();
					break;
				case 4:
					System.out.println();
					System.out.println("Displaying All Player Bowling Details");
					List<BowlingDetails> bowlingList = new ArrayList<>();
					bowlingList = BowlingDAO.displayAllPlayerBowlingDetails();
					List<BowlingDetails> bowlingSort = bowlingList.stream()
							.sorted(Comparator.comparingInt(BowlingDetails::getWickets).reversed())
							.collect(Collectors.toList());
					System.out.println();
					System.out.println(
							"************************************************************************************************************************************************************************");

					System.out.format("\t\t%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Player Name", "Jersey Number",
							"Matches", "Wickets", "Econamy", "Five Wickets", "Best Figure");
					System.out.println(
							"************************************************************************************************************************************************************************");

					for (BowlingDetails bowling : bowlingSort) {
						System.out.format("\t\t%-20s%-20d%-20d%-20d%-20.2f%-20d%-20s\n", bowling.getName(),
								bowling.getJerseyNumber(), bowling.getMatches(), bowling.getWickets(),
								bowling.getEconamy(), bowling.getFiveWickets(), bowling.getBestFigure());
					}
					System.out.println(
							"************************************************************************************************************************************************************************");
					System.out.println();
					System.out.println();
					System.out.println();
					break;
				case 5:
					boolean temp = true;
					while (temp) {
						System.out.println();
						System.out.println(
								"*************************************************************Player Details**************************************");
						System.out.println("\t\t\t\t\t1. Display Player Detail");
						System.out.println("\t\t\t\t\t2. Display Batting Detail for the Player");
						System.out.println("\t\t\t\t\t3. Display Bowling Detail for the Player");
						System.out.println("\t\t\t\t\t4. Enter 4 to exit from the Player Detail Menu");
						System.out.println(
								"*****************************************************************************************************************");
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println("Enter the choice from the menu(Single Player Display):");
						int playerChoice = mk.nextInt();
						int jerseyNumber;
						System.out.println();
						switch (playerChoice) {
						case 1:
							System.out.println();
							System.out.println("Enter the player jersey number to search to display player detail: ");
							jerseyNumber = mk.nextInt();
							Player player = new Player();
							player.setJerseyNumber(jerseyNumber);
							PlayerDAO.displayOnePlayerDetail(player);
							System.out.println();
							System.out.println();
							System.out.println();
							break;
						case 2:
							System.out.println();
							System.out.println(
									"Enter the player jersey number to search to display player batting detail: ");
							jerseyNumber = mk.nextInt();
							BattingDetails batting = new BattingDetails();
							batting.setJerseyNumber(jerseyNumber);

							BattingDAO.displayOnePlayerBattingDetail(batting);
							System.out.println();
							System.out.println();
							System.out.println();
							break;
						case 3:
							System.out.println();
							System.out.println(
									"Enter the player jersey number to search to display player bowling detail: ");
							jerseyNumber = mk.nextInt();
							BowlingDetails bowling = new BowlingDetails();
							bowling.setJerseyNumber(jerseyNumber);

							BowlingDAO.displayOnePlayerBowlingDetail(bowling);
							System.out.println();
							System.out.println();
							System.out.println();
							break;
						case 4:
							System.out.println();
							System.out.println(
									"--------------------------------------------Closing(Single Player Search Menu)---------------------------------------------");
							temp = false;
							System.out.println();
							System.out.println();
							System.out.println();
							break;
						default:
							System.out.println();
							System.out.println(
									"****************!!!!Enter correct choice to display the player detail!!!!*****************");
							System.out.println();
							System.out.println();
							System.out.println();
						}
					}
					break;
				case 6:
					System.out.println();
					System.out.println(
							"---------------------------------------------------------------------------------------Closing Menu---------------------------------------------------------------------------------");
					System.exit(0);
					break;
				default:
					System.err.println("Please, enter the correct choice to display records");
					System.out.println();
					System.out.println();
					System.out.println();
				}
			}
		} else {
			System.err.println("\n\t\t\t\tSelect correct Login type..\t\t\t\t");
		}
		mk.close();
	}
}
