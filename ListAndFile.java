import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListAndFile{

    private ArrayList<String> sonad;

    ListAndFile(){
        this.sonad = new ArrayList<>();
    }


    public ArrayList<String> makeAList(String fileName) throws FileNotFoundException {

        try(Scanner sc = new Scanner(new File(fileName))){ // new file

            while(sc.hasNextLine()){

                this.sonad.add(sc.nextLine()); // add to list
            }

        }catch(Exception ignored){}

        return this.sonad;

    }

    public String getRandomWord(ArrayList<String> sonad){
        return sonad.get((int) Math.floor(Math.random()*sonad.size())); // random word
    }

    public ArrayList<String> getSonad() {
        return this.sonad;
    }
}