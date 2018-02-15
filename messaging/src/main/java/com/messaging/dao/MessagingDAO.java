package com.messaging.dao;

import java.util.List;

import com.messaging.entity.MessageUser;
import com.messaging.entity.User;
import com.messaging.entity.UserProfilePhoto;

public interface MessagingDAO {
public List login(String userName,String password);
public int singup(User user);
public String sendMessage(MessageUser user);
public List<MessageUser> getMessage(String uName);
public String uploadPhoto(UserProfilePhoto user);
public byte[] retrievePhoto(String uName);
public String updatePassword(String uname,String newPassword);
public User getUser(String uname);
public boolean redirect(String uname);
public List retrieveQuestion(String qType);
}
