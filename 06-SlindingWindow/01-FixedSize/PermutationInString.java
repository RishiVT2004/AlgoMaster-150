


// initial solution
          
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // If s1 is longer than s2, no permutation of s1 can be a substring of s2
        if (n > m) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // Populate frequency map for s1
        for (char ch : s1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        // Sliding window technique to check for permutations in s2
        for (int i = 0; i < m; i++) {
            char currentChar = s2.charAt(i);
            map2.put(currentChar, map2.getOrDefault(currentChar, 0) + 1);

            // Remove the leftmost character when window size exceeds n
            if (i >= n) {
                char leftChar = s2.charAt(i - n);
                if (map2.get(leftChar) == 1) {
                    map2.remove(leftChar); // Remove the character if count is 1
                } else {
                    map2.put(leftChar, map2.get(leftChar) - 1);
                }
            }

            // Check if both HashMaps are equal (i.e., s1's permutation exists in s2)
            if (map1.equals(map2)) {
                return true;
            }
        }

        return false; // No permutation found

    }
}

// Optimized Soln 

import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        // If s1 is longer than s2, no permutation of s1 can be in s2
        if (n > m) {
            return false;
        }
        
        int[] counter1 = new int[26]; // Frequency array for s1
        int[] counter2 = new int[26]; // Frequency array for s2's current window

        // Count character frequencies for s1
        for (int i = 0; i < n; i++) {
            counter1[s1.charAt(i) - 'a']++;  // Increase count for s1 characters
        }

        // Sliding window technique to check for permutation in s2
        for (int i = 0; i < m; i++) {
            // Include the current character in the window
            counter2[s2.charAt(i) - 'a']++; 

            // Remove the character that is out of the window when i >= n
            if (i >= n) {
                counter2[s2.charAt(i - n) - 'a']--;
            }

            // Check if both frequency arrays match (i.e., s1's permutation exists in s2)
            if (Arrays.equals(counter1, counter2)) {
                return true;
            }
        }

        return false; // If no match is found, return false
    }
}
