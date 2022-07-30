package guru.springframework.sfgpetclinic.controllers;

/*
 * by bennani  / 2022
 * testing-java-junit5
 */

import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@Tag("controller")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface ControllerTests {
    @BeforeAll
    default void beforeAll(){
        System.out.println("methode default BeforeALl dans l'interface commune des controllers ");

    }
}
