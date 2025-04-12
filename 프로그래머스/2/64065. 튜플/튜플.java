import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2); // 앞 "{{", 뒤 "}}" 제거
        String[] groups = s.split("\\},\\{"); // "},{" 기준으로 나누기

        List<String[]> all = new ArrayList<>();
        for (String group : groups) {
            all.add(group.split(","));
        }

        all.sort(Comparator.comparingInt(a -> a.length));

        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (String[] group : all) {
            for (String numStr : group) {
                int num = Integer.parseInt(numStr);
                if (!seen.contains(num)) {
                    seen.add(num);
                    result.add(num);
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
