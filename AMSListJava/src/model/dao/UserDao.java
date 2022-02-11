package model.dao;

import java.util.List;
import model.entities.Element;
import model.entities.User;

public interface UserDao {
	void inser(User user);
	void update(User user);
	void deleteById(Integer id);
	User findById(Integer id);
	List<User> findAll();
}
