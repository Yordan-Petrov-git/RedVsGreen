import services.Impl.GameServiceImpl;

import java.io.IOException;

/**
 * @author Yordan Petrov
 * @version 1.0
 */
public class Main {
    /**
     * @param args Variable arguments.
     * @throws IOException Exceptions for the console input.
     */
    public static void main(final String[] args) throws IOException {
        GameServiceImpl gameService = new GameServiceImpl();
        gameService.run();
    }
}
