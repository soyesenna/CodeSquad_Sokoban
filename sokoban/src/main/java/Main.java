import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        SokobanManager sokobanManager = new SokobanManager();
        sokobanManager.startMapping();
        sokobanManager.printMap();
    }

}

