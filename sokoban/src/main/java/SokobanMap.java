
import java.util.*;

public class SokobanMap {

    private List<List<Integer>> parsedMap;
    private Map<Character, Integer> sokobanMapCount;
    private List<String> originMap;
    private int[] playerIdx;
    private int rowSize, colSize = 0;
    private final Map<Integer, Character> parsingInfoToChar;

    public SokobanMap() {
        parsedMap = new ArrayList<>();
        sokobanMapCount = new HashMap<>();
        playerIdx = new int[2];
        originMap = new ArrayList<>();
        parsingInfoToChar = new HashMap<>();

        sokobanMapCount.put(' ', 0);
        sokobanMapCount.put('O', 0);
        sokobanMapCount.put('o', 0);
        sokobanMapCount.put('P', 0);
        sokobanMapCount.put('#', 0);

        parsingInfoToChar.put(0, ' ');
        parsingInfoToChar.put(1, 'O');
        parsingInfoToChar.put(2, 'o');
        parsingInfoToChar.put(3, 'P');
        parsingInfoToChar.put(4, '#');
    }

    public int[] getPlayerIdx() {
        int[] toReturn = new int[2];
        toReturn[0] = playerIdx[0];
        toReturn[1] = playerIdx[1];
        return toReturn;
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

    public void change(int[] idx1, int[] idx2) {
        int tmp = parsedMap.get(idx1[0]).get(idx1[1]);
        int tmp2 = parsedMap.get(idx2[0]).get(idx2[1]);

        parsedMap.get(idx1[0]).set(idx1[1], tmp2);
        parsedMap.get(idx2[0]).set(idx2[1], tmp);

    }

    public int[] getMapSize() {
        int[] toReturn = {rowSize, colSize};
        return toReturn;
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

    parsedMap을 char로 변환해서 출력해주는 메서드
     */
    public void printParsedMap() {
        StringBuilder sb = new StringBuilder();
        for (List<Integer> integers : parsedMap) {
            for (Integer parsedNum : integers) {
                sb.append(parsingInfoToChar.get(parsedNum));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
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
        System.out.println("가로크기: " + colSize);
        System.out.println("세로크기: " + rowSize);
        System.out.println("구멍의 수: " + sokobanMapCount.get('O'));
        System.out.println("공의 수: " + sokobanMapCount.get('o'));
        System.out.println("플레이어의 위치: " + playerIdx[0] + "행 " + playerIdx[1] + "열");
    }

    /*
    parameter : none
    return : void

    맵의 크기를 찾아서 저장하는 메서드
     */
    public void findMapSize() {
        int max = Integer.MIN_VALUE;

        for (List<Integer> li : parsedMap) {
            if (li.size() > max) max = li.size();
        }
        colSize = max;
        rowSize = parsedMap.size();
    }

}
