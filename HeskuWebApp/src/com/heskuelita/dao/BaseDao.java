package com.heskuelita.dao;

import com.heskuelita.pojo.Student;

public interface BaseDao {
 public boolean login(String username, String password);

 public String register(Student student);
}
