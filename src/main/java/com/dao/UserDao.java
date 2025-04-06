package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.entity.UserEntity;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public void addUser(UserEntity user) {
		// query
		// executeUpdate
		// update
		// insert update delete
		stmt.update("insert into users (firstName,email,password) values (?,?,?)", user.getFirstName(), user.getEmail(),
				user.getPassword());
	}

	public List<UserEntity> getAllUsers() {

		// executeQuery
		// query
		List<UserEntity> users = stmt.query("select * from users", new BeanPropertyRowMapper<>(UserEntity.class));// firstName
		return users;
	}

	public List<UserEntity> searchByFirstName(String firstName) {
		List<UserEntity> users = stmt.query("select * from users where firstName = ?",
				new BeanPropertyRowMapper<>(UserEntity.class), firstName);// firstName
		return users;

	}
}
