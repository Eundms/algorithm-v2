import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Arrays.sort(book_time, 
                    Comparator.comparing((String[] x) -> x[0])
                   .thenComparing((String[] x) -> x[1])
        );
       
        PriorityQueue<String> endTime = new PriorityQueue<>(); // 제일 짧은 시간 먼저 찾기 
        for (String[] book : book_time) {
            System.out.println(Arrays.toString(book));
            if (!endTime.isEmpty() && compareTime(endTime.peek(), book[0])) {
                endTime.poll();
            }
            endTime.add(book[1]);
        }
        
        return endTime.size();
    }
    
    static boolean compareTime(String a, String b) {
        int aMinutes = toMinutes(a) + 10;
        int bMinutes = toMinutes(b);
        return aMinutes <= bMinutes;
    }

    static int toMinutes(String time) { // 시간 계산할 때 분으로 비교하기 
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    
}