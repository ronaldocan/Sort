package leetcode;

import java.util.HashSet;

/**
 * Created by Administrator on 2017/6/9.
 */
public class Solution2 {
    public static int  search(String s)
    {
        if(s==null || s.length()==0)
            return 0;
        HashSet<Character> set = new HashSet<Character>();
        int max = 0;
        int walker = 0;
        int runner = 0;
        while(runner<s.length())
        {
            if(set.contains(s.charAt(runner)))
            {
                if(max<runner-walker)
                {
                    max = runner-walker;
                }
                while(s.charAt(walker)!=s.charAt(runner))
                {
                    set.remove(s.charAt(walker));
                    walker++;
                }
                walker++;
            }
            else
            {
                set.add(s.charAt(runner));
            }
            runner++;
        }
        max = Math.max(max,runner-walker);
        return max;
    }
    public static void main(String[] args) {
        String str = "aaavzxbcaaaa";
        System.out.println(Solution2.search(str));

    }
}
