
/**
 * Teema: Mäng Sõnadle
 * Autorid: Artur Kašnikov, Nikita Chernov
 *
 * Kirjeldus:
 *
 *      Tegime Wordle (https://www.nytimes.com/games/wordle/index.html) mängu lihtsama varianti,
 *
 *      kus on vaja arvata mingi inglisekeelse 5-tähelise sõna.
 *      Selleks on antud 6 katset
 *
 *      Kui täht on õiges kohas, siis seda tähte tähistatakse rohelise värviga, ning see jaab sama kohal
 *      Kui täht on õige, aga vales kohas, siis tähistatakse seda kollase värviga, ning jääb see sama kohal
 *      Kui täht on öldse vale, siis tähistatakse musta värviga
 *
 *      Nöide on antud Mängureeglites
 *
 * Klassid:
 *
 *      Main (start klass)
 *      Text (teksti kirjutamise klass)
 *      ListAndFile (Faili ja listide töödeldamise klass)
 *      GameProcess (Klass, kus toimub mänguprotsess)
 *      Alphabet (Klass, mis vastutab, et mis värvi on täht)
 *      Checkers (Kõigide tingimuste loomise klass)
 *
 *Ajakulu:
 *
 *      Nikita - GameProcess, Alphabet
 *      Artur - Text,Checkers,ListAndFile, natuke Alphabet
 *      Palju tunde läks, ei tea :')
 *
 * Tegemise mured:
 *
 *      Ausalt öeldes, neid ei olnud, kuid lihtsalt oli natuke mahukas
 *      Ja lisaks, et natuke puudusid teadused Stringbuilderitest
 *
 *Hinnang :
 *
 *      Jagasime kõiki asju eraldi klassidesse+
 *      Kood on loetav +
 *      Kood töötab +
 *      Meie projektiidee on tehtud +
 *      Kood on kommentitud+
 *
 *      Pigem hästi
 *
 *Test:
 *
 *      Testisime mängu niimodi, et proovisime esialgselt õige variante, pärast vale variente, kas viga ei tekki.
 *      Siis proovisime leida mingeid buggi, aga midagi sellest vist ei leindud
 *      Katsetasime mitu korda erinevaid sõnu, lihtsalt mängides
 *
 */


/**
 *
 * INGLISEKEELNE VARIANT ALL
 *
 *
 *
 * ENGLISH VARIANT BELOW
 *
 */



/**
 *  Subject: Sonadle (Game Words)
 *  Authors: Artur Kashnikov, Nikita Chernov
 *  Description:
 *      We made Wordle (https://www.nytimes.com/games/wordle/index.html) a simpler variant of the game,
 *      where it is necessary to guess some English 5-letter word.
 *      To guess the word you have 6 tries.
 *      If the letter is in the right place, then this letter is marked with green color, and remains on the same place
 *      If the letter is right, but in the wrong place, it is marked with yellow color, and it remains in the same place
 *      If the letter is wrong, then it is marked with black color
 *      NB! Everytime a person writes a new word, the whole combination changes, so be careful when typing a word (just using to wordle rules)
 *
 *      The note is given in the rules of the game
 *
 * Classes:
 *      Main (start class)
 *      Text (text writing class)
 *      ListAndFile (File and List processing class)
 *      GameProcess (Class where the play process takes place)
 *      Alphabet (Class responsible for what color is the star)
 *      Checkers (Class for creating all conditions)
 * Time spent:
 *      Nikita - GameProcess, Alphabet
 *      Artur - Text,Checkers,ListAndFile, a bit of an Alphabet
 *      Many hours, did not count them
 *
 * Making Concerns:
 *      To be honest, there weren't any, but it was just a bit bulky
 *      And in addition, there was a little lack of knowledge about Stringbuilders
 *
 * Test:
 *      We tested the game in such a way that we initially tried the correct variants, then the wrong variants, to see if there was an error.
 *      Then we tried to find some bugs, but I guess nothing was found
 *      We tried several times different words by just playing

/*
https://courses.cs.ut.ee/2023/OOP/spring/Main/Ruhm1
 */


import java.io.FileNotFoundException;


public class Main {
    //Peameetod
    public static void main(String[] args) throws FileNotFoundException {

        //Siin me teeme objekte ning paneme siit terve koodi töötama

        Text gameAndText = new Text(); // Klass, mis on mõeldud tekstide kirjutamiseks
        GameProcess game = new GameProcess(); //Klass, mis vastutab terve mängu protsessi
        ListAndFile laf = new ListAndFile(); //Klass, mis on mõeldud listide ja failide töödeldamiseks.

        System.out.println(gameAndText);//Siin väljastatakse reegleid

        StringBuilder randomSona = new StringBuilder(laf.getRandomWord());//Siin luuakse uue sõna, mis tuleb failist suvaliselt

        //System.out.println(randomSona);//Et teada, mis sõna tuleb, jäime souti siin
        game.Game(randomSona);//Mäng algabsiit
    }
}
