/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 
 * Time Complexity:     O(LEN_P) + O(LEN_S) ~ O(LEN_S)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0438;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0SlidingWindow1 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (s == null || s.isEmpty() || p == null || p.isEmpty())
            return ans;

        final int LEN_S = s.length(), LEN_P = p.length();

        int[] freqs = new int[26];
        for (final char CH : p.toCharArray())
            ++freqs[CH - 'a'];

        int count = 0;
        for (int i = 0; i < LEN_S; ++i) {
            if (i >= LEN_P) {
                ++freqs[s.charAt(i - LEN_P) - 'a'];
                if (freqs[s.charAt(i - LEN_P) - 'a'] > 0) {
                    --count;
                }
            }

            --freqs[s.charAt(i) - 'a'];

            if (freqs[s.charAt(i) - 'a'] >= 0)
                ++count;
            if (count == LEN_P) {
                ans.add(i - count + 1);
            }
        }

        return ans;
    }
}