package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/*
 * by bennani  / 2022
 * testing-java-junit5
 */
@Disabled(value = "désactivé jusqu'à apprendre à se moquer")
class OwnerSDJpaServiceTest {
    OwnerSDJpaService service;



    @BeforeEach
    void setUp() {

        service = new OwnerSDJpaService(null,null, null);
    }

    @Test
    void findByLastName() {
        Owner owner = service.findByLastName("Ahmed");
    }

    @Test
    void findAllByLastNameLike() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}