package com.heskuelita.service;

import com.heskuelita.pojo.Student;

public interface BaseService {
 public boolean login(String username, String password);

 public String registration(Student student);
}