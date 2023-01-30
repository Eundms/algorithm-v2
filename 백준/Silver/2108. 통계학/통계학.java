import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
    /*
     * 산술평균 : N개의 수들의 합을 N으로 난ㄴ 값
     * 중앙값
     * 최빈값
     * 범위
     * **/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] items = new int[N];
        for(int i=0;i<N;i++) {
            items[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(items);
        Map<Integer,Integer> count = new HashMap<>();

        int sum=0;
        for(int item : items) {
            sum+=item;
            count.put(item, count.getOrDefault(item,0)+1);//해당 item
        }

        int maxValue = -1;
        for(Entry<Integer, Integer> entry : count.entrySet()) {
            if(maxValue<entry.getValue()) {//최댓값
                maxValue = entry.getValue();
            }

        }

        List<Integer> sameMax = new ArrayList<>();
        for(int key : count.keySet()) {
            if(count.get(key) == maxValue) {
                sameMax.add(key);
            }
        }
        sameMax.sort(Comparator.comparingInt(x->x));

        // 산술 평균
        System.out.printf("%d\n",Math.round((float)sum/N));
        // 중앙값
        System.out.println(items[N/2]);

        // 최빈값 :N개의 수들 중 가장 많이 나타나는 값
        // 여러개 있을 때는 두번째로 작은 값
        if(sameMax.size()>1) {
            System.out.println(sameMax.get(1));
        }else{
            System.out.println(sameMax.get(0));
        }
        // 범위 : N개의 수들 중 최댓값 - 최솟값
        System.out.println(items[N-1]-items[0]);
    }
}
