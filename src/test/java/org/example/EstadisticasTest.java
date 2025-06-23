package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstadisticasTest extends TestFunctions{
    String homePage = "http://127.0.0.1:5500/QAAcademy/src/main/resources/TorneoHTML/HomePage.html";
    String estadisticasPage = "http://127.0.0.1:5500/QAAcademy/src/main/resources/TorneoHTML/estadisticas.html";


    String estadisticasButtonXpath = "/html/body/nav/div/ul[1]/li[4]/a";
    String tablaEstadisticasXpath = "//*[@id=\"tablaJugadores_wrapper\"]";

    @BeforeEach
    public void setUp() {
        super.setUp();
        getUrl(homePage);
        clickElement(estadisticasButtonXpath);
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void estadisticasPageIsDisplayed() {
        String currentUrl = getCurrentUrl();
        Assertions.assertEquals(estadisticasPage, currentUrl, "La página de estadísticas no se ha cargado correctamente.");
        Assertions.assertTrue(elementExists(tablaEstadisticasXpath));
    }
}
