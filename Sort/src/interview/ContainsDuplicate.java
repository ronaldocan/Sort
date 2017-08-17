package interview;

import com.sun.javafx.collections.MappingChange;

import java.util.*;

/**
 * Created by Administrator on 2017/6/12.
 */
public class ContainsDuplicate {
    private static HashMap<Integer, Integer> record = new HashMap<>();
    private static Set<Integer> recorde2 = new TreeSet<>();
    public static boolean containsDuplicate(int[] num,int k){
        boolean success = false;
        for (int i = 0; i < num.length; i++) {
            if(recorde2.contains(num[i])){
                success = true;
            }
            recorde2.add(num[i]);
            if(recorde2.size() == k + 1){
                recorde2.remove(num[i - k]);
            }
        }
        return success;
    }
    private static boolean containsSame(int[] num){
        boolean success = false;
        for (int i = 0; i < num.length; i++) {
            if(recorde2.contains(num[i])){
                success = true;
            }
            recorde2.add(num[i]);
        }
        return success;
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
    {
        if(k < 1 || t < 0)
            return false;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            if(set.floor(n) != null && n <= t + set.floor(n) ||
                    set.ceiling(n) != null && set.ceiling(n) <= t + n)
                return true;
            set.add(n);
            if (i >= k)
                set.remove(nums[i - k]);
        }
        return false;
    }
        public boolean isIsomorphic(String s, String t) {

            // 两个字符串都为空
            if (s == null && t == null) {
                return true;
            }
            // 只有一个为空
            else if (s == null || t == null) {
                return false;
            }
            // 两个字符串的长度都为0
            else if (s.length() == 0 && t.length() == 0) {
                return true;
            }
            // 两个字符串的长度不相等
            else if (s.length() != t.length()) {
                return false;
            }
            HashMap<Character, Character> map = new HashMap<>(s.length());
            Set<Character> set = new HashSet<>(t.length());
            for (int i = 0; i < s.length(); i++) {
                char cs = s.charAt(i);
                char ct = t.charAt(i);
                if(!map.containsKey(cs)){
                    if(set.contains(ct))
                        return false;
                    else{
                        map.put(cs,ct);
                        set.add(ct);
                    }
                }
                else {
                    if (map.get(cs) != ct) {
                        return false;
                    }
                }
            }
            return true;
        }

    public static String reverse(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.put(c,map.get(c)+1);
            }
        }
        List<Map.Entry<Character, Integer>> list = new LinkedList<>();
        for(Map.Entry<Character, Integer> m : map.entrySet()) {
            list.add(m);
        }
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> m : list) {
            for (int i = 0; i < m.getValue(); i++) {
                sb.append(m.getKey());
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int[] num = {1,3,5,4,2,1};
//        System.out.println(ContainsDuplicate.containsDuplicate(num,2));
//        System.out.println(ContainsDuplicate.containsSame(num));
        System.out.println(ContainsDuplicate.reverse("tree"));
    }
}
