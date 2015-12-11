package com.gis.springboot.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gis.springboot.springboot.Man;
import com.gis.springboot.springboot.Person;

/**
 * Created by wenchao.ren on 2014/4/26.
 */
@Controller
//@EnableAutoConfiguration
@SpringBootApplication
public class SimpleController {

	@Autowired
	private UserDao userDao ;
	
	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		return "hello world,i'm here";
	}

	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	@ResponseBody
	public Person getPerson() {
		return new Person("hello world", "100", "tianjin,China!");
	}

	@RequestMapping(value = "/man", method = RequestMethod.GET)
	@ResponseBody
	public com.gis.springboot.springboot.Man user() {
		return new com.gis.springboot.springboot.Man("sichuan", "tianjin", 100);
	}

	@RequestMapping("/man/{id}")
	@ResponseBody
	public com.gis.springboot.springboot.Man view(@PathVariable("id") int id) {
		com.gis.springboot.springboot.Man user = new com.gis.springboot.springboot.Man(
				"beijing", "lundun", id);
		return user;
	}

	@RequestMapping("/email/{emailid}")
	@ResponseBody
	public List<User> getByEmail(@PathVariable("emailid") String email) {
		
		List<User> listUser = userDao.findByEmail(email);
		return listUser;
	}
	
	@RequestMapping("/name/{name}")
	@ResponseBody
	public List<User> getByName(@PathVariable("name") String name) {
		
		List<User> listUser = userDao.findByname(name);
		return listUser;
	}

	@RequestMapping("/add/{name}")
	@ResponseBody
	public Object addUser(@PathVariable("name") String name) {
		User newUser=new User(name,name);
		Object o=userDao.save(newUser);
		return o;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SimpleController.class, args);
	}
}