package com.awie.awiepetclinic.services;

import java.util.Set;

import com.awie.awiepetclinic.model.Owner;

public interface OwnerInterface {

	Owner findByLasName(String lastName);
	
	Owner findById(Long id);
	
	Owner save(Owner owner);
	
	Set<Owner> findAll();
	
}
