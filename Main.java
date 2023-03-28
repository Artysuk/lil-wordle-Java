/*
https://courses.cs.ut.ee/2023/OOP/spring/Main/Ruhm1
 */
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Text gameAndText = new Text();
        System.out.println(gameAndText);
        GameProcess game = new GameProcess();
        ListAndFile laf = new ListAndFile();

        StringBuilder randomSona = new StringBuilder(laf.getRandomWord());
        System.out.println(randomSona);
        game.Game(randomSona);
    }
}
