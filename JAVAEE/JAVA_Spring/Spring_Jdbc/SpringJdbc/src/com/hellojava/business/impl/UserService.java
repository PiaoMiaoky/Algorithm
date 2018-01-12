package com.hellojava.business.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellojava.business.IUserService;
import com.hellojava.dao.IBaseDao;
import com.hellojava.entity.User;

@Service
public class UserService implements IUserService{
	@Autowired
	private IBaseDao<User> userDao;
	
	
	@Override
	public boolean save(User user) {
		boolean bool = false;
		try {
			int count =  userDao.save(user);
			bool=count>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bool;
	}

	@Override
	public boolean update(User user) {
		boolean bool = false;
		try {
			int count = userDao.update(user);
			bool = count>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bool;
	}

	@Override
	public boolean delete(User user) {
		boolean bool = false;
		try {
			int count = userDao.delete(user);
			bool = count>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bool;
	}

	@Override
	public User loadUser(int id) {
		User user = null;
		try {
			user = userDao.loadUser(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}

	@Override
	public List<User> loadAll() {
		List<User> userList=null;
		try {
			userList = userDao.loadAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	
}
