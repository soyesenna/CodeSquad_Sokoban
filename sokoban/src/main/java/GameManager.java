import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameManager {

    private final SokobanManager sokobanManager;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public GameManager() {
        sokobanManager = new SokobanManager();
    }

    public void gameStart() throws IOException {
        int nowRound = 2;
        sokobanManager.startMapping();
        SokobanMap nowSokobanMap = sokobanManager.getSokobanMapWithRount(nowRound);

        boolean doGame = true;
        while (doGame) {
            nowSokobanMap.printParsedMap();
            String command = inputCommand();
            for (int i = 0; i < command.length(); i++) {
                String moveMessage = move(command.charAt(i), nowSokobanMap);
                if (moveMessage.equals("Stop")) doGame = false;
                else if (!moveMessage.equals("Success")) System.out.println("\n(경고!) " + moveMessage);
            }
        }
        System.out.println("bye~");

    }

    private String move(char nowMove, SokobanMap sokobanMap) {
        String moveResult = "Success";
        if (nowMove == 'w' || nowMove == 'W') {
            if (!Move.up(sokobanMap)) moveResult = "해당 명령을 수행할 수 없습니다!";
        }
        else if (nowMove == 'd' || nowMove == 'D') {
            if (!Move.rignt(sokobanMap)) moveResult = "해당 명령을 수행할 수 없습니다!";
        }
        else if(nowMove == 'a' || nowMove == 'A') {
        if (!Move.left(sokobanMap)) moveResult = "해당 명령을 수행할 수 없습니다!";
      }
        else if (nowMove == 's' || nowMove == 'S') {
        if (!Move.down(sokobanMap)) moveResult = "해당 명령을 수행할 수 없습니다!";
      }
        else if (nowMove == 'q' || nowMove == 'Q') moveResult = "Stop";
        else moveResult = "지원하지 않는 명령입니다!";

        return moveResult;
    }


    /*
    parameter : none
    return : String

    사용자의 입력을 받는 메서드
     */
    private String inputCommand() throws IOException{
        System.out.print("SOKOBAN> ");
        return br.readLine();
    }
}
