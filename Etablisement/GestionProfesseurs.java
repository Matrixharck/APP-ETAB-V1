package Etablissement;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionProfesseurs {
    private static ArrayList<Professeur> professeurs = new ArrayList<>();

    public static void afficherMenuProfesseurs(Scanner scanner) {
        while (true) {
            System.out.println("\n========================================");
            System.out.println("    GESTION DES PROFESSEURS");
            System.out.println("========================================");
            System.out.println("Menu:");
            System.out.println("1: Ajouter un professeur");
            System.out.println("2: Supprimer un professeur");
            System.out.println("3: Modifier les informations du professeur");
            System.out.println("4: Lister les professeurs");
            System.out.println("5: Obtenir le dernier professeur ajouté");
            System.out.println("6: Retour");
            System.out.println("0: Accueil");

            System.out.print("\nVotre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Nom: "); String nom = scanner.nextLine();
                    System.out.print("Prénom: "); String prenom = scanner.nextLine();
                    System.out.print("Spécialité: "); String specialite = scanner.nextLine();
                    professeurs.add(new Professeur(nom, prenom, specialite));
                    System.out.println("Professeur ajouté avec succès!");
                    break;
                case 2:
                    System.out.print("Nom du professeur à supprimer: ");
                    String nomSup = scanner.nextLine();
                    professeurs.removeIf(p -> p.nom.equals(nomSup));
                    System.out.println("Professeur supprimé!");
                    break;
                case 3:
                    System.out.print("Nom du professeur à modifier: ");
                    String nomMod = scanner.nextLine();
                    for (Professeur p : professeurs) {
                        if (p.nom.equals(nomMod)) {
                            System.out.print("Nouveau nom: "); p.nom = scanner.nextLine(); // Note: Devrait utiliser un setter
                            System.out.print("Nouveau prénom: "); p.prenom = scanner.nextLine(); // Note: Devrait utiliser un setter
                            System.out.print("Nouvelle spécialité: "); p.setSpecialite(scanner.nextLine());
                            System.out.println("Informations modifiées!");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Liste des professeurs:");
                    for (Professeur p : professeurs) System.out.println(p);
                    break;
                case 5:
                    if (!professeurs.isEmpty()) System.out.println("Dernier professeur: " + professeurs.get(professeurs.size() - 1));
                    else System.out.println("Aucun professeur enregistré");
                    break;
                case 6: return;
                case 0: MenuPrincipal.afficherMenuPrincipal(scanner); return;
                default: System.out.println("Choix invalide");
            }
        }
    }
}