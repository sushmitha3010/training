package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.model.Register;


//@WebServlet(name = "RegisterTestServlet", urlPatterns = { "/RegisterTestServlet" })
public class RegTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Register reg=new Register();
    
    public RegTestServlet() {
        super();
       
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
				System.out.println(connection);
				
				String query="insert into Register(user_id,user_name,password,mobile_no,aadhar_no,address)values(?,?,?,?,?,?)";
				PreparedStatement ps = connection.prepareStatement(query);
				
				String UserId=request.getParameter("UserId");
				reg.setUserId(UserId);
			
				String UserName = request.getParameter("UserName");
				reg.setUserName(UserName);
				
				String Password = request.getParameter("Password");
				reg.setPassword(Password);
				
				String MobileNo=request.getParameter("MobileNo");
				reg.setMobileNo(MobileNo);
				
				String AadharNo=request.getParameter("AadharNo");
				reg.setAadharNo(AadharNo);
				
				String Address=request.getParameter("Address");
				reg.setAddress(Address);
				
				PrintWriter writer = response.getWriter();
				writer.println(UserId);
				writer.println(UserName);
				writer.println(Password);
				writer.println(MobileNo);
				writer.println(AadharNo);
				writer.println(Address);
				

				      
			    ps.setString(1,reg.getUserId());
			    ps.setString(2,reg.getUserName());
			    ps.setString(3,reg.getPassword());
			    ps.setString(4,reg.getMobileNo());
			    ps.setString(5,reg.getAadharNo());
			    ps.setString(6,reg.getAddress());
			    
			    request.getRequestDispatcher("HomePage.jsp").forward(request, response);

			    
			    writer.println("Register Successfully");
			    
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
		/*String UserId = request.getParameter("UserId");
		PrintWriter writer = response.getWriter();
		writer.println("User Id:" + UserId);

		String UserName = request.getParameter("UserName");
		PrintWriter writer1 = response.getWriter();
		writer.println("User Name:" + UserName);

		String Password = request.getParameter("Password");
		PrintWriter writer2 = response.getWriter();
		writer.println("Password:" + Password);

		String MobileNo = request.getParameter("MobileNo");
		PrintWriter writer3 = response.getWriter();
		writer.println("Mobile No:" + MobileNo);

		String AadharNo = request.getParameter("AadharNo");
		PrintWriter writer4 = response.getWriter();
		writer.println("Aadhar No:" + AadharNo);
		
		String Address=request.getParameter("Address");
		PrintWriter writer5 = response.getWriter();
		writer.println("Address:"+Address);*/
		
	}
	
	



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
