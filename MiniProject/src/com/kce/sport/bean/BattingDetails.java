package com.kce.sport.bean;

public class BattingDetails {
	// IPL Only
	private String name;
	private int jerseyNumber;
	private int matches;
	private int runs;
	private int highestScore;
	private float strikeRate;
	private int hundered;
	private int fifty;
	private int sixes;
	private int fours;

	public BattingDetails() {
		super();
	}

	public BattingDetails(String name, int jerseyNumber, int matches, int runs, int highestScore, float strikeRate,
			int hundered, int fifty, int sixes, int fours) {
		super();
		this.name = name;
		this.jerseyNumber = jerseyNumber;
		this.matches = matches;
		this.runs = runs;
		this.highestScore = highestScore;
		this.strikeRate = strikeRate;
		this.hundered = hundered;
		this.fifty = fifty;
		this.sixes = sixes;
		this.fours = fours;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

	public int getMatches() {
		return matches;
	}

	public void setMatches(int matches) {
		this.matches = matches;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getHighestScore() {
		return highestScore;
	}

	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}

	public float getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(float strikeRate) {
		this.strikeRate = strikeRate;
	}

	public int getHundered() {
		return hundered;
	}

	public void setHundered(int hundered) {
		this.hundered = hundered;
	}

	public int getFifty() {
		return fifty;
	}

	public void setFifty(int fifty) {
		this.fifty = fifty;
	}

	public int getSixes() {
		return sixes;
	}

	public void setSixes(int sixes) {
		this.sixes = sixes;
	}

	public int getFours() {
		return fours;
	}

	public void setFours(int fours) {
		this.fours = fours;
	}

	@Override
	public String toString() {
		return "BattingDetails [name=" + name + ", jerseyNumber=" + jerseyNumber + ", matches=" + matches + ", runs="
				+ runs + ", highestScore=" + highestScore + ", strikeRate=" + strikeRate + ", hundered=" + hundered
				+ ", fifty=" + fifty + ", sixes=" + sixes + ", fours=" + fours + "]";
	}

}
