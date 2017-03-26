package com.example.server.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.model.User;


@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;
	
	@Override
	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}
	
	@Override
	public User findById(long id) {
		return dao.findById(id);
	}

	@Override
	public User findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public void saveUser(User user) {
		dao.saveUser(user);
	}

	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
	}

	@Override
	public void deleteUserById(long id) {
		dao.deleteUserById(id);
	}

	@Override
	public boolean isUserExist(User user) {
		return dao.isUserExist(user);
	}

	@Override
	public void deleteAllUsers() {
		dao.deleteAllUsers();
	}

	@Override
	public User checkCookie(HttpSession session){
		User user = null;
		String username = (String) session.getAttribute("username");
		if(username != null)
			user = findByName(username);
		
		return user;
	}

}
