package com.task.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.db.model.Authorization;
import com.task.db.repository.AuthorizationRepository;
import com.task.exception.BussinesException;
import com.task.http.request.AuthorizationReq;
import com.task.http.request.UpdAuthorizationReq;

@Service
public class AuthorizationService {

	private AuthorizationRepository authorizationRep;

	@Autowired
	public AuthorizationService(AuthorizationRepository authorizationRep) {
		super();
		this.authorizationRep = authorizationRep;
	}
	
	/*
	 * Obtiene todas las autorizaciones registradas
	 */
	public List<Authorization> getAll(){
		
		List<Authorization> authorizations = (List<Authorization>) authorizationRep.findAll();
		return authorizations;
	}
	
	/**
	 * Realiza el registro de una nueva autorizacion
	 * @param request
	 */
	public void addAuthorization(AuthorizationReq request) {
		
		Authorization authorization = new Authorization();
		
		authorization.setDescription(request.getDescription());
		authorization.setStatus(request.getStatus());
		authorization.setAmount(request.getAmount());
		
		authorizationRep.save(authorization);
	}
	
	/*
	 * Actualiza una autorizacion, se agrega la parte de transaccion en caso de que 
	 * se realicen mas cambios en otras tablas y falle el flujo
	 */
	@Transactional
	public void updAuthorization(UpdAuthorizationReq request) throws BussinesException {
		
		Optional<Authorization> authorization = authorizationRep.findById(request.getId());
		
		if(!authorization.isPresent()) {
			throw new BussinesException("UPDATE AUTHORIZATION", "Authorization not found", 422);
		}
		
		authorization.get().setDescription(request.getDescription());
		authorization.get().setStatus(request.getStatus());
		authorization.get().setAmount(request.getAmount());
		
		authorizationRep.save(authorization.get());		
	}
	
}
