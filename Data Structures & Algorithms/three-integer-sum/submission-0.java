class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
    
    Arrays.sort(arr);
    int n = arr.length;
    List<List<Integer>> ls = new ArrayList<>();
    for(int i = 0 ; i< n;i++){

        if(i > 0 && arr[i] == arr[i-1]) continue;
        int left = i+1;
        int right = n-1;
        
        while(left < right){

            int sum = arr[i] + arr[left] + arr[right];
            if(sum == 0){
                List<Integer> ls1 = new ArrayList<>(Arrays.asList(arr[i],arr[left],arr[right]));
                ls.add(ls1);
                left++;
                right--;
                while(left< right && arr[left] == arr[left-1]) left++;
                while(left< right && arr[right] == arr[right+1]) right--;
            }
            else if(sum < 0){
                left++;
            }
            else{
                right--;
            }
        }

    }
return ls;

    }
}
