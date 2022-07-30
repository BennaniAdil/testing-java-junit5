package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

/*
 * by bennani  / 2022
 * testing-java-junit5
 */

@Tag("model")
public interface ModelTests {
    @BeforeEach
    default void beforeEach() {
        System.out.println("Running test with interface implemented by Junit");
    }
}
