package com.acn.manu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class ControllerAllEmployee
 */
@WebServlet("/allemployee")
public class ControllerAllEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceEmployee serviceEmployee;
	private DataSource dataSource;
	private List<DtoEmployee> listEmployee;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAllEmployee() {
        super();
       }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        serviceEmployee = new ServiceEmployee();
        //chiamata al Service
        listEmployee = serviceEmployee.verifyActivity(dataSource);
        //ciclo sulla lista di tipo DtoEmployee e stampa in console i campi di interesse
       // System.out.println("List Employees ");
       /* for (DtoEmployee DtoEmployee : listEmployee) {
        	System.out.println("\r");
            System.out.println(DtoEmployee.getEmployeeId() + " " + DtoEmployee.getFirstName()+ " " + DtoEmployee.getLastName());
            System.out.println(DtoEmployee.getEmail()+ " " + DtoEmployee.getPhoneNumber());
            System.out.println(DtoEmployee.getJobId()+ " " + DtoEmployee.getManagerId() + " " + DtoEmployee.getDepartmentId());
           
        }*/
        //invio dei file alla pagina jsp che mostra l'elenco degli impiegati
        RequestDispatcher rd = request.getRequestDispatcher("allemployees.jsp");
        request.getSession().setAttribute("listEmployee",listEmployee);
        rd.forward(request, response);
        
}
}
