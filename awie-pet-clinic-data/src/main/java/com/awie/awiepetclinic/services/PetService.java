package com.awie.awiepetclinic.services;

import java.util.Set;

import com.awie.awiepetclinic.model.Pet;

public interface PetService {

	Pet findById(Long id);
	
	Pet save(Pet pet);
	
	Set<Pet> findAll();
	
	
}
