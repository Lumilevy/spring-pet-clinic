package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
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

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSugrery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michel");
        owner1.setLastName("Blanc");
        owner1.setAddress("123 rue Super");
        owner1.setCity("SuperVille");
        owner1.setTelephone("1212121212");

        Pet michelPet = new Pet();
        michelPet.setPetType(savedDogPetType);
        michelPet.setOwner(owner1);
        michelPet.setBirthDate(LocalDate.now());
        michelPet.setName("Susano");
        owner1.getPets().add(michelPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Robert");
        owner2.setLastName("Plant");
        owner2.setAddress("123 rue Super");
        owner2.setCity("SuperVille");
        owner2.setTelephone("1212121212");

        Pet robertPet = new Pet();
        robertPet.setPetType(savedCatPetType);
        robertPet.setOwner(owner2);
        robertPet.setBirthDate(LocalDate.now());
        robertPet.setName("Koneko");
        owner2.getPets().add(robertPet);

        ownerService.save(owner2);

        Visit visit1 = new Visit();
        visit1.setPet(robertPet);
        visit1.setDate(LocalDate.now());
        visit1.setDescription("description for visit");

        visitService.save(visit1);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Freddy");
        vet1.setLastName("Mercury");
        vet1.getSpecialties().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Nina");
        vet2.setLastName("Hagen");
        vet2.getSpecialties().add(savedRadiology);

        vetService.save(vet2);

        System.out.println("Vets loaded");
    }
}
