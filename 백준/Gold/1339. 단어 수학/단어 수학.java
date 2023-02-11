import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {// 단어 수학
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 단어의 개수

        Map<Character, Integer> map = new TreeMap<>();// 순서유지

        for (int i = 0; i < N; i++) { // 둘째 줄부터 N개의 줄에 단어가 한 줄에 하나씩 주어짐
            String word = br.readLine();
            int len = word.length();

            for (int j = len - 1; j >= 0; j--) {
                map.put(word.charAt(len-1-j), map.getOrDefault(word.charAt(len-1-j),0)+(int) Math.pow(10, j )); ;
            }
        }
        int res=0;
        List<Integer> values = new ArrayList<>(map.values());
        values.sort(Comparator.comparingInt(Integer::intValue).reversed());
        for(int i=0;i<values.size();i++){
            res+=values.get(i)*(9-i);
        }
        System.out.println(res);

    }
}
