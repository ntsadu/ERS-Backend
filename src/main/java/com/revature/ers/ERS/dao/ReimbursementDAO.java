package com.revature.ers.ERS.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.revature.ers.ERS.model.ReimbursementRequest;
import com.revature.ers.ERS.model.ReimbursementStatus;
import com.revature.ers.ERS.model.ReimbursementType;

public class ReimbursementDAO {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void init(){
    	System.out.println("ReimbursementDAO is initializing...");
    }
    
    public void destroy(){
    	System.out.println("ReimbursementDAO is now closing...");
    }

	public ReimbursementRequest addNewReimbursementRequest(ReimbursementRequest request){
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(request);
		session.getTransaction().commit();
		session.close();
		return request;
    }
	
	public ReimbursementRequest updateReimbursementRequest(ReimbursementRequest request){
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.update(request);
		session.getTransaction().commit();
		session.close();
		return request;
    }
	
	@SuppressWarnings("unchecked")
	public List<ReimbursementRequest> getAllReimbursementRequests(){
    	System.out.println("ReimbursementDAO is reading...");
		Session session = this.sessionFactory.openSession();
		List<ReimbursementRequest> requestList = session.createQuery("FROM ReimbursementRequest").list();
		System.out.println("ReimbursementDAO is finished reading...");
		session.close();
		return requestList;
    }
	
	@SuppressWarnings("unchecked")
	public List<ReimbursementRequest> getAllReimbursementRequestsByAuthorID(int userId){
    	System.out.println("ReimbursementDAO is reading...");
		Session session = this.sessionFactory.openSession();
		Query<ReimbursementRequest> query  = session.createQuery("FROM ReimbursementRequest WHERE reimbursementAuthorId = :id");
		query.setParameter("id", userId);
		List<ReimbursementRequest> requestList = new ArrayList<ReimbursementRequest>(query.list());
		System.out.println("ReimbursementDAO is finished reading...");
		session.close();
		return requestList;
    }
    
	@SuppressWarnings("unchecked")
	public List<ReimbursementStatus> getAllReimbursementStatus(){
    	System.out.println("ReimbursementDAO is reading...");
		Session session = this.sessionFactory.openSession();
		List<ReimbursementStatus> statusList = session.createQuery("FROM ReimbursementStatus").list();
		System.out.println("ReimbursementDAO is finished reading...");
		session.close();
		return statusList;
    }
	
	@SuppressWarnings("unchecked")
	public ReimbursementStatus getReimbursementStatusByID(int statusId){
		Session session = this.sessionFactory.openSession();
        Query<ReimbursementStatus> query = session.createQuery("FROM ReimbursementStatus WHERE reimbursementStatusId = :id");
        query.setParameter("id", statusId);
		ReimbursementStatus status = new ArrayList<ReimbursementStatus>(query.list()).get(0);
		session.close();
		return status;
    }
	
	@SuppressWarnings("unchecked")
	public List<ReimbursementType> getAllReimbursementTypes(){
    	System.out.println("ReimbursementDAO is reading...");
		Session session = this.sessionFactory.openSession();
		List<ReimbursementType> typeList = session.createQuery("FROM ReimbursementType").list();
		System.out.println("ReimbursementDAO is finished reading...");
		session.close();
		return typeList;
    }
	
	@SuppressWarnings("unchecked")
	public ReimbursementType getReimbursementTypeByID(int typeId){
		Session session = this.sessionFactory.openSession();
        Query<ReimbursementType> query = session.createQuery("FROM ReimbursementType WHERE reimbursementTypeId = :id");
        query.setParameter("id", typeId);
		ReimbursementType type = new ArrayList<ReimbursementType>(query.list()).get(0);
		session.close();
		return type;
    }
}
