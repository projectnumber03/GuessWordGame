import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scan = new Scanner(System.in);
        while (game.isAlive()) {
            game.play(scan.nextLine());
        }
    }
}