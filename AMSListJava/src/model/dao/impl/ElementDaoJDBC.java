package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ElementDao;
import model.entities.Element;

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

	@Override
	public void insert(Element element) {
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("INSERT INTO mangas "
					+ "(name, coverImage, siteLink, description, status, volume, chapter, userId) "
					+ "VALUES (?,?,?,?,?,?,?,?)");
			
			/*st.setString(1, manga.getName());
			st.setString(2, manga.getCoverImage());
			st.setString(3, manga.getSiteLink());
			st.setString(4, manga.getDescription());
			st.setString(5, manga.getStatus().toString());
			st.setDouble(6, element.getVolume());
			st.setDouble(7, manga.getChapter());
			st.setInt(8, manga.getUser().getId());*/
			
						
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

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



}
