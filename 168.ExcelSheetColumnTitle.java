// Note: all solutions use the trick of "--columnNumber" to consider the case of "Z".

//s1
// 7 ms (30%) Recursive
class Solution {
    public String convertToTitle(int columnNumber) {
        if (columnNumber==0)
            return "";
        return convertToTitle(--columnNumber / 26) + (char) ('A' + columnNumber %26);
    }
}
// the above solution in one line:
        return columnNumber == 0 ? "" : convertToTitle(--columnNumber / 26) + (char)('A' + (columnNumber % 26));

// solution 2
// brute force 0ms (100%)
class Solution {
    public String convertToTitle(int columnNumber) {
        if (columnNumber==0)
            return "";
        StringBuilder res = new StringBuilder();
        
            int reminder = --columnNumber %26;
            char temp =  (char) ('A' + reminder);
            res.append(temp);
            columnNumber-= reminder; 
        
        while(columnNumber>0) {
               columnNumber/=26;
            if (columnNumber<=26) {
                temp =  (char) ('A' + columnNumber -1);
                res.append(temp);
                break;
            }
            else {
                reminder = columnNumber %26;
                temp =  (char) ('A' + reminder -1);
                res.append(temp);
                 columnNumber-= reminder; 
            }
        }
            
        res.reverse();
        return res.toString();
    }
}

// simplfied solution 2:

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
    while(columnNumber > 0){
      res.append((char)('A' + (--columnNumber % 26)));
      columnNumber /= 26;
    }
    return res.reverse().toString();

    }
}
