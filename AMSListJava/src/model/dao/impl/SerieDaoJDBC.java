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
import model.dao.SerieDao;
import model.entities.Serie;
import model.entities.Serie;
import model.entities.User;
import model.enums.Status;

public class SerieDaoJDBC implements SerieDao{
	
	Connection conn;
	
	public SerieDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Serie serie) {
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("INSERT INTO series "
					+ "(serieName, serieCoverImage, serieSiteLink, serieDescription, serieStatus, serieSeason, serieEpisode, userId)\r\n"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?);");

			st.setString(1, serie.getName());
			st.setString(2, serie.getCoverImage());
			st.setString(3, serie.getSiteLink());
			st.setString(4, serie.getDescription());
			st.setString(5, serie.getStatus().toString());
			st.setDouble(6, serie.getSeason());
			st.setDouble(7, serie.getEpisode());
			st.setInt(8, serie.getUser().getId());

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Serie serie) {
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("UPDATE series " 
					+ "SET serieName = ?, " 
					+ "serieCoverImage = ?, "
					+ "serieSiteLink = ?, " 
					+ "serieDescription = ?, " 
					+ "serieStatus = ?, " 
					+ "serieSeason = ?, "
					+ "serieEpisode = ?, " 
					+ "userId = ? " 
					+ "WHERE serieId = ?");

			st.setString(1, serie.getName());
			st.setString(2, serie.getCoverImage());
			st.setString(3, serie.getSiteLink());
			st.setString(4, serie.getDescription());
			st.setString(5, serie.getStatus().toString());
			st.setDouble(6, serie.getSeason());
			st.setDouble(7, serie.getEpisode());
			st.setInt(8, serie.getUser().getId());
			st.setInt(9, serie.getId());

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("DELETE FROM series WHERE serieId = ?");

			st.setInt(1, id);

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public Serie findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("SELECT series.*, user.*" 
					+ "FROM series INNER JOIN user "
					+ "ON series.userId = user.userId " 
					+ "WHERE series.serieId = ?");

			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {

				User user = instatiateUser(rs);
				Serie serie = instantiateSerie(rs, user);

				return serie;
			}
			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}

	}

	@Override
	public List<Serie> findAll() {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT series.*, user.* " 
					+ "FROM series INNER JOIN user "
					+ "ON series.userId = user.userId " 
					+ "ORDER BY serieId");

			rs = st.executeQuery();

			List<Serie> list = new ArrayList<Serie>();
			Map<Integer, User> map = new HashMap<Integer, User>();

			while (rs.next()) {
				User user = map.get(rs.getInt("userId"));

				if (user == null) {
					user = instatiateUser(rs);
					map.put(rs.getInt("userId"), user);
				}

				Serie serie = instantiateSerie(rs, user);

				list.add(serie);
			}
			return list;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}

	}

	@Override
	public List<Serie> findByUser(User user) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT series.*, user.* " 
					+ "FROM series INNER JOIN user "
					+ "ON series.userId = user.userId " 
					+ "WHERE user.userId = ? " 
					+ "ORDER BY serieName");

			st.setInt(1, user.getId());

			rs = st.executeQuery();

			List<Serie> list = new ArrayList<>();
			Map<Integer, User> map = new HashMap<>();

			while (rs.next()) {
				User usr = map.get(rs.getInt("series.userId"));

				if (usr == null) {
					usr = instatiateUser(rs);
					map.put(rs.getInt("series.userId"), usr);
				}

				Serie serie = instantiateSerie(rs, usr);

				list.add(serie);
			}

			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}

	}

	private Serie instantiateSerie(ResultSet rs, User user) throws SQLException {
		Serie serie = new Serie();
		serie.setId(rs.getInt("serieId"));
		serie.setName(rs.getString("serieName"));
		serie.setCoverImage(rs.getString("serieCoverImage"));
		serie.setSiteLink(rs.getString("serieSiteLink"));
		serie.setDescription(rs.getString("serieDescription"));
		serie.setStatus(Status.valueOf(rs.getString("serieStatus")));
		serie.setSeason(rs.getDouble("serieSeason"));
		serie.setEpisode(rs.getDouble("serieEpisode"));
		serie.setUser(user);
		return serie;
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
