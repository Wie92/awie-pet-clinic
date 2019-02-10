package com.awie.awiepetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.awie.awiepetclinic.model.Visit;
import com.awie.awiepetclinic.repositories.VisitRepository;
import com.awie.awiepetclinic.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService{

	private final VisitRepository visitrepository;

	public VisitSDJpaService(VisitRepository visitrepository) {
		this.visitrepository = visitrepository;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();
		visitrepository.findAll().forEach(visits::add);
		return visits;
	}

	@Override
	public Visit findById(Long id) {
		return visitrepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit object) {
		return visitrepository.save(object);
	}

	@Override
	public void delete(Visit object) {
		visitrepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		visitrepository.deleteById(id);
	}
}
