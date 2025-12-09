import java.util.Scanner;
public class Main {
    private static double[][] notes = new double[4][5];
//    private static int nombreEtudiantsSaisis = 0;
    private static String [] matieres={"Java Oriente Objet","C#","PHP","Teleinformatique","Python" };
    public static void main(String[] args) {

        menu();
    }
    public static void menu() {
        Scanner input = new Scanner(System.in);
        int choix = -1;
        while (choix != 5) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Saisie des notes de 4 étudiants");
            System.out.println("2 - Afficher les notes et la moyenne des étudiants");
            System.out.println("3 - Modifier les notes");
            System.out.println("4 - Effacer les notes");

            System.out.println("5 - Quitter");
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
                    case 4:
                        effacernote();
                    case 5:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Erreur: Veuillez entrer un nombre valide.");
                input.next(); // Consomme l'entrée incorrecte
                choix = -1; // Réinitialise le choix pour continuer la boucle
            }
        }
    }

    public static void saisirNotesEtudiants() {
        int numeroEtudiant;
        int indexCours;

        Scanner input = new Scanner(System.in);
        System.out.println("\n--Entrez les numero des étudiants commencer par le 0 ---");
        numeroEtudiant=input.nextInt();
        System.out.println("Entrez le numero de matiere commencer par 0");
        indexCours=input.nextInt();
        System.out.println("Entrez le  note de "+matieres[indexCours]+":");
        notes[numeroEtudiant][indexCours]= input.nextDouble();
//        int NB_ETUDIANTS = notes.length; // 4
//        int NB_NOTES = notes[0].length; // 5

//        for (int i = 0; i<4; i++) {
//             Affichage du numéro de l'étudiant
//            System.out.println("\nSaisie pour le numero l'étudiant " + (i+1));
//            notes[i][i]=input.nextDouble();
//             On pourrait demander le nom de l'étudiant ici, mais on se contente des notes.

//            for (int j =0; j<5; j++) {
//                System.out.print("Entrez la note " + (j + 1) + " (entre 0 et 20) : ");
//                notes[numeroEtudiant][j]=input.nextDouble();
//              //  double noteSaisie = input.nextDouble();
//                // Stockage de la note dans le tableau global statique 'notes'
//               // notes[i][j] = noteSaisie;
//            }

//        nombreEtudiantsSaisis = 4;
    }

    public static void afficherResultats() {
        Scanner input = new Scanner(System.in);
//        if (nombreEtudiantsSaisis == 0) {
//            System.out.println(" Aucune note n'a été saisie. Veuillez utiliser l'option 1 d'abord.");
//            return;
//        }
        System.out.println("Entrez le numero des etudiants que vous regardez");

        int voirNoteEtudiant;
        voirNoteEtudiant=input.nextInt();
//        for (int i = 1; i < 5; i++) {
//            double sommeNotes = 0.0;
//            System.out.print("Étudiant " + (i + 1) + " | Notes : [");
        System.out.println("Le note de l'etudieant de numero "+voirNoteEtudiant+"sont");
            for (int j = 0; j < 5; j++) {
                double note = notes[voirNoteEtudiant][j];
                System.out.println(matieres[j]+"="+ notes[voirNoteEtudiant][j]);
                //System.out.println(note + (j < 5 - 1 ? ", " : "")); // Ajoute une virgule sauf pour la dernière note
//                sommeNotes += note;
            }


//            double moyenne = sommeNotes / 5;
//            // Affichage de la moyenne avec deux décimales
//            System.out.printf("] | Moyenne: %.2f%n", moyenne);
//        }
    }
    public static void modifierNotes(){
        Scanner input = new Scanner(System.in);
        int modifyNote;
        int numeroEtudiant;
        System.out.println("Entrez le numero de l'etudiant modifier de notes");
        numeroEtudiant=input.nextInt();
        System.out.println("Entrez le id de matiere ");
        modifyNote=input.nextInt();
        double note;
        System.out.println("Entrez le nouveaux note de "+matieres[modifyNote]);
        note=input.nextDouble();
        notes[numeroEtudiant][modifyNote]=note;
//        for (int i=0;i<5;i++){
//
//            note=input.nextDouble();
//            notes[modifyNote][i]=note;
//
//        }

    }
    public static void effacernote(){
        Scanner input = new Scanner(System.in);
        int deleteNote;
        int noteEffacer;
        System.out.print("Entrez le numero de l'etudiant à effacer de note :");
        deleteNote=input.nextInt();
        System.out.println("entrez le numero de cours effacer de note");
        noteEffacer= input.nextInt();
        double note;
        note =0;
        notes[deleteNote][noteEffacer]=note;
        System.out.println("Suppression reussie ");
    }
}