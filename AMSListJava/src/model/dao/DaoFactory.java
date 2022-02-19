package model.dao;

import db.DB;
import model.dao.impl.AnimeDaoJDBC;
import model.dao.impl.ElementDaoJDBC;
import model.dao.impl.MangaDaoJDBC;
import model.dao.impl.SerieDaoJDBC;
import model.dao.impl.UserDaoJDBC;
import model.entities.Element;

public class DaoFactory {
	
	public MangaDao createMangaDao() {
		return new MangaDaoJDBC(DB.getConnection());
	}
	
	public AnimeDao createAnimeDao() {
		return new AnimeDaoJDBC(DB.getConnection());
	}
	
	public SerieDao createSerieDao() {
		return new SerieDaoJDBC(DB.getConnection());
	}
	
	public UserDao creatUserDao() {
		return new UserDaoJDBC(DB.getConnection());
	}
	
	public ElementDao createElementDao(){
		return new ElementDaoJDBC(DB.getConnection());
	}
}
