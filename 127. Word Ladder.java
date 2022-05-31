// solution 1

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
     HashSet<String> frontier = new HashSet<String>();
    HashSet<String> frontierEnd = new HashSet<String>();
    HashSet<String> wordListHash = new HashSet<String>();
    
    wordListHash.addAll(wordList);
    int res = 2;
    
    frontier.add(beginWord);
    frontierEnd.add(endWord);
    if(!wordListHash.contains(endWord)) return 0;
    else
        wordListHash.remove(endWord);
    while(!frontier.isEmpty() && !frontierEnd.isEmpty()){
        HashSet<String> temp = new HashSet<String>();
        for(String word: frontier){
            char[] wordchars = word.toCharArray();
            for(int i = 0; i < wordchars.length; i++){
                for(char c = 'a'; c <= 'z'; c++){
                    char backup = wordchars[i];
                    if(wordchars[i] != c){
                        wordchars[i] = c;
                        String nextword = new String(wordchars);
                        if(frontierEnd.contains(nextword)) return res;
                        if(wordListHash.contains(nextword)){
                            //if(!explored.contains(nextword)){
                                temp.add(nextword);
                                //explored.add(nextword);
                                wordListHash.remove(nextword);
                            //}
                        }
                    }
                    wordchars[i] = backup;
                }
                
            }
        }//for(String word: frontier)
        res ++;
        if(temp.size() < frontierEnd.size()){
            frontier = temp;
            frontierEnd = frontierEnd;
        }
        else{
            frontier = frontierEnd;
            frontierEnd = temp;
        }
    }//while
    return 0;
       
    }
}
