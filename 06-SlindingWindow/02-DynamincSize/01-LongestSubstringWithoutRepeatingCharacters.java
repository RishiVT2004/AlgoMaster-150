Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

// BRUTE FORCE O(N^3)
public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int maxLength = 0;
    
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            if (isUnique(s, i, j)) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
    }
    
    return maxLength;
}

private boolean isUnique(String s, int start, int end) {
    // Use a set to track characters in the current substring
    Set<Character> chars = new HashSet<>();
    
    for (int k = start; k <= end; k++) {
        // If character is already in the set, it's not unique
        if (chars.contains(s.charAt(k))) {
            return false;
        }
        chars.add(s.charAt(k));
    }
    return true;
}

// Optimal 1 Sliding window + HashSet(O(2N))
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(); // Get the length of the string
        int maxLen = 0; // Variable to store the maximum length of unique substring
        HashSet<Character> set = new HashSet<>(); // HashSet to store unique characters
        int i = 0, j = 0; // Two pointers to define the sliding window
        
        while (j < n) { // Traverse the string with right pointer `j`
            if (!set.contains(s.charAt(j))) { // If character is not in the set, expand the window
                set.add(s.charAt(j)); // Add the character to the set
                j++; // Move the right pointer
                maxLen = Math.max(maxLen, j - i); // Update maxLen (fixing off-by-one error)
            } else { 
                set.remove(s.charAt(i)); // If duplicate is found, shrink window from the left
                i++; // Move the left pointer
            }
        }

        return maxLen; // Return the maximum length of the unique substring
    }

The algorithm has O(2N) = O(N) complexity because each character is processed at most twice—once
when expanding (j moves right) and once when shrinking (i moves right). Since both pointers traverse N positions,
the total operations are 2N, simplifying to O(N).

