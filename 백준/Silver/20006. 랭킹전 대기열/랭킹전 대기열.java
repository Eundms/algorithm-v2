import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int P, M; // 플레이어수, 방의 정원
    static List<List<Player>> rooms;
    static boolean[] isRoomFull;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rooms = new ArrayList<>();
        isRoomFull = new boolean[301];
        P = Integer.parseInt(st.nextToken()); // 플레이어수
        M = Integer.parseInt(st.nextToken()); // 방의 정원
        for (int p = 0; p < P; p++) { // 플레이어의 레벨 l 닉네임 n
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            Player newPlayer = new Player(nickname, level);

            // 1. 방에 Player 입장
            if (rooms.size() == 0) { // 방이 아에 없는 상태
                List<Player> newRoom = new ArrayList<>(); // 새로운 방만들고
                newRoom.add(newPlayer); // Player 입장
                rooms.add(newRoom);
            } else { // 기존방이 있는 상태
                boolean isEntered = false;
                for (int i = 0; i < rooms.size(); i++) {
                    List<Player> playersInRoom = rooms.get(i);
                    Player firstEnterPlayer = playersInRoom.get(0);
                    if (isRoomFull[i] == false && newPlayer.isBetween(firstEnterPlayer)) {
                        rooms.get(i).add(newPlayer);
                        isEntered = true;
                        break;
                    }
                }
                if (isEntered == false) { // 입장 가능한 방이 없는 경우
                    List<Player> newRoom = new ArrayList<>(); // 새로운 방만들고
                    newRoom.add(newPlayer); // Player 입장
                    rooms.add(newRoom);
                }
            }

            // 2. 방 정원이 다 차면 게임 시작
            for (int i = 0; i < rooms.size(); i++) {
                if (rooms.get(i).size() == M) { // 방의 정원
                    isRoomFull[i] = true;
                }
            }
        }

        // 출력
        for (int i = 0; i < rooms.size(); i++) {
            if (isRoomFull[i]) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }
            List<Player> players = rooms.get(i);
            Collections.sort(players);
            for (int j = 0; j < players.size(); j++) {
                System.out.println(players.get(j));
            }
        }

    }

    static class Player implements Comparable<Player>{
        String nickname;
        int level;

        public Player(String nickname, int level) {
            this.nickname = nickname;
            this.level = level;
        }

        @Override
        public String toString() {
            return level + " " + nickname;
        }

        public boolean isBetween(Player player) {
            if (this.level >= player.level - 10 && this.level <= player.level + 10) {
                return true;
            }
            return false;
        }


        @Override
        public int compareTo(Player o) {
            return this.nickname.compareTo(o.nickname);
        }
    }
}
