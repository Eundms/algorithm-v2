import java.util.*;
class Solution {
    static int basicTime, basicFee, addTime, addFee;
    public int[] solution(int[] fees, String[] records) {
        basicTime = fees[0];
        basicFee = fees[1];
        addTime = fees[2];
        addFee = fees[3];
        
        Map<String, Integer> sumOfUseTime = new HashMap<>();
        // 기본 시간(분) 기본 요금(원) 단위 시간(분) 단위 요금(원)
        Map<Integer, String> idxToCar = new HashMap<>();
        Map<String, Integer> carIdToIdx = new HashMap<>(); // "0000" : 1번 // 입차 1 출차 0
        boolean[] isIn = new boolean[records.length];
        Arrays.fill(isIn, false);
        String[] prevTime = new String[records.length];
        for(String record : records) {
            String[] tokens = record.split(" ");
            
            String carId = tokens[1];
            String command = tokens[2];
            if(!carIdToIdx.keySet().contains(carId)){
                int idx = carIdToIdx.size();
                carIdToIdx.put(carId, idx);
                idxToCar.put(idx, carId);
            }
            if (command.equals("IN")) {
                isIn[carIdToIdx.get(carId)] = true;
                prevTime[carIdToIdx.get(carId)] = tokens[0];
            } else {
                isIn[carIdToIdx.get(carId)] = false;
                int useTime = sumOfUseTime.getOrDefault(carId, 0) + calculate(prevTime[carIdToIdx.get(carId)], tokens[0]);
                sumOfUseTime.put(carId, useTime);
                prevTime[carIdToIdx.get(carId)] = "";
            }
        }
        
        int size = carIdToIdx.size();
        for(int i = 0; i < size; i++) {
            if(isIn[i]) {
                String end = prevTime[i];
                int sum = sumOfUseTime.getOrDefault(idxToCar.get(i), 0) + calculate(end, "23:59");
                sumOfUseTime.put(idxToCar.get(i), sum);
            }
        }
        List<Car> cars = new ArrayList<>();
        List<String> keys = new ArrayList<>(sumOfUseTime.keySet());
        for(String key : keys){
            cars.add(new Car(key, sumOfUseTime.get(key)));
        }
        Collections.sort(cars);
        
        int[] res = cars.stream()
                  .mapToInt(x -> calculateFee(x.time))
                  .toArray();
        return res;
    }
    static int calculateFee(int time){
        System.out.println(time);
        int fee = 0;
        fee += basicFee;
        if(time > basicTime) {
            time -= basicTime;
            fee += (time/addTime + (time % addTime > 0 ? 1 : 0)) * addFee;
        }        
        return fee;
    }
    
    static int calculate(String start, String end) {
        String[] starts = start.split(":");
        int sHour = Integer.parseInt(starts[0]);
        int sMinute = Integer.parseInt(starts[1]);
        
        String[] ends = end.split(":");
        int eHour = Integer.parseInt(ends[0]);
        int eMinute = Integer.parseInt(ends[1]);
        
        int distHour = eHour - sHour;
        int distMinute = eMinute - sMinute;
        if(distMinute < 0) {
            distHour -= 1;
            distMinute += 60;
        }
        
        return distHour * 60 + distMinute;
    }
    
    static class Car implements Comparable<Car>{
        String id;
        int time;
        Car(String id, int time){
            this.id = id;
            this.time = time;
        }
        @Override
        public int compareTo(Car o) {
            return this.id.compareTo(o.id);
        }
    }
}