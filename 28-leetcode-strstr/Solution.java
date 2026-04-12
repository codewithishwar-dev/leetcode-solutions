public class Solution {

    // Main function
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        int[] lps = buildLPS(needle);

        int i = 0; // pointer for haystack
        int j = 0; // pointer for needle

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            // Found match
            if (j == needle.length()) {
                return i - j;
            } 
            // Mismatch after j matches
            else if (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    // Build LPS (Longest Prefix Suffix) array
    private int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0; // length of previous longest prefix suffix
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}


// Brute Force Approach (O(n * m))
// for (int i = 0; i <= haystack.length() - needle.length(); i++) {
//     int j = 0;
//     while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
//         j++;
//     }
//     if (j == needle.length()) return i;
// }
// return -1;
