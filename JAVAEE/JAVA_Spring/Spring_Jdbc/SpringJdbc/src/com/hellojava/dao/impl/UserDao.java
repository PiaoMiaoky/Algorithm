package com.hellojava.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hellojava.dao.DBManager;
import com.hellojava.dao.IBaseDao;
import com.hellojava.entity.User;

@Repository
public class UserDao extends DBManager implements IBaseDao<User>{
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public int save(User t) throws SQLException {
		String sql = "insert into user values(default,?,password(?))";
		Connection conn = this.openConnection();
		Object[] obs = {t.getUserId(),t.getUserName(),t.getUserPwd()};
		int count = this.update(conn,sql,obs);
		this.closeConnection(conn);
		return count;
	}

	@Override
	public int update(User t) throws SQLException {
		String sql = "update user set userName=?,userPwd=password(?)";
		Connection conn = this.openConnection();
		Object[] obs = {t.getUserId(),t.getUserName(),t.getUserPwd()};
		int count = this.update(conn, sql, obs);
		this.closeConnection(conn);
		return count;
	}

	@Override
	public int delete(User t) throws SQLException {
		String sql = "delete from user where userId=?";
		Connection conn = this.openConnection();
		Object[] obs = {t.getUserId()};
		int count = this.update(conn, sql, obs);
		this.closeConnection(conn);
		return count;
	}

	@Override
	public User loadUser(int id) throws SQLException {
		User user = null;
		String sql = "select *from user where userId=?";
		Connection conn = this.openConnection();
		Object[] obs = {id};
		ResultSet rs = this.query(conn, sql, obs);
		if(rs.next()) {
			user = new User();
			user.setUserId(rs.getInt("userId"));
			user.setUserName(rs.getString("userName"));
			user.setUserPwd(rs.getString("userPwd"));
		}
		this.closeConnection(conn);
		return user;
	}

	@Override
	public List<User> loadAll() throws SQLException {
		List<User> userList = new ArrayList<User>();
		String sql = "select *from user";
		Connection conn = this.openConnection();
		ResultSet rs = this.query(conn, sql, null); 
		if(rs.next()) {
			User user = new User();
			user.setUserId(rs.getInt("userId"));
			user.setUserName(rs.getString("userName"));
			user.setUserPwd(rs.getString("userPwd"));
			userList.add(user);
		}
		this.closeConnection(conn);
		return userList;
	}
	
}
