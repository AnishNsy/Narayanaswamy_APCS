//Randp returns a random number
//random number is between 1 and int n, can not repeat numbers
public class Randp {
    //0 if it has been selected, 1 if it has not been used:
	//essentially used as a boolean array
	private int[] nums;
    //numsLeft keeps the amount of unselected numbers
    private int numsLeft;
	
    //constructor
    public Randp(int n) {
        numsLeft = n;
        nums = new int[n];
        initNums(n);
        		
    }
    
    private void initNums(int n) {
    	for(int i = 0; i < n; i++) {
    		nums[i] = i + 1;
    	}
    }
	
    //fill the fields
    private void initNumsInefficient(int n) {
        //nums gets filled with all ones
        for(int i = 0; i <= n-1; i++) {
        	nums[i] = 1;
        }
    }
	
    //Implement
    public int nextIntInefficient() {
        // Math.random() should never be called more than once
        // when this method is called.  Recursion is not allowed.
    	//if you get retnum to 0, make it go back to the end
    	int retNum = (int)(Math.random()*nums.length);
    	if(nums[retNum] == 1) {
    		nums[retNum] = 0;
    		numsLeft--;
    		return retNum + 1;
    	}
    	if(numsLeft == 0) {
    		return 0;
    	}
    	//check if retNum -1 works, 
    	int i = retNum;
    	int times = nums.length;
    	while(times != 0) {
    		if(nums[i] == 1) {
    			numsLeft--;
    			nums[i] = 0;
    			return i + 1;
    		}
    		times--;
    		if(i == 0) {
    			i = nums.length - 1;
    		}
    		else {
    			i--;
    		}
    	}
    	return 0;
    }
    //From Wikipedia: Fisher Yates shuffle, modified by Durstenfeld
//    -- To shuffle an array a of n elements (indices 0..n-1):
//    	for i from 0 to n−2 do
//    	     j ← random integer such that i ≤ j < n
//    	     exchange a[i] and a[j]
    //nextInt does one iteration on each call
    public int nextInt() {
    	if(numsLeft == 0) {
    		return 0;
    	}
    	int retInd = (int)(Math.random()*numsLeft);
    	int ret = nums[retInd];
    	int temp = nums[retInd];
    	nums[retInd] = nums[numsLeft-1];
    	nums[numsLeft-1] = temp;
    	numsLeft--;
    	return ret;
    }
}
