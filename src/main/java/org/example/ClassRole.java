package org.example;


//Fill será ClassRole
public class ClassRole {
    String className = "FILL";

    public String getClassName() {
        return className;
    }
}

class Top extends ClassRole {
    String className = "TOP";
}

class Jungla extends ClassRole {
    String className = "JUNGLA";
}

class Mid extends ClassRole {
    String className = "MID";
}

class ADC extends ClassRole {
    String className = "ADC";
}

class Support extends ClassRole {
    String className = "SOPORTE";
}