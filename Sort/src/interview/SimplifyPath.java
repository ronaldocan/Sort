package interview;

import java.util.Stack;

/**
 * Created by Administrator on 2017/6/18.
 */
public class SimplifyPath {
    public static String simplifyPath(String path) {
//        Stack<String> stack = new Stack<>();
//        int len = path.length();
//        stack.push(path.charAt(0)+"");
//        for (int i = 1; i < len; i++) {
//            switch (path.charAt(i)){
//                case '.':
//                    if('.' == path.charAt(i + 1) && i + 1 <= len)
//                    {
//                        String tmp = stack.peek();
//                        if(tmp.length() > 2) {
//                            tmp = tmp.substring(0, tmp.length() - 2);
//                        }
//                        stack.push(tmp);
//                    }
//                    break;
//                case '/':
//                    break;
//                default:
//                    stack.push(stack.peek() + path.charAt(i));
//            }
//        }
//        return stack.peek();
       String[] pathArray = path.split("/");
       Stack<String> stack = new Stack<>();
       String result = "";
        for (int i = 0; i < pathArray.length; i++) {
            if(pathArray[i].equals("")||pathArray[i].equals("."))
            {}
            else if(pathArray[i].equals("..") ){
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(pathArray[i]);
            }
        }
        if(stack.isEmpty())
            return "/";
        while(!stack.isEmpty())
        {
            result="/"+stack.pop()+result;
        }
        return result;
    }

    public static void main(String[] args) {
        String path = "/home/saf/../s/.";
        System.out.println(simplifyPath(path));
    }
}
