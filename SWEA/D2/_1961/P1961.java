package swexpertacademy.d2._1961;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.StringTokenizer;

public class P1961 {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        //System.setIn(new FileInputStream("src/test/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;//= new StringTokenizer(br.readLine());

        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++) {
            int N = Integer.parseInt(br.readLine()); // #t 로 시작
            int[][] box = new int[N][N];

            for(int n=0;n<N;n++) {
                st = new StringTokenizer(br.readLine());
                for (int nn=0;nn<N;nn++) {
                    box[n][nn]=Integer.parseInt(st.nextToken());
                }
            }


            String[][] allBox=new String[N][3];
            for(int i=0;i<3;i++) {
                box = right90(box,N);
                addToAllBox(allBox,i,box,N);
            }
            System.out.println("#"+test_case);
            printBox(allBox,N);
        }
    }
    private static void addToAllBox(String[][] allBox, int i, int[][] box, int N){
        for(int row=0;row<N;row++) {
            StringBuilder st = new StringBuilder();

            for(int column=0;column<N;column++) {
                st.append(box[row][column]);
            }
            allBox[row][i] = st.toString();

        }

    }
    private static int[][] right90(int[][] box,int N) {
        int[][] afterBox=new int[N][N];
        for(int row=0;row<N;row++) {
            //열 : N-1-row
            //행 : 원래의 열i
            for (int column=0;column<N;column++) {
                afterBox[column][N-1-row]=box[row][column];
            }

        }

        return afterBox;
    }
    private static void printBox(String[][] allBox,int N) {
        for(int n=0;n<N;n++) {
            for(int i=0;i<3;i++) {
                System.out.print(allBox[n][i]+" ");
            }
            System.out.println();
        }

    }
}
