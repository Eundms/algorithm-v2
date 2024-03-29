import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static int n;
    static int m;
    static int INF=(int)1e9;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph= new int[n + 1][n + 1];
        // 초기값 설정
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = INF;

                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }
        StringTokenizer st ;
        for(int i=0;i<m;i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b]=Math.min(graph[a][b],c);
        }

        for(int k = 1; k<= n; k++){ //경유
            for(int i = 1; i <= n; i++){ //출발
                for(int j = 1; j<=n; j++){ //도착
                    graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]); //k거쳐 가는것이 바로가는것보다 빠른가?
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if (graph[i][j] == INF) {
                    graph[i][j]=0;
                }
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }

    }
}
