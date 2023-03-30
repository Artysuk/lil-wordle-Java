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

    public void remainingLettersAlphabet(StringBuilder alphabetGrey){

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
    public String writeExample(){

        return "\n Näide (Sõna: glove)\n" +
                numberOfTries(6) + "\n";

    }

    public String toString(){

        System.out.println(welcomeText() +
                manyDashes() +
                rulesText());

        return  manyDashes() +
                writeExampleBool() +
                manyDashes();
    }

    public String writeExampleBool(){

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

        for (int i = 0; i < alphabetGreen.length(); i++) {

            if (i==alphabetGreen.length()-1)
                System.out.println(GREEN + alphabetGreen.charAt(i) + " " + RESET);

            else System.out.print(GREEN + alphabetGreen.charAt(i) + " " + RESET);
        }
    }

    public void justRightLetters(StringBuilder alphabetYellow, String YELLOW, String RESET) {

        System.out.println("Teie olete kasutanud õigesti järgmised tähed: ");

        for (int i = 0; i < alphabetYellow.length(); i++) {

            if (i==alphabetYellow.length()-1)
                System.out.println(YELLOW + alphabetYellow.charAt(i) + " " + RESET);

            else System.out.print(YELLOW + alphabetYellow.charAt(i) + " " + RESET);
        }

    }

    public void incorrectLetters(StringBuilder alphabetUsed, String BLACK, String RESET) {

        System.out.println("Teie olete kasutanud valesti järgmised tähed: ");

        for (int i = 0; i < alphabetUsed.length(); i++) {

            if (i==alphabetUsed.length()-1){
                System.out.println(BLACK + alphabetUsed.charAt(i) + " " + RESET);

            }else System.out.print(BLACK + alphabetUsed.charAt(i) + " " + RESET);
        }
    }
}
