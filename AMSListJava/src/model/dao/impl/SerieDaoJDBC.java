package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.SerieDao;
import model.entities.Serie;

public class SerieDaoJDBC implements SerieDao{
	
	Connection conn;
	
	public SerieDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Serie serie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Serie serie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Serie findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Serie> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
