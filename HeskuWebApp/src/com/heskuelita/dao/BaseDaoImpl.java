package com.heskuelita.dao;

import org.hibernate.Session;


import com.heskuelita.pojo.Student;
import com.heskuelita.util.HibernateUtil;

public class BaseDaoImpl implements BaseDao {

 @Override
 public boolean login(String username, String password) {
  Session session = HibernateUtil.getSession();
  if (session != null) {
   try {
    Student student = (Student) session.get(Student.class, username);
    if (password.equals(student.getPassword())) {
     System.out.println("User: " + student.toString());
     return true;
    }
   } catch (Exception exception) {
    System.out.println("Exception occred while reading user data: "
      + exception.getMessage());
    return false;
   }

  } else {
   System.out.println("DB server down.....");
  }
  return false;
 }

 @Override
 public String register(Student student) {
  String msg = "Registration unsuccessful, try again.....";
  Session session = HibernateUtil.getSession();
  if (session != null) {
   try {
    if (student != null) {
     String username = (String) session.save(student);
     session.beginTransaction().commit();
     msg = "User " + username
       + " created successfully, please login...";
    }
   } catch (Exception exception) {
    System.out.println("Exception occred while reading user data: "
      + exception.getMessage());
   }

  } else {
   System.out.println("DB server down.....");
  }
  System.out.println("msg:" + msg);
  return msg;
 }
}