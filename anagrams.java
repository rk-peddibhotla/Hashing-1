// Time Complexity : O(n * k log k), n-> no of strings; k-> max length of string for sorting each string
// Space Complexity : O(n * k), storing strings in hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in 3 sentences only
// I used a HashMap to group strings that are anagrams of each other by sorting each word and using it as a key.  
// If two words have the same sorted form, they are anagrams, so I put them in the same list.  
// At the end, I added all the grouped lists from the HashMap to the result list and returned it.



import java.util.*;

public class anagrams {
    
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> ar = new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] charray = strs[i].toCharArray();
            Arrays.sort(charray); 
            String keystr = new String(charray);
            if(!hm.containsKey(keystr)){
                hm.put(keystr, new ArrayList<>());
            }
            hm.get(keystr).add(strs[i]);

        }
        ar.addAll(hm.values());
        return ar;
    }
    public static void main(String[]args){
        anagrams ob = new anagrams();
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = ob.groupAnagrams(strs1);

        System.out.println("Grouped Anagrams:");
        for (List<String> group : result1) {
            System.out.println(group);
        }


        String[] strs2 = {""};
        List<List<String>> result2 = ob.groupAnagrams(strs2);

        System.out.println("Grouped Anagrams:");
        for (List<String> group : result2) {
            System.out.println(group);
        }

        String[] strs3 = {"a"};
        List<List<String>> result3 = ob.groupAnagrams(strs3);

        System.out.println("Grouped Anagrams:");
        for (List<String> group : result3) {
            System.out.println(group);
        }


    }
}
