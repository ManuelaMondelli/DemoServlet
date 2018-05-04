package com.acn.manu.service;

import javax.sql.DataSource;

import com.acn.manu.dao.DaoLogin;
import com.acn.manu.dto.DtoLogin;

public class ServiceLogin {

	private DaoLogin dao;
   

    public boolean login(DtoLogin dtoLogin, DataSource ds) {
        dao = new DaoLogin();
        //chiamata al dao che esegue la query
        boolean result = dao.verifyLogin(dtoLogin, ds);
        return result;
    }
	
}
