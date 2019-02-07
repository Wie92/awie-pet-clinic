package com.awie.awiepetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.awie.awiepetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>{
	
	Owner findByLastName(String lastName);
	
}
