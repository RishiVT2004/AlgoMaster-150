A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, 
it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

class Solution {
    public boolean isPalindrome(String s) {
       s = s.toLowerCase(); // converts all char to lowercase 
       s = s.replaceAll("[^a-z0-9]",""); // replaces all non alpha-num symbols with ""
       int n = s.length();

       int i = 0;
       int j = n-1;
       while(i < j){
        if(s.charAt(i) != s.charAt(j)) return false;
        i++;
        j--;
       }
       return true;
    }
}
