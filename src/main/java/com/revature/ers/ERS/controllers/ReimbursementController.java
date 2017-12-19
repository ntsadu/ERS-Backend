package com.revature.ers.ERS.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.ERS.model.ReimbursementRequest;
import com.revature.ers.ERS.model.ReimbursementStatus;
import com.revature.ers.ERS.model.ReimbursementType;
import com.revature.ers.ERS.model.User;
   
@Controller
public class ReimbursementController {

   public HttpHeaders setHeaders(){
	   HttpHeaders headers = new HttpHeaders();
	   headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
	   headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "POST");
	   headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "Content-Type");
	   headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
	   return headers;
   }
   
   @RequestMapping(value = "/AddNewReimbursementRequest", method = RequestMethod.POST)
   public @ResponseBody ResponseEntity<String> addNewReimbursementRequest(@RequestBody String req) {
       ObjectMapper mapper = new ObjectMapper();
       String body;
	   
       try{ 
		    body = mapper.writeValueAsString(APIMethods.addNewReimbursementRequest(mapper.readValue(req, ReimbursementRequest.class)));
		    return new ResponseEntity<>(body.toString(), setHeaders(), HttpStatus.OK);
		}catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
   }
   
   @RequestMapping(value = "/UpdateReimbursementRequest", method = RequestMethod.POST)
   public @ResponseBody ResponseEntity<String> updateReimbursementRequest(@RequestBody String req) {
       ObjectMapper mapper = new ObjectMapper();
       String body;
	   
       try{ 
		    body = mapper.writeValueAsString(APIMethods.updateReimbursementRequest(mapper.readValue(req, ReimbursementRequest.class)));
		    return new ResponseEntity<>(body.toString(), setHeaders(), HttpStatus.OK);
		}catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
   }
	
   @RequestMapping(value = "/GetAllReimbursementRequests", method = RequestMethod.POST)
   public @ResponseBody ResponseEntity<String> getAllReimbursementRequests() {
       List<ReimbursementRequest> requestList = APIMethods.getAllReimbursementRequests();
       ObjectMapper mapper = new ObjectMapper();
       List<String> body = new ArrayList<String>();
       try{ 
    	   for(ReimbursementRequest rr : requestList)body.add(mapper.writeValueAsString(rr));
			return new ResponseEntity<>(body.toString(), setHeaders(), HttpStatus.OK);
		}catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
   }
   
   @RequestMapping(value = "/GetAllReimbursementRequestsByAuthorID", method = RequestMethod.POST)
   public @ResponseBody ResponseEntity<String> getAllReimbursementRequestsByAuthorID(@RequestBody String req) {
//       List<ReimbursementRequest> requestList = APIMethods.getAllReimbursementRequests();
//       ObjectMapper mapper = new ObjectMapper();
//       List<String> body = new ArrayList<String>();
//       try{ 
//    	   for(ReimbursementRequest rr : requestList)body.add(mapper.writeValueAsString(rr));
//			return new ResponseEntity<>(body.toString(), setHeaders(), HttpStatus.OK);
//		}catch (IOException e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//       
       ObjectMapper mapper = new ObjectMapper();
	   Map<String, Object> status = new HashMap<String, Object>();
	   String body;
       try{ 
			status = mapper.readValue(mapper.writeValueAsString(mapper.readValue(req, ReimbursementRequest.class)), new TypeReference<Map<String, String>>(){});
		    body = mapper.writeValueAsString(APIMethods.getReimbursementStatusByAuthorID(Integer.parseInt(status.get("reimbursementAuthorId").toString())));
		    return new ResponseEntity<>(body, setHeaders(), HttpStatus.OK);
		}catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
   }
	
   @RequestMapping(value = "/GetAllReimbursementTypes", method = RequestMethod.POST)
   public @ResponseBody ResponseEntity<String> getAllReimbursementTypes() {
       List<ReimbursementType> typeList = APIMethods.getAllReimbursementTypes();
       ObjectMapper mapper = new ObjectMapper();
       List<String> body = new ArrayList<String>();
       try{ 
    	   for(ReimbursementType rt : typeList)body.add(mapper.writeValueAsString(rt));
			return new ResponseEntity<>(body.toString(), setHeaders(), HttpStatus.OK);
		}catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
   }

   @RequestMapping(value = "/GetAllReimbursementStatus", method = RequestMethod.POST)
   public @ResponseBody ResponseEntity<String> getAllReimbursementStatus() {
       List<ReimbursementStatus> statusList = APIMethods.getAllReimbursementStatus();
       ObjectMapper mapper = new ObjectMapper();
       List<String> body = new ArrayList<String>();
       try{ 
    	   for(ReimbursementStatus rs : statusList)body.add(mapper.writeValueAsString(rs));
			return new ResponseEntity<>(body.toString(), setHeaders(), HttpStatus.OK);
		}catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
   }

   @RequestMapping(value = "/GetReimbursementStatusByID", method = RequestMethod.POST)
   public @ResponseBody ResponseEntity<String> getReimbursementStatusByID(@RequestBody String req) {
       ObjectMapper mapper = new ObjectMapper();
	   Map<String, Object> status = new HashMap<String, Object>();
	   String body;
       try{ 
			status = mapper.readValue(mapper.writeValueAsString(mapper.readValue(req, ReimbursementStatus.class)), new TypeReference<Map<String, String>>(){});
		    body = mapper.writeValueAsString(APIMethods.getReimbursementStatusByID(Integer.parseInt(status.get("reimbursementStatusId").toString())));
		    return new ResponseEntity<>(body, setHeaders(), HttpStatus.OK);
		}catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
   }
   
   @RequestMapping(value = "/GetReimbursementTypeByID", method = RequestMethod.POST)
   public @ResponseBody ResponseEntity<String> getReimbursementTypeByID(@RequestBody String req) {
       ObjectMapper mapper = new ObjectMapper();
	   Map<String, Object> type = new HashMap<String, Object>();
	   String body;
       try{ 
			type = mapper.readValue(mapper.writeValueAsString(mapper.readValue(req, ReimbursementType.class)), new TypeReference<Map<String, String>>(){});
		    body = mapper.writeValueAsString(APIMethods.getReimbursementTypeByID(Integer.parseInt(type.get("reimbursementTypeId").toString())));
		    return new ResponseEntity<>(body, setHeaders(), HttpStatus.OK);
		}catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
   }
}
