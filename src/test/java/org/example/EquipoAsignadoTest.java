package org.example;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class EquipoAsignadoTest extends TestFunctions{
    String homePage = "http://127.0.0.1:5500/QAAcademy/src/main/resources/TorneoHTML/HomePage.html";
    String equiposAsignadosUrl = "http://127.0.0.1:5500/QAAcademy/src/main/resources/TorneoHTML/equipos.html";

    //Xpath
    String equiposAsignadosButtonXpath = "/html/body/nav/div/ul[1]/li[3]/a";
    static int cantidadEquipos = 8;
    static List<EquipoAsignadoCard> equiposAsignadosCards = new ArrayList<>();

    @BeforeAll
    public static void suiteSetUp() {
        for (int i=0; i < cantidadEquipos; i++){
            equiposAsignadosCards.add(new EquipoAsignadoCard(i));
        }
    }

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
    public void equipoCardsAreDisplayed(){
        for (EquipoAsignadoCard cardElement : equiposAsignadosCards){
            Assertions.assertTrue(elementExists(cardElement.getCardContainerXpath()));
            Assertions.assertTrue(elementExists(cardElement.getCardTeamNameXpath()));
            Assertions.assertTrue(elementExists(cardElement.getCardCaptainNameXpath()));
            Assertions.assertTrue(elementExists(cardElement.getCardMembersPanelXpath()));
        }
    }
}
