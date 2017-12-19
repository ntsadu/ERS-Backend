package com.revature.ers.ERS.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ERS_USER_ROLE")
public class UserRole implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="USER_ROLE_ID")
	private int userRoleId;
	
	@Column(name="USER_ROLE_NAME")
	private String userRoleName;

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", userRoleName=" + userRoleName + "]";
	}
}

