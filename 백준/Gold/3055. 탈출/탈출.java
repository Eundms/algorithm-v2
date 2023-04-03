import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int R,C;
    static Character[][] gmap; // 맵
    static int result;  // 결과
    static int[]dx = {-1,1,0,0};
    static int[]dy={0,0,-1,1};
    static Queue<int[]> q = new LinkedList<>(); // 다음에 방문할 곳 x,y
    static Queue<int[]>water = new LinkedList<>(); // 물 list
    // 고슴도치 위치
    static int[]gsdc=new int[2];

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        R=sc.nextInt();
        C=sc.nextInt();
        gmap=new Character[R][C];
        result=Integer.MAX_VALUE;
        for(int i=0;i<R;i++){
            String line=sc.next();
            for(int j=0;j<C;j++){
                gmap[i][j]=line.charAt(j);
                if (gmap[i][j]=='S') { // 초기 고슴도치 위치 - 1곳
                    q.add(new int[]{i, j,0});
                }else if(gmap[i][j]=='*'){
                    water.add(new int[]{i,j});
                }
            }
        }
        bfs();
        // Integer.MAX_VALUE
        if (result==Integer.MAX_VALUE)
            System.out.println("KAKTUS");
        else
            System.out.println(result);
        /*
        for(int i=0;i<R;i++) {
            for (int j = 0; j < C; j++) {
                System.out.println(gmap[i][j]);
            }
        }*/
    }
    public static void bfs(){
        while(!q.isEmpty()){
            // 물 넘침
            int water_len= water.size();
            for(int i=0;i<water_len;i++){
                int[]w_xy=water.poll();//[x,y]
                for(int way=0;way<4;way++){
                    int nx= w_xy[0]+dx[way];
                    int ny=w_xy[1]+dy[way];
                    if(nx>=0 &&nx<R&&ny>=0&&ny<C&&gmap[nx][ny]=='.'){
                        gmap[nx][ny]='*'; // 물 넘침 표시
                        water.add(new int[]{nx,ny});
                    }
                }
            }
            // 고슴도치 이동
            int gsdc_len =q.size();
            for(int i=0;i<gsdc_len;i++){
                int []q_xy=q.poll();//[x,y,이동시간]
                for(int way=0;way<4;way++){
                    int nx= q_xy[0]+dx[way];
                    int ny=q_xy[1]+dy[way];
                    if(nx>=0 && nx<R && ny>=0 && ny<C){
                        if(gmap[nx][ny]=='D'){
                            result=Math.min(result,q_xy[2]+1);//(result,직전까지이동시간+1)
                            return;
                        }else if(gmap[nx][ny]=='.'){
                            gmap[nx][ny]='S';
                            q.add(new int[]{nx,ny,q_xy[2]+1});

                        }
                    }
                }

            }


        }

    }
}
