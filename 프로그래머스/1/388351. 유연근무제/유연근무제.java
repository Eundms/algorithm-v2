class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        // 주중 : 출근 희망 시각 + 10분 
        // 주말 : 신경 X 
        // 시각 : 시 * 100 + 분 
        for(int s = 0; s < schedules.length; s++) {
            int schedule = schedules[s];
            boolean isOnTime = true;
            for(int t = 0; t < timelogs[s].length; t++) {
                int timelog = timelogs[s][t];
                if(isWeekend((startday + t - 1)% 7)){
                    continue;
                }
                if(timelog > schedule + 10) {
                    isOnTime = false;
                    break;
                }
            }
            if(isOnTime){
                answer += 1;
            }
        }
        return answer;
    }
    static boolean isWeekend(int day) {
        return day == 5 || day == 6;
    }
}