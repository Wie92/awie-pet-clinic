package com.awie.awiepetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.awie.awiepetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long>{

}
