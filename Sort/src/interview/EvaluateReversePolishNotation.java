package interview;

import java.util.Stack;

/**
 * Created by Administrator on 2017/6/18.
 */
public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a, b;
        for (int i = 0; i < tokens.length; i++) {
            String temp = tokens[i];
            switch (temp) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push((b + a));
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b * a);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    if (a == 0) {
                        return -1;
                    }
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.parseInt(temp));
            }
        }

        int result = stack.peek();

        return result;
    }

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));

    }
}
