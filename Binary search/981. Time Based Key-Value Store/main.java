class TimeMap {

    HashMap<String, List<Pair<Integer, String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        } 
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            List<Pair<Integer, String>> list = map.get(key);
            return binarySearch(list, timestamp);
        } else return "";
    }
    
    private String binarySearch(List<Pair<Integer, String>> list, int timestamp) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (list.get(mid).getKey() <= timestamp) left = mid; 
            else right = mid - 1;
        }
        return list.get(left).getKey() <= timestamp ? list.get(left).getValue() : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
