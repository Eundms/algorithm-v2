import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String,Double> sTable = new HashMap<>();
        sTable.put("A+",4.3);
        sTable.put("A0",4.0);
        sTable.put("A-",3.7);
        sTable.put("B+",3.3);
        sTable.put("B0",3.0);
        sTable.put("B-",2.7);
        sTable.put("C+",2.3);
        sTable.put("C0",2.0);
        sTable.put("C-",1.7);
        sTable.put("D+",1.3);
        sTable.put("D0",1.0);
        sTable.put("D-",0.7);
        sTable.put("F",0.0);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(sTable.get(br.readLine()));
    }
}