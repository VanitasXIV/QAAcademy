package org.example;
import org.example.ClassRole;

public class TorneoForm {
    private String nombreCompleto;
    private String telefono;
    private String email;
    private String discordUser;
    private String inGameName;
    private int nivel;
    private ClassRole mainRole;
    private ClassRole sideRole;

    //Usando un constructor para inicializar los campos. Se podría usar
    //el patrón Builder pero considero que es innecesario añadirle más complejidad
    //cuando se puede utilizar dos valores null para los campos opcionales.
    public TorneoForm(String nombreCompleto, String telefono, String email, String inGameName,
                      int nivel, ClassRole mainRole, String discordUser, ClassRole sideRole) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.email = email;
        this.discordUser = discordUser;
        this.inGameName = inGameName;
        this.nivel = nivel;
        this.mainRole = mainRole;
        this.sideRole = sideRole;
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
