package Main;

import Services.Impl.GameServiceImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameServiceImpl gameService = new GameServiceImpl();
        gameService.run();
    }
}
