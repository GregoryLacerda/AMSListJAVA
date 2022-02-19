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
import model.dao.AnimeDao;
import model.entities.Anime;
import model.entities.User;
import model.enums.Status;

public class AnimeDaoJDBC implements AnimeDao {
	Connection conn;

	public AnimeDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Anime anime) {
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("INSERT INTO animes "
					+ "(animeName, animeCoverImage, animeSiteLink, animeDescription, animeStatus, animeSeason, animeEpisode, userId)\r\n"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?);");

			st.setString(1, anime.getName());
			st.setString(2, anime.getCoverImage());
			st.setString(3, anime.getSiteLink());
			st.setString(4, anime.getDescription());
			st.setString(5, anime.getStatus().toString());
			st.setDouble(6, anime.getSeason());
			st.setDouble(7, anime.getEpisode());
			st.setInt(8, anime.getUser().getId());

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Anime anime) {
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("UPDATE animes " + "SET animeName = ?, " + "animeCoverImage = ?, "
					+ "animeSiteLink = ?, " + "animeDescription = ?, " + "animeStatus = ?, " + "animeSeason = ?, "
					+ "animeEpisode = ?, " + "userId = ? " + "WHERE animeId = ?");

			st.setString(1, anime.getName());
			st.setString(2, anime.getCoverImage());
			st.setString(3, anime.getSiteLink());
			st.setString(4, anime.getDescription());
			st.setString(5, anime.getStatus().toString());
			st.setDouble(6, anime.getSeason());
			st.setDouble(7, anime.getEpisode());
			st.setInt(8, anime.getUser().getId());
			st.setInt(9, anime.getId());

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("DELETE FROM animes WHERE animeId = ?");

			st.setInt(1, id);

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public Anime findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("SELECT animes.*, user.*" + "FROM animes INNER JOIN user "
					+ "ON animes.userId = user.userId " + "WHERE animes.animeId = ?");

			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {

				User user = instatiateUser(rs);
				Anime anime = instantiateAnime(rs, user);

				return anime;
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
	public List<Anime> findAll() {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT animes.*, user.* " + "FROM animes INNER JOIN user "
					+ "ON animes.userId = user.userId " + "ORDER BY animeId");

			rs = st.executeQuery();

			List<Anime> list = new ArrayList<Anime>();
			Map<Integer, User> map = new HashMap<Integer, User>();

			while (rs.next()) {
				User user = map.get(rs.getInt("userId"));

				if (user == null) {
					user = instatiateUser(rs);
					map.put(rs.getInt("userId"), user);
				}

				Anime anime = instantiateAnime(rs, user);

				list.add(anime);
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
	public List<Anime> findByUser(User user) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT animes.*, user.* " + "FROM animes INNER JOIN user "
					+ "ON animes.userId = user.userId " + "WHERE user.userId = ? " + "ORDER BY animeName");

			st.setInt(1, user.getId());

			rs = st.executeQuery();

			List<Anime> list = new ArrayList<>();
			Map<Integer, User> map = new HashMap<>();

			while (rs.next()) {
				User usr = map.get(rs.getInt("animes.userId"));

				if (usr == null) {
					usr = instatiateUser(rs);
					map.put(rs.getInt("animes.userId"), usr);
				}

				Anime anime = instantiateAnime(rs, usr);

				list.add(anime);
			}

			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}

	}

	private Anime instantiateAnime(ResultSet rs, User user) throws SQLException {
		Anime anime = new Anime();
		anime.setId(rs.getInt("animeId"));
		anime.setName(rs.getString("animeName"));
		anime.setCoverImage(rs.getString("animeCoverImage"));
		anime.setSiteLink(rs.getString("animeSiteLink"));
		anime.setDescription(rs.getString("animeDescription"));
		anime.setStatus(Status.valueOf(rs.getString("animeStatus")));
		anime.setSeason(rs.getDouble("animeSeason"));
		anime.setEpisode(rs.getDouble("animeEpisode"));
		anime.setUser(user);
		return anime;
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
