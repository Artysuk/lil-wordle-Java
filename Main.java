import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ListAndFile listAndFile = new ListAndFile();
        listAndFile.makeAList("sonad.txt");
        System.out.println(listAndFile.getRandomWord());
        System.out.println(listAndFile.getSonad().size());
    }
}
