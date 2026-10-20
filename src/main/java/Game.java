public class Game {

    public void play() {
        boolean playing = true;

        while (playing) {
            String firstName1 = readName("Spelare 1 förnamn: ");
            String lastName1 = readName("Spelare 1 efternamn: ");
            Player player1 = new Player(firstName1, lastName1);

            String firstName2 = readName("Spelare 2 förnamn: ");
            String lastName2 = readName("Spelare 2 efternamn: ");
            Player player2 = new Player(firstName2, lastName2);

            for (int i = 1; i <= 2; i++) {
                int castDice = Dice.roll();
                IO.println(player1.getFullName() + " slog " + castDice);
                player1.addToScore(castDice);
            }

            for (int i = 1; i <= 2; i++) {
                int castDice = Dice.roll();
                IO.println(player2.getFullName() + " slog " + castDice);
                player2.addToScore(castDice);
            }

            IO.println();
            IO.println(player1.getFullName() + ": " + player1.getScore());
            IO.println(player2.getFullName() + ": " + player2.getScore());

            if (player1.getScore() > player2.getScore()) {
                IO.println("Vinnare: " + player1.getFullName());
            } else if (player2.getScore() > player1.getScore()) {
                IO.println("Vinnare: " + player2.getFullName());
            } else {
                IO.println("Det blev oavgjort.");
            }

            IO.println();
            String answer = IO.readln("Vill du spela igen? (j/n): ");
            if (!answer.equals("j")) {
                playing = false;
            }
        }
    }

    private String readName(String message) {
        String name = "";

        while (name.isEmpty()) {
            try {
                name = IO.readln(message);
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("Du måste mata in ett värde. Försök igen.");
                }
            } catch (IllegalArgumentException e) {
                IO.println(e.getMessage());
            }
        }
        return name;
    }
}
