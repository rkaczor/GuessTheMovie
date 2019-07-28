

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class GuessTheMovie {
    public static void main(String[] args) throws Exception {
        try {
            String[] listOfMovies = ListOfMovies();
            List<String> emptyList;

            if (listOfMovies.length > 0) {
                String randomMovie = randomMovie(listOfMovies);
                System.out.println("next:  " + randomMovie);
                GuessTheMovieStartGame startGame = new GuessTheMovieStartGame(randomMovie, "");
                startGame.guessMovie();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static String[] ListOfMovies() throws Exception {
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);
        String[] listOfMovies = {};
        String newMowieLine = "";

        try {
            while (scanner.hasNextLine() == true) {
                String line = scanner.nextLine();
                line += "\n";
                newMowieLine += line;
                listOfMovies = newMowieLine.split("\n");
            }
            // Tests
        /*
        for (int i = 0; i < listOfMovies.length; i++) {
            System.out.println(listOfMovies[i]);
        }

         */


        } catch (Exception e) {
            throw e;
        }
        return listOfMovies;
    }


    public static String randomMovie(String[] movies) {
        int randomMovie = (int) (Math.random() * movies.length);
        return movies[randomMovie];
    }
}
