import java.io.*;
import java.util.*;
class Solution {
    static List<String> answer = new ArrayList<>();
    static String[][] routes;
    static boolean[] visited;
    public String[] solution(String[][] tickets) throws Exception {
        visited = new boolean[tickets.length];
        routes = tickets;
        dfs("ICN", "ICN", 0);
        Collections.sort(answer);
        return answer.get(0).split(" ");
    }
    static void dfs(String from, String ans, int cnt) {
        if(cnt == routes.length) {
            answer.add(ans);
            return;
        }
        for(int i = 0; i < routes.length; i++){
            if(routes[i][0].equals(from) && !visited[i]) {
                visited[i] = true;
                dfs(routes[i][1], ans + " " + routes[i][1], cnt + 1);
                visited[i] = false;
            }
        }
    }
}