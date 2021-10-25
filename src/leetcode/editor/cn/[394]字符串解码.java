//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 递归 字符串 👍 907 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {
        return decode(s,0)[0];
    }

    // 如果长度为2：0 - 右括号的位置 / 1 - 子串
    // 如果长度为1：只包含结束子串
    public String[] decode(String s, int i) {
        StringBuilder res = new StringBuilder();
        int num = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + (s.charAt(i) - '0');
            } else if (s.charAt(i) == '[') {
                String[] temp = decode(s, i + 1);
                i = Integer.parseInt(temp[0]);
                while (num > 0) {
                    res.append(temp[1]);
                    num --;
                }
            } else if (s.charAt(i) == ']') {
                return new String[]{String.valueOf(i), res.toString()};
            } else {
                res.append(s.charAt(i));
            }
            i ++;
        }
        return new String[]{res.toString()};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
