package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NavBarTest extends TestFunctions {
    String homePage = "http://127.0.0.1:5500/QAAcademy/src/main/resources/TorneoHTML/HomePage.html";
    String homeButtonXpath = "/html/body/nav/div/ul[1]/li[1]/a";
    String registroDeJugadorUrl = "http://127.0.0.1:5500/QAAcademy/src/main/resources/TorneoHTML/registro.html";
    String registroJugadorButtonXpath = "/html/body/nav/div/ul[1]/li[2]/a";
    String equiposAsignadoUrl = "http://127.0.0.1:5500/QAAcademy/src/main/resources/TorneoHTML/equipos.html";
    String equiposAsignadosButtonXpath = "/html/body/nav/div/ul[1]/li[3]/a";
    String estadisticasUrl = "http://127.0.0.1:5500/QAAcademy/src/main/resources/TorneoHTML/estadisticas.html";
    String estadisticasButtonXpath = "/html/body/nav/div/ul[1]/li[4]/a";
    String welcomeQATraineeButtonXpath = "/html/body/nav/div/ul[2]/li/a";

    //Variables para testear dropdown
    String welcomeQATraineeDropdownOpcionesXpath = "/html/body/nav/div/ul[2]/li/ul/li[1]/a";

    @BeforeEach
    public void setUp() {
        super.setUp();
        getUrl(homePage);
    }

    @AfterEach
    public void teardown() {
        super.tearDown();
    }

    @Test
    public void testNavBarHomeButton(){
        getUrl(homePage);
        clickElement(homeButtonXpath);
        assertEquals(getCurrentUrl(), homePage);
    }

    @Test
    public void testRegistroDeJugadorButton(){
        getUrl(homePage);
        clickElement(registroJugadorButtonXpath);
        assertEquals(getCurrentUrl(), registroDeJugadorUrl);
    }

    @Test
    public void testEquiposAsignadosButton(){
        getUrl(homePage);
        clickElement(equiposAsignadosButtonXpath);
        assertEquals(getCurrentUrl(), equiposAsignadoUrl);
    }

    @Test
    public void testEstadisticasButton(){
        getUrl(homePage);
        clickElement(estadisticasButtonXpath);
        assertEquals(getCurrentUrl(), estadisticasUrl);
    }

    @Test
    public void testWelcomeQATraineeButton(){
        getUrl(homePage);
        clickElement(welcomeQATraineeButtonXpath);
        assertEquals(getCurrentUrl(), homePage); //No debería llevarnos a otra página
    }


}
