package interview;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * Created by Administrator on 2017/6/12.
 */
public class FourSum {
//    private List<Integer> result;
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
//        if (root == null) {
//            return resultList;
//        }
//
//        List<Integer> levelStorage = new LinkedList<Integer>();
//        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.offer(root);
//        queue.offer(null);
//        while (queue.size() > 1) {
//            TreeNode top = queue.poll();
//            if (top == null) {
//                resultList.add(levelStorage);
//                queue.offer(null);
//                levelStorage = new LinkedList<Integer>();
//            } else {
//                levelStorage.add(top.val);
//                if (top.left != null) {
//                    queue.offer(top.left);
//                }
//                if (top.right != null) {
//                    queue.offer(top.right);
//                }
//            }
//        }
//        resultList.add(levelStorage);
//
//        return resultList;
//    }
//    public int[] twoSum(int[] nums, int target) {
//        int[] results = new int[2];
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            Integer temp = map.get(target - nums[i]);
//            if(temp == null)
//                map.put(nums[i], i);
//            else
//            {
//                results[0] = i + 1;
//                results[1] = temp + 1;
//                if(results[0] > results[1]){
//                    int temp2 = results[0];
//                    results[0] = results[1];
//                    results[1] = temp2;
//                }
//                return results;
//            }
//        }
//        return results;
//    }
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> list = new LinkedList<List<Integer>>();
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        if(root == null)
//            return list;
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            int num = queue.size();
//            List<Integer> levelList = new LinkedList<Integer>();
//            for(int i = 0; i < num; i++){
//                if(queue.peek().left != null)
//                    queue.offer(queue.peek().left);
//                if(queue.peek().right != null)
//                    queue.offer(queue.peek().right);
//                levelList.add(queue.poll().val);
//            }
//            list.add(0, levelList);
//        }
//        return list;
//    }
}
