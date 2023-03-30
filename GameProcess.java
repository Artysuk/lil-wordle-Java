
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class GameProcess {
    private int tries = 6;
    private static final String GREEN = "\u001B[32m";
    private static final String RESET = "\u001B[0m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLACK = "\u001B[30m";

    public void Game(StringBuilder randomWord){
        Text text = new Text();
        Checkers check = new Checkers();
        ListAndFile laf = new ListAndFile();
        boolean result = false;
        Alphabet alphabet = new Alphabet();
        String userInput = "_ _ _ _ _";


        while (tries!=0) {

            // Loome tähte erinevaid värvidega

            StringBuilder alphabetGreen = alphabet.getGreen();
            StringBuilder alphabetGrey = alphabet.getGrey();
            StringBuilder alphabetYellow = alphabet.getYellow();
            StringBuilder alphabetUsed = alphabet.getUsed();


            System.out.println(text.numberOfTries(tries)); // Kirjutame katsete numbrit

            text.remainingLettersAlphabet(alphabetGrey); // Kirjutame ülejaanud tähed

            if (alphabetGreen.length()!=0){

                text.rightLettersAndPlaces(alphabetGreen,GREEN,RESET); //kutsume meetodi, mis kirjutab, millised tähed on õiged ja kirjutatud õigel kohal

            }
            if (alphabetYellow.length()!=0){

                text.justRightLetters(alphabetYellow,YELLOW,RESET); // kutsume meetodi, mis kirjutab, millised tähed on õiged, aga vales kohas

            }

            if (alphabetUsed.length()!=0){

                text.incorrectLetters(alphabetUsed,BLACK,RESET);


            }

            System.out.print("Kirjutage oma sõna: ");
            System.out.println(userInput);

            Scanner sc = new Scanner(System.in); // Palume, et inimene kirjutaks sõna

            StringBuilder answer = new StringBuilder(sc.nextLine());

            if (!check.wordLengthChecker(answer.length())) continue;// Kui sõna pikkkus on suurem kui 5, siis see on vale, ja me läheme tagasi

            if(check.wordInList(answer, laf.getSonad())) continue;// Samalt kui sõna puudub failiListis, siis sama tagasi

            if(answer.toString().equals(randomWord.toString())) {// Kui sõna on see, mida palutati, siis läheme tsükklist välja
                result = true;
                break;
            }

            ArrayList<Integer> greenIndex = check.greenLetter(answer, randomWord); //Õige sõna tähed (rohelise värviga)
            alphabet.add_Green_Remove_Grey(answer, greenIndex); // Asendame tähtedeListi värvi rohelisega

            ArrayList<Integer> yellowIndex = check.yellowLetter(answer, randomWord);//Üige süna tähed (kollase värviga)
            yellowIndex.removeAll(greenIndex);//Asendame tähtedeListi värvi kollasega

            ArrayList<Integer> yellowIndexAlphabet = new ArrayList<>();

            userInput ="";

            x:for (int i = 0; i < 5; i++) {

                if(greenIndex.size()!=0){

                    if (yellowIndex.size()==0){

                        for (int j = 0; j < greenIndex.size(); j++) {

                            if (greenIndex.get(j) == i){
                                userInput+= GREEN + answer.charAt(greenIndex.get(j)) + RESET + " ";
                                continue x;
                            }

                        }

                    }else {

                        for (int j = 0; j < greenIndex.size(); j++) {

                            for (int k = 0; k < yellowIndex.size(); k++) {

                                if (greenIndex.get(j) == i){
                                    userInput+= GREEN + answer.charAt(greenIndex.get(j)) + RESET + " ";
                                    continue x;

                                }
                                else if (answer.indexOf(String.valueOf(randomWord.charAt(yellowIndex.get(k)))) == i) {

                                    userInput+= YELLOW + randomWord.charAt(yellowIndex.get(k)) + RESET + " ";
                                    yellowIndexAlphabet.add(i);

                                    continue x;
                                }

                            }
                        }

                    }

                } else if (yellowIndex.size()!=0) {

                    for (int k = 0; k < yellowIndex.size(); k++) {

                        if (answer.indexOf(String.valueOf(randomWord.charAt(yellowIndex.get(k)))) == i) {

                            userInput += YELLOW + randomWord.charAt(yellowIndex.get(k)) + RESET + " ";
                            yellowIndexAlphabet.add(i);
                            continue x;
                        }
                    }
                }
                userInput+="_ ";
            }
            alphabet.add_Yellow_Remove_Grey(answer, yellowIndexAlphabet);

            ArrayList<Integer> usedIndex = new ArrayList<>(Arrays.asList(0,1,2,3,4));
            usedIndex.removeAll(greenIndex);
            usedIndex.removeAll(yellowIndexAlphabet);

            for (int i = 0; i < usedIndex.size(); i++) {

                for (int j = 0; j < greenIndex.size(); j++) {
                    if (answer.charAt(usedIndex.get(i)) == answer.charAt(greenIndex.get(j))){
                        usedIndex.remove(i);
                    }
                }

            }
            for (int i = 0; i < usedIndex.size(); i++) {
                for (int j = 0; j < yellowIndexAlphabet.size(); j++) {
                    if (answer.charAt(usedIndex.get(i)) == answer.charAt(yellowIndexAlphabet.get(j))){
                        usedIndex.remove(i);
                    }
                }
            }

            alphabet.add_Used_Remove_Grey(answer, usedIndex);

            tries--;
        }
        if (result){
            System.out.println(text.winningSpeech());
        }else {
            System.out.println(text.loserSpeech());
        }
    }
}
