package com.acme;

import java.util.Scanner;

public class Mensaje {

    public String solicitarDatos(String mensaje) {
        System.out.println(mensaje);
        Scanner snc = new Scanner(System.in);
        return snc.nextLine();
    }

    public void saludar(String nombre) {
        System.out.printf("Hola %s, bienvenido a Java \n", nombre);
    }
}
