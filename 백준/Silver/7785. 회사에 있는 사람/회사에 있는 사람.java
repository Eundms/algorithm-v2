import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 로그에 기록된 출입 기록이 수
        Set<String> set = new HashSet<>();
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String move = st.nextToken();
            if (move.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }
        List<String> names = new ArrayList<>(set);
        names.sort(Comparator.reverseOrder());
        for(int i = 0; i < names.size() ; i++){
            System.out.println(names.get(i));
        }
    }
}
