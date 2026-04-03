class Pair{
String value;
int timestamp;
public Pair(int timestamp , String value ){
    this.timestamp = timestamp;
    this.value = value;
}
}
class TimeMap {
    HashMap<String,List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<Pair>ls = map.get(key);
        int low = 0;
        int high = ls.size()-1;
        String result = "";
        while(low<=high){
            int mid = low + (high - low)/2;
            if(ls.get(mid).timestamp <= timestamp){
                result = ls.get(mid).value;
                low = mid+1;
            }
            else{
                high = mid -1;
            }

        }
        return result;
    }
}
