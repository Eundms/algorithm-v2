package swexpertacademy.d1._2063;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P2063 {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/main/java/swexpertacademy/d1/_2063/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<N;i++){
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        int mid = N / 2;
        numbers.sort(Comparator.comparingInt(Integer::intValue));
        System.out.println(numbers.get(mid));

    }
}
