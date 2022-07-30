package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/*
 * by bennani  / 2022
 * testing-java-junit5
 */

class PersonTest implements ModelTests{

    @Test
    void groupAssertions() {
        //given
        Person person = new Person(1L, "Ahmed", "Isac");
        //when

        //then
        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Ahmed"),
                () -> assertEquals(person.getLastName(),"Isac"));
    }

    @Test
    void groupAssertionsMsg() {
        //given
        Person person = new Person(1L, "Ahmed", "Isac");
        //when

        //then
        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Ahmed", "First name Failed"),
                () -> assertEquals(person.getLastName(),"Isac", "Last name Failed"));
    }

}