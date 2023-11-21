import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SokobanMap {

    private Map<Integer, List<List<Integer>>> parsedMap;
    private final Map<Character, Integer> parsingInfo;
    private Map<Character, Integer> sokobanMapCount;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public SokobanMap() {
        parsedMap = new HashMap<>();
        parsingInfo = new HashMap<>();
        sokobanMapCount = new HashMap<>();

        parsingInfo.put(' ', 0);
        parsingInfo.put('O', 1);
        parsingInfo.put('o', 2);
        parsingInfo.put('P', 3);
        parsingInfo.put('#', 4);

        sokobanMapCount.put(' ', 0);
        sokobanMapCount.put('O', 0);
        sokobanMapCount.put('o', 0);
        sokobanMapCount.put('P', 0);
        sokobanMapCount.put('#', 0);
    }

    /*
    parameter : none
    return : void

    사용자의 입력과 파싱을 총괄하는 메서드
     */
    public void startMapping() throws IOException{
        List<String> inputMap = input();

    }

    /*
    parameter : List<String>
    return : void

    parameter로 받은 List<String>들을 저장된 parsingInfo에 따라 파싱하여 parsedMap에 저장한다.
    이때 각 오브젝트의 카운트도 같이 세서 sokobanMapCount에 저장한다.
     */
    private void parse(List<String> inputMap) throws NumberFormatException{
        StringTokenizer st;
        int nowRound = 0;
        for (String s : inputMap) {
            if (s.contains("Stage")) {
                try {
                    st = new StringTokenizer(s, " ");
                    st.nextToken();
                    nowRound = Integer.parseInt(st.nextToken());
                    parsedMap.put(nowRound, new ArrayList<>());
                } catch (NumberFormatException numberFormatException){throw new NumberFormatException("잘못된 입력입니다.");}
            } else if (!s.contains("=")) {
                addToParsedMapAndCount(s, nowRound);
            }
        }
    }

    /*
    parameter : String, int
    return : void

    parameter로 받은 String을 parsingInfo에따라 파싱하여 parsedMap에 parameter로 받은 round key로 저장한다
    또한 오브젝트의 개수 또한 여기서 세어서 sokobanMapCount에 저장한다
     */
    private void addToParsedMapAndCount(String s, int nowRound) {
        List<Integer> tmp = new ArrayList<>();
        for (char c : s.toCharArray()) {
            tmp.add(parsingInfo.get(c));
            sokobanMapCount.replace(c, sokobanMapCount.get(c) + 1);
        }
        parsedMap.get(nowRound).add(tmp);
    }

    /*
    parameter : none
    return : List<String>

    사용자로부터 맵 정보를 받아서 \n 구분자를 기준으로 List에 담아 반환해주는 메서드
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
}
