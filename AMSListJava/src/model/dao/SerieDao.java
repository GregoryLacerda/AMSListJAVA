package model.dao;

import java.util.List;

import model.entities.Serie;


public interface SerieDao {
	
	void insert(Serie serie);
	void update(Serie serie);
	void deleteById(Integer id);
	Serie findById(Integer id);
	List<Serie> findAll();
}
