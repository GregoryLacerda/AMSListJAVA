package model.entities;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DbException;
import model.enums.Status;

public class Manga extends Element{
	
	//Attributes
	private Double volume;
	private Double chapter;
	private String table = "mangas";
	
	//Contructors
	public Manga() {
		
	}

	public Manga( String name, String coverImage, String siteLink, String description, 
			Double volume, Double chapter, Status status, User user) {
		super(name, coverImage, siteLink, description, user, status);
		this.volume = volume;
		this.chapter = chapter;
	}
	
	//Getters and Setters
	public Double getVolumeOrSeason() {
		return volume;
	}

	public void setVolumeOrSeason(Double volume) {
		this.volume = volume;
	}

	public Double getChapterOrEpisode() {
		return chapter;
	}

	public void setChapterOrEpisode(Double chapter) {
		this.chapter = chapter;
	}
	
	
	public String getTable() {
		return table;
	}
	
	//toString
	@Override
	public String toString() {
		return "Manga ="+ super.toString() +"Volume: " + volume + ", Chapter: " + chapter + "]";
	}
	
	
	
}
