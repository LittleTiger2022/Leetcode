class CountIntervals {
    TreeMap<Integer, Integer> s;
    int count;

    public CountIntervals() {
        s = new TreeMap<Integer, Integer>();
        count = 0;

    }
    
    public void add(int left, int right) {
        if (s.floorKey(right) == null || s.get(s.floorKey(right)) < left) {
            s.put(left, right);
            count += (right - left + 1);
        } else {
            int start = left;
            int end = right;
            
            // Remove overlapping intervals and update count.
            while (true) {
                int l = s.floorKey(end);
                int r = s.get(l);
                start = Math.min(start, l);
                end = Math.max(end, r);
                count -= (r - l + 1);
                s.remove(l);
                // Break the loop until there is no overlapping with interval (start, end).
                if (s.floorKey(end) == null || s.get(s.floorKey(end)) < start) {
                    break;
                }
            }
            // Add (start, end) to TreeMap and update count.
            s.put(start, end);
            count += (end - start + 1);
        }
        
    }
    
    public int count() {
                return count;

    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */
