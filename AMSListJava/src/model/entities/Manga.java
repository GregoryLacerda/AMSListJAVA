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

	public Manga(Integer id, String name, String coverImage, String siteLink, String description, 
			Double volume, Double chapter, Status status, User user) {
		super(id, name, coverImage, siteLink, description, user, status);
		this.volume = volume;
		this.chapter = chapter;
	}
	
	//Getters and Setters
	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getChapter() {
		return chapter;
	}

	public void setChapter(Double chapter) {
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
