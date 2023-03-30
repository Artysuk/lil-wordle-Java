import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class GameProcess {
    private int tries = 6; //katsete arv
    private static final String GREEN = "\u001B[32m"; //konsooli teksti värvi muutumiseks
    private static final String RESET = "\u001B[0m"; //konsooli teksti värvi muutumiseks
    private static final String YELLOW = "\u001B[33m"; //konsooli teksti värvi muutumiseks
    private static final String BLACK = "\u001B[30m"; //konsooli teksti värvi muutumiseks

    public void Game(StringBuilder randomWord){

        Text text = new Text(); // klass, kust me saame kõik sõnumid
        Checkers check = new Checkers(); // klass, mis kontrollib mingeid tegevusi
        ListAndFile laf = new ListAndFile(); // Listidega ja failidega töötamine
        boolean result = false; // mängu resultaati leidmime
        Alphabet alphabet = new Alphabet(); // klass, kus saab töötada tähestikkuga
        String userInput = "_ _ _ _ _"; //algne mängija vastus(tühi)

        System.out.println("Let the game begin!");
        while (tries!=0) {//kontrollib kas on veel katseid mängimiseks


            // Loome tähistikud erinevate värvidega, selleks et tulevikus väljastada ekraanile tähtede informatsiooni

            StringBuilder alphabetGreen = alphabet.getGreen();
            StringBuilder alphabetGrey = alphabet.getGrey();
            StringBuilder alphabetYellow = alphabet.getYellow();
            StringBuilder alphabetUsed = alphabet.getUsed();


            System.out.println(text.numberOfTries(tries)); // Kirjutame katsete numbrit

            text.remainingLettersAlphabet(alphabetGrey); // Kirjutame tähed, mis me saame kasutada

            if (alphabetGreen.length()!=0){

                text.rightLettersAndPlaces(alphabetGreen,GREEN,RESET); //kutsume meetodi, mis kirjutab, millised tähed on õiged ja kirjutatud õigel kohal

            }
            if (alphabetYellow.length()!=0){

                text.justRightLetters(alphabetYellow,YELLOW,RESET); // kutsume meetodi, mis kirjutab, millised tähed on õiged, aga vales kohas

            }

            if (alphabetUsed.length()!=0){

                text.incorrectLetters(alphabetUsed,BLACK,RESET); // kutsume meetodi, mis kirjutab, millised tähed on valed


            }

            System.out.print("Kirjutage oma sõna: ");

            System.out.println(userInput + "\n" + text.manyDashes()); // väljastatakse ekraanile kotnrollitud tähed sõnas

            Scanner sc = new Scanner(System.in); // Palume, et inimene kirjutaks sõna

            StringBuilder answer = new StringBuilder(sc.nextLine());

            if (!check.wordLengthChecker(answer.length())) continue;// Kui sõna pikkkus on suurem või väiksem kui 5, siis seda meile ei sobi ning me alustame otsest.

            if(check.wordInList(answer, laf.getSonad())) continue;// Samalt kui sõna puudub failiListis, siis sama otsest.

            if(answer.toString().equals(randomWord.toString())) {// Kui sõna on see, mida palutati, siis läheme tsükklist välja
                result = true; //muudame resultaat, anname talle väärtuse, mis näitab võitmist
                break;
            }

            ArrayList<Integer> greenIndex = check.greenLetter(answer, randomWord);
            //Õige sõna tähtede indeksid (rohelise värviga), indeksid saab kasutada nii peidetud sõnale, kui ka mängija sõnale
            alphabet.add_Green_Remove_Grey(answer, greenIndex); // Muudame tähestikud, tähestiku klassis

            ArrayList<Integer> yellowIndex = check.yellowLetter(answer, randomWord);
            //Õige tähe vale kohas indeksid, indeksid saab kasutada ainult PEIDETUD sõnas(kollase värviga)
            yellowIndex.removeAll(greenIndex);//Paneme kollast indeksist ära rohelised indeksid

            ArrayList<Integer> yellowIndexAlphabet = new ArrayList<>();
            //Õige tähe vale kohas indeksid, indeksid saab kasutada ainult MÄNGIJA sõnas(kollase värviga)

            userInput ="";

            x:for (int i = 0; i < 5; i++) { //x on selleks et liikuda tsükli alguse

                if(greenIndex.size()!=0){

                    if (yellowIndex.size()==0){

                        for (int j = 0; j < greenIndex.size(); j++) { //võtab kontrollimiseks kõik väärtused greenIndekx listist

                            if (greenIndex.get(j) == i){ //kontrollib indeksid mängija sõnas ja for tsükli muutuja (mis on 0-st 4-ni)
                                userInput+= GREEN + answer.charAt(greenIndex.get(j)) + RESET + " "; //userinputile pannatakse roheline täht
                                continue x; //tuleme tsükli alguse
                            }

                        }

                    }else {

                        for (int j = 0; j < greenIndex.size(); j++) {//võtab kontrollimiseks kõik väärtused greenIndekx listist

                            for (int k = 0; k < yellowIndex.size(); k++) {//võtab kontrollimiseks kõik väärtused yellowIndekx listist

                                if (greenIndex.get(j) == i){
                                    userInput+= GREEN + answer.charAt(greenIndex.get(j)) + RESET + " ";
                                    continue x;

                                }
                                else if (answer.indexOf(String.valueOf(randomWord.charAt(yellowIndex.get(k)))) == i) {
                                    //võtab väärtus yellowIndex listist, vaatab mis täht(märk) on see peidetus sõnas, muutub märk sõnaks,
                                    //vaatab, mis indeksis on sama täht mängija sõnas

                                    userInput+= YELLOW + randomWord.charAt(yellowIndex.get(k)) + RESET + " ";//userinputile pannatakse kollane täht
                                    yellowIndexAlphabet.add(i); //lisatakse indeks listile, mis vaatab indeksid MÄNGIJA sõnas

                                    continue x;
                                }

                            }
                        }

                    }

                } else if (yellowIndex.size()!=0) {//see koodi lõik on vajalik, kui rohelineIndex on tühi aga kollaneIndex mitte

                    for (int k = 0; k < yellowIndex.size(); k++) {

                        if (answer.indexOf(String.valueOf(randomWord.charAt(yellowIndex.get(k)))) == i) {

                            userInput += YELLOW + randomWord.charAt(yellowIndex.get(k)) + RESET + " ";
                            yellowIndexAlphabet.add(i);
                            continue x;//sama printsiib mis on üleval
                        }
                    }
                }
                userInput+="_ ";//kui midagi ei sobinud siis lisatakse userInputile tühik ("_  ")
            }
            alphabet.add_Yellow_Remove_Grey(answer, yellowIndexAlphabet);
            //lisatakse tähed kollase tähestikuse kasutades mängija sõnu ja indeksid, mis sobivad mängija sõnale

            ArrayList<Integer> usedIndex = new ArrayList<>(Arrays.asList(0,1,2,3,4)); // list, selleks et leida kõik valed tähed
            usedIndex.removeAll(greenIndex);
            usedIndex.removeAll(yellowIndexAlphabet);//kustutakse indeksid, kus on õiged tähed, sellega ülejäänud indeksid mängija sõnas on valed

            for (int i = 0; i < usedIndex.size(); i++) {//kontroll, mis kontrollib kas sõnas on samad tähed,
                //Näiteks sõna: beers, ütleme, et esimene "e" on õiges kohas, aga teine ei ole, siis me paneme e rohelise sõnastikuse
                //ja me ei saa panna teist "e" kasutatu sõnastiku, sest see ei ole tehniliselt vale täht

                for (int j = 0; j < greenIndex.size(); j++) {
                    if (answer.charAt(usedIndex.get(i)) == answer.charAt(greenIndex.get(j))){
                        usedIndex.remove(i);
                    }
                }

            }
            for (int i = 0; i < usedIndex.size(); i++) {//sama printsiib mis oli üleval
                for (int j = 0; j < yellowIndexAlphabet.size(); j++) {
                    if (answer.charAt(usedIndex.get(i)) == answer.charAt(yellowIndexAlphabet.get(j))){
                        usedIndex.remove(i);
                    }
                }
            }

            alphabet.add_Used_Remove_Grey(answer, usedIndex);

            tries--; // tsükli lõpp, võtab üks katse maha
        }
        if (result){ //vaatab resultaadi väärtust(true = võit, false = kaotus)
            System.out.println(text.winningSpeech());
        }else {
            System.out.println(text.loserSpeech());
        }
    }
}