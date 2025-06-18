package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WelcomeQATraineeDropdown extends TestFunctions {
    String homePage = "http://127.0.0.1:5500/QAAcademy/src/main/resources/TorneoHTML/HomePage.html";
    String buttonXpath = "/html/body/nav/div/ul[2]/li/a";
    String dropdownXpath = "/html/body/nav/div/ul[2]/li/ul";
    String dropdownOpcionesXpath = "/html/body/nav/div/ul[2]/li/ul/li[1]/a";
    String dropdownNombreEquipoXpath = "/html/body/nav/div/ul[2]/li/ul/li[2]/a";
    String dropdownFechaTorneoXpath = "/html/body/nav/div/ul[2]/li/ul/li[3]/a";
    String dropdownVotarLiderXpath = "/html/body/nav/div/ul[2]/li/ul/li[4]/a";
    String dropdownAbandonarEquipoXpath = "/html/body/nav/div/ul[2]/li/ul/li[5]/a";
    String dropdownDesloguearXpath = "/html/body/nav/div/ul[2]/li/ul/li[6]/a";

    String nombreEquipoPage = "http://127.0.0.1:5500/QAAcademy/src/main/resources/TorneoHTML/nombre_equipo.html";

    @BeforeEach
    public void setUp() {
        super.setUp();
        getUrl(homePage);
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void testWelcomeQATraineeDropdown(){
        clickElement(buttonXpath);
        waitSeconds(1); // Espera para que el dropdown se muestre
        assertNotNull(waitElementVisible(dropdownXpath));
    }

    //Tests del dropdown de Welcome QATrainee
    @Test
    public void testWelcomeQATraineeDropdownOpciones(){
        clickElement(buttonXpath);
        waitSeconds(1); // Espera para que el dropdown se muestre
        clickElement(dropdownOpcionesXpath);
        assertNotEquals(getCurrentUrl(), homePage); // Debería llevarnos a otra página
    }

    @Test
    public void testWelcomeQATraineeDropdownNombreEquipo(){
        clickElement(buttonXpath);
        waitSeconds(1); // Espera para que el dropdown se muestre
        clickElement(dropdownNombreEquipoXpath);
        Assertions.assertEquals(getCurrentUrl(), nombreEquipoPage);
    }
}
