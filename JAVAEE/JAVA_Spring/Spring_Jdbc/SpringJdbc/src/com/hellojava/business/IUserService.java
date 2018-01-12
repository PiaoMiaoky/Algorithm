package com.hellojava.business;

import java.util.List;

import com.hellojava.entity.User;

public interface IUserService {
	public boolean save(User user);
	public boolean update(User user);
	public boolean delete(User user);
	public User loadUser(int id);
	public List<User> loadAll();
}
