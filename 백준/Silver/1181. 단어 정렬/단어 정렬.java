import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N;
    static String[] strList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 단어의 개수
        strList = new String[N];
        for (int n = 0; n < N; n++) {
            strList[n] = br.readLine();
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        };
        Arrays.sort(strList, comparator);

        Set<String> stringSet = new HashSet<>();

        for(int i = 0; i < N ; i++){
            if(!stringSet.contains(strList[i])){
                System.out.println(strList[i]);
                stringSet.add(strList[i]);
            };

        }
    }

}
