package com.revature.ers.ERS.controllers;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.ers.ERS.config.Constants;
import com.revature.ers.ERS.dao.ReimbursementDAO;
import com.revature.ers.ERS.dao.UserDAO;
import com.revature.ers.ERS.model.ReimbursementRequest;
import com.revature.ers.ERS.model.ReimbursementStatus;
import com.revature.ers.ERS.model.ReimbursementType;
import com.revature.ers.ERS.model.User;
import com.revature.ers.ERS.model.UserRole;

public class APIMethods {
	
	private static ClassPathXmlApplicationContext context = Constants.context;
	
	public APIMethods(){
		context = Constants.context;
		context.registerShutdownHook();
	}
	
	public static User addNewUser(User user){
		return context.getBean(UserDAO.class).addNewUser(user);
	}
	
	public static User updateUser(User user){
		return context.getBean(UserDAO.class).updateUser(user);
	}
	
	public static List<User> getAllUsers(){
		return context.getBean(UserDAO.class).getAllUsers();
	}
	
	public static List<UserRole> getAllUserRoles(){
		return context.getBean(UserDAO.class).getAllUserRoles();
	}
	
	public static User getUserByID(int userId){
		return context.getBean(UserDAO.class).getUserByID(userId);
	}
	
	public static User getUserByUsername(String username){
		return context.getBean(UserDAO.class).getUserByUsername(username);
	}
	
	public static UserRole getUserRoleByID(int roleId){
		return context.getBean(UserDAO.class).getUserRoleByID(roleId);
	}
	
	public static ReimbursementRequest addNewReimbursementRequest(ReimbursementRequest request){
		return context.getBean(ReimbursementDAO.class).addNewReimbursementRequest(request);
	}
	
	public static ReimbursementRequest updateReimbursementRequest(ReimbursementRequest request){
		return context.getBean(ReimbursementDAO.class).updateReimbursementRequest(request);
	}
	
	public static List<ReimbursementRequest> getAllReimbursementRequests(){
		return context.getBean(ReimbursementDAO.class).getAllReimbursementRequests();
	}
	
	public static List<ReimbursementRequest> getReimbursementStatusByAuthorID(int userId){
		return context.getBean(ReimbursementDAO.class).getAllReimbursementRequestsByAuthorID(userId);
	}
	
	public static List<ReimbursementStatus> getAllReimbursementStatus(){
		return context.getBean(ReimbursementDAO.class).getAllReimbursementStatus();
	}
	
	public static ReimbursementStatus getReimbursementStatusByID(int statusId){
		return context.getBean(ReimbursementDAO.class).getReimbursementStatusByID(statusId);
	}
	
	public static List<ReimbursementType> getAllReimbursementTypes(){
		return context.getBean(ReimbursementDAO.class).getAllReimbursementTypes();
	}
	
	public static ReimbursementType getReimbursementTypeByID(int typeId){
		return context.getBean(ReimbursementDAO.class).getReimbursementTypeByID(typeId);
	}
	
	public void close(){
		context.close();
	}
}
