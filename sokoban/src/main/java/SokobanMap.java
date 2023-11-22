
import java.util.*;

public class SokobanMap {

    private List<List<Integer>> parsedMap;
    private Map<Character, Integer> sokobanMapCount;
    private List<String> originMap;
    private int[] playerIdx;

    public SokobanMap() {
        parsedMap = new ArrayList<>();
        sokobanMapCount = new HashMap<>();
        playerIdx = new int[2];
        originMap = new ArrayList<>();

        sokobanMapCount.put(' ', 0);
        sokobanMapCount.put('O', 0);
        sokobanMapCount.put('o', 0);
        sokobanMapCount.put('P', 0);
        sokobanMapCount.put('#', 0);
    }

    public void addSokobanMapCountAsChar(char c) {
        sokobanMapCount.replace(c, sokobanMapCount.get(c) + 1);
    }

    public void addToParsedMap(List<Integer> list) {
        this.parsedMap.add(list);
    }

    public void addToOriginMap(String s) {
        this.originMap.add(s);
    }


    public List<String> getOriginMap() {
        return new ArrayList<>(originMap);
    }


    public void setPlayerIdx(int r, int c) {
        this.playerIdx[0] = r;
        this.playerIdx[1] = c;
    }

    /*
    parsedMap의 getter
    외부에서 리스트의 수정을 막기위해 리스트를 복사해서 리턴한다
     */
    public List<List<Integer>> getParsedMap() {
        List<List<Integer>> copidMap = new ArrayList<>();
        for (int i = 0; i < parsedMap.size(); i++) {
            copidMap.add(new ArrayList<>(parsedMap.get(i)));
        }
        return copidMap;
    }

    /*
    parameter : none
    return : void

    originMap을 출력해주는 메서드
     */
    public void printOriginMap() {
        for (String s : originMap) {
            System.out.println(s);
        }
    }
    /*
    parameter : none
    return : void

    SokobanMap의 정보를 출력해준다
     */
    public void printMapInfo() {
        System.out.println("가로크기: " + findColSize());
        System.out.println("세로크기: " + parsedMap.size());
        System.out.println("구멍의 수: " + sokobanMapCount.get('O'));
        System.out.println("공의 수: " + sokobanMapCount.get('o'));
        System.out.println("플레이어의 위치: " + playerIdx[0] + "행 " + playerIdx[1] + "열");
    }

    private int findColSize() {
        int max = Integer.MIN_VALUE;

        for (List<Integer> li : parsedMap) {
            if (li.size() > max) max = li.size();
        }
        return max;
    }

}
