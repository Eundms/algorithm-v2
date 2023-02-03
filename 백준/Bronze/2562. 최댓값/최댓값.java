
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[9];
        for (int i=0;i<9;i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }
        int max= Integer.MIN_VALUE;
        int index=-1;
        for(int i=0;i<9;i++){
            if(max<numbers[i]){
                max=numbers[i];
                index=i;
            }
        }
        System.out.println(max);
        System.out.println(index+1);


    }
}
