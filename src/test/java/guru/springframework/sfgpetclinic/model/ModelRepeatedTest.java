package guru.springframework.sfgpetclinic.model;

/*
 * by bennani  / 2022
 * testing-java-junit5
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("repeated")
public interface ModelRepeatedTest {

    @BeforeEach
    default void beforeEach( TestInfo testInfo, RepetitionInfo repetitionInfo ) {
        System.out.println(String.format("Before each interface : %s - %s ", testInfo.getDisplayName(), repetitionInfo.getCurrentRepetition()));
    }
}
