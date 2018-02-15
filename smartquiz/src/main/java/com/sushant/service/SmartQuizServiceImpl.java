package com.sushant.service;

import java.sql.SQLException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushant.dao.SmartQuizDAO;
import com.sushant.dao.SmartQuizDAOImpl;
import com.sushant.dao.User;
@Service("smarQuizServiceImpl")
public class SmartQuizServiceImpl implements SmartQuizService{
@Autowired(required=false)
	public SmartQuizDAO smartQuizDAOImpl;
	public String insertUser(User user) throws SQLException {
		String status="Record Insertion Failed !Please Try Again";
		int count =smartQuizDAOImpl.insertUser(user);
		if(count==1)
			status="Record Inserted Succesfully";
		return status;
	}


	public String updatePassword(String username, String password)
			throws SQLException {
		String status="Updation Password Failed! Please Try Again ";
		int count =smartQuizDAOImpl.updatePassword(username, password);
		if(count==1)
		status="Password Updated Succesfully";
		return status;
	}

	
	public Set<String> searchUser(String username) throws SQLException {
		Set<String> set =smartQuizDAOImpl.searchUser(username);
		
		return set;
	}

}
