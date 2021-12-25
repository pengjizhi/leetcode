/**
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 

 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 

 

 示例 1: 

 
输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 

 示例 2: 

 
输入: strs = [""]
输出: [[""]]
 

 示例 3: 

 
输入: strs = ["a"]
输出: [["a"]] 

 

 提示： 

 
 1 <= strs.length <= 10⁴ 
 0 <= strs[i].length <= 100 
 strs[i] 仅包含小写字母 
 
 Related Topics 哈希表 字符串 排序 👍 949 👎 0

*/
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：字母异位词分组
public class GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs){
            int[] record = new int[26];
            for (char c : str.toCharArray()){
                record[c - 'a'] += 1;
            }
            StringBuffer sb = new StringBuffer();
            // 将一个字符串，每个按照顺序排列的字符，和它自己出现的次数，作为key，存入map
            // 例如：a1b2c3
            for (int i = 0; i < record.length; i++) {
                if (record[i] != 0){
                    sb.append((char)('a' + i));
                    sb.append(record[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> values : map.values()){
            res.add(values);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}