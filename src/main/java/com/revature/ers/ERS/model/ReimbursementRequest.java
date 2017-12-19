package com.revature.ers.ERS.model;

import java.io.Serializable;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ERS_REIMBURSEMENT_REQUEST")
public class ReimbursementRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="REIMBURSEMENT_REQUEST_ID")
	private int reimbursementRequestId;
	
	@Column(name="REIMBURSEMENT_AMOUNT")
	private double reimbursementRequestAmount;
	
	@Column(name="REIMBURSEMENT_DESCRIPTION")
	private String reimbursementDescription;
	
	@Column(name="REIMBURSEMENT_SUBMITTED")
	private String reimbursementSubmitted;
	
	@Column(name="REIMBURSEMENT_PROCESSED")
	private String reimbursementProcessed;
	
	@Column(name="REIMBURSEMENT_RECEIPT")
	private Blob reimbursementReceipt;
	
	@Column(name="REIMBURSEMENT_AUTHOR_ID")
	private int reimbursementAuthorId;

	@Column(name="REIMBURSEMENT_PROCESSOR_ID", nullable = true)
	private Integer reimbursementProcessorId;
	
	@Column(name="REIMBURSEMENT_STATUS_ID")
	private int reimbursementStatusId;
	
	@Column(name="REIMBURSEMENT_TYPE_ID")
	private int reimbursementTypeId;

	public int getReimbursementRequestId() {
		return reimbursementRequestId;
	}

	public void setReimbursementRequestId(int reimbursementRequestId) {
		this.reimbursementRequestId = reimbursementRequestId;
	}

	public double getReimbursementRequestAmount() {
		return reimbursementRequestAmount;
	}

	public void setReimbursementRequestAmount(double reimbursementRequestAmount) {
		this.reimbursementRequestAmount = reimbursementRequestAmount;
	}

	public String getReimbursementDescription() {
		return reimbursementDescription;
	}

	public void setReimbursementDescription(String reimbursementDescription) {
		this.reimbursementDescription = reimbursementDescription;
	}

	public String getReimbursementSubmitted() {
		return reimbursementSubmitted;
	}

	public void setReimbursementSubmitted(String reimbursementSubmitted) {
		this.reimbursementSubmitted = reimbursementSubmitted;
	}

	public String getReimbursementProcessed() {
		return reimbursementProcessed;
	}

	public void setReimbursementProcessed(String reimbursementProcessed) {
		this.reimbursementProcessed = reimbursementProcessed;
	}

	public Blob getReimbursementReceipt() {
		return reimbursementReceipt;
	}

	public void setReimbursementReceipt(Blob reimbursementReceipt) {
		this.reimbursementReceipt = reimbursementReceipt;
	}

	public int getReimbursementAuthorId() {
		return reimbursementAuthorId;
	}

	public void setReimbursementAuthorId(int reimbursementAuthorId) {
		this.reimbursementAuthorId = reimbursementAuthorId;
	}

	public Integer getReimbursementProcessorId() {
		return reimbursementProcessorId;
	}

	public void setReimbursementProcessorId(Integer reimbursementProcessorId) {
        this.reimbursementProcessorId = reimbursementProcessorId;
	}

	public int getReimbursementStatusId() {
		return reimbursementStatusId;
	}

	public void setReimbursementStatusId(int reimbursementStatusId) {
		this.reimbursementStatusId = reimbursementStatusId;
	}

	public int getReimbursementTypeId() {
		return reimbursementTypeId;
	}

	public void setReimbursementTypeId(int reimbursementTypeId) {
		this.reimbursementTypeId = reimbursementTypeId;
	}

	@Override
	public String toString() {
		return "ReimbursementRequest [reimbursementRequestId=" + reimbursementRequestId
				+ ", reimbursementRequestAmount=" + reimbursementRequestAmount + ", reimbursementDescription="
				+ reimbursementDescription + ", reimbursementSubmitted=" + reimbursementSubmitted
				+ ", reimbursementProcessed=" + reimbursementProcessed + ", reimbursementReceipt="
				+ reimbursementReceipt + ", reimbursementAuthorId=" + reimbursementAuthorId
				+ ", reimbursementProcessorId=" + reimbursementProcessorId + ", reimbursementStatusId="
				+ reimbursementStatusId + ", reimbursementTypeId=" + reimbursementTypeId + "]";
	}
}


