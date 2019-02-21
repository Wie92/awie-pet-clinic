package com.awie.awiepetclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.awie.awiepetclinic.model.Owner;

class OwnerMapServiceTest {

	OwnerMapService ownerMapService;
	
	final Long ownerId = 1L;
	final String ownerLastName = "Smith"; 
	
	@BeforeEach
	void setUp() {
		ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
		
		ownerMapService.save(Owner.builder().id(ownerId).lastName(ownerLastName).build());
	}
	
	@Test
	void testOwnerMapService() {
		
	}

	@Test
	void testFindAll() {
		Set<Owner> owners =  ownerMapService.findAll();
		
		assertEquals(1, owners.size());
	}

	@Test
	void testFindByIdLong() {
		Owner owner = ownerMapService.findById(ownerId);
		
		assertEquals(ownerId, owner.getId());
	}

	@Test
	void testSaveOwnerWithExistingId() {

		Long id = 2L;
		
		Owner owner2 = Owner.builder().id(id).build();
		
		Owner savedOwner = ownerMapService.save(owner2);
		
		assertNotNull(savedOwner);
		assertEquals(id, savedOwner.getId());	
	}

	@Test
	void testSaveOwnerWithoutId() {
		Owner savedOwner = ownerMapService.save(Owner.builder().build());
		
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}
	
	@Test
	void testDeleteOwner() {
		ownerMapService.delete(ownerMapService.findById(ownerId));
		
		assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void testDeleteByIdLong() {
		ownerMapService.deleteById(ownerId);
		
		assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner smith = ownerMapService.findByLastName(ownerLastName);
		
		assertNotNull(smith);
		assertEquals(ownerId, smith.getId());
	}

	@Test
	void testFindByLastNameNotFound() {
		Owner foo = ownerMapService.findByLastName("foo");
		
		assertNull(foo);
	}
}
