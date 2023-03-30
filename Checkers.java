import java.util.ArrayList;

public class Checkers {
    private int wordLength = 5;

    public boolean wordLengthChecker(int wordLength){

        if (this.wordLength > wordLength){

            System.out.println("Sõna pikkus on liiga lühike");
            return false;

        } else if (this.wordLength < wordLength) {

            System.out.println("Sõna pikkus on liiga suur");
            return false;

        }

        return true;
    }

    public boolean wordInList(StringBuilder sona, ArrayList<String> massiiv){

        if (massiiv.contains(String.valueOf(sona))){
            return false;
        }
        System.out.println("Seda sõna pole sõnade loendis");
        return true;
    }

    public ArrayList<Integer> greenLetter(StringBuilder user,StringBuilder random){

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < user.length(); i++) {

            if(user.charAt(i) == (random.charAt(i))){
                result.add(i);
            }

        }
        return result;
    }

    public ArrayList<Integer> yellowLetter(StringBuilder user,StringBuilder random){

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < user.length(); i++) {

            if(random.indexOf(String.valueOf(user.charAt(i)))!=-1){
                result.add(random.indexOf(String.valueOf(user.charAt(i))));
            }

        }

        return result;
    }

}
