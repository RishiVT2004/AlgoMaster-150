Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the
characters without disturbing the relative positions of the remaining characters. 
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

  class Solution {
    public boolean isSubsequence(String s, String t) {
    
        int m = s.length();
        int n = t.length();

        int i = 0; // tracks string s 
        int j = 0; // tracks string t

        while(i < m && j < n){
            if(s.charAt(i) == t.charAt(j)){
                i++; // character of s is in t -> move next to check next char 
            }
            j++; // constantly iterate through string t to check for common chars  
        }
        /*
        if(i == m){ // indicates that all char in i are mapped and present in j 
            return true;
        }
        return false;
        */
        return i==m;
    }
}

time -> O(N)
space -> O(1)
