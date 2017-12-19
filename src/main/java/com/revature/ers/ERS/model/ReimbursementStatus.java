package com.revature.ers.ERS.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ERS_REIMBURSEMENT_STATUS")
public class ReimbursementStatus implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="REIMBURSEMENT_STATUS_ID")
	private int reimbursementStatusId;
	
	@Column(name="REIMBURSEMENT_STATUS_NAME")
	private String reimbursementStatusName;

	public int getReimbursementStatusId() {
		return reimbursementStatusId;
	}

	public void setReimbursementStatusId(int reimbursementStatusId) {
		this.reimbursementStatusId = reimbursementStatusId;
	}

	public String getReimbursementStatusName() {
		return reimbursementStatusName;
	}

	public void setReimbursementStatusName(String reimbursementStatusName) {
		this.reimbursementStatusName = reimbursementStatusName;
	}

	@Override
	public String toString() {
		return "ReimbursementStatus [reimbursementStatusId=" + reimbursementStatusId + ", reimbursementStatusName="
				+ reimbursementStatusName + "]";
	}
}


