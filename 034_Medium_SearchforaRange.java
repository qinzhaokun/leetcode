

//my solution1
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        int [] re = new int [2];
        while(i < j){
            int mid = i + (j-i)/2;
            if(target <= nums[mid]){
                j = mid;
            }
            else{
                i = mid+1;
            }
        }
        if(nums[i] == target){
            re[0] = i;
        }
        else{
            re[0] = -1;
        }
        
        i = 0;
        j = nums.length-1;
        while(j-i>1){
            int mid = i + (j-i)/2;
            if(target >= nums[mid]){
                i = mid;
            }
            else{
                j = mid -1;
            }
        }
        if(nums[j] == target){
            re[1] = j;
        }
        else if(nums[i] == target){
            re[1] = i;
        }
        else{
            re[1] = -1;
        }
        return re;
    }
}

//my solution2
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            int mid = (i+j)/2;
            if(nums[mid]<target){
                i=mid+1;
            }
            else if(nums[mid]>target){
                j = mid-1;
            }
            else {
                int k1 = i;
                int k2 = mid;
                while(k1<k2){
                    int midk = (k1+k2)/2;
                    if(nums[midk]<target){
                        k1 = midk+1;
                    }
                    else{
                        k2=midk;
                    }
                }
                i=k2;
                k1=mid;
                k2=j;
                while(k1<k2){
                    int midk = (k1+k2)/2;
                    if(nums[midk]>target){
                        k2 = midk-1;
                    }
                    else{
                        k1 = midk+1;
                    }
                }
                if(nums[k1]!=target&&k1>0){
                    k1--;
                }
                j=k1;
                break;
            }
    }
    if(nums[i]==target){
        int []a = new int[2];
        a[0]= i;
        a[1]= j;
        return a;
    }
    else{
        int []a = new int[2];
        a[0]= -1;
        a[1]= -1;
        return a;
    }
}
}

//other solution
vector<int> searchRange(int A[], int n, int target) {
    int i = 0, j = n - 1;
    vector<int> ret(2, -1);
    // Search for the left one
    while (i < j)
    {
        int mid = (i + j) /2;
        if (A[mid] < target) i = mid + 1;
        else j = mid;
    }
    if (A[i]!=target) return ret;
    else ret[0] = i;

    // Search for the right one
    j = n-1;  // We don't have to set i to 0 the second time.
    while (i < j)
    {
        int mid = (i + j) /2 + 1;   // Make mid biased to the right
        if (A[mid] > target) j = mid - 1;  
        else i = mid;               // So that this won't make the search range stuck.
    }
    ret[1] = j;
    return ret; 
}
