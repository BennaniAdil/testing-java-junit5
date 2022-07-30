package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;

/*
 * by bennani  / 2022
 * testing-java-junit5
 */

public class PersonRepeatedTest implements ModelRepeatedTest{

 @RepeatedTest(value = 2, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
 @DisplayName("simple repeat : ")
 void repeatTest() {

 }


 @RepeatedTest(value = 5, name = "{displayName} : {currentRepetition} ------ {totalRepetitions}")
 @DisplayName("My assignment Repeated")
 void myAssignementRepeated() {
 }

}
