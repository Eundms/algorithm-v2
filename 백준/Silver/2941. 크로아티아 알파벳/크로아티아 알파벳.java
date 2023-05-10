import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int cnt = 0;
        int realLen = 0;
        Set<String> croatia = new HashSet<>(List.of("c=", "s=", "z=", "dz=", "c-", "d-", "lj", "nj"));
        for (int w = 0; w < word.length(); w++) {
            if (word.charAt(w) == '=') {
                if (w >= 1) {
                    if (w >= 2 && word.charAt(w - 1) == 'z' && word.charAt(w - 2) == 'd') {
                        realLen += 2;
                    } else if (word.charAt(w - 1) == 'c' || word.charAt(w - 1) == 's' || word.charAt(w - 1) == 'z') {
                        realLen += 1;
                    }
                }
            } else if (word.charAt(w) == '-') {
                if (w >= 1) {
                    if (word.charAt(w - 1) == 'c' || word.charAt(w - 1) == 'd') {
                        realLen += 1;
                    }
                }
            } else if (word.charAt(w) == 'j') {
                if (w >= 1) {
                    if (word.charAt(w - 1) == 'l' || word.charAt(w - 1) == 'n') {
                        realLen += 1;
                    }
                }
            }
        }
        System.out.println((word.length()-realLen));

    }
}
