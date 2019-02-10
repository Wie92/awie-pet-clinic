package com.awie.awiepetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.awie.awiepetclinic.model.Pet;
import com.awie.awiepetclinic.services.PetService;
	
@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService{

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Pet save(Pet object) {
		return super.save(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Pet object) {
		super.delete(object);
	}
}
