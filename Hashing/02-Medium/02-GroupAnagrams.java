49. Group Anagrams

Given an array of strings strs, group the 
anagrams together. You can return the answer in any order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , ArrayList<String>> map = new HashMap<>();
        for(String s : strs){
            char []ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        List<List<String>> list = new ArrayList<>(map.values()); 
        return list;
    }
}

/*
Process : 
strs = ['tea','eat','cab']

1. Create a HashMap that stores String as Key and an ArrayList as value
2. for each s in String , convert s to a char Array first -: s = ['t','e','a']
3. then sort it -> s = ['a','e','t']
4. then convert it back to string , this will give us the key for our map -: s = 'aet'
5. then check is key is present in the map , if not then put the key in the map and initialize it with 
an empty ArrayList
6. if not then add the original string s to the key , {aet : <'tea'>}
7. keep doing this for all s in strs 
MAP - : {
            'aet' : <'tea','eat'>
            'abc' : <'cab'>
        }
8. return the values of map in form of a new ArrayList<>(): 
return new ArrayList<>(map.values);
*/
