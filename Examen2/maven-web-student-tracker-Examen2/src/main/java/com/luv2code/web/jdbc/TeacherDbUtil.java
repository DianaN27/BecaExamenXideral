package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class TeacherDbUtil {

	private DataSource dataSource;

	public TeacherDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Teacher> getStudents() throws Exception {
		
		List<Teacher> teachers = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from teacher order by last_name_teacher";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id_teacher");
				String firstName = myRs.getString("first_name_teacher");
				String lastName = myRs.getString("last_name_teacher");
				String email = myRs.getString("email_teacher");
				
				// create new student object
				Teacher tempStudent = new Teacher(id, firstName, lastName, email);
				
				// add it to the list of students
				teachers.add(tempStudent);				
			}
			
			return teachers;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addTeacher(Teacher theTeacher) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into teacher "
					   + "(first_name_teacher, last_name_teacher, email_teacher) "
					   + "values (?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, theTeacher.getFirstName());
			myStmt.setString(2, theTeacher.getLastName());
			myStmt.setString(3, theTeacher.getEmail());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public Teacher getTeacher(String theTeacherID) throws Exception {

		Teacher theTeacher = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int teacherId;
		
		try {
			// convert student id to int
			teacherId = Integer.parseInt(theTeacherID);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected student
			String sql = "select * from teacher where id_teacher=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, teacherId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String firstName = myRs.getString("first_name_teacher");
				String lastName = myRs.getString("last_name_teacher");
				String email = myRs.getString("email_teacher");
				
				// use the studentId during construction
				theTeacher = new Teacher(teacherId, firstName, lastName, email);
			}
			else {
				throw new Exception("Could not find student id: " + teacherId);
			}				
			
			return theTeacher;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateTeacher(Teacher theTeacher) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update teacher "
						+ "set first_name_teacher=?, last_name_teacher=?, email_teacher=? "
						+ "where id_teacher=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theTeacher.getFirstName());
			myStmt.setString(2, theTeacher.getLastName());
			myStmt.setString(3, theTeacher.getEmail());
			myStmt.setInt(4, theTeacher.getId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteTeacher(String theTeacherID) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert student id to int
			int teacherId = Integer.parseInt(theTeacherID);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete student
			String sql = "delete from teacher where id_teacher=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, teacherId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
}















