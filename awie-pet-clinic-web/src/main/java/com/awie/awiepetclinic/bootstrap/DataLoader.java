package com.awie.awiepetclinic.bootstrap;

import java.time.LocalDate;
import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.awie.awiepetclinic.model.Owner;
import com.awie.awiepetclinic.model.Pet;
import com.awie.awiepetclinic.model.PetType;
import com.awie.awiepetclinic.model.Vet;
import com.awie.awiepetclinic.services.OwnerService;
import com.awie.awiepetclinic.services.PetTypeService;
import com.awie.awiepetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner{

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		PetType bird = new PetType();
		bird.setName("Bird");
		PetType savedBirdPetType = petTypeService.save(bird);
		
		System.out.println("Loades Pet Types...");
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("Gang Keluarga 39Z");
		owner1.setCity("Jakarta");
		owner1.setTelephone("06212345678");
		
		Pet mikesPet = new Pet();
		mikesPet.setName("Rosco");
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setPetType(savedDogPetType);
		owner1.getPets().add(mikesPet);
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("Gang Keluarga 39Z");
		owner2.setCity("Jakarta");
		owner2.setTelephone("06212345678");
		
		Pet fionasPet = new Pet();
		fionasPet.setName("Kitty");
		fionasPet.setOwner(owner2);
		fionasPet.setBirthDate(LocalDate.now());
		fionasPet.setPetType(savedCatPetType);
		owner2.getPets().add(fionasPet);
			
		ownerService.save(owner2);
		
		System.out.println("Loades Owners...");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		
		vetService.save(vet2);
		
		System.out.println("Loades Vets...");
		
	}
	
}
