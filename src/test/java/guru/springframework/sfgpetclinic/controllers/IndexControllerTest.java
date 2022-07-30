package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


/*
 * by bennani  / 2022
 * testing-java-junit5
 */

class IndexControllerTest implements ControllerTests {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }


    @DisplayName("Test du nom de la page d'index")
    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(), () -> "Another expensive" +
                "message to build"
                + "Make my only if you have to");
        assertThat(indexController.index()).isEqualTo("index");
    }

    @Test
    @DisplayName("Test de l'exception")
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () ->{
            indexController.oupsHandler();
        },"Attends une exception levée de type : ");
    }
    @Disabled
    @Test
    void timeOutTest() {
        assertTimeout(Duration.ofMillis(100),
                () -> Thread.sleep(2000));
        System.out.println("time out ");
    }

    @Test
    void timeOutTestPreemptively() {
        assertTimeoutPreemptively(Duration.ofMillis(100),
                () -> Thread.sleep(20));
        System.out.println("preemetively ............");
    }

    @Test
    void testAssumptionTrue() {

        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {

        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }
    @EnabledOnOs(OS.LINUX)
    @Test
    void testMeOnLinuxOS() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {
    }
    @EnabledIfEnvironmentVariable(named = "USER", matches = "bennani")
    @Test
    void testIfUserBennani() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "admin")
    @Test
    void testIfUserAdmin() {
    }

}