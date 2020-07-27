import services.Impl.GameServiceImpl;

import java.io.IOException;

/**
 * @author Yordan Petrov
 * @version 1.0
 */
public class Main {
    /**
     * @param args Variable arguments.
     * @throws IOException
     */
    public static void main(final String[] args) throws IOException {
        GameServiceImpl gameService = new GameServiceImpl();
        gameService.run();
    }
}
