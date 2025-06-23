package org.example;

public class JugadorTest {
    String rol;
    String nombre;
    int nivel;

    public JugadorTest(String rol, String nombre, int nivel) {
        this.rol = rol;
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }


}
