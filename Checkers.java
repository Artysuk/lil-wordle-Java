public abstract class Checkers {
    private int wordLength = 5;
    private String vowels = "aeiou";
    private String consonants = "qwrtpasdfghjklzxcvbnm";

    private int maxTries = 10;

    public boolean wordLengthChecker(int wordLength){

        if (this.wordLength < wordLength){

            System.out.println("Sõna pikkus on liiga lühike");
            return false;

        } else if (this.wordLength> wordLength) {

            System.out.println("Sõna pikkus on liiga suur");
            return false;

        }

        return true;
    }

    public boolean vowelChecker(String typedWord){
        return typedWord.toLowerCase().matches(vowels);
    }
    public boolean consonantChecker(String typedWord){
        return typedWord.toLowerCase().matches(consonants);
    }

    public boolean triesChecker(int counter){
        return counter == maxTries;
    }
}
