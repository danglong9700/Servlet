package ifi.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ifi.com.dao.EmployeeDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	final static Logger logger = Logger.getLogger(Login.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uName = request.getParameter("uName");
		logger.debug(uName);
		String uPassword = request.getParameter("uPassword");
		logger.debug(uPassword);
		EmployeeDao employeeDao = new EmployeeDao();
		boolean loginValidate = employeeDao.validateLogin(uName, uPassword);
		logger.fatal(loginValidate);
		if (loginValidate == true) {
			RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
			rd.forward(request,response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request,response);
		}
		
	}

}
