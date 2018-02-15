package com.sushant.service;

import java.sql.SQLException;
import java.util.Set;

import com.sushant.dao.User;

public interface SmartQuizService {
	public String insertUser(User user) throws SQLException;
	public String updatePassword(String username,String password) throws SQLException;
	public Set<String> searchUser(String username) throws SQLException;
}
