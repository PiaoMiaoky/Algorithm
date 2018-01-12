package com.hellojava.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import com.hellojava.entity.User;

public interface IBaseDao<T extends Serializable> {
	public int save(T t)throws SQLException;
	public int update(T t)throws SQLException;
	public int delete(T t)throws SQLException;
	public User loadUser(int id)throws SQLException;
	public List<T> loadAll()throws SQLException;
}
