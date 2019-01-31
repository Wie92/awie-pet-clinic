package com.awie.awiepetclinic.services;

import java.util.Set;

import com.awie.awiepetclinic.model.Vet;

public interface VetService {

	Vet findById(Long id);
	
	Vet save(Vet vet);
	
	Set<Vet> findAll();
}
