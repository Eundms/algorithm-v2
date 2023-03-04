import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (sb.length() >= 4) {
                if (sb.substring(sb.length() - 4, sb.length()).equals("PPAP")) {
                    sb.replace(sb.length() - 4, sb.length(), "P");
                }
            }
        }
        if (sb.toString().equals("P")) {
            System.out.println("PPAP");
        }else {
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == 'A') {
                    System.out.println("NP");
                    return;
                }
            }
            System.out.println("NP");
        }
    }
}
