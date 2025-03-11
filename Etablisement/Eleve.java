package Etablissement;


public class Eleve extends Personne {
    private String matricule;

    public Eleve(String nom, String prenom, String matricule) {
        super(nom, prenom);
        this.matricule = matricule;
    }

    public String getMatricule() {
        return matricule;
    }

    @Override
    public String toString() {
        return super.toString() + ", Matricule: " + matricule;
    }
}