public class Move {

    public static boolean up(SokobanMap sokobanMap) {
        boolean result = false;
        int[] nowPlayer = getPlayerIdx(sokobanMap);
        nowPlayer[0] -= 1;
        nowPlayer[1] -= 1;
        int[] mapSize = sokobanMap.getMapSize();
        int nowR = nowPlayer[0] - 1;
        int nowC = nowPlayer[1];
        if (check(nowR, nowC, mapSize, sokobanMap)) {
            doMove(nowR, nowC, nowPlayer, sokobanMap);
            result = true;
        }
        return result;
    }

    public static boolean down(SokobanMap sokobanMap) {
        boolean result = false;
        int[] nowPlayer = getPlayerIdx(sokobanMap);
        nowPlayer[0] -= 1;
        nowPlayer[1] -= 1;
        int[] mapSize = sokobanMap.getMapSize();
        int nowR = nowPlayer[0] + 1;
        int nowC = nowPlayer[1];
        if (check(nowR, nowC, mapSize, sokobanMap)) {
            doMove(nowR, nowC, nowPlayer, sokobanMap);
            result = true;
        }
        return result;
    }

    public static boolean left(SokobanMap sokobanMap) {
        boolean result = false;
        int[] nowPlayer = getPlayerIdx(sokobanMap);
        nowPlayer[0] -= 1;
        nowPlayer[1] -= 1;
        int[] mapSize = sokobanMap.getMapSize();
        int nowR = nowPlayer[0];
        int nowC = nowPlayer[1] - 1;
        if (check(nowR, nowC, mapSize, sokobanMap)) {
            doMove(nowR, nowC, nowPlayer, sokobanMap);
            result = true;
        }
        return result;
    }

    public static boolean rignt(SokobanMap sokobanMap) {
        boolean result = false;
        int[] nowPlayer = getPlayerIdx(sokobanMap);
        nowPlayer[0] -= 1;
        nowPlayer[1] -= 1;
        int[] mapSize = sokobanMap.getMapSize();
        int nowR = nowPlayer[0];
        int nowC = nowPlayer[1] + 1;
        if (check(nowR, nowC, mapSize, sokobanMap)) {
            doMove(nowR, nowC, nowPlayer, sokobanMap);
            result = true;
        }
        return result;
    }

    private static void doMove(int r, int c, int[] nowPlayer, SokobanMap sokobanMap) {
        int[] tmp = {r, c};
        sokobanMap.change(tmp, nowPlayer);
    }

    private static boolean check(int r, int c, int[] mapSize, SokobanMap sokobanMap) {
        return inRange(r, c, mapSize) && sokobanMap.getParsedMap().get(r).get(c) == 0;
    }

    private static int[] getPlayerIdx(SokobanMap sokobanMap) {
        return sokobanMap.getPlayerIdx();
    }

    private static boolean inRange(int r, int c, int[] mapSize) {
        return r >= 0 && r < mapSize[0] && c >= 0 && c < mapSize[1];
    }
}
