class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List<String>> map = new HashMap<>();

        for(String s : strs){

            char[] ch = s.toCharArray();

            Arrays.sort(ch);

            String key= new String(ch);
      
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(s);
        }

        List<List<String>> ls = new ArrayList<>(map.values());
        return ls;
    }
}
