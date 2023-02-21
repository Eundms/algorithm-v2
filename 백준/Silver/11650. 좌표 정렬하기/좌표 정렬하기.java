import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Node[] node = new Node[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            node[i] = new Node(x, y);
        }
        Arrays.sort(node);
        for(int i=0;i<N;i++){
            System.out.println(node[i].x+" "+node[i].y);
        }
    }

}

class Node implements Comparable<Node> {
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        return this.x - o.x == 0 ? this.y - o.y : this.x - o.x;
    }
}