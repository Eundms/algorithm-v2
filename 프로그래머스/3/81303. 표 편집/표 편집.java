import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        TreeSet<Integer> activeRows = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            activeRows.add(i);
        }
        
        Stack<Integer> deletedStack = new Stack<>();
        int current = k;

        for (String command : cmd) {
            char cmdType = command.charAt(0);
            if (cmdType == 'U') {
                int x = Integer.parseInt(command.split(" ")[1]);
                while (x-- > 0) {
                    current = activeRows.lower(current);
                }
            } else if (cmdType == 'D') {
                int x = Integer.parseInt(command.split(" ")[1]);
                while (x-- > 0) {
                    current = activeRows.higher(current);
                }
            } else if (cmdType == 'C') {
                deletedStack.push(current);
                activeRows.remove(current);
                if (activeRows.higher(current) != null) {
                    current = activeRows.higher(current);
                } else {
                    current = activeRows.lower(current);
                }
            } else if (cmdType == 'Z') {
                int restored = deletedStack.pop();
                activeRows.add(restored);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(activeRows.contains(i) ? "O" : "X");
        }
        return result.toString();
    }
}
