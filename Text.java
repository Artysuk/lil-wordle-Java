import java.util.Scanner;

public class Text {


    public String welcomeText(){
        return manyDashes() +"\n Sõnadle\n" + manyDashes();
    }

    public String manyDashes(){
        return "--------------------------------------------------------------";
    }

    public String numberOfTries(int tries){
        return "Teie katsete arv:" + tries;
    }

    public String rulesText(){

        return "\n Arvake ära sõna 6 katsega" +
                "\n Iga sõna peab olema 5 täheline" +
                "\n Kui täht on vale/on õiges kohas/vales kohas, siis mina teile sellest kirjutan." +
                "\n SÕNAD ON INGLISE KEELES!!!!\n";

    }

    public String winningSpeech(){
        return "Palju õnne! Te saite sõnast ilusasti aru!";
    }

    public void remainingLettersAlphabet(StringBuilder alphabetGrey){ //meetod, mis kirjutab kõik ülejaanud tähed

        System.out.println("Teie saate kasutada järgmised tähed: ");

        for (int i = 0; i < alphabetGrey.length(); i++) {

            if (i==alphabetGrey.length()-1)
                System.out.println(alphabetGrey.charAt(i) + " ");

            else
                System.out.print(alphabetGrey.charAt(i) + " ");
        }
    }



    public String loserSpeech(){
        return "Kahjuks te olete kaotanud";
    }
    public String writeExample(){ //näidemäng

        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";
        String YELLOW = "\u001B[33m";
        String BLACK = "\u001B[30m";

        return "\n Näide (Sõna: ended)\n" +
                manyDashes() + "\n" +
                numberOfTries(6) + "\n" +

                "Teie saate kasutada järgmised tähed: \n" +
                    "a b c d e f g h i j k l m n o p q r s t u v w x y z \n" +
                        "Kirjutage oma sõna: _ _ _ _ _ (blend)\n" +
                manyDashes() + "\n " +
                numberOfTries(5) + "\n" +
                "Teie saate kasutada järgmised tähed: \n" +
                    "a c f g h i j k m o p q r s t u v w x y z \n" +
                    "Teie olete kasutanud järgmised tähed õiges kohas: \n" +
                    GREEN + "d\n" + RESET +
                        "Teie olete kasutanud õigesti järgmised tähed: \n" +
                            YELLOW + "e n \n" + RESET +
                                "Teie olete kasutanud valesti järgmised tähed:\n" +
                                    BLACK + "b l \n" + RESET +
                                    "Kirjutage oma sõna: _ _ " + YELLOW + "e n " + GREEN + "d" + RESET + " (glent)\n" +
                "Seda sõna pole sõnade loendis\n" +
                    manyDashes() + "\n " +
                    numberOfTries(5) + "\n" +
                    "Teie saate kasutada järgmised tähed: \n" +
                        "a c f g h i j k m o p q r s t u v w x y z \n" +
                            "Teie olete kasutanud järgmised tähed õiges kohas: \n" +
                            GREEN + "d\n" + RESET +
                                "Teie olete kasutanud õigesti järgmised tähed: \n" +
                            YELLOW + "e n \n" + RESET +
                                "Teie olete kasutanud valesti järgmised tähed:\n" +
                            BLACK + "b l \n" + RESET +
                                "Kirjutage oma sõna: _ _ " + YELLOW + "e n " + GREEN + "d (ended)" + RESET + "\n" +
                winningSpeech() + "\n";



    }

    public String toString(){

        System.out.println(welcomeText() +
                manyDashes() +
                rulesText());

        return  manyDashes() +
                writeExampleBool() +
                manyDashes();
    }

    public String writeExampleBool(){ //meetod, mis väljastab infot ning küsib, kas on vaja näidet.

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("Kas te soovite näha näidet? (j,e)");
            String answer = sc.nextLine();
            if (answer.equals("j".toLowerCase())) {

                return  manyDashes() +
                        writeExample() +
                        manyDashes();

            } else if (answer.equals("e".toLowerCase())) {
                break;

            } else {
                System.out.println("Midagi läks valessti, proovige veel kord.");
            }
        }
        return "\nOlgu nii\n";
    }


    public void rightLettersAndPlaces(StringBuilder alphabetGreen, String GREEN, String RESET) {

        System.out.println("Teie olete kasutanud järgmised tähed õiges kohas: ");

        for (int i = 0; i < alphabetGreen.length(); i++) { // kirjutan rohelised tähed

            if (i==alphabetGreen.length()-1) // Kui täht on viimane, siis kirjtutan nii, et pärast tekst oleks järgmisest reast
                System.out.println(GREEN + alphabetGreen.charAt(i) + " " + RESET);//Muudan tähtede värvi roheliseks ja pärast, kui tähtede arv lõpeb, siis kustutam seda värvi, et edasi kood ei kirjuta teksti rohelises värvis.

            else System.out.print(GREEN + alphabetGreen.charAt(i) + " " + RESET);
        }
    }

    public void justRightLetters(StringBuilder alphabetYellow, String YELLOW, String RESET) {

        System.out.println("Teie olete kasutanud õigesti järgmised tähed: ");

        for (int i = 0; i < alphabetYellow.length(); i++) {//kirjutan kollased tähed

            if (i==alphabetYellow.length()-1)//analoogiliselt rohelise värviga
                System.out.println(YELLOW + alphabetYellow.charAt(i) + " " + RESET);//Muudan tähtede värvi kollaseks ja pärast, kui tähtede arv lõpeb, siis kustutam seda värvi, et edasi kood ei kirjuta teksti kollases värvis.

            else System.out.print(YELLOW + alphabetYellow.charAt(i) + " " + RESET);
        }

    }

    public void incorrectLetters(StringBuilder alphabetUsed, String BLACK, String RESET) {

        System.out.println("Teie olete kasutanud valesti järgmised tähed: ");

        for (int i = 0; i < alphabetUsed.length(); i++) {//kirjutan mustad tähed

            if (i==alphabetUsed.length()-1){//analoogiliselt rohelise vörviga

                System.out.println(BLACK + alphabetUsed.charAt(i) + " " + RESET); //Muudan tähtede värvi mustaks ja pärast, kui tähtede arv lõpeb, siis kustutam seda värvi, et edasi kood ei kirjuta teksti mustas värvis.

            }else System.out.print(BLACK + alphabetUsed.charAt(i) + " " + RESET);
        }
    }
}
