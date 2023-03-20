import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test{
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> sonad = new ArrayList<>();

        File file = new File("sonad.txt");

        try(Scanner sc = new Scanner(file)){
            while(sc.hasNextLine()){
                sonad.add(sc.nextLine());
            }

        }catch(Exception ignored){}

        for (int i = 0; i < sonad.size(); i++) {
            System.out.println(sonad.get((int) Math.ceil(Math.random()*sonad.size())));
        }


        
    }
}