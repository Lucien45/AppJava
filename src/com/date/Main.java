package com.date;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    static LocalTime hdebut;
    static LocalTime hfin;
    static int duree;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Creneau crn1 = creerCreneau();

        while (true) {
            try {
                System.out.println("\n1. Prendre un rendez-vous\n2. Quitter");
                int choix = sc.nextInt();
                if (choix == 2) {
                    break;
                } else if (choix == 1) {
                    prendreRendezVous(crn1);
                } else {
                    System.out.println("Choix invalide. Veuillez réessayer.");
                }
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
                sc.next(); 
            }
        }
    }

    private static Creneau creerCreneau() {
        System.out.println("Créer un nouveau créneau.");
        hdebut = lireHeure("Date Debut (HH:mm): ");
        hfin = lireHeure("Date fin (HH:mm): ");
        Creneau crn1 = new Creneau(1, "consultation", hdebut, hfin);
        crn1.printTotalTime();
        System.out.println(crn1.toString());
        return crn1;
    }

    private static void prendreRendezVous(Creneau crn1) {
        duree = lireEntier("Durée de votre visite (en minutes): ");
        if (Rv.estDisponible(crn1, duree)) {
            Rv rv1 = new Rv(1, duree, "01/07/2024", crn1);
            rv1.printRemainingTime();
            System.out.println(rv1.toString());
            System.out.println(crn1.toString());
        } else {
            System.out.println("Le créneau n'est pas disponible pour cette durée.");
        }
    }

    private static LocalTime lireHeure(String message) {
        System.out.print(message);
        return LocalTime.parse(sc.next());
    }

    private static int lireEntier(String message) {
        System.out.print(message);
        return sc.nextInt();
    }
}
