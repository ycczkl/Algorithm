import java.util.*;

public class SubarraySum {
	//建HashMap, key: sum value from 0 to index i, value: index
	//if valuei == valuej, index i-1 to j is the result;
	//corner case: [0], [], null, [1,0], !!! what if sum can be 0? map.set(0, -1);
	//Time O(n), space: O(n)
	public ArrayList<Integer> subarraySum(int[] nums) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		if (nums == null || nums.length == 0) 
			return res;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {			
			sum += nums[i];			
			if (!map.containsKey(sum)) 
				map.put(sum, i);
			else {			        
				res.add(map.get(sum)+1);
				res.add(i);
				return res;
			}			
		}
		return res;
	}
	//brute force: O(n^2)
	public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> res= new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return res;
        for (int i = 0; i < nums.length; i++) {
            int sum  = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == 0) {
                    res.add(i);
                    res.add(j);
                    return res;
                }
            }
        }
        return res;
    }
	
	//错误方法！ subarray应为连续的！！！
	public static ArrayList<Integer> SubarraySum(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return res;
        res.add(0);
        helper(nums, 0, res, indexList);
        if (indexList.size() > 0) {
            res.set(0, indexList.get(0));
            res.add(indexList.get(indexList.size()-1));
            return res;    
        } else {
            return res;
        }
    }
    private static void helper(int[] nums, int pos, ArrayList<Integer> res, ArrayList<Integer> indexList) {
        if (res.get(0) == 0 && indexList.size() > 0) return;
        for (int i = pos; i < nums.length; i++) {
            res.set(0, res.get(0) + nums[i]);            
            indexList.add(i);
            for (int v : indexList)
            	System.out.print(v + "->");
            System.out.println();
            helper(nums, i+1, res, indexList);
            if (res.get(0) == 0 && indexList.size() > 0) return;
            res.set(0, res.get(0) - nums[i]);
            indexList.remove(indexList.size()-1);
            System.out.println("Remove: "+i);
        }
    }
    public static void main(String[] args) {
    	ArrayList<Integer> res = SubarraySum(new int[]{-5,10,5,-3,1,1,1,-2,3,-4});
    	System.out.println(res.get(0));
    	System.out.println(res.get(1));
    }
}
