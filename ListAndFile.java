import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ListAndFile{

    private ArrayList<String> sonad;

    ListAndFile(){
        sonad = new ArrayList<>();
    }


    public ArrayList<String> makeAList(String fileName){

        try(Scanner sc = new Scanner(new File(fileName))){ // new file

            while(sc.hasNextLine()){

                sonad.add(sc.nextLine()); // add to list
            }

        }catch(Exception ignored){}

        System.out.println("List tehtud");
        return sonad;

    }

    public String getRandomWord(){
        return sonad.get((int) Math.floor(Math.random()*sonad.size())); // random word
    }

    public ArrayList<String> getSonad() {
        return sonad;
    }
}