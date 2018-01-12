package com.hellojava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class DBManager {
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Connection openConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	public void closeConnection(Connection conn) throws SQLException{
		if(conn!=null&&!conn.isClosed()) {
			conn.close();
		}
	}
	
	public ResultSet query(Connection conn,String sql,Object...obs) throws SQLException{
		ResultSet rs = null;
		if(conn!=null&&!conn.isClosed()) {
			PreparedStatement psment = conn.prepareStatement(sql);
			if(obs!=null) {
				for (int i = 0; i < obs.length; i++) {
					psment.setObject(i+1, obs[i]);
				}
			}
			rs = psment.executeQuery();
		}
		return rs;
	}
	
	public int update(Connection conn,String sql,Object...obs) throws SQLException{
		int count = 0;
		if(conn!=null&&!conn.isClosed()) {
			PreparedStatement psment = conn.prepareStatement(sql);
			if(obs!=null) {
				for (int i = 0; i < obs.length; i++) {
					psment.setObject(i+1, obs[i]);
				}
			}
			count = psment.executeUpdate();
		}
		return count;
	}
	
}
