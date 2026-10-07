package algorithms.palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Longest palindromic substring
 *
 * Every palindrome has a centre: one character for an odd length
 * ("aba"), or the gap between two characters for an even length
 * ("abba"). From each centre, walk outward while the characters match.
 * The longest walk is the answer. A tie keeps the earlier one.
 *
 * This test finds "bab" in "babad" and "bb" in "cbbd".
 */
class LongestPalindromeTest {

    @Test
    void findsTheLongestPalindromicSubstring() {
        assertEquals("bab", longest("babad"));
        assertEquals("bb", longest("cbbd"));
        assertEquals("racecar", longest("racecar"));
        assertEquals("a", longest("a"));
        assertEquals("", longest(""));
    }

    private String longest(String text) {
        if (text.isEmpty()) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int centre = 0; centre < text.length(); centre++) {
            int odd = expand(text, centre, centre);
            int even = expand(text, centre, centre + 1);
            int length = Math.max(odd, even);
            if (length > end - start + 1) {
                start = centre - (length - 1) / 2;
                end = centre + length / 2;
            }
        }
        return text.substring(start, end + 1);
    }

    private int expand(String text, int left, int right) {
        while (left >= 0 && right < text.length() && text.charAt(left) == text.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
