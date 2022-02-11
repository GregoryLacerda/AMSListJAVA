package model.dao;

import java.util.List;

import model.entities.Anime;

public interface AnimeDao {
	void insert(Anime anime);
	void update(Anime anime);
	void deleteById(Integer id);
	Anime findById(Integer id);
	List<Anime> findAll();
}
