package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


/*
 * by bennani  / 2022
 * testing-java-junit5
 */
@DisplayName("Owner Map service test - ")
class OwnerMapServiceTest {
    OwnerMapService ownerMapService;
    PetTypeService petTypeService;
    PetService petService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);

        System.out.println("First Before Each ");
    }

    @DisplayName("Pet Type Test - ")
    @Nested
    class TestCreatePetTypes {

        @BeforeEach
        void setUp() {
            PetType petType = new PetType(1L, "Boby");
            PetType petType1 = new PetType(2L, "Kalb");
            petTypeService.save(petType);
            petTypeService.save(petType1);

            System.out.println("Create Pet Type Before each");
        }

        @Test
        void testPetCount() {
            int count = petTypeService.findAll().size();
            assertThat(count).isNotZero().isEqualTo(2);
        }

        @DisplayName("Save owner Tests - ")
        @Nested
        class SaveOwnersTest {

            @BeforeEach
            void setUp() {
                ownerMapService.save(new Owner(1L, "Juliette", "Carcassonne"));
                System.out.println("Save owner before each");
            }

            @Test
            void saveOwner() {
                Owner owner = new Owner(2L, "Bob", "Luck");
                Owner saveOwner = ownerMapService.save(owner);
                assertThat(saveOwner).isNotNull();
            }

            @DisplayName("Find owner Tests - ")
            @Nested
            class FindOwnersTest {

                @DisplayName("Find Owner")
                @Test
                void findOwner() {
                    Owner foundOwner = ownerMapService.findById(1L);
                    assertThat(foundOwner).isNotNull();
                }

                @DisplayName("Find Owner not found")
                @Test
                void findOwnerNotFound() {
                    Owner foundOwner = ownerMapService.findById(2L);
                    assertThat(foundOwner).isNull();
                }
            }
        }
    }

    @DisplayName("Verify Zero Owners")
    @Test
    void ownersAreZero() {
        int ownerCount = ownerMapService.findAll().size();
        assertThat(ownerCount).isZero();
    }

    @DisplayName("Verify Still Zero Owners")
    @Test
    void ownersStillAreZero() {
        int ownerCount = ownerMapService.findAll().size();
        assertThat(ownerCount).isZero();
    }

}
