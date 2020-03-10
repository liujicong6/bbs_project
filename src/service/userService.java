package service;

import dao.userDao;
import pojo.user;

public class userService {
	userDao  userDao=new userDao();
	public user findUserById(String userId) {
		return userDao.findUserById(userId);
	}
	
	
	public int addBookUser(user user) {
		return userDao.addBookUser(user);
	}
}
