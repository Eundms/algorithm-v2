import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int score=0;
        Stack<Homework> task = new Stack<>();
        for(int n=1;n<=N;n++){
            st  = new StringTokenizer(br.readLine());

            int code = Integer.parseInt(st.nextToken());
            if(code==1){ // 새로운 과제 있음 - 1 A T
                int A = Integer.parseInt(st.nextToken()); // 과제 만점
                int T = Integer.parseInt(st.nextToken()); // 과제 해결
                task.push(new Homework(A,T-1));
            }else {// 기존 과제 - 0
                if(!task.isEmpty()){
                    task.peek().remainTime-=1;
                }
            }
            if(!task.isEmpty() && task.peek().remainTime==0){
                score +=task.pop().score;
            }

        }
        System.out.println(score);
    }
}
class Homework{
    int score;
    int remainTime;
    Homework(int score, int remainTime){
        this.score = score;
        this.remainTime = remainTime;
    }
}
