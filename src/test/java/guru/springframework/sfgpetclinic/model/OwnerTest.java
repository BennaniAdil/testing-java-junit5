package guru.springframework.sfgpetclinic.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


/*
 * by bennani  / 2022
 * testing-java-junit5
 */

class OwnerTest implements ModelTests {

    @Test
    void dependentAssertions() {
        //given
        Owner owner = new Owner(1L, "Kamal", "Tijani");
        owner.setCity("Agadir");
        owner.setTelephone("1234432123");

        //then
        assertAll("Properties Test",
                () -> assertAll("Person properties",
                        () -> assertEquals("Kamal", owner.getFirstName(), "First Name Did not match"),
                        () -> assertEquals("Tijani", owner.getLastName())),
                () -> assertAll("Owner properties",
                        () -> assertEquals("Agadir", owner.getCity(), "City did not match"),
                        () -> assertEquals("1234432123", owner.getTelephone()))
        );
    }

    @DisplayName("Value source test - ")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource( String val ) {
        System.out.println(val);
    }

    @DisplayName("Enum source test")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    @EnumSource(OwnerType.class)
    void OwnerTypeTest( OwnerType ownerType ) {
        System.out.println(ownerType);
    }

    @DisplayName("CSV source test")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    @CsvSource({
            "FL,1,1",
            "OH,12,12",
            "MI,441,991"
    })
    void csvInputTest( String stateName, int val1, int val2 ) {
        System.out.println(String.format("%s = %s : %s", stateName, val1, val2));
    }

    @DisplayName("CSV file test")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFromFIleTest( String stateName, int val1, int val2 ) {
        System.out.println(String.format("%s = %s : %s", stateName, val1, val2));
    }

    @DisplayName("method args test")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    @MethodSource("getArgs")
    void fromMethodTest( String stateName, int val1, int val2 ) {
        System.out.println(String.format("%s = %s : %s", stateName, val1, val2));
    }

    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of("FL", 61, 1),
                Arguments.of("OH", 62, 12),
                Arguments.of("MI", 641, 991));
    }

    @DisplayName("Custom args test")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    @ArgumentsSource(CustomArgsProvider.class)
    void fromCustomProviderTest( String stateName, int val1, int val2 ) {
        System.out.println(String.format("%s = %s : %s", stateName, val1, val2));
    }

}