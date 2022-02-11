package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.UserDao;
import model.entities.User;

public class UserDaoJDBC implements UserDao {

	public UserDaoJDBC(Connection connection) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
