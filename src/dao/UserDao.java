package dao;

import beans.User;

public class UserDao {
	public static User getUser(String name,String password){
		// У�����ݿ�
		boolean ok = name.equals(password);
		
		if(ok){
			return new User("С��");
		}
		return null;
	}
}
