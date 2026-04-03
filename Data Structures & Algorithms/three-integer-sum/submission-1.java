class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
    
    Set<List<Integer>> st = new HashSet<>();

    for(int i = 0 ; i< arr.length ; i++){
    Set<Integer> st1 = new HashSet<>();
        for(int j = i +1 ; j< arr.length ; j++){
            int third = - (arr[j]+arr[i]);
            if(st1.contains(third)){
            List<Integer> ls = new ArrayList<>(Arrays.asList(arr[i],arr[j],third));     
            Collections.sort(ls);
            st.add(ls);
            }
            st1.add(arr[j]);
        }

    }
return new ArrayList<>(st);
    }
}
