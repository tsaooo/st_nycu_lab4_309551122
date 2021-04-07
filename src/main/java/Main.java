import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("=== rock-paper-scissors game ===");
        System.out.println("Player 1 choice(r/p/s) :");
        String p1 = in.next();
        System.out.println("Player 2 choice(r/p/s) :");
        String p2 = in.next();
        Game game = new Game();

        try {
            game.validate(p1, p2);
            game.play(p1, p2);
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
