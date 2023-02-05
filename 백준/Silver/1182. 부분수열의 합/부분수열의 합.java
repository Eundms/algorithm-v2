import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정수의 개수
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int[] result = new int[N+1];
        boolean[] visited = new boolean[N+1];
        int depth=0;
        for(int n = 1;n<=N;n++)
           dfs(1,visited,result,depth,n);
        System.out.println(count);
    }
    static int count=0;
    public  static void dfs(int start, boolean[] visited,int[] result, int depth, int R){
        if(depth==R){
            int sum=0;
            for(int i=0;i<R;i++){
                sum+=result[i];
                //System.out.print(result[i]+" ");
            }
            if(sum==S){
                count++;
            }
            //System.out.println(" = "+sum);
            return;
        }
        for(int i=start;i<=N;i++){
            if(!visited[i]){
                visited[i]=true;
                result[depth]=arr[i];
                dfs(i,visited,result,depth+1,R);
                visited[i]=false;
            }
        }
    }


}
