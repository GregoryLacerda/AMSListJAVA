package model.entities;

import model.enums.Status;

public class Serie extends Element{
	
	//Attributes
	private Double season;
	private Double episode;
	private String table = "series";
	
	//Contructors
	public Serie() {
		
	}

	public Serie(Integer id, String name, String coverImage, String siteLink, String description, 
			Double season, Double episode,  Status status, User user) {
		super(id, name, coverImage, siteLink, description, user, status);
		this.season = season;
		this.episode = episode;
	}
	
	//Getters and Setters
		
	public Double getSeason() {
		return season;
	}

	public void setSeason(Double season) {
		this.season = season;
	}

	public Double getEpisode() {
		return episode;
	}

	public void setEpisode(Double episode) {
		this.episode = episode;
	}
	
	public String getTable() {
		return table;
	}
	
	//toString
	@Override
	public String toString() {
		return "Serie =" + super.toString() + "Season: " + season + ", Episode: " + episode +"]";
	}
	
	
	
	
	
}
