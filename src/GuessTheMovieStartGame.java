
import java.util.Scanner;

public class GuessTheMovieStartGame {
    private String movie;
    private String inputLetter;
    private String[] letters = {};

    public GuessTheMovieStartGame(String movie, String inputLetter) {
        this.movie = movie;
        this.inputLetter = inputLetter;
    }

    public String getMovie() {
        return movie;
    }

    public String getInputLetter() {
        return inputLetter;
    }

    public void guessMovie() {
        int badLetter = 0;
        String dashTitle;
        String allGuessedLetters = "";
        boolean isWinner = false;
        try {
            System.out.println("Guess the moovie title typing the letters.");
            Scanner scan = new Scanner(System.in);
            while (badLetter <= 10) {
                dashTitle = buildDashName();
                System.out.println("You are guessing: " + dashTitle);
                System.out.println("You have guessed " + badLetter + " wrong letters");
                inputLetter = scan.nextLine();
                if (movie.contains(inputLetter)) {
                    //OK
                    allGuessedLetters += inputLetter + "\n";
                    letters = allGuessedLetters.split("\n");

                    /*
                    for (int i = 0; i<letters.length; i++){
                        System.out.println("wpisana litera:" + letters[i]);
                    }

                     */
                    if (movie.equals(buildDashName())) {
                        isWinner = true;
                        System.out.println("YOU WIN! Movie title: " + movie);
                        break;
                    }
                } else {
                    System.out.println("bad letter: " + inputLetter);
                    badLetter++;
                }
            }
            if (!isWinner) {
                System.out.println("YOU LOOSE!!!");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public String buildDashName() {
        String dashedTitle = "";
        String compareLetter = "";
        for (int i = 0; i < movie.length(); i++) {
            char letter = movie.charAt(i);
            boolean input = false;
            if(letter == ' '){
                dashedTitle += " ";
                continue;
            }

            for (int j=0; j< letters.length; j++){
                compareLetter = letters[j];
                if (compareLetter.indexOf(letter) > -1){
                    input = true;
                    break;
                }
            }
            if (input) {
                dashedTitle += letter;
            } else {
                dashedTitle += "_";
            }

        }

        return dashedTitle;
    }
}
