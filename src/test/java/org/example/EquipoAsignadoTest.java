package org.example;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EquipoAsignadoTest extends TestFunctions{
    String homePage = "http://127.0.0.1:5500/QAAcademy/src/main/resources/TorneoHTML/HomePage.html";
    String equiposAsignadosUrl = "http://127.0.0.1:5500/QAAcademy/src/main/resources/TorneoHTML/equipos.html";

    //Xpath
    String equiposAsignadosButtonXpath = "/html/body/nav/div/ul[1]/li[3]/a";

    @BeforeEach
    public void setUp() {
        super.setUp();
        getUrl(homePage);
        clickElement(equiposAsignadosButtonXpath);
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void equipoCardsContainElements(){
        //TODO
    }
}
