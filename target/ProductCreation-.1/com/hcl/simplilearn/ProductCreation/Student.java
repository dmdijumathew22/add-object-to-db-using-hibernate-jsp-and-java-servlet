package com.hcl.simplilearn.ProductCreation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.hcl.simplilearn.ProductCreation.entity.StudentEntity;
import com.hcl.simplilearn.ProductCreation.hibernate.HibernateUtils;

/**
 * Servlet implementation class Student
 */
@WebServlet("/StudentInsertion")
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Session hibernateSession;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	public void init() throws ServletException {
		hibernateSession = HibernateUtils.buildSessionFactory().openSession();
		hibernateSession.beginTransaction();


		super.init();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentEntity s = new StudentEntity();
		s.setFirstName(request.getParameter("first_name")); 
		s.setLastName(request.getParameter("last_name"));
		s.setPercentage(Float.parseFloat(request.getParameter("percentage")));
		hibernateSession.save(s);
		hibernateSession.getTransaction().commit();
		 response.setContentType("text/html");

	        PrintWriter out = response.getWriter();
	        out.println("ID : "+s.getId());
	        out.println("Name : "+ s.getFirstName()+" "+s.getLastName());
	        out.println("Percetage : "+ s.getPercentage());
	        
	        
		System.out.println(s.getFirstName()+" "+ s.getLastName()+""+ s.getPercentage());
		hibernateSession.close();
	}

}
