public class Game {
    public void validate(String p1, String p2) throws IllegalArgumentException{
        if ((!p1.equals("r") && !p1.equals("p") && !p1.equals("s")) || (!p2.equals("r") && !p2.equals("p") && !p2.equals("s"))) {
            throw new IllegalArgumentException("invalid input");
        }
    }
    public void play(String p1, String p2){
        if(p1.equals(p2)){
            System.out.println("Draw!");
        }
        else if((p1 == "r" && p2 =="s") || (p1 == "p" && p2 == "r") || (p1 == "s" && p2 == "p")){
            System.out.println("Player 1 win!");
        }
        else{
            System.out.println("Player 2 win!");
        }
    }
}
