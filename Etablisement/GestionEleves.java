package Etablissement;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionEleves {
    private static ArrayList<Eleve> eleves = new ArrayList<>();

    public static void afficherMenuEleves(Scanner scanner) {
        while (true) {
            System.out.println("\n========================================");
            System.out.println("    GESTION DES ÉLÈVES");
            System.out.println("========================================");
            System.out.println("Menu:");
            System.out.println("1: Ajouter un élève");
            System.out.println("2: Supprimer un élève");
            System.out.println("3: Modifier les informations de l'élève");
            System.out.println("4: Lister les élèves");
            System.out.println("5: Obtenir le dernier élève ajouté");
            System.out.println("6: Retour");
            System.out.println("0: Accueil");

            System.out.print("\nVotre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Nom: "); String nom = scanner.nextLine();
                    System.out.print("Prénom: "); String prenom = scanner.nextLine();
                    System.out.print("Matricule: "); String matricule = scanner.nextLine();
                    eleves.add(new Eleve(nom, prenom, matricule));
                    System.out.println("Élève ajouté avec succès!");
                    break;
                case 2:
                    System.out.print("Matricule de l'élève à supprimer: ");
                    String matSup = scanner.nextLine();
                    eleves.removeIf(e -> e.getMatricule().equals(matSup));
                    System.out.println("Élève supprimé!");
                    break;
                case 3:
                    System.out.print("Matricule de l'élève à modifier: ");
                    String matMod = scanner.nextLine();
                    for (Eleve e : eleves) {
                        if (e.getMatricule().equals(matMod)) {
                            System.out.print("Nouveau nom: "); e.nom = scanner.nextLine();
                            System.out.print("Nouveau prénom: "); e.prenom = scanner.nextLine();
                            System.out.println("Informations modifiées!");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Liste des élèves:");
                    for (Eleve e : eleves) System.out.println(e);
                    break;
                case 5:
                    if (!eleves.isEmpty()) System.out.println("Dernier élève: " + eleves.get(eleves.size() - 1));
                    else System.out.println("Aucun élève enregistré");
                    break;
                case 6: return;
                case 0: MenuPrincipal.afficherMenuPrincipal(scanner); return;
                default: System.out.println("Choix invalide");
            }
        }
    }
}
