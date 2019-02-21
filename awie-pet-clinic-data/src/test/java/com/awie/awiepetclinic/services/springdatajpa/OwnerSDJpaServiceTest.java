package com.awie.awiepetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;

import com.awie.awiepetclinic.model.Owner;
import com.awie.awiepetclinic.repositories.OwnerRepository;
import com.awie.awiepetclinic.repositories.PetRepository;
import com.awie.awiepetclinic.repositories.PetTypeRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

	public static final String LAST_NAME = "Smith";
	
	@Mock
	OwnerRepository ownerRepository;
	
	@Mock
	PetRepository petRepository;
	
	@Mock
	PetTypeRepository petTypeRepository;
	
	@InjectMocks
	OwnerSDJpaService service;
	
	Owner returnOwner;
	
	@BeforeEach
	void setUp() {
		returnOwner = Owner.builder().id(1l).lastName(LAST_NAME).build();
	}
	
	@Test
	void testOwnerSDJpaService() {
		
	}

	@Test
	void testFindAll() {
		Set<Owner> returnOwnerSet = new HashSet<>();
		returnOwnerSet.add(Owner.builder().id(1l).build());
		returnOwnerSet.add(Owner.builder().id(2l).build());
		
		when(ownerRepository.findAll()).thenReturn(returnOwnerSet);
		
		Set<Owner> owners = service.findAll();
		
		assertNotNull(owners);
		assertEquals(2, owners.size());
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		
		Owner owner = service.findById(1L);
		
		assertNotNull(owner);
	}
	
	@Test
	void testFindByIdNotFound() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
		
		Owner owner = service.findById(1L);
		
		assertNull(owner);
	}

	@Test
	void testSave() {
		Owner ownerToSave = Owner.builder().id(1L).build();
		
		when(ownerRepository.save(any())).thenReturn(returnOwner);
		
		Owner savedOwner = service.save(ownerToSave);
		
		assertNotNull(savedOwner);
		
		verify(ownerRepository).save(any());
	}

	@Test
	void testDelete() {
		service.delete(returnOwner);
		
		verify(ownerRepository).delete(any());
	}

	@Test
	void testDeleteById() {
		service.deleteById(1L);
		
		//default is 1 times
		verify(ownerRepository, times(1)).deleteById(any());
	}

	@Test
	void testFindByLastName() {
		
		Owner returnOwner = Owner.builder().id(1l).lastName(LAST_NAME).build();
		
		when(service.findByLastName(any())).thenReturn(returnOwner);
		
		Owner smith = service.findByLastName(LAST_NAME);
		
		assertEquals(LAST_NAME, smith.getLastName());
		
		verify(ownerRepository).findByLastName(any());
	}

}
