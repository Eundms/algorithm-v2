import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        for(int i=0;i<str.length();i++){
            char item =str.charAt(i);
            if(item>='A'&&item<='Z'){
                sb.append(String.valueOf(item).toLowerCase());
            }else if(item>='a'&&item<='z'){
                sb.append(String.valueOf(item).toUpperCase());
            }else{
                sb.append(item);
            }
        }
        System.out.println(sb);

    }
}
