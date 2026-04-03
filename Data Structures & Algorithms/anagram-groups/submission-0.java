class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ls = new ArrayList<>();
       
        boolean vis[] = new boolean[strs.length];
        for(int i = 0 ; i< strs.length; i++){

            if(vis[i] == true){
                continue;
            }
             List<String> ls1 = new ArrayList<>();
            vis[i] = true;
            ls1.add(strs[i]);

            for(int j = i+1; j<strs.length;j++){

                if(!vis[j] && isAnagram(strs[i],strs[j])){
                    vis[j] = true;
                    ls1.add(strs[j]);
                }

            }
        ls.add(ls1);
        }
    return ls;
    }


    public static boolean isAnagram(String s1 , String s2){

        char ch1[] = s1.toCharArray();
        char ch2[] = s2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        String s3 = new String(ch1);
        String s4 = new String(ch2);

        if(s3.equals(s4)){
            return true;
        }
    return false;
    }
}
