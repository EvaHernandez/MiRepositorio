/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cine;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Cine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Proyecto que gestione un cine, tendremos un menú con las opciones: vender entradas, visualizar ocupación y salir.

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int temp = rand.nextInt(10) + 3;
        String[][] ocu = new String[temp][temp];
        String option;

        for (int i = 0; i < ocu.length; i++) {
            for (int j = 0; j < ocu[0].length; j++) {
                ocu[i][j] = "O";
            }
        }
        menu(ocu);

    }

    private static void menu(String[][] ocu) {

        Scanner sc = new Scanner(System.in);
        int fila = -1, col = -1;
        System.out.println("Menu:");
        System.out.println("A.-Vender entradas");
        System.out.println("B.-Visualizar ocupación");
        System.out.println("Q.-Salir");

        String option = sc.nextLine();
        switch (option) {
            case "A":
            case "a":
                do {
                    System.out.println("Introduzca la fila");
                    fila = sc.nextInt();
                    System.out.println("Introduca la columna");
                    col = sc.nextInt();

                } while (fila < 0 || fila > ocu.length || col < 0 || col > ocu[fila].length);
                if (ocu[fila][col].contains("X")) {
                    System.out.println("Ese asiento ya esta ocupado,visualice los asientos libres y elija otro");
                } else {
                    System.out.println("Ya tiene su asiento");
                    ocu[fila][col] = "X";
                }
                menu(ocu);
                break;

            case "b":
            case "B":

                for (int i = 0; i < ocu.length; i++) {
                    for (int j = 0; j < ocu[0].length; j++) {
                        System.out.printf("%s\t", ocu[i][j]);
                    }
                    System.out.println("");
                }
                menu(ocu);
                break;

            case "q":
            case "Q":

                askForExit(ocu);
                break;

            default:
                System.out.println("Opcion Incorrecta volviendo al menu");
                menu(ocu);
        }
    }

    private static void askForExit(String[][] ocu) {
        String opt;
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Desea salir? [Ss/Nn]");
        opt = sc.nextLine();
        if (opt.contains("S") || opt.contains("s")) {
            System.err.println("Saliendo...");
        } else if (opt.contains("N") || opt.contains("n")) {
            System.err.println("Volviendo al menú");
            menu(ocu);
        }
    }

}
