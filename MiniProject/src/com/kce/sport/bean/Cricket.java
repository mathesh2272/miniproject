package com.kce.sport.bean;

public class Cricket {
	
	// Displaying the team won how many World Cup ODI, T20 and Test
	private String teamName;
	private int worldCupODI;
	private int worldCupTest;
	private int WorldCupT20;

	public Cricket() {
		super();
	}

	public Cricket(String teamName, int worldCupODI, int worldCupTest, int worldCupT20) {
		super();
		this.teamName = teamName;
		this.worldCupODI = worldCupODI;
		this.worldCupTest = worldCupTest;
		WorldCupT20 = worldCupT20;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setWorldCupODI(int worldCupODI) {
		this.worldCupODI = worldCupODI;
	}

	public void setWorldCupTest(int worldCupTest) {
		this.worldCupTest = worldCupTest;
	}

	public void setWorldCupT20(int worldCupT20) {
		WorldCupT20 = worldCupT20;
	}

	public String getTeamName() {
		return teamName;
	}

	public int getWorldCupODI() {
		return worldCupODI;
	}

	public int getWorldCupTest() {
		return worldCupTest;
	}

	public int getWorldCupT20() {
		return WorldCupT20;
	}

	@Override
	public String toString() {
		return "Cricket [teamName=" + teamName + ", worldCupODI=" + worldCupODI + ", worldCupTest=" + worldCupTest
				+ ", WorldCupT20=" + WorldCupT20 + "]";
	}

}