import java.util.Scanner;
public class Main {
    private static double[][] notes = new double[4][5];
//    private static int nombreEtudiantsSaisis = 0;
    private static String [] matieres={"Java Oriente Objet","C#","PHP",
        "Teleinformatique","Python" };
    private static String [] nom = new String[4];
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
                input.next();
                choix = -1;
            }
        }
    }

    public static void saisirNotesEtudiants() {
        int numeroEtudiant;
        int indexCours;

        Scanner input = new Scanner(System.in);
        System.out.println("\n--Entrez les numero des étudiants entre par le 0 et 3 ---");
        numeroEtudiant=input.nextInt();
        System.out.println("Entrez le nom etudiant");
        input.nextLine();
        nom[numeroEtudiant]=input.nextLine();
        System.out.println("Entrez le numero de matiere entre 0 et 4");
        indexCours=input.nextInt();
        System.out.println("Entrez le  note de "+matieres[indexCours]+":");
        if(notes[numeroEtudiant][indexCours]==0){
            notes[numeroEtudiant][indexCours]= input.nextDouble();
        }
        else {
            System.out.println("Erreur le note de matiere " + matieres[indexCours] + " " +
                    "deja rempli donc vous allez au modifier note");
        }
    }
    public static void afficherResultats() {
        Scanner input = new Scanner(System.in);
        System.out.println("Entrez le numero des etudiants que vous regardez");
        int voirNoteEtudiant;
        voirNoteEtudiant=input.nextInt();
        System.out.println("Le note de " +nom[voirNoteEtudiant]+ " sont");
        System.out.println(nom[0]);
            for (int j = 0; j < 5; j++) {
                System.out.println(matieres[j]+"="+ notes[voirNoteEtudiant][j]);
            }
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