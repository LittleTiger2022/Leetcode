// O(n*k) 
// create a list for each key, and append to previous combinations (key point: StringBuilder)
class Solution {
    public List<String> letterCombinations(String digits) {
        char [][] cs = new char[8][];
        cs[0] = new char [] {'a','b','c'};
        cs[1] = new char [] {'d','e','f'};
        cs[2] = new char [] {'g','h','i'};
        cs[3] = new char [] {'j','k','l'};
        cs[4] = new char [] {'m','n','o'};
        cs[5] = new char [] {'p','q','r','s'};
        cs[6] = new char [] {'t','u','v'};
        cs[7] = new char [] {'w','x','y','z'};
        

        List <String> res = new ArrayList<>();
        bt(digits,0,cs,res, new StringBuilder());
        return res;
        
    }
    void bt(String digits,int i,char[][] cs, List<String> ans, StringBuilder can) {
                                   //ystem.out.println(i);
                        //  System.out.println(ans);

        if (i == digits.length()) {
            if (i!=0) 
                ans.add(can.toString());
            return;
        }
        
        for (char c : cs[digits.charAt(i)-'2']) {

            StringBuilder nc = new StringBuilder (can);
            nc.append(c);
            bt(digits,i+1,cs,ans,nc);
        }
    }
}
// 6 ms
// key point (LinkedList t = ans.remove()
class Solution {
    public List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i =0; i<digits.length();i++){
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length()==i){
             //   System.out.println("before " + ans);
				String t = ans.remove();
             //   System.out.println("t " + t);
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
	}
}
