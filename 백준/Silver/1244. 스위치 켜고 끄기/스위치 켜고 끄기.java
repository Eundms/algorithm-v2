import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스위치 개수 100이하 양의 정수
        int n = Integer.parseInt(br.readLine());

        // 각 스위치 상태 : 켜져있음 1, 꺼져있음 0
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] status = new int[n+1];
        for(int i=1;i<=n;i++){
            status[i]=Integer.parseInt(st.nextToken());
        }

        // 학생수 : 100 이하인 양의 정수
        int studentNum = Integer.parseInt(br.readLine());
        for(int s=1;s<=studentNum;s++){
            st= new StringTokenizer(br.readLine());
            // 학생의 성별
            int gender = Integer.parseInt(st.nextToken());
            // 학생이 받은 수
            int number = Integer.parseInt(st.nextToken());
            if(gender==1){//남학생
                // 스위치 번호가 number의 배수이면, 스위치 상태를 바꿈
                for(int i=number;i<=n;i+=number){
                    status[i]=onOff(status[i]);
                }
            }else{//여학생
                // number 스위치 중심으로 좌우가 대칭인 모든 연속 구간.
                status[number]=onOff(status[number]);
                int i = number-1;
                int j = number+1;
                while(true){
                    if(i<=0 || j>n || status[i]!=status[j]){
                        break;
                    }
                    if(status[i]==status[j]){
                        status[i]=onOff(status[i]);
                        status[j]=onOff(status[j]);
                        i--;
                        j++;
                    }

                }
            }

        }
       for(int i=1;i<=n;i++){
            System.out.print(status[i]);
            if(i!=n){
                System.out.print(" ");
            }
           if(i%20==0){
                System.out.println();
            }
        }


    }
    private static int onOff(int s){
        if(s==0){
            return 1;
        }
        return 0;
    }
}
