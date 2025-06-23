package org.example;

import java.util.ArrayList;
import java.util.List;

public class EquipoAsignadoCard extends TestFunctions {
    int i;
    String cardContainerXpath;
    String cardTeamNameXpath;
    String cardCaptainNameXpath;
    String cardMembersPanelXpath;
    ArrayList<JugadorTest> miembrosEquipo = new ArrayList<>();

    public EquipoAsignadoCard(int i) {
        this.i = i;
        this.cardContainerXpath = String.format("/html/body/div["+i+1+"]/div/div");
        this.cardTeamNameXpath = cardContainerXpath + "/div[1]";
        this.cardCaptainNameXpath = cardContainerXpath + "/div[2]";
        this.cardMembersPanelXpath = cardContainerXpath + "/div[3]/dl/ul";
        addMiembrosFromCard(getMiembros());

    }

    public void addMember(JugadorTest jugador) {
        miembrosEquipo.add(jugador);
    }

    public void setCardContainerXpath(String cardContainerXpath) {
        this.cardContainerXpath = cardContainerXpath;
    }

    public String getCardContainerXpath() {
        return cardContainerXpath;
    }

    public void setCardTeamNameXpath(String cardTeamNameXpath) {
        this.cardTeamNameXpath = cardTeamNameXpath;
    }

    public String getCardTeamNameXpath() {
        return cardTeamNameXpath;
    }

    public void setCardCaptainNameXpath(String cardCaptainNameXpath) {
        this.cardCaptainNameXpath = cardCaptainNameXpath;
    }

    public String getCardCaptainNameXpath() {
        return cardCaptainNameXpath;
    }

    public void setCardMembersPanelXpath(String cardMembersPanelXpath) {
        this.cardMembersPanelXpath = cardMembersPanelXpath;
    }

    public String getCardMembersPanelXpath() {
        return cardMembersPanelXpath;
    }

    //TODO mejorar método para que sea mejor legible
    public String getMiembroMayorNivel() {
        String nombreMiembroMayorNivel = "";
        int nivelMayor = 0;
        for (JugadorTest jugador : miembrosEquipo) {
            if (nombreMiembroMayorNivel.isEmpty() || jugador.getNivel() > nivelMayor) {
                nombreMiembroMayorNivel = jugador.getNombre();
            }
        }

        return nombreMiembroMayorNivel;
    }

    private void addMiembrosFromCard(List<String> miembros) {
        for (String linea : miembros) {
            if (linea.contains(":")) {
                String[] partes = linea.split(":", 2);
                String rol = partes[0].trim();
                String nombre = partes[1].split("\\(")[0].trim();
                int nivel = Integer.parseInt(partes[1].replaceAll(".*Nivel: (\\d+)\\)", "$1"));
                addMember(new JugadorTest(rol, nombre, nivel));
            }
        }
    }

    private List<String> getMiembros() {
        return getItemsFromElement(cardMembersPanelXpath);
    }
}
