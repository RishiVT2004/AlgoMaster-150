Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character, but a character may map to itself.
 
Example 1:
Input: s = "egg", t = "add"
Output: true

Explanation:
The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.

// Initial Approach 

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        int n1 = s.length();
        int n2 = t.length();
        if(n1 != n2) return false;

        insertMap(map1,s);
        insertMap(map2,t);
        
        int []a1 = new int[n1];
        int []a2 = new int[n2];
        
        insertArray(map1,a1,s);
        insertArray(map2,a2,t);

        if(Arrays.equals(a1,a2)){
            return true;
        }
        return false;
    }
    void insertMap(HashMap<Character,Integer> map,String s){
        int n = s.length();
        for(int i = 0;i<n;i++){
            char key = s.charAt(i);
            map.put(key,map.getOrDefault(key,0) + 1);
        }
    }

    void insertArray(HashMap<Character,Integer> map,int[] arr,String s){
        
        int n = arr.length;
        for(int i = 0;i<n;i++){
            arr[i] = map.get(s.charAt(i));
        }
    }
}

ERROR AS IT IS NOT MAPPING BUT CHECKING FREQ OF EACH CHAR 
  
***
A string is isomorphic to another string if there is a one-to-one mapping between every character in the first string 
and every character in the second string, such that the order of characters is preserved.
***
  
Optimal Solution (2 way Mapping)

  class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> mapST = new HashMap<>();
        HashMap<Character,Character> mapTS = new HashMap<>();
        int n1 = s.length();
        int n2 = t.length();
        if(n1 != n2) return false;

        for(int i = 0;i<n1;i++){
            char key1 = s.charAt(i); // get chars at index i of both strings 
            char key2 = t.charAt(i);

            /*  if mapST contains key1 then check if it is mapped to key2 or not 
                if key1 is mapper to another char except key2 then return false  
            */

            if(mapST.containsKey(key1)){
                if(mapST.get(key1) != key2){
                    return false;
                }
            }

            /*
            Similarly  
            if mapTS contains key2 then check if it is mapped to key1 or not 
            if key2 is mapper to another char except key1 then return false  
            */
            if(mapTS.containsKey(key2)){
                if(mapTS.get(key2) != key1){
                    return false;
                }
            }

            mapST.put(key1,key2); // map char from S->T
            mapTS.put(key2,key1); // map char form T->S
        }
        return true;
    }
}

  
