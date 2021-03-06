package com.book.model.admin;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable {  
	
	private static final long serialVersionUID = -7898194272883238670L;  
	
	private Integer id;

    private String username;

    private String password;

    private String createdBy;

    private Date createdOn;

    public Admin(){}
    
    public Admin(Integer id, String username, String password,
			String createdBy, Date createdOn) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    
    @Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password=" + password + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + "]";
	}
}