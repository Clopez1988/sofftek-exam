package com.task.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.db.model.Authorization;
import com.task.exception.BussinesException;
import com.task.http.request.AuthorizationReq;
import com.task.http.request.UpdAuthorizationReq;
import com.task.service.AuthorizationService;

@RestController
@RequestMapping("/sofftek-exam/task")
public class AuthorizationController {

	private AuthorizationService authorizationService;

	@Autowired
	public AuthorizationController(AuthorizationService authorizationService) {
		super();
		this.authorizationService = authorizationService;
	}
	
	@GetMapping(value = "/authorization", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Authorization>> getAll(){
		
		List<Authorization> authorizations = authorizationService.getAll();
		
		return new ResponseEntity<List<Authorization>>(authorizations, HttpStatus.OK);
	}
	
	@PutMapping(value = "/authorization", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addAuthorization(@Valid @RequestBody AuthorizationReq request, Errors errors) throws BussinesException{
		
		if(errors.hasErrors()) {
			throw new BussinesException("ADD AUTHORIZATION", errors.getFieldError().getDefaultMessage(), 400);
		}
		
		authorizationService.addAuthorization(request);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping(value = "/authorization", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updAuthorization(@Valid @RequestBody UpdAuthorizationReq request, Errors errors) throws BussinesException{
		
		if(errors.hasErrors()) {
			throw new BussinesException("UPDATE AUTHORIZATION", errors.getFieldError().getDefaultMessage(), 400);
		}
		
		authorizationService.updAuthorization(request);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
