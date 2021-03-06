package ifi.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ifi.com.dao.Bill_Imp;
import ifi.com.model.Bill;

/**
 * Servlet implementation class Success
 */
@WebServlet("/success")
public class Success extends HttpServlet {
	final static Logger logger = Logger.getLogger(Success.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Success() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Bill> billList = new ArrayList<Bill>();
		Bill_Imp bill_imp = new Bill_Imp();
		billList = bill_imp.getAllList();
		logger.fatal(billList);
		request.setAttribute("billList", billList);
		RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
		rd.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
