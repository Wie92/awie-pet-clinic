package com.awie.awiepetclinic.services;

import java.util.Set;

import com.awie.awiepetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

	Owner findByLasName(String lastName);

}
