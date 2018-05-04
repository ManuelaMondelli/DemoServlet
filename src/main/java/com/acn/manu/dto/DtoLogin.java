package com.acn.manu.dto;

public class DtoLogin {

	private String username;
    private String password;

    public DtoLogin(String username,String password ) {
        this.username=username;
        this.password=password;
    }

    public DtoLogin() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	
}
