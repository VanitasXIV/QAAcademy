package org.example;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class EquipoAsignadoTest extends TestFunctions {

    String homePage = "http://127.0.0.1:5500/src/main/resources/TorneoHTML/HomePage.html";
    String equiposAsignadosUrl = "http://127.0.0.1:5500/QAAcademy/src/main/resources/TorneoHTML/equipos.html";


    //Xpath
    String equiposAsignadosButtonXpath = "/html/body/nav/div/ul[1]/li[3]/a";
    String cardContainerXpathPartOne = "/html/body/div[";
    String getCardContainerXpathPartTwo = "]/div/div";
    String leaderNameLocatorXpath = "/div[2]/p";
    String memberUnorderedListLocatorXpath = "/div[3]/ul";


    static List<EquipoAsignadoCard> equiposAsignadosCards = new ArrayList<>();

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
    public void equipoCardsAreDisplayed() {
        for (EquipoAsignadoCard cardElement : equiposAsignadosCards) {
            Assertions.assertTrue(elementExists(cardElement.getCardContainerXpath()));
            Assertions.assertTrue(elementExists(cardElement.getCardTeamNameXpath()));
            Assertions.assertTrue(elementExists(cardElement.getCardCaptainNameXpath()));
            Assertions.assertTrue(elementExists(cardElement.getCardMembersPanelXpath()));
        }
    }

    @Test
    public void verificar40MiembrosEnTotal() {
        int cantidadEquipos = countNumberedElements(cardContainerXpathPartOne, getCardContainerXpathPartTwo);
        int totalMembers = 0;

        for (int i = 0; i < cantidadEquipos; i++) {
            String membersListXpath = cardContainerXpathPartOne + (i + 2) + getCardContainerXpathPartTwo + memberUnorderedListLocatorXpath;
            totalMembers += countUnorderedListItems(membersListXpath);
        }

        Assertions.assertEquals(40, totalMembers, "El número total de miembros no es 40");
    }


    //Checar método
    public String getMemberWithHighestLevel(int cardElementIndex) {
        String membersListXpath = cardContainerXpathPartOne + cardElementIndex + getCardContainerXpathPartTwo + memberUnorderedListLocatorXpath;
        List<String> members = getItemsFromElement(membersListXpath);
        System.out.println(members);
        String memberWithHighestLevel = "";
        int highestLevel = 0;

        for (String member : members) {
            String[] parts = member.split(":", 2);  // ["TOP", "Franco (Nivel: 200)"]
            String resto = parts[1].replaceAll("\\s+", " ").trim(); // limpia \n, \r, dobles espacios

            String nombre = resto.split("\\(")[0].trim();           // "Franco"
            String nivelStr = resto.replaceAll(".*Nivel: (\\d+).*", "$1").trim();

            int nivel = Integer.parseInt(nivelStr);

            if (nivel > highestLevel) {
                highestLevel = nivel;
                memberWithHighestLevel = nombre;
            }
        }

        return memberWithHighestLevel;
    }

    @Test
    public void elLiderDefaultFueElegidoCorrectamente() {
        int cantidadEquipos = countNumberedElements(cardContainerXpathPartOne, getCardContainerXpathPartTwo);

        for (int i = 2; i < cantidadEquipos; i++) {
            String leaderName = getElementText(cardContainerXpathPartOne + (i) + getCardContainerXpathPartTwo + leaderNameLocatorXpath).replace("Líder: ", "");
            String memberWithHighestLevel = getMemberWithHighestLevel(i);
            Assertions.assertEquals(leaderName, memberWithHighestLevel);
        }
    }


}

