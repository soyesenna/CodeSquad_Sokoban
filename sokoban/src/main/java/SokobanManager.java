import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SokobanManager {

    private Map<Integer, SokobanMap> parsedMapWithRound;
    private final Map<Character, Integer> parsingInfo;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final ParsingTool parsingTool;

    public SokobanManager() {
        parsingInfo = new HashMap<>();
        parsingInfo.put(' ', 0);
        parsingInfo.put('O', 1);
        parsingInfo.put('o', 2);
        parsingInfo.put('P', 3);
        parsingInfo.put('#', 4);

        parsingTool = new ParsingTool();
    }

    /*
    parameter : none
    return : void

    사용자의 입력과 파싱을 총괄하는 메서드
     */
    public void startMapping() throws IOException {
        makeSokobanMapWithRound(input());

    }

    /*
    parameter : List<String>
    return : void

    input으로 받은 문자열 리스트를 통해 스테이지를 구별하고 스테이지별 SokobanMap객체를 만든다
    또한, 해당 SokobanMap객체에 originMap을 저장한다
     */
    private void makeSokobanMapWithRound(List<String> input) {
        int nowRound = 0;
        for (String s : input) {
            if (s.contains("Stage")){
                nowRound = Integer.parseInt(s.split(" ")[1]);
                parsedMapWithRound.put(nowRound, new SokobanMap());
            } else if (!s.contains("=")) {
                parsedMapWithRound.get(nowRound).addToOriginMap(s);
            }
        }
    }


    /*
    parameter : none
    return : void

    사용자로부터 맵 정보를 받아서 \n 구분자를 기준으로 나눈후 리턴
     */
    private List<String> input() throws IOException {
        List<String> result = new ArrayList<>();
        while (true){
            String input = br.readLine();
            if (input.equals("")) {
                break;
            }
            result.add(input);
        }
        return result;
    }

    public void printMap() {

    }
}

