import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        boolean[] visited=new boolean[N+1];
        int[] result = new int[N+1];
        arr = new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i]=i;
        }
        dfs(visited,result,0);

    }
    public  static void dfs(boolean[] visited,int[] result, int depth){
        if(depth==N){
            for(int i=0;i<N;i++){
                System.out.print(result[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                visited[i]=true;
                result[depth]=arr[i];
                dfs(visited,result,depth+1);
                visited[i]=false;
            }
        }
    }
}
