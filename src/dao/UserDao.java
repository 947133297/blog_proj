package dao;

import beans.User;

public class UserDao {
	public static User getUser(String name,String password){
		// 校验数据库
		boolean ok = name.equals(password);
		
		if(ok){
			return new User("小明");
		}
		return null;
	}
}
