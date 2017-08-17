package interview;

import java.util.*;

/**
 * Created by Administrator on 2017/6/12.
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs){
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String sortedStr = String.valueOf(strChars);
            if(map.containsKey(sortedStr)){
                map.get(sortedStr).add(str);
            }else
            {
                ArrayList<String> tmp = new ArrayList<String>();
                tmp.add(str);
                map.put(sortedStr, tmp);
            }

        }
        List<List<String>> result = new ArrayList<>();
        for (List list : map.values()) {
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
    public static boolean validAnagram(String s,String t){
        if(s == null || t == null)
            return false;
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return String.valueOf(chars).equals(String.valueOf(chars1));
    }
    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = GroupAnagrams.groupAnagrams(str);
        System.out.println(lists);
        System.out.println(validAnagram(" ","rac"));
    }
}
