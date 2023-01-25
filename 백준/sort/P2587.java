package 백준.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2587 {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/main/java/baekjoon/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[5];
        int allSum=0;
        for(int i=0;i<5;i++){
            int now = Integer.parseInt(br.readLine());
            allSum+=now;
            array[i]=now;
        }
        Arrays.sort(array);
        System.out.println(allSum/5);
        System.out.println(array[2]);

    }
}
