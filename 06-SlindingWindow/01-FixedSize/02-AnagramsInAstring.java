Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

// BRUTE FORCE SOLN (O(n2logn2 X n1))
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int n1 = s.length(), n2 = p.length();
        
        if (n1 < n2) {
            return list;
        }

        // Sort p to compare with substrings
        char[] pSorted = p.toCharArray();
        Arrays.sort(pSorted);
        
        // Check all substrings of length n2
        for (int i = 0; i <= n1 - n2; i++) {
            String sub = s.substring(i, i + n2);
            char[] subSorted = sub.toCharArray();
            Arrays.sort(subSorted); // sort the substring 

            if (Arrays.equals(pSorted, subSorted)) { // chjeck if sorted substring is equal to that of the sorted string p
                list.add(i);
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc")); // Output: [0, 6]
        System.out.println(solution.findAnagrams("abab", "ab")); // Output: [0, 1, 2]
    }
}

// Optimal SOLN(O(N1) + O(N2))


import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int n1 = s.length();
        int n2 = p.length();

        if (n1 < n2) {
            return list; // Return empty list if s is shorter than p
        }

        int[] counter1 = new int[26]; // Frequency array for p
        int[] counter2 = new int[26]; // Sliding window frequency array for s

        // Populate counter1 with character frequencies of p
        for (int i = 0; i < n2; i++) {
            counter1[p.charAt(i) - 'a']++;
        }

        // Traverse s with a sliding window of size n2
        for (int i = 0; i < n1; i++) {
            counter2[s.charAt(i) - 'a']++; // Add current character to window
            
            // Remove leftmost character when window size exceeds n2
            if (i >= n2) {
                counter2[s.charAt(i - n2) - 'a']--;
            }

            // Compare both frequency arrays
            if (Arrays.equals(counter1, counter2)) {
                list.add(i - n2 + 1); // Store the starting index of the anagram
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc")); // Output: [0, 6]
        System.out.println(solution.findAnagrams("abab", "ab")); // Output: [0, 1, 2]
    }
}

