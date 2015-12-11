package com.gis.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

//@Transactional
public interface UserDao extends CrudRepository<User, Long> {
//	List<User> findByEmail(String email);
	List<User> findByEmail(String email);
	List<User> findByname(String name);
}
