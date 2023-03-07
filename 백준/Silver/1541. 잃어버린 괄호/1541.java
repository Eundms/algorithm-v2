import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String sik;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sik = br.readLine();

        int res = 0;
        String[] str = sik.split("-");
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            String item = str[i];
            String[] num = item.split("\\+");
            int number = 0;
            for (int n = 0; n < num.length; n++) {
                number += Integer.parseInt(num[n]);
            }
            arr.add(number);
        }
        res = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            res -= arr.get(i);
        }
        System.out.println(res);
    }
}
