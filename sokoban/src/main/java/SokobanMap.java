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

    public void addToOriginMap(String s) {
        this.originMap.add(s);
    }

    public List<List<Integer>> getParsedMap() {
        return parsedMap;
    }

    public Map<Character, Integer> getSokobanMapCount() {
        return sokobanMapCount;
    }

    public List<String> getOriginMap() {
        return originMap;
    }

    public int[] getPlayerIdx() {
        return playerIdx;
    }

    private void printMap() {

    }




}
