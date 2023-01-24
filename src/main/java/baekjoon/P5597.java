package baekjoon;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5597 {//Main
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/main/java/baekjoon/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] students=new boolean[31];//1~30
        for(int i=0;i<28;i++){
            students[Integer.parseInt(br.readLine())]=true;
        }
        for(int i=1;i<=30;i++){
            if(students[i]==false){
                System.out.println(i);
            }
        }

    }
}
