// s1 (My naive solution)
// 1 ms (88%) 40Mb (84%)

class Solution {
    public int compareVersion(String version1, String version2) {
        int lenV1 = version1.length(), lenV2 = version2.length();
        int [] ver1 = new int[lenV1];
        int [] ver2 = new int[lenV2];
        
        int tempVer1=0, tempVer2=0;
        int countDot1=0, countDot2=0;
        char temp1, temp2;
        int res=0;
        for (int i=0;i<lenV1;i++) {
            temp1 = version1.charAt(i);
            if (temp1!='.') {
                tempVer1 = tempVer1*10+Integer.parseInt(String.valueOf(temp1));
            }
            else {
                ver1[countDot1++] = tempVer1;
                tempVer1=0;
                
            }
        }
        ver1[countDot1] = tempVer1;
        countDot1++;
        for (int i=0;i<lenV2;i++) {
            temp2 = version2.charAt(i);
            if (temp2!='.') {
                tempVer2 = tempVer2*10+Integer.parseInt(String.valueOf(temp2));
            }
            else {
                ver2[countDot2++] =  tempVer2;
                tempVer2=0;
                
            }
        }
        ver2[countDot2] = tempVer2;
        countDot2++;
     //   System.out.println(Arrays.toString(ver1));
     //   System.out.println(Arrays.toString(ver2));
        
        int compN = Math.min(countDot1,countDot2);
     //   System.out.println("Common N = " + compN);
        for (int i=0;i<compN;i++) {
     //   System.out.println("v1 = "+ ver1 + " v2 = " + ver2 + "countDot1 = " + countDot1 + " countDot1 = " + countDot2);
        if (ver1[i]<ver2[i]) {
            res = -1;
            break;
        }
        else if (ver1[i]>ver2[i]) {
            res = 1;
            break;}
        else
            res = 0;
        }
        
        if (res==0 && countDot1!=countDot2) {
            if (countDot1>countDot2) {
                for (int i=compN;i<countDot1;i++) {
                    if (ver1[i]>0) {
                        res = 1;
                        break;}
                }
                
            }
            else if (countDot1<countDot2 ){
                for (int i=compN;i<countDot2;i++) {
                    if (ver2[i]>0) {
                        res = -1;
                        break;}
                }
                
            }
        }
        
        return res;
    }
}
// solution 2
// 2 ms (55%) 42Mb (7%)
class Solution {
    public int compareVersion(String version1, String version2) {
        String [] v1 = version1.split("\\.");
        String [] v2 = version2.split("\\.");
        
        int n = v1.length, m = v2.length;
        
        for (int i=0;i<Math.min(m,n); ++i) {
           // System.out.println("i = " + i + " v1 = " + v1[i] + " v2 = " + v2[i]);
            if (!Integer.valueOf(v1[i]).equals(Integer.valueOf(v2[i])))
                return Integer.valueOf(v1[i]).compareTo(Integer.valueOf(v2[i]));
        }
        
        Integer sv1=0, sv2=0;
        for (int i= Math.min(m,n);i<Math.max(m,n);i++) {
            if (v1.length>i)
                sv1 += Integer.valueOf(v1[i]);
            if (v2.length>i)
                sv2 += Integer.valueOf(v2[i]);
        }
        return sv1.compareTo(sv2);
    }
}
// s3: elegant soltion
// 88% & 85%
class Solution {
    public int compareVersion(String version1, String version2) {
    String[] levels1 = version1.split("\\.");
    String[] levels2 = version2.split("\\.");
    
    int length = Math.max(levels1.length, levels2.length);
    for (int i=0; i<length; i++) {
    	Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
    	Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
    	int compare = v1.compareTo(v2);
    	if (compare != 0) {
    		return compare;
    	}
    }
    
    return 0;    
    }
}

