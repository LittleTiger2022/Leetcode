class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<String> list = new ArrayList<>();
        char [] firstChars = words[0].toCharArray();
        Arrays.sort(firstChars);
        list.add(words[0]);
        for (int i = 1;i<n;i++) {
            char [] chars = words[i].toCharArray();
            Arrays.sort(chars);
            if (!Arrays.equals(firstChars, chars)) {
                list.add(words[i]);
            }
            firstChars = chars;
            
        }
     return  list;
    }
    
}
