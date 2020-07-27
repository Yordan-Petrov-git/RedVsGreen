package Main;

import Services.Impl.GameServiceImpl;

import java.io.IOException;
/**
 * @author Yordan Petrov
 *
 * @Main
 *
 * @main
 */
public class Main {
    public static void main(String[] args) throws IOException {
        GameServiceImpl gameService = new GameServiceImpl();
        gameService.run();
    }
}
