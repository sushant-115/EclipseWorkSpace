package com.sushant.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface SmartQuizDAO {
public int insertUser(User user) throws SQLException;
public int updatePassword(String username,String password) throws SQLException;
public Set<String> searchUser(String username) throws SQLException;
}
