package com.awie.awiepetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.awie.awiepetclinic.model.Visit;
import com.awie.awiepetclinic.services.VisitService;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService{

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Visit save(Visit visit) {
		
		if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null
				|| visit.getPet().getOwner().getId() == null) {
			throw new RuntimeException("Invalid visit.");
		}

		return super.save(visit);
	}

	@Override
	public void delete(Visit object) {
		super.delete(object);
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}
