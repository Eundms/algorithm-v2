import java.util.*;
class Solution {
    static int MAX_ENDURE_WEIGHT;
    static int BRIDGE_LENGTH;
    // bridge_length : 다리에 올라갈 수 있는 트럭의 수
    // weight : 다리가 견딜 수 있는 무게
    // truck_weights : 트럭별 무게 
    static int onBridgeWeight = 0;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        MAX_ENDURE_WEIGHT = weight;
        BRIDGE_LENGTH = bridge_length;
        // 다리에 1초 머물다가 나감 
        Deque<Car> bridge = new ArrayDeque<>();
        int time = 0;
        
        int inIdx = 0;
        while(!(bridge.isEmpty() && inIdx >= truck_weights.length)) {
            time += 1;
            outBridge(bridge, time);
            if(inIdx < truck_weights.length) {
                boolean inSuccess = inBridge(bridge, time, truck_weights[inIdx]);
                if(inSuccess){
                    inIdx += 1;
                }
            }
            //System.out.println(time + " : " + bridge + onBridgeWeight);
        }
        
        return time;
    }
    
    // 1. 내보내기
    static void outBridge(Deque<Car> bridge, int curTime) {
        if(!bridge.isEmpty() && bridge.peek().outTime == curTime) {
            onBridgeWeight -= bridge.pollFirst().weight;
        }
    }
    
    // 2. 다리에 올라갈 수 있는지 판단
    static boolean inBridge(Deque<Car> bridge, int curTime, int newTruckWeight) {
        if(onBridgeWeight + newTruckWeight <= MAX_ENDURE_WEIGHT) {
            bridge.addLast(new Car(curTime + BRIDGE_LENGTH, newTruckWeight));
            onBridgeWeight += newTruckWeight;
            return true;
        }
        return false;
    }
    
    
    
    static class Car {
        int outTime, weight;
        Car(int outTime, int weight) {
            this.outTime = outTime;
            this.weight = weight;
        }
        @Override
        public String toString(){
            return ""+weight;
        }
    }
}