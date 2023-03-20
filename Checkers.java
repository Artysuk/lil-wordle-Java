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

    //https://www.google.com/search?client=opera-gx&q=how+to+check+if+a+word+has+vowels+in+java&sourceid=opera&ie=UTF-8&oe=UTF-8#fpstate=ive&vld=cid:eb501137,vid:iL3EZ01KY9s

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
