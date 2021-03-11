package com.task.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.task.db.model.Authorization;

public interface AuthorizationRepository extends PagingAndSortingRepository<Authorization, Integer>{

}
