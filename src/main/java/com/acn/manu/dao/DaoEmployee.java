package com.acn.manu.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.sql.DataSource;

import com.acn.manu.dto.DtoEmployee;

public class DaoEmployee {

	private List<DtoEmployee> listEmployee;
	private Connection connection;
	private Statement stm;
	private PreparedStatement pstm;
	private ResultSet rs;
	private DtoEmployee empApp;
	private DtoEmployee dtoEmp;
	private DtoEmployee dtoUpEmp;
	private boolean result=false;
	private int row;
	
	public List<DtoEmployee> allEmployees(DataSource ds){
		final String sql="SELECT * FROM EMPLOYEES";
		
		try {
			//apertura della connessione
			//creazione dello statement
			//esecuzione della query
		connection=ds.getConnection();
		stm=connection.createStatement();
		rs=stm.executeQuery(sql);
		listEmployee = new ArrayList<DtoEmployee>();
		
		while(rs.next()) {
			//setting del dto di appoggio
			 empApp = new DtoEmployee();
			 empApp.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
             empApp.setFirstName(rs.getString("FIRST_NAME"));
             empApp.setLastName(rs.getString("LAST_NAME"));
             empApp.setEmail(rs.getString("EMAIL") );
             empApp.setPhoneNumber(rs.getString("PHONE_NUMBER"));
             empApp.setJobId(rs.getString("JOB_ID"));
             empApp.setManagerId(rs.getInt("MANAGER_ID"));
             empApp.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
             //aggiunta del dto di appoggio alla lista
             listEmployee.add(empApp);
		}//chiusura del result set, dello Statement e della connessione
		rs.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
		return listEmployee;
			
	}
	
	
	public int addEmployee(DtoEmployee dtoAddEmp, DataSource ds){
		final String sql="INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID, HIRE_DATE)"+
						 "VALUES (?,?,?,?,?,?,?,?,?,?,SYSDATE)";
		try {
		connection=ds.getConnection();
		pstm=connection.prepareStatement(sql);
		
//		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//        Date hireDate;
//        java.sql.Date sqlHireDate;
//		try {
//			hireDate = format.parse(dto.getHireDate());
//			sqlHireDate = new java.sql.Date(hireDate.getTime());
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			sqlHireDate = null;
//		}
        
		pstm.setInt(1,dtoAddEmp.getEmployeeId());
		pstm.setString(2,dtoAddEmp.getFirstName());
		pstm.setString(3,dtoAddEmp.getLastName());
		pstm.setString(4,dtoAddEmp.getEmail());
		pstm.setString(5,dtoAddEmp.getPhoneNumber());
		//pstm.setDate(6,sqlHireDate);
		pstm.setString(6,dtoAddEmp.getJobId());
		pstm.setDouble(7,dtoAddEmp.getSalary());
		pstm.setDouble(8,dtoAddEmp.getCommissionPct());
		pstm.setInt(9,dtoAddEmp.getManagerId());
		pstm.setInt(10,dtoAddEmp.getDepartmentId());
		
		row=pstm.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} try {
            if (stm != null) {
                stm.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
		
		return row;
	}
	
	public DtoEmployee printEmployee(int idE, String operation, DataSource ds) {
		final String sql="SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
				
		try {
		connection=ds.getConnection();
		pstm=connection.prepareStatement(sql);
		pstm.setInt(1, idE);
		rs=pstm.executeQuery();
		
		while(rs.next()) {
			dtoEmp=new DtoEmployee();
			dtoEmp.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
			dtoEmp.setFirstName(rs.getString("FIRST_NAME"));
			dtoEmp.setLastName(rs.getString("LAST_NAME"));
			dtoEmp.setEmail(rs.getString("EMAIL") );
			dtoEmp.setPhoneNumber(rs.getString("PHONE_NUMBER"));
			dtoEmp.setJobId(rs.getString("JOB_ID"));
			dtoEmp.setSalary(rs.getDouble("SALARY"));
			dtoEmp.setCommissionPct(rs.getDouble("COMMISSION_PCT"));
			dtoEmp.setManagerId(rs.getInt("MANAGER_ID"));
			dtoEmp.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
           
		}
		}catch (SQLException e) {
			e.printStackTrace();
		} try {
            if (stm != null)
                stm.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } try {
            if (connection != null) 
                connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
		
		return dtoEmp;
	}


	public int updateEmployee(int idE, DtoEmployee dtoUpEmp, DataSource ds) {
		final String sql="UPDATE EMPLOYEES SET FIRST_NAME=?, LAST_NAME=?, EMAIL=?, PHONE_NUMBER=?, JOB_ID=?, SALARY=?, COMMISSION_PCT=?, MANAGER_ID=?, DEPARTMENT_ID=?"+ 
						 "WHERE EMPLOYEE_ID=?";
		
		try {
			connection=ds.getConnection();
			pstm=connection.prepareStatement(sql);
			
			pstm.setString(1,dtoUpEmp.getFirstName());
			pstm.setString(2,dtoUpEmp.getLastName());
			pstm.setString(3,dtoUpEmp.getEmail());
			pstm.setString(4,dtoUpEmp.getPhoneNumber());
			pstm.setString(5,dtoUpEmp.getJobId());
			pstm.setDouble(6,dtoUpEmp.getSalary());
			pstm.setDouble(7,dtoUpEmp.getCommissionPct());
			pstm.setInt(8,dtoUpEmp.getManagerId());
			pstm.setInt(9,dtoUpEmp.getDepartmentId());
			pstm.setInt(10,idE);
			
			row=pstm.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
		
		return row;
	}
	
	public int deleteEmployee(int idE, String operation, DataSource ds){
		final String sql="DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		
		try {
			connection=ds.getConnection();
			pstm=connection.prepareStatement(sql);
			
			pstm.setInt(1, idE);
			row=pstm.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
		
		return row;
	}
}

