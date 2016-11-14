package service;

import beans.User;
import dao.UserDao;

public class LoginService {
	public static User login(String name,String password){
		return UserDao.getUser(name, password);
	}
}
