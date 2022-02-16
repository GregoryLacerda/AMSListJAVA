package model.dao;

import java.util.List;

import model.entities.Manga;
import model.entities.User;

public interface MangaDao {
	
	void insert(Manga manga);
	void update(Manga manga);
	void deleteById(Integer id);
	Manga findById(Integer id);
	List<Manga> findAll();
	List<Manga> findByUser(User user);
}
