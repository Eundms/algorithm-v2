import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N; //샘플번호1~N
    static int M;
    static int[]parent;
    static long[] dist;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N==0 && M==0){
                break;
            }
            parent = new int[N + 1];
            for(int i=1;i<=N;i++){
                parent[i]=i;
            }
            dist = new long[N + 1];


            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (command == '!') {
                    // b가 a보다 w그램 무겁다
                    int w = Integer.parseInt(st.nextToken());
                    union(a, b, w);
                } else { // b가 a보다 얼마나 무거운가

                    if (find(a) != find(b)) {
                        // [1] 무게 비교 불가능
                        System.out.println("UNKNOWN");
                    } else {
                        // [2] 무게 비교 가능
                        System.out.println(dist[a] - dist[b]);
                    }

                }
            }
        }
    }
    static int find(int x){
        if(parent[x] == x){
            return x;
        }
        int p=find(parent[x]);
        dist[x]+=dist[parent[x]];
        parent[x] = p;
      return p;
    }
    static void union(int a, int b,int w) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA==rootB)return;
        dist[rootA]=dist[b]-dist[a]+w;
        parent[rootA] = rootB;
    }


}
