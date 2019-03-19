package com.heskuelita.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heskuelita.dao.BaseDao;
import com.heskuelita.dao.BaseDaoImpl;
import com.heskuelita.pojo.Student;


public class RegistrationController extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }


 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.sendRedirect("userRegistration.jsp");
 }


 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String msg = "Password and Conform Passwords must be same";
  String page = "userRegistration.jsp";
  if(request.getParameter("password").equals(request.getParameter("confPassword"))){
   Student student = new Student();
   student.setUsername(request.getParameter("username"));
   student.setPassword(request.getParameter("password"));
   student.setFirstName(request.getParameter("firstName"));
   student.setLastName(request.getParameter("lastName"));

   
   System.out.println(student.toString());
   BaseDao baseDao = new BaseDaoImpl();
   msg = baseDao.register(student);
   page = "login.jsp";
  } 
  request.setAttribute("msg2", msg);
  request.getRequestDispatcher(page).include(request, response);
 }

}