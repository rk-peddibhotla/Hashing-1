// Time Complexity: O(n), where n is the number of words
// Space Complexity: O(n), for the HashMap and HashSet
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Approach in 3 sentences:
// I used a HashMap to store the mapping from each character in the pattern to each word in the string.
// I also used a HashSet to make sure no two characters map to the same word.
// While looping, I check if the mapping is consistent; if not, I return false.



import java.util.HashMap;
import java.util.HashSet;

public class wordPattern {
    public boolean solve(String pattern, String s){
        HashMap<Character, String> hmap = new HashMap<>();
        HashSet<String> hset = new HashSet<>();

        String[] st = s.split(" ");
        if(pattern.length() != st.length){
            return false;
        }
        for(int i=0;i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            String str = st[i];

            if(!hmap.containsKey(ch)){
                if(hset.contains(str)){
                    return false;
                }
                hmap.put(ch, str);
                hset.add(str);
            }
            else{
                if(!hmap.get(ch).equals(str)){
                    return false;
                }
            }
        }
            return true;
    }

    public static void main(String []args){
        wordPattern ob = new wordPattern();
        String pattern1 = "abba";
        String s1 = "dog cat cat dog";
        System.out.println("Test Case 1: "+ob.solve(pattern1, s1));

        String pattern2 = "abba";
        String s2 = "dog cat cat fish";
        System.out.println("Test Case 2: "+ob.solve(pattern2, s2));
        

        String pattern3 = "aaaa";
        String s3 = "dog cat cat dog";
        System.out.println("Test Case 3: "+ob.solve(pattern3, s3));
    }
    
}
