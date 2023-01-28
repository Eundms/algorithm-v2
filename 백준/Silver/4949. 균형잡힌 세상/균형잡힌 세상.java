import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    /*
     * silver 4
     * ()
     * []
     * 괄호 안 문자열 균형
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            String line = br.readLine();
            //System.out.println(line);
            if(line.equals(".")){
                break;
            }
            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;
            for (int i = 0; i < line.length(); i++) {//line.length()-1으로 할 경우 ). 반례
                if (line.charAt(i) == '[' || line.charAt(i) == '(') {
                    stack.push(line.charAt(i));
                } else if (line.charAt(i) == ']' || line.charAt(i) == ')') {
                    if (stack.isEmpty()) {//이상한 배열
                        isBalanced = false;
                        break;
                    }
                    char popItem = stack.pop();
                    if(popItem=='['){
                        if ( line.charAt(i)!=']') {//괄호가 짝이 맞지 않음
                            isBalanced = false;
                            break;
                        }
                    }else{

                        if ( line.charAt(i)!=')') {//괄호가 짝이 맞지 않음
                            isBalanced = false;
                            break;
                        }
                    }

                }

            }
            if (!stack.isEmpty()){
                isBalanced=false;
            }
            if (isBalanced == true) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
