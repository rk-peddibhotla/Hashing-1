// Time Complexity : O(n) traversing both the strings once
// Space Complexity : O(n) since we use Hashmap and Hashset to solve
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// I used a HashMap to store which character in the first string maps to which character in the second string.  
// I also used a HashSet to make sure that two characters from the first string don't map to the same character in the second string.  
// If I see any mismatch or duplicate mapping while looping through the strings, I return false — otherwise I return true at the end.


import java.util.*;

public class isomorphic {
    public boolean solve(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character, Character> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        int i;
        for(i=0;i<s.length();i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(!hm.containsKey(sChar)){
                hm.put(sChar, tChar);
                if(hs.contains(tChar)){
                    return false;
                }
                hs.add(tChar);
            }
            else{
                if(hm.get(sChar) != tChar){
                    return false;
                }
            }
        }
        return true;

    }
    public static void main(String[]args){
        isomorphic ob = new isomorphic();
        String s1 = "egg";
        String t1 = "add";
        System.out.println(s1+ " "+ "and" + " "+t1+ " "+ "are isomorphic ?"+ " " +ob.solve(s1, t1));
        String s2 = "foo";
        String t2 = "bar";
        System.out.println(s2+ " "+ "and" + " "+t2+ " "+ "are isomorphic ?"+ " " +ob.solve(s2, t2));
        String s3 = "paper";
        String t3 = "title";
        System.out.println(s3+ " "+ "and" + " "+t3+ " "+ "are isomorphic ?"+ " " +ob.solve(s3, t3));


    }
    
}
