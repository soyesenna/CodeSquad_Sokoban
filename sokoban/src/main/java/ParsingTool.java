import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class ParsingTool {


    /*
    parameter : SokobanMap, Map<Character, Integer>
    return : none

    파싱을 수행하는 메서드
    오브젝트의 수와 플레이어의 인덱스도 여기서 확인한다
     */
    public void parse(SokobanMap sokobanMap, Map<Character, Integer> parsingInfo) {
        for (String s : sokobanMap.getOriginMap()) {
            List<Integer> tmp = new ArrayList<>();
            for (char c : s.toCharArray()) {
                tmp.add(parsingInfo.get(c));
                sokobanMap.addSokobanMapCountAsChar(c);
            }
            sokobanMap.addToParsedMap(tmp);
        }
        findPlayer(sokobanMap);

    }
    /*
    parameter : SokobanMap
    return : void

    플레이어의 index를 찾는 메서드
     */
    private void findPlayer(SokobanMap sokobanMap) {
        List<List<Integer>> copiedMap = sokobanMap.getParsedMap();
        for (int i = 0; i < copiedMap.size(); i++) {
            int idx = copiedMap.get(i).indexOf(3);
            if (idx != -1) {
                sokobanMap.setPlayerIdx(i, idx);
                break;
            }
        }
    }
}
