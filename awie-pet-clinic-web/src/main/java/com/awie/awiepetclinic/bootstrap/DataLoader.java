package com.awie.awiepetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.awie.awiepetclinic.model.Owner;
import com.awie.awiepetclinic.model.Pet;
import com.awie.awiepetclinic.model.PetType;
import com.awie.awiepetclinic.model.Speciality;
import com.awie.awiepetclinic.model.Vet;
import com.awie.awiepetclinic.model.Visit;
import com.awie.awiepetclinic.services.OwnerService;
import com.awie.awiepetclinic.services.PetTypeService;
import com.awie.awiepetclinic.services.SpecialityService;
import com.awie.awiepetclinic.services.VetService;
import com.awie.awiepetclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner{

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, 
			PetTypeService petTypeService, SpecialityService specialityService,
			VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		int count = petTypeService.findAll().size();
		
		if(count ==0) {
			loadData();
		}
		
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		PetType bird = new PetType();
		bird.setName("Bird");
		PetType savedBirdPetType = petTypeService.save(bird);
		
		System.out.println("Loaded Pet Types...");
		
		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRaidology = specialityService.save(radiology);
		
		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialityService.save(surgery);
		
		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);
		
		System.out.println("Loaded Specialities");
		
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

		System.out.println("Loaded Owners...");
		
		
		Visit catVisit = new Visit();
		catVisit.setPet(fionasPet);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Sneezy Kitty");
		
		visitService.save(catVisit);
		
		System.out.println("Loaded Visit");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialities().add(savedRaidology);
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialities().add(savedSurgery);
		
		vetService.save(vet2);
		
		System.out.println("Loaded Vets...");
	}
	
}
