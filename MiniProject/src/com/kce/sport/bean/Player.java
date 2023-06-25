package com.kce.sport.bean;

public class Player {
	// IPL Only
	private String playerName;
	private String birthPlace;
	private int age;
	private int jerseyNumber;
	private String BattingType;
	private String BowlingType;
	private String role;
	private int ICCBattingRank;
	private int ICCBowlingRank;
	private String status;

	public Player() {
		super();
	}

	public Player(String playerName, String birthPlace, int age, int jerseyNumber, String battingType,
			String bowlingType, String role, int iCCBattingRank, int iCCBowlingRank, String status) {
		super();
		this.playerName = playerName;
		this.birthPlace = birthPlace;
		this.age = age;
		this.jerseyNumber = jerseyNumber;
		BattingType = battingType;
		BowlingType = bowlingType;
		this.role = role;
		ICCBattingRank = iCCBattingRank;
		ICCBowlingRank = iCCBowlingRank;
		this.status = status;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

	public String getBattingType() {
		return BattingType;
	}

	public void setBattingType(String battingType) {
		BattingType = battingType;
	}

	public String getBowlingType() {
		return BowlingType;
	}

	public void setBowlingType(String bowlingType) {
		BowlingType = bowlingType;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getICCBattingRank() {
		return ICCBattingRank;
	}

	public void setICCBattingRank(int iCCBattingRank) {
		ICCBattingRank = iCCBattingRank;
	}

	public int getICCBowlingRank() {
		return ICCBowlingRank;
	}

	public void setICCBowlingRank(int iCCBowlingRank) {
		ICCBowlingRank = iCCBowlingRank;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", birthPlace=" + birthPlace + ", age=" + age + ", jerseyNumber="
				+ jerseyNumber + ", BattingType=" + BattingType + ", BowlingType=" + BowlingType + ", role=" + role
				+ ", ICCBattingRank=" + ICCBattingRank + ", ICCBowlingRank=" + ICCBowlingRank + ", status=" + status
				+ "]";
	}

}
