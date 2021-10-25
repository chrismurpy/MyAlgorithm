//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1532 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String[] keyword = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<String>();
        if(digits.length() > 0) {
            dfs("", 0, digits);
        }
        return result;
    }

    void dfs(String combination, int index, String digits) {
        if(index == digits.length()) {
            result.add(combination);
            return;
        }

        for (char c : keyword[digits.charAt(index) - '2'].toCharArray()) {
            dfs(combination + c, index + 1, digits);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
