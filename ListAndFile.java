import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ListAndFile{

    private ArrayList<String> sonad;

    public ListAndFile(){
        sonad = new ArrayList<>();
        try(Scanner sc = new Scanner(new File("sonad.txt"))){ // uus fail

            while(sc.hasNextLine()){

                sonad.add(sc.nextLine()); // Lisame listi
            }

        }catch(Exception ignored){}
    }

    public String getRandomWord(){
        return sonad.get((int) Math.floor(Math.random()*sonad.size())); // tagastame suvalise sõna listist
    }

    public ArrayList<String> getSonad() {
        return sonad; //tagastame terve listi
    }
}