//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1205 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        return wordBreak(s, map, dict);
    }

    private boolean wordBreak(String s,
                              Map<String, Boolean> map,
                              Set<String> dict) {
        if (map.containsKey(s)) return map.get(s);
        if (dict.contains(s)) {
            map.put(s, true);
            return true;
        }
        /**
         * s : 'abcdef'
         * i : 3
         * s.substring(i) : 'def'
         * s.substring(0, i) : 'abc'
         */
        for (int i = 1; i < s.length(); i++) {
            // 分割后的两个字符串均为非空
            if (dict.contains(s.substring(i)) && wordBreak(s.substring(0,i), map, dict)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
