import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N; //나무의 수
    static int M; //나무의 길이
    static int[] trees ;

    static long cutS; //자르는 범위 시작점
    static long cutE; //자르는 범위 끝점
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees=new int[N];
        cutS=0;
        cutE=0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            trees[i]=Integer.parseInt(st.nextToken());
            if(cutE<trees[i]){
                cutE=trees[i];
            }
        }

        while(cutS<=cutE){
            long mid=(cutS+cutE)/2;
            long sum =0;
            for(int i=0;i< N;i++){
                if(trees[i]>mid){
                    sum+=(trees[i]-mid);
                }
            }
            if(sum>=M){
                cutS=mid+1;
            } else{
                cutE=mid-1;
            }
        }
        System.out.println(cutS-1);

    }
}
