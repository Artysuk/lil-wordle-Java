import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;

public class GameProcess {
    private int tries = 6;
    private static final String GREEN = "\u001B[32m";
    private static final String RESET = "\u001B[0m";
    private static final String YELLOW = "\u001B[33m";
    public void Game(StringBuilder randomWord){
        Checkers check = new Checkers();
        ListAndFile laf = new ListAndFile();
        boolean resultaad = false;
        Alphabet alphabet = new Alphabet();
        String userInput = "_ _ _ _ _";


        while (tries!=0) {
            StringBuilder alphabetGreen = alphabet.getGreen();
            StringBuilder alphabetGrey = alphabet.getGrey();
            StringBuilder alphabetYellow = alphabet.getYellow();
            StringBuilder alphabetUsed = alphabet.getUsed();


            System.out.println("Teie katsete arv: " + tries);
            System.out.println("Teie saate kasutada järgmised tähed: ");


            for (int i = 0; i < alphabetGrey.length(); i++) {
                if (i==alphabetGrey.length()-1){
                    System.out.println(alphabetGrey.charAt(i) + " ");
                }else System.out.print(alphabetGrey.charAt(i) + " ");
            }

            if (alphabetGreen.length()!=0){
                System.out.println("Teie olete kasutanud järgmised tähed õiges kohas: ");

                for (int i = 0; i < alphabetGreen.length(); i++) {
                    if (i==alphabetGreen.length()-1){
                        System.out.println(GREEN + alphabetGreen.charAt(i) + " " + RESET);
                    }else System.out.print(GREEN + alphabetGreen.charAt(i) + " " + RESET);
                }
            }
            if (alphabetYellow.length()!=0){
                System.out.println("Teie olete kasutanud õigesti järgmised tähed: ");

                for (int i = 0; i < alphabetYellow.length(); i++) {
                    if (i==alphabetYellow.length()-1){
                        System.out.println(YELLOW + alphabetYellow.charAt(i) + " " + RESET);
                    }else System.out.print(YELLOW + alphabetYellow.charAt(i) + " " + RESET);
                }
            }

            System.out.print("Kirjutage oma sõna: ");
            System.out.println(userInput);
            Scanner sc = new Scanner(System.in);
            StringBuilder answer = new StringBuilder(sc.nextLine());

            if (!check.wordLengthChecker(answer.length())) continue;

            if(check.wordInList(answer, laf.getSonad())) continue;

            if(answer.toString().equals(randomWord.toString())) {
                resultaad = true;
                break;
            }


            ArrayList<Integer> greenIndex = check.greenLetter(answer, randomWord);
            System.out.println(greenIndex);
            alphabet.add_Green_Remove_Grey(answer, greenIndex);

            ArrayList<Integer> yellowIndex = check.yellowLetter(answer, randomWord);
            yellowIndex.removeAll(greenIndex);
            System.out.println(yellowIndex);








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
                                else if ( answer.indexOf(String.valueOf(randomWord.charAt(yellowIndex.get(k))))  /*yellowIndex.get(k)*/ == i) {
                                    userInput+= YELLOW + randomWord.charAt(yellowIndex.get(k)) + RESET + " ";
                                    yellowIndexAlphabet.add(i);
                                    continue x;
                                }
                            }
                        }
                    }
                }
                userInput+="_ ";
            }
            System.out.println("Yellow index alphabet: " + yellowIndexAlphabet) ;
            alphabet.add_Yellow_Remove_Grey(answer, yellowIndexAlphabet);


            tries--;
        }
        if (resultaad){
            System.out.println("Palju õnne, te arvasite selle sõna ära");
        }else {
            System.out.println("Kahjuks, te ei arvanud sõnu ära");
        }
    }
}
