package org.example;

public class TorneoForm {

    private Jugador jugador;
    private String nombreCompleto = jugador.getNombreCompleto();
    private String telefono = jugador.getTelefono();
    private String email = jugador.getEmail();
    private String discordUser = jugador.getDiscordUser();
    private String inGameName = jugador.getInGameName();
    private int nivel = jugador.getNivel();
    private ClassRole mainRole = jugador.getMainRole();
    private ClassRole sideRole = jugador.getSideRole();

    public TorneoForm(Jugador jugador){
        this.jugador = jugador;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDiscordUser() {
        return discordUser;
    }

    public String getInGameName() {
        return inGameName;
    }

    public int getNivel() {
        return nivel;
    }

    public ClassRole getMainRole() {
        return mainRole;
    }

    public ClassRole getSideRole() {
        return sideRole;
    }
}
