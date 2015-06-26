
public class gasStation {
	// 从i开始计算油含量，如果出现负值则从i到j都不能作为起点
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length != cost.length)
            return -1;
        int i = 0;
        int sum = 0;
        for (i = 0; i < gas.length; i++) {
            sum = 0;
            for (int j = i; j < gas.length + i; j++) {
            	int index = j >= gas.length ? j%gas.length : j;                
                sum += gas[index]-cost[index];
                if (sum < 0) {
                    i = j;
                    break;
                }
            }
            if (sum >= 0) return i;
        }
        return -1;
    }
	public static void main(String[] args) {
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		System.out.println(canCompleteCircuit(gas, cost));
	}
}
