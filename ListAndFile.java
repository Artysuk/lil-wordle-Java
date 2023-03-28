import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ListAndFile{

    private ArrayList<String> sonad;

    public ListAndFile(){
        sonad = new ArrayList<>();
        try(Scanner sc = new Scanner(new File("sonad.txt"))){ // new file

            while(sc.hasNextLine()){

                sonad.add(sc.nextLine()); // add to list
            }

        }catch(Exception ignored){}
    }

    public String getRandomWord(){
        return sonad.get((int) Math.floor(Math.random()*sonad.size()));
    }

    public ArrayList<String> getSonad() {
        return sonad;
    }
}