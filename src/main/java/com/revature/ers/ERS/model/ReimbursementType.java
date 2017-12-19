package com.revature.ers.ERS.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ERS_REIMBURSEMENT_TYPE")
public class ReimbursementType implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="REIMBURSEMENT_TYPE_ID")
	private int reimbursementTypeId;
	
	@Column(name="REIMBURSEMENT_TYPE_NAME")
	private String reimbursementTypeName;

	public int getReimbursementTypeId() {
		return reimbursementTypeId;
	}

	public void setReimbursementTypeId(int reimbursementTypeId) {
		this.reimbursementTypeId = reimbursementTypeId;
	}

	public String getReimbursementTypeName() {
		return reimbursementTypeName;
	}

	public void setReimbursementTypeName(String reimbursementTypeName) {
		this.reimbursementTypeName = reimbursementTypeName;
	}

	@Override
	public String toString() {
		return "ReimbursementType [reimbursementTypeId=" + reimbursementTypeId + ", reimbursementTypeName="
				+ reimbursementTypeName + "]";
	}
}


