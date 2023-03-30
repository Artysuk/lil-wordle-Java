import java.util.Scanner;

public class Text {
    public String welcomeText(){
        return manyDashes() +"\n Sõnadle\n" + manyDashes();
    }
    public String manyDashes(){
        return "--------------------------------------------------------------";
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

    public String loserSpeech(){
        return "Kahjuks te olete kaotanud";
    }
    public String writeExample(){

        return "\n Näide (Sõna: glove)\n"+
                manyDashes()+
                "\n Kirjutage sõna (inglise keeles, 5 tähte): sunny" +
                "\n Esimene,teine,kolmas,neljas,viies täht on vale.\n Proovige veel üks kord (proove jäänud: 5)\n"+
                manyDashes() +
                "\n Kirjutage sõna (inglise keeles, 5 tähte): pills" +
                "\n Esimene,teine,neljas,viies täht on vale.\n Kolmas täht on vales asukohas.\n Proovige veel üks kord (proove jäänud: 4)\n" +
                manyDashes() +
                "\n Kirjutage sõna (inglise keeles, 5 tähte): block" +
                "\n Esimene,neljas,viies täht on vale.\n Teine,kolmas täht on õiged.\n Proovige veel üks kord (proove jäänud: 3)\n" +
                manyDashes() +
                "\n Kirjutage sõna (inglise keeles, 5 tähte): glove" +
                "\n Palju õnne, te saite sõnast õigesti aru!!!\n";
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
}
