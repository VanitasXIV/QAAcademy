package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WelcomeQATraineeDropdown extends TestFunctions {
    String buttonXpath = "/html/body/nav/div/ul[2]/li/a";
    String dropdownXpath = "/html/body/nav/div/ul[2]/li/ul";
    String dropdownOpcionesXpath = "/html/body/nav/div/ul[2]/li/ul/li[1]/a";
    String dropdownNombreEquipoXpath = "/html/body/nav/div/ul[2]/li/ul/li[2]/a";
    String dropdownFechaTorneoXpath = "/html/body/nav/div/ul[2]/li/ul/li[3]/a";
    String dropdownVotarLiderXpath = "/html/body/nav/div/ul[2]/li/ul/li[4]/a";
    String dropdownAbandonarEquipoXpath = "/html/body/nav/div/ul[2]/li/ul/li[5]/a";
    String dropdownDesloguearXpath = "/html/body/nav/div/ul[2]/li/ul/li[6]/a";

    String homePage = "http://127.0.0.1:5500/QAAcademy/src/main/resources/TorneoHTML/HomePage.html";
    String nombreEquipoPage = "http://127.0.0.1:5500/QAAcademy/src/main/resources/TorneoHTML/nombre_equipo.html";
    String fechaTorneoPage = "http://127.0.0.1:5500/QAAcademy/src/main/resources/TorneoHTML/panel_admin.html";
    String votarLiderPage = "http://127.0.0.1:5500/QAAcademy/src/main/resources/TorneoHTML/votar_lider.html";
    String abandonarEquipoPage = "http://127.0.0.1:5500/QAAcademy/src/main/resources/TorneoHTML/abandonar_equipo.html";
    String dropdownDesloguearPage = homePage;
    String homePageTest = "http://127.0.0.1:5500/QAAcademy/src/main/resources/TorneoHTML/HomePage.html#";

    @BeforeEach
    public void setUp() {
        super.setUp();
        getUrl(homePage);
        clickElement(buttonXpath);
        waitSeconds(1); // Espera para que el dropdown se muestre
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void testWelcomeQATraineeDropdown(){
        assertNotNull(waitElementVisible(dropdownXpath));
    }

    //Tests del dropdown de Welcome QATrainee
    @Test
    public void testWelcomeQATraineeDropdownOpciones(){
        clickElement(dropdownOpcionesXpath);
        assertNotEquals(getCurrentUrl(), homePage);
        assertNotEquals(getCurrentUrl(), homePageTest);
    }

    @Test
    public void testWelcomeQATraineeDropdownNombreEquipo(){
        clickElement(dropdownNombreEquipoXpath);
        Assertions.assertEquals(getCurrentUrl(), nombreEquipoPage);
    }

    @Test
    public void testWelcomeQATraineeDropdownFechaTorneo(){
        clickElement(dropdownFechaTorneoXpath);
        Assertions.assertEquals(getCurrentUrl(), fechaTorneoPage);
    }

    @Test
    public void testWelcomeQATraineeDropdownVotarLider(){
        clickElement(dropdownVotarLiderXpath);
        Assertions.assertEquals(getCurrentUrl(), votarLiderPage);
    }

    @Test
    public void testWelcomeQATraineeDropdownAbandonarEquipo(){
        clickElement(dropdownAbandonarEquipoXpath);
        Assertions.assertEquals(getCurrentUrl(), abandonarEquipoPage);
    }

    @Test
    public void testWelcomeQATraineeDropdownDesloguear(){
        clickElement(dropdownDesloguearXpath);
        Assertions.assertEquals(getCurrentUrl(), dropdownDesloguearPage); // Debería llevarnos a la página de inicio
    }
}
