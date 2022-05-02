// 285 ms
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s==null || words == null) return new ArrayList<>();
        
        List <Integer> res = new ArrayList<>();
        int n = words.length;
        int m = words[0].length();
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String str: words) {
            map.put(str,map.getOrDefault(str,0)+1);
        }
        
        for (int i=0; i <= s.length() - n*m; i++) {
            HashMap<String, Integer> copy = new HashMap<>(map);
            int k = n;
            int j = i;
            
            while (k>0 ) {
                String str = s.substring(j,j+m);
                if (!copy.containsKey(str)|| copy.get(str)<1) {
                    break;
                }
                copy.put(str,copy.get(str)-1);
                k--;
                j+=m;
            }
            if (k==0) res.add(i);
                
        }
        return res;
    }
}

// 199 ms
// LC normal solution
// Time complexity: O(nab-(a*n)**2) 
// space complex: O(a+b)

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
      final Map<String, Integer> counts = new HashMap<>();
        for (final String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        final List<Integer> indexes = new ArrayList<>();
        
        final int n = s.length(), num = words.length, len = words[0].length();
        
        for ( int i =0; i < n- num*len +1; i++) {
            final Map<String, Integer> seen = new HashMap<>();
            int j =0;
            while (j <num) {
                final String word = s.substring(i+j*len,i+(j+1)*len);
                if (counts.containsKey(word)) {
                    seen.put(word,seen.getOrDefault(word,0)+1);
                    if (seen.get(word)>counts.getOrDefault(word,0)) {
                        break;
                    }
                }
                else { break;}
            j++;
            }   
        if (j==num) { indexes.add(i); }
    }
        return indexes;
}
}
