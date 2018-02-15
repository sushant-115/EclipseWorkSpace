package com.user.dao;

import java.util.List;

import com.user.pojo.User;

public interface UserDAO {
	public int createUser(User user);
	public List<User> getAllUsers();
	public int deleteUser(int userId);
	

}
