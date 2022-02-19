package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.MangaDao;
import model.entities.Manga;
import model.entities.User;
import model.enums.Status;

public class MangaDaoJDBC implements MangaDao{
	
	Connection conn;
	
	public MangaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Manga manga) {
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("INSERT INTO mangas "
					+ "(mangaName, mangaCoverImage, mangaSiteLink, mangaDescription, mangaStatus, volume, chapter, userId)\r\n"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?);");
			
			st.setString(1, manga.getName());
			st.setString(2, manga.getCoverImage());
			st.setString(3, manga.getSiteLink());
			st.setString(4, manga.getDescription());
			st.setString(5, manga.getStatus().toString());
			st.setDouble(6, manga.getVolume());
			st.setDouble(7, manga.getChapter());
			st.setInt(8, manga.getUser().getId());
			
			st.executeUpdate();
						
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Manga manga) {
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("UPDATE mangas "
					+ "SET mangaName = ?, "
					+ "mangaCoverImage = ?, "
					+ "mangaSiteLink = ?, "
					+ "mangaDescription = ?, "
					+ "mangaStatus = ?, "
					+ "volume = ?, "
					+ "chapter = ?, "
					+ "userId = ? "
					+ "WHERE mangaId = ?");
			
			st.setString(1, manga.getName());
			st.setString(2, manga.getCoverImage());
			st.setString(3, manga.getSiteLink());
			st.setString(4, manga.getDescription());
			st.setString(5, manga.getStatus().toString());
			st.setDouble(6, manga.getVolume());
			st.setDouble(7, manga.getChapter());
			st.setInt(8, manga.getUser().getId());
			st.setInt(9, manga.getId());
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("DELETE FROM mangas WHERE mangaId = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		
	}

	@Override
	public Manga findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
						
		try {
			
			st = conn.prepareStatement("SELECT mangas.*, user.*"
					+ "FROM mangas INNER JOIN user "
					+ "ON mangas.userId = user.userId "  
					+ "WHERE mangas.mangaId = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				
				User user = instatiateUser(rs);
				Manga manga = instantiateManga(rs, user);
				
				return manga;
			}
			return null;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		
	}

	@Override
	public List<Manga> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT mangas.*, user.* "
					+ "FROM mangas INNER JOIN user "
					+ " ON mangas.userId = user.userId "
					+ "ORDER BY mangaId");
			
			rs = st.executeQuery();
			
			List<Manga> list = new ArrayList<Manga>();
			Map<Integer, User> map = new HashMap<Integer, User>(); 
			
			while (rs.next()) {
				User user = map.get(rs.getInt("userId"));
				
				if (user == null) {
					user = instatiateUser(rs);
					map.put(rs.getInt("userId"), user);
				}
				
				Manga manga = instantiateManga(rs, user);
				
				list.add(manga);
			}
			return list;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		
		
	}
	@Override
	public List<Manga> findByUser(User user){
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT mangas.*, user.* "
					+ "FROM mangas INNER JOIN user "
					+ "ON mangas.userId = user.userId "
					+ "WHERE user.userId = ? "
					+ "ORDER BY mangaName");
			
			st.setInt(1, user.getId());
			
			rs = st.executeQuery();
			
			List <Manga> list = new ArrayList<>();
			Map<Integer, User> map = new HashMap<>();
			
			while (rs.next()) {
				User usr = map.get(rs.getInt("mangas.userId"));
				
				if (usr == null) {
					usr = instatiateUser(rs);
					map.put(rs.getInt("mangas.userId"), usr);
				}
				
				Manga manga = instantiateManga(rs, usr);
				
				list.add(manga);
			}
			
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		
		
	}
	
	private Manga instantiateManga(ResultSet rs, User user) throws SQLException {		
		Manga manga = new Manga();
		manga.setId(rs.getInt("mangaId"));
		manga.setName(rs.getString("mangaName"));
		manga.setCoverImage(rs.getString("mangaCoverImage"));
		manga.setSiteLink(rs.getString("mangaSiteLink"));
		manga.setDescription(rs.getString("mangaDescription"));
		manga.setStatus(Status.valueOf(rs.getString("mangaStatus")));
		manga.setVolume(rs.getDouble("volume"));
		manga.setChapter(rs.getDouble("chapter"));
		manga.setUser(user);
		return manga;		
	}
	
	private User instatiateUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("userId"));
		user.setName(rs.getString("userName"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));		
		return user;		
	}
	
	
}
