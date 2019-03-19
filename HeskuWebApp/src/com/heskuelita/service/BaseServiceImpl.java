package com.heskuelita.service;


import com.heskuelita.dao.BaseDao;
import com.heskuelita.dao.BaseDaoImpl;
import com.heskuelita.pojo.Student;

public class BaseServiceImpl implements BaseService {

	 private BaseDao loginDao = new BaseDaoImpl();

	 @Override
	 public boolean login(String username, String password) {
	  return loginDao.login(username, password);
	 }

	 @Override
	 public String registration(Student student) {
	  return loginDao.register(student);
	 }

	}