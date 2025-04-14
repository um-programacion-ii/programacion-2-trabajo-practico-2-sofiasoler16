package biblioteca;

import java.util.Scanner;
//uso scanner para leer datos que ingresa el usuario
public class consola {
    private Scanner scanner;

    public consola() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("Biblioteca");
        System.out.println("1. Gestionar usuarios");
        System.out.println("2. Gestionar recurso");
        System.out.println("3. Salir");
    }
}
