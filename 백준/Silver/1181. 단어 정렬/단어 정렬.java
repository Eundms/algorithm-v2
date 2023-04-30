import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static int N;
    static String[] strList;
    public static void main(String[] args) throws IOException {

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        };

        TreeSet<String> treeSet = new TreeSet<>(comparator);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 단어의 개수
        strList = new String[N];
        for (int n = 0; n < N; n++) {
            treeSet.add(br.readLine());
        }

        while(!treeSet.isEmpty()){
            System.out.println(treeSet.pollFirst());
        }
    }

}
