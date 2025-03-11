package Etablissement;

import java.util.ArrayList;
import java.util.Scanner;



public class GestionUtilisateurs {
    private static ArrayList<Utilisateur> utilisateurs = new ArrayList<>();

    public static void afficherMenuUtilisateurs(Scanner scanner) {
        while (true) {
            System.out.println("\n========================================");
            System.out.println("    GESTION DES UTILISATEURS");
            System.out.println("========================================");
            System.out.println("Menu:");
            System.out.println("1: Ajouter un utilisateur");
            System.out.println("2: Supprimer un utilisateur");
            System.out.println("3: Modifier les informations d'un utilisateur");
            System.out.println("4: Lister les utilisateurs");
            System.out.println("5: Obtenir le dernier utilisateur ajouté");
            System.out.println("6: Retour");
            System.out.println("0: Accueil");

            System.out.print("\nVotre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Nom: "); String nom = scanner.nextLine();
                    System.out.print("Prénom: "); String prenom = scanner.nextLine();
                    System.out.print("Identifiant: "); String identifiant = scanner.nextLine();
                    System.out.print("Mot de passe: "); String motDePasse = scanner.nextLine();
                    utilisateurs.add(new Utilisateur(nom, prenom, identifiant, motDePasse));
                    System.out.println("Utilisateur ajouté avec succès!");
                    break;
                case 2:
                    System.out.print("Identifiant de l'utilisateur à supprimer: ");
                    String idSup = scanner.nextLine();
                    utilisateurs.removeIf(u -> u.getIdentifiant().equals(idSup));
                    System.out.println("Utilisateur supprimé!");
                    break;
                case 3:
                    System.out.print("Identifiant de l'utilisateur à modifier: ");
                    String idMod = scanner.nextLine();
                    for (Utilisateur u : utilisateurs) {
                        if (u.getIdentifiant().equals(idMod)) {
                            System.out.print("Nouveau nom: "); u.setNom(scanner.nextLine());
                            System.out.print("Nouveau prénom: "); u.setPrenom(scanner.nextLine());
                            System.out.print("Nouveau identifiant: "); u.setIdentifiant(scanner.nextLine());
                            System.out.print("Nouveau mot de passe: "); u.setMotDePasse(scanner.nextLine());
                            System.out.println("Informations modifiées!");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Liste des utilisateurs:");
                    for (Utilisateur u : utilisateurs) System.out.println(u);
                    break;
                case 5:
                    if (!utilisateurs.isEmpty()) System.out.println("Dernier utilisateur: " + utilisateurs.get(utilisateurs.size() - 1));
                    else System.out.println("Aucun utilisateur enregistré");
                    break;
                case 6: return;
                case 0: MenuPrincipal.afficherMenuPrincipal(scanner); return;
                default: System.out.println("Choix invalide");
            }
        }
    }
}