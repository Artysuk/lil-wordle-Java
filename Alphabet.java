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
        System.out.println("yellow letterWord is: " + letterWord);
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
        System.out.println("green letterWord is: " + letterWord);
        green.append(letterWord);
        for (int i = 0; i < letterWord.length(); i++) {
            if (grey.indexOf(Character.toString(letterWord.charAt(i)))!=-1){
                grey.deleteCharAt(grey.indexOf(Character.toString(letterWord.charAt(i))));
            }
        }
    }
    public void add_Used_Remove_Grey(StringBuilder abc){
        used.append(abc);
        for (int i = 0; i < abc.length(); i++) {
            grey.deleteCharAt(grey.indexOf(Character.toString(abc.charAt(i))));
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
