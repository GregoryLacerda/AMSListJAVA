package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ElementDao;
import model.entities.Anime;
import model.entities.Element;
import model.entities.Manga;
import model.entities.Serie;
import model.entities.User;

public class ElementDaoJDBC implements ElementDao{

	private Connection conn;
	
	public ElementDaoJDBC(Connection connection) {
		this.conn = connection; 
	}

	@Override
	public List<Element> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public <T> void insert(T element) {
		PreparedStatement st = null;	
				
		try {
			
			if (element instanceof Anime) {
				
				st = conn.prepareStatement("INSERT INTO animes "
						+ "(name, coverImage, siteLink, description, status, volume, chapter, userId) "
						+ "VALUES (?,?,?,?,?,?,?,?)");
				
				st.setString(1, element.getName());
				st.setString(2, elemt.getCoverImage());
				st.setString(3, elemt.getSiteLink());
				st.setString(4, elemt.getDescription());
				st.setString(5, elemt.getStatus().toString());
				st.setDouble(6, elemt.getVolumeOrSeason());
				st.setDouble(7, elemt.getChapterOrEpisode());
				st.setInt(8, elemt.getUser().getId());
				
			}else if (element instanceof Manga) {
				Manga elemt = (Manga) element;

				st = conn.prepareStatement("INSERT INTO mangas "
						+ "(mangaName, mangaCoverImage, mangaSiteLink, mangaDescription, mangaStatus, volume, chapter, userId)\r\n"
						+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?);");
				
				st.setString(1, elemt.getName());
				st.setString(2, elemt.getCoverImage());
				st.setString(3, elemt.getSiteLink());
				st.setString(4, elemt.getDescription());
				st.setString(5, elemt.getStatus().toString());
				st.setDouble(6, elemt.getVolumeOrSeason());
				st.setDouble(7, elemt.getChapterOrEpisode());
				st.setInt(8, elemt.getUser().getId());
				
			}else if(element instanceof Serie) {
				Serie elemt = (Serie) element;

				st = conn.prepareStatement("INSERT INTO series "
						+ "(name, coverImage, siteLink, description, status, volume, chapter, userId) "
						+ "VALUES (?,?,?,?,?,?,?,?)");
				
				st.setString(1, elemt.getName());
				st.setString(2, elemt.getCoverImage());
				st.setString(3, elemt.getSiteLink());
				st.setString(4, elemt.getDescription());
				st.setString(5, elemt.getStatus().toString());
				st.setDouble(6, elemt.getVolumeOrSeason());
				st.setDouble(7, elemt.getChapterOrEpisode());
				st.setInt(8, elemt.getUser().getId());
				
			}
			
			st.executeUpdate();
						
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}*/

	

	@Override
	public void update(Element element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Element findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Element> findByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Element element) {
		// TODO Auto-generated method stub
		
	}


				
}
	

