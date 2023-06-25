package com.kce.sport.bean;

public class BowlingDetails {
	// IPL Only
	private String name;
	private int jerseyNumber;
	private int matches;
	private int wickets;
	private float econamy;
	private int fiveWickets;
	private String bestFigure;

	public BowlingDetails() {
		super();
	}

	public BowlingDetails(String name, int jerseyNumber, int matches, int wickets, float econamy, int fiveWickets,
			String bestFigure) {
		super();
		this.name = name;
		this.jerseyNumber = jerseyNumber;
		this.matches = matches;
		this.wickets = wickets;
		this.econamy = econamy;
		this.fiveWickets = fiveWickets;
		this.bestFigure = bestFigure;
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

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public float getEconamy() {
		return econamy;
	}

	public void setEconamy(float econamy) {
		this.econamy = econamy;
	}

	public int getFiveWickets() {
		return fiveWickets;
	}

	public void setFiveWickets(int fiveWickets) {
		this.fiveWickets = fiveWickets;
	}

	public String getBestFigure() {
		return bestFigure;
	}

	public void setBestFigure(String bestFigure) {
		this.bestFigure = bestFigure;
	}

	@Override
	public String toString() {
		return "BowlingDetails [name=" + name + ", jerseyNumber=" + jerseyNumber + ", matches=" + matches + ", wickets="
				+ wickets + ", econamy=" + econamy + ", fiveWickets=" + fiveWickets + ", bestFigure=" + bestFigure
				+ "]";
	}

}
