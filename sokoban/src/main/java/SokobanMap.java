import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SokobanMap {

    private List<List<Integer>> parsedMap;
    private final Map<Integer, String> parsingInfo;
    private Map<String, Integer> sokobanMapCount;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public SokobanMap() {
        parsedMap = new ArrayList<>();
        parsingInfo = new HashMap<>();
        sokobanMapCount = new HashMap<>();
        parsingInfo.put(0, " ");
        parsingInfo.put(1, "O");
        parsingInfo.put(2, "o");
        parsingInfo.put(3, "P");
        parsingInfo.put(4, "#");
    }

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
