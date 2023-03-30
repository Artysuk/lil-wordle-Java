import java.util.ArrayList;

public class Alphabet { //klass selleks et jälgida kõik tähtede muudatused
    private StringBuilder grey = new StringBuilder("abcdefghijklmnopqrstuvwxyz"); //Muutuja, kus on kõik võimalikud tähed
    private StringBuilder yellow = new StringBuilder(); //Tähed, mis on peidetud sõnas aga vales kohas
    private StringBuilder green = new StringBuilder();//Tähed, mis on õiges kohas
    private StringBuilder used = new StringBuilder();//Tähaed, mis ei ole selles sõnas
    public void add_Yellow_Remove_Grey(StringBuilder user, ArrayList<Integer> yellowIndex){
        //Meetod, mis võtab kogu tähistikust tähed ära. Paneb uus tähed kollase tähestikuse
        //Argumetideks: sõna, mis sisestas mängija ja list, kus on kirjas sõna indeksid, kus oli õiged tähed

        StringBuilder letterWord = new StringBuilder();//abi sõna

        for (int i = 0; i < yellowIndex.size(); i++) {
            letterWord.append(user.charAt(yellowIndex.get(i)));
        }//Mängija sõnast õiged tähed lähevad abi sõnale

        yellow.append(letterWord);//tähed lisatakse kollase tähestikusse

        for (int i = 0; i < letterWord.length(); i++) {

            if (grey.indexOf(Character.toString(letterWord.charAt(i)))!=-1){
                // kontroll: kas kogu sõnastikus on need tähed või ei ole
                // võetakse abi sõnast iga täht(märk), muutukse seda sõnaks, ja kuj halli tähestikkus seda täht on olemas siis vastuseks ta ei anna -1
                grey.deleteCharAt(grey.indexOf(Character.toString(letterWord.charAt(i))));
                //võetakse abi sõnast täht, leiame selle tähe index halli tähestikus ja kustutame täht selles indeksis hallis tähestikus

            }
        }
    }
    public void add_Green_Remove_Grey(StringBuilder user, ArrayList<Integer> greenIndex){//sama printsiib mis oli üleval

        StringBuilder letterWord = new StringBuilder();

        for (int i = 0; i < greenIndex.size(); i++) {
            letterWord.append(user.charAt(greenIndex.get(i)));
        }

        green.append(letterWord);

        for (int i = 0; i < letterWord.length(); i++) {
            if (grey.indexOf(Character.toString(letterWord.charAt(i)))!=-1){
                grey.deleteCharAt(grey.indexOf(Character.toString(letterWord.charAt(i))));
            }
        }

    }
    public void add_Used_Remove_Grey(StringBuilder user, ArrayList<Integer> usedIndex){//sama printsiib mis oli üleval

        StringBuilder letterWord = new StringBuilder();

        for (int i = 0; i < usedIndex.size(); i++) {
            letterWord.append(user.charAt(usedIndex.get(i)));
        }

        used.append(letterWord);

        for (int i = 0; i < letterWord.length(); i++) {

            if (grey.indexOf(Character.toString(letterWord.charAt(i)))!=-1){
                grey.deleteCharAt(grey.indexOf(Character.toString(letterWord.charAt(i))));
            }

        }

    }

    public StringBuilder getGrey() {
        return grey;
    }

    public StringBuilder getYellow() {
        return yellow;
    }

    public StringBuilder getGreen() {
        return green;
    }

    public StringBuilder getUsed() {
        return used;
    }
}
