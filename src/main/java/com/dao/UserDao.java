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
		stmt.update("insert into users (firstName,email,password,profilepicpath) values (?,?,?,?)", user.getFirstName(), user.getEmail(),
				user.getPassword(),user.getProfilePicPath());
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

	public void deleteUser(Integer userId) {
		stmt.update("delete from users where userId = ? ", userId);
	}

	public UserEntity getByUserId(Integer userId) {
		UserEntity user = null;
		try {
			user = stmt.queryForObject("select * from users where userId = ? ",
					new BeanPropertyRowMapper<>(UserEntity.class), userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public void updateUser(UserEntity user) {
		stmt.update("update users set firstName = ? where userId = ? ", user.getFirstName(), user.getUserId());
	}
	
	public UserEntity getUserByEmail(String email) {
		UserEntity user = null;
		try {
			user = stmt.queryForObject("select * from users where email = ? ",
					new BeanPropertyRowMapper<>(UserEntity.class), email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
