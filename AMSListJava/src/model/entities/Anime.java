package model.entities;

import model.enums.Status;

public class Anime extends Element{
	
	//Attributes
	private Double season;
	private Double episode;
	private String table = "animes";
	

	//Contructors
	public Anime() {
		
	}
	
	public Anime(String name, String coverImage, String siteLink, String description, Double season, Double episode, Status status, User user) {
		super(name, coverImage, siteLink, description, user, status);
		this.season = season;
		this.episode = episode;
	}
	
	//Getters and Setters
	public Double getVolumeOrSeason() {
		return season;
	}

	public void setVolumeOrSeason(Double season) {
		this.season = season;
	}

	public Double getChapterOrEpisode() {
		return episode;
	}

	public void setChapterOrEpisode(Double episode) {
		this.episode = episode;
	}
	
	public String getTable() {
		return table;
	}
	
	//To String
	@Override
	public String toString() {
		return "Anime =" + super.toString() + "Season: " + season + ", Episode: " + episode + "]";
	}
	
	 	
}
