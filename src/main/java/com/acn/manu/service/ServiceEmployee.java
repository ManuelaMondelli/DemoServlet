package com.acn.manu.service;

import java.util.List;

import javax.sql.DataSource;

import com.acn.manu.dao.DaoEmployee;
import com.acn.manu.dto.DtoEmployee;

public class ServiceEmployee {

	private List<DtoEmployee> listEmployee;
	private DaoEmployee daoEmployee= new DaoEmployee();
	private boolean result=false;
	private DataSource ds;
	private int row;
	private DtoEmployee dtoAddEmp;
	private DtoEmployee dtoEmp;
	private DtoEmployee dtoUpEmp;
	
	public List<DtoEmployee> verifyActivity(DataSource ds) {
		// chiamata al metodo Dao che esegue la query sul database
		listEmployee = daoEmployee.allEmployees(ds);
		return listEmployee;
	}

	public int create(DtoEmployee dtoAddEmp, DataSource ds) {
		row=daoEmployee.addEmployee(dtoAddEmp, ds);
		return row;
	}
	
	public DtoEmployee find(int idE, String operation, DataSource ds) {
		dtoEmp=daoEmployee.printEmployee(idE, operation, ds);
		return dtoEmp;
	}

	public int update(int idE, DtoEmployee dtoUpEmp, DataSource ds) {
		row=daoEmployee.updateEmployee(idE, dtoUpEmp, ds);
		return row;
	}
	
	public int delete(int idE, String operation, DataSource ds) {
		row=daoEmployee.deleteEmployee(idE, operation, ds);
		return row;
	}

}
