import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M ; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(arr);
        for(int i = 0; i < arr.size(); i++){
            sb.append(arr.get(i)+" ");
        }
        System.out.println(sb);

    }
}
