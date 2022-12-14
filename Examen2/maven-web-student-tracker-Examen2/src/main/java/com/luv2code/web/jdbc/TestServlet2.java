package com.luv2code.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/ServletTryWithResource")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Define datasource/connection pool for Resource Injection
	@Resource(name = "jdbc/web_student_tracker")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		System.out.println("Paso por init de ServletTryWithResource");
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Step 1: Set up the printwriter
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");		

		try ( Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery
						("select * from teacher")) {
			
			// Step 5: Process the result set
			while (myRs.next()) {
				String last_name_teacher = myRs.getString("last_name_teacher");
				String first_name_teacher = myRs.getString("first_name_teacher");
				String email_teacher = myRs.getString("email_teacher");
				out.println(first_name_teacher + " " + last_name_teacher + " " + email_teacher);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} 
	}

}
