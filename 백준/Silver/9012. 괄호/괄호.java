import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0;i<testCase;i++){
            boolean isVPS = true;//올바른 괄호 문자열?
            int stack  = 0;
            String data = br.readLine();

            for(int s=0;s<data.length();s++){
                if(data.charAt(s)=='('){
                    stack+=1;
                }else{//')'
                    if(stack==0){
                        isVPS=false;
                        break;
                    }
                    stack-=1;
                }
            }
            if(stack>0){
                isVPS=false;
            }
            if(isVPS==true){//올바른 괄호 문자열
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
