import java.util.Scanner;
public class Main {
    private static double[][] notes = new double[50][5];
    private static String[] matieres = {"Java Oriente Objet", "C#", "PHP",
            "Teleinformatique", "Python"};
    private static String[] nom = new String[4];

    public static void main(String[] args) {
        System.out.println("Bienvenue dans le projet de Manantena");
        System.out.println("Gestion des 50 Etudiants");
        menu();
    }
    public static void menu() {
        Scanner input = new Scanner(System.in);
        int choix = -1;
        while (choix != 5) {

            System.out.println("\n--- MENU ---");
            System.out.println("1 - Creer des etudiants ou remplir le notes complet");
            System.out.println("2 - Afficher les etudiants");
            System.out.println("3 - Modifier les notes des etudiants");
            System.out.println("4 - Effacer les notes des etudiants");
            System.out.println("5 - Quitter le programme");
            System.out.print("Entrez votre choix : ");

            try {
                choix = input.nextInt();
                switch (choix) {
                    case 1:
                        saisirNotesEtudiants();
                        break;
                    case 2:
                        afficherResultats();
                        break;
                    case 3:
                        modifierNotes();
                        break;
                    case 4:
                        effacernote();
                        break;
                    case 5:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Erreur: Veuillez entrer un nombre valide.");
                input.next();
                choix = -1;
            }
        }
    }

    public static void saisirNotesEtudiants() {
        int numeroEtudiant;
        int indexCours;

        Scanner input = new Scanner(System.in);
        System.out.println("\n--Entrez les numero des étudiants entre  0 et 49  comme ID---");
        numeroEtudiant = input.nextInt();
        if (nom[numeroEtudiant] == null
                || notes[numeroEtudiant][0] == 0
                || notes[numeroEtudiant][1] == 0
                || notes[numeroEtudiant][2] == 0
                || notes[numeroEtudiant][3] == 0
                || notes[numeroEtudiant][4] == 0) {
            if (nom[numeroEtudiant] == null) {
                System.out.println("Entrez le nom etudiant");
                input.nextLine();
                nom[numeroEtudiant] = input.nextLine();
            }
            System.out.println("Entrez le numero de matiere entre 0 et 4");
            indexCours = input.nextInt();
            System.out.println("Entrez le  note de " + nom[numeroEtudiant] + "  "
                    + matieres[indexCours] + ":");
            if (notes[numeroEtudiant][indexCours] == 0) {
                do{
                    if( notes[numeroEtudiant][indexCours]>20||
                            notes[numeroEtudiant][indexCours]<0){
                        System.out.println("Eentrez note compris entre 0 et 20");
                    }

                    notes[numeroEtudiant][indexCours] = input.nextDouble();
                }while ( notes[numeroEtudiant][indexCours]>20||
                        notes[numeroEtudiant][indexCours]<0);

            } else {
                System.out.println("Erreur le note de matiere " + matieres[indexCours] + " " +
                        "deja rempli donc vous allez au modifier note");
            }
        } else {
            System.out.println("le notes de " + nom[numeroEtudiant] + " deja remmplir ");
        }
    }

    public static void afficherResultats() {
        Scanner input = new Scanner(System.in);
        System.out.println("Entrez le numero des etudiants que vous regardez");
        int voirNoteEtudiant;
        voirNoteEtudiant = input.nextInt();
        if(nom[voirNoteEtudiant]!=null){
            System.out.println("Le note de " + nom[voirNoteEtudiant] + " sont");
            for (int j = 0; j < 5; j++) {
                if(notes[voirNoteEtudiant][j]==0){
                    System.out.print("Veuillez remplir le note de ");
                }
                System.out.println(matieres[j] + "=" + notes[voirNoteEtudiant][j]);

            }
        }else{
            System.out.println("Veuillez creer etudiant correspond a la ID ="+voirNoteEtudiant);
        }

    }

    public static void modifierNotes() {
        Scanner input = new Scanner(System.in);
        int modifyNote;
        int numeroEtudiant;
        System.out.println("Entrez le numero de l'etudiant modifier de notes");
        numeroEtudiant = input.nextInt();
        System.out.println("Entrez le id de matiere ");
        modifyNote = input.nextInt();
        double note;
        if(nom[numeroEtudiant]!=null && notes[numeroEtudiant][modifyNote]!=0){
            System.out.println("Entrez le nouveaux note de " + nom[numeroEtudiant] +
                    " " + matieres[modifyNote]);
            note = input.nextDouble();
            notes[numeroEtudiant][modifyNote] = note;
        }else {
            System.out.println("Aucune etudiant ou note correspondent a la ID ="+numeroEtudiant);
        }

    }

    public static void effacernote(){
        Scanner input = new Scanner(System.in);
        int deleteNote;
        int noteEffacer;
        System.out.print("Entrez le numero de l'etudiant à effacer de note :");
        deleteNote=input.nextInt();
        System.out.println("entrez le numero de cours effacer ");
        noteEffacer= input.nextInt();
        if(nom[deleteNote]!=null && notes[deleteNote][noteEffacer]!=0){
            double note;
            note =0;
            notes[deleteNote][noteEffacer]=note;
            System.out.println("Suppression reussie le note de "+nom[deleteNote] +" "+
                    matieres[noteEffacer]);
        }else {
            System.out.println("Veulliez creer l'etudiant ou le note");
        }

    }
}