import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] array ;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st  = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K==0){
                break;
            }
            array = new int[K];
            boolean[] visited=new boolean[K+1];
            for(int k=0;k<K;k++){
                array[k]= Integer.parseInt(st.nextToken());
            }
            comb1(array,visited,0,K,6);
            System.out.println();
        }

    }
    static Stack<Integer> answer = new Stack<>();

    static void comb1(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            print(arr, visited);
            return;
        } else {
            for(int i = start; i < n; i++) {
                visited[i] = true;
                comb1(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }
    static void print(int[] arr, boolean[] visited) {
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}