package com.acn.manu.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.acn.manu.dto.DtoEmployee;
import com.acn.manu.service.ServiceEmployee;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/employee")
public class ControllerEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource dataSource;
	private ServiceEmployee serviceEmployee;
	private DtoEmployee dtoEmp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerEmployee() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	//collegamento al file context per il caricamento del data source
    public void init(ServletConfig config) {
        try {
        	 System.out.println("-----------------------------------------------------");
             System.out.println("init method has been called and servlet is initialized");

             /*
             * Using JDNI lookup get the DataSource.
              */
             Context initContext = new InitialContext();
             Context envContext = (Context) initContext.lookup("java:/comp/env");
             dataSource = (DataSource) envContext.lookup("jdbc/HRDB");

             System.out.println("Using JDNI lookup got the DataSource : " + dataSource);
             System.out.println("-----------------------------------------------------");
        }catch (Exception ex) {
            System.out.println("ERROR");
        }
    }	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("Employee ID: " +request.getParameter("selectedrow")); 
        String id=request.getParameter("selectedrow");
        System.out.println(request.getParameter("selectedrow"));
        int idE=Integer.parseInt(id);
        System.out.println("Operazione : " +request.getParameter("hidden_field_operation"));
        String operation=request.getParameter("hidden_field_operation");
        serviceEmployee = new ServiceEmployee();
       
        if (operation.equals("update")) {
        	dtoEmp=new DtoEmployee();
        	dtoEmp=serviceEmployee.find(idE, operation, dataSource);
            RequestDispatcher rd = request.getRequestDispatcher("employee.jsp");
            request.getSession().setAttribute("dto",dtoEmp);
            rd.forward(request, response);
        }else{
        	int row=serviceEmployee.delete(idE, operation, dataSource);
        	RequestDispatcher rd = request.getRequestDispatcher("deletedEmployee.jsp");
            rd.forward(request, response);
        }
        
        
}
}

