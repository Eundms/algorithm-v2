package 백준.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int maxValue=Integer.MIN_VALUE;
        int maxX=0;
        int maxY=0;
        for(int i=0;i<9;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                int nowValue=Integer.parseInt(st.nextToken());
                if(maxValue<nowValue){
                    maxValue=nowValue;
                    maxX=i;
                    maxY=j;
                }
            }
        }
        System.out.println(maxValue);
        System.out.println((maxX+1)+" "+(maxY+1));
    }
}
