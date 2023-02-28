package swexpertacademy.d1._2058;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class P2058 {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/main/java/swexpertacademy/d1/_2058/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N = br.readLine().trim();
        int sum=0;
        for(int i=0;i<N.length();i++){
            sum+=Integer.parseInt(String.valueOf(N.charAt(i)));
        }
        System.out.println(sum);
    }
}
