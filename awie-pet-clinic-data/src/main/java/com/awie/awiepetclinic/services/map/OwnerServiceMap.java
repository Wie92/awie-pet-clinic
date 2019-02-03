package com.awie.awiepetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.awie.awiepetclinic.model.Owner;
import com.awie.awiepetclinic.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService{

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}
	
	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Owner save(Owner owner) {
		return super.save(owner);
	}
	
	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public Owner findByLasName(String lastName) {
		return null;
	}
}
