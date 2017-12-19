package com.revature.ers.ERS.controllers;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.ERS.model.User;

@Controller
public class AuthController {

   public HttpHeaders setHeaders(){
	   HttpHeaders headers = new HttpHeaders();
	   headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
	   headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "POST");
	   headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "Content-Type");
	   headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
	   return headers;
   }
	   
   @RequestMapping(value = "/login", method = RequestMethod.POST)
   public @ResponseBody ResponseEntity<String> login(@RequestBody String req) {
       ObjectMapper mapper = new ObjectMapper();
       String body;
       
       try{ 
    	   	User user = APIMethods.getUserByUsername(mapper.readValue(req, User.class).getUsername());
            String password1 = mapper.readValue(req, User.class).getPassword();
            String password2 = user.getPassword();
            body = mapper.writeValueAsString(user);
            
            boolean auth = runAuth(password1, password2);
            if(auth == true) return new ResponseEntity<>(body.toString(), setHeaders(), HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
   }
   
   public boolean runAuth(String pw1, String pw2){
	   if(pw1.equals(pw2)) return true;
	   else return false;
   }
}


