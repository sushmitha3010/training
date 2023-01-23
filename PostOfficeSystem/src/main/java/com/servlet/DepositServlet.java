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

@WebServlet(name = "DepositTest", urlPatterns = { "/DepositTest" })
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DepositServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
				System.out.println(connection);
				
				String query="Insert into Deposit(user_id,user_name,mobile_no,account_no,ifsc_code,amount)values(?,?,?,?,?,?)";
				PreparedStatement ps = connection.prepareStatement(query);
				
				String UserId=request.getParameter("UserId");
				String UserName = request.getParameter("UserName");
				String MobileNo = request.getParameter("MobileNo");
				String AccountNo = request.getParameter("AccountNo");
				String IfscCode=request.getParameter("IfscCode");
				String Amount=request.getParameter("Address");
				
				ps.setString(1,request.getParameter("UserId"));
				ps.setString(2,request.getParameter("UserName"));
				ps.setString(3,request.getParameter("AccountNo"));
				ps.setString(4,request.getParameter("MobileNo"));
				ps.setString(5,request.getParameter("IfscCode"));
				ps.setString(6,request.getParameter("Amount"));
				
				 request.getRequestDispatcher("HomePage.jsp").forward(request, response);
				
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

				
				
				String UserId = request.getParameter("UserId");
				PrintWriter writer = response.getWriter();
				writer.println("User Id:" + UserId);

				String UserName = request.getParameter("UserName");
				PrintWriter writer1 = response.getWriter();
				writer.println("User Name:" + UserName);

				
				String MobileNo = request.getParameter("MobileNo");
				PrintWriter writer3 = response.getWriter();
				writer.println("Mobile No:" + MobileNo);
				
				String AccountNo= request.getParameter("AccountNo");
				PrintWriter writer2 = response.getWriter();
				writer.println("Account No:" + AccountNo);


				String IfscCode = request.getParameter("IfscCode");
				PrintWriter writer4 = response.getWriter();
				writer.println("Ifsc Code:" + IfscCode);
				
				String Amount=request.getParameter("Amount");
				PrintWriter writer5 = response.getWriter();
				writer.println("Amount:"+Amount);
					
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
