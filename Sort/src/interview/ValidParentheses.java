package interview;

import java.util.Stack;

/**
 * Created by Administrator on 2017/6/18.
 */
public class ValidParentheses {
    public static boolean isValid(String s){
        int len = s.length();
        Stack<Character> stack = new Stack();
        stack.push(s.charAt(0));
        for (int i = 1; i < len; i++) {
            if(!stack.empty() && isMatch(stack.peek(),s.charAt(i))) {
                stack.pop();
            }else
                stack.push(s.charAt(i));
        }
        if(stack.empty()) {
            return true;
        } else {
            return false;
        }

    }
     public static boolean isMatch(char a,char b){
        if(a == '(' && b == ')'||a == '{' && b == '}'||a == '[' && b == ']')
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        String s = "[()]";
        System.out.println(isValid(s));

    }
}
