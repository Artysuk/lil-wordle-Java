import java.util.ArrayList;

public class Alphabet {
    private StringBuilder grey = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
    private StringBuilder yellow = new StringBuilder();
    private StringBuilder green = new StringBuilder();
    private StringBuilder used = new StringBuilder();
    public void add_Yellow_Remove_Grey(StringBuilder user, ArrayList<Integer> yellowIndex){

        StringBuilder letterWord = new StringBuilder();

        for (int i = 0; i < yellowIndex.size(); i++) {
            letterWord.append(user.charAt(yellowIndex.get(i)));
        }

        yellow.append(letterWord);

        for (int i = 0; i < letterWord.length(); i++) {

            if (grey.indexOf(Character.toString(letterWord.charAt(i)))!=-1){
                grey.deleteCharAt(grey.indexOf(Character.toString(letterWord.charAt(i))));

            }
        }
    }
    public void add_Green_Remove_Grey(StringBuilder user, ArrayList<Integer> greenIndex){

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
    public void add_Used_Remove_Grey(StringBuilder user, ArrayList<Integer> usedIndex){

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
