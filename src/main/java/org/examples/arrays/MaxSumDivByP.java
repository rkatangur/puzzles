package org.examples.arrays;

import java.util.HashMap;
import java.util.Map;

public class MaxSumDivByP {

	public int minSubarray(int[] nums, int p) {
//       int modToRemove = 0;        
//       for(int num: nums){
//           modToRemove = (modToRemove + num)%p;
//       }

//       if(modToRemove == 0){
//           return 0;
//       }

//       int minSubarrLength = nums.lengtOh;
//       int cur_mod =0;

//       Map<Integer, Integer> modsMap = new HashMap<>();        
//       for(int i=0; i<nums.length; i++){
//           cur_mod = (cur_mod + nums[i])%p;
//           int r_mod = (p - modToRemove + cur_mod)%p;
//           if(modsMap.containsKey(r_mod)){
//               minSubarrLength = Math.min(minSubarrLength, i - modsMap.get(r_mod));
//           }
//           modsMap.put(cur_mod, i);
//       }

//       return minSubarrLength >= nums.length ? -1 : minSubarrLength;

		int mod = 0, r_mod = 0, min_w = nums.length;
		for (int n : nums)
			mod = (mod + n) % p;
		if (mod == 0)
			return 0;
		Map<Integer, Integer> pos = new HashMap<>();
		pos.put(0, -1);
		for (int i = 0; i < nums.length; ++i) {
			r_mod = (r_mod + nums[i]) % p;
			int comp = (p - mod + r_mod) % p;
			if (pos.containsKey(comp))
				min_w = Math.min(min_w, i - pos.get(comp));
			pos.put(r_mod, i);
		}
		return min_w >= nums.length ? -1 : min_w;

		// return minSubarrLength;
	}
}
