import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        return originMap;
    }


    public void setPlayerIdx(int r, int c) {
        this.playerIdx[0] = r;
        this.playerIdx[1] = c;
    }

    public List<List<Integer>> getParsedMap() {
        List<List<Integer>> copidMap = new ArrayList<>();
        for (int i = 0; i < parsedMap.size(); i++) {
            copidMap.add(new ArrayList<>(parsedMap.get(i)));
        }
        return copidMap;
    }


}
