package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


/*
 * by bennani  / 2022
 * testing-java-junit5
 */

class VetControllerTest implements ControllerTests {

    VetController controller;
    VetService service;
    SpecialtyService specialtyService;


    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        service = new VetMapService(specialtyService);
        controller = new VetController(service);

        Vet vet1 = new Vet(1L,"Ahmed", "Rajab", null);
        Vet vet2 = new Vet(2L,"Saad", "Karam", null);
        service.save(vet1);
        service.save(vet2);

    }
    @Disabled
    @Test
    void listVets() {
        Model model = new ModelMapImpl();
        String view  = controller.listVets(model);
         assertThat("vets/index").isEqualTo(view);
        }

}