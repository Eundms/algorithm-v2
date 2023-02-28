package swexpertacademy.d1._1936;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class P1936 {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/main/java/swexpertacademy/d1/_1936/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(a-b==1 || a-b==-2){
            System.out.println("A");
        }
        else{
            System.out.println("B");
        }
    }
}
