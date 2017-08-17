package union;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("G:\\d.txt","rw");
        FileChannel channel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {
            int bytesRead = channel.read(byteBuffer);
            System.out.println(bytesRead);
            while(bytesRead != -1)
            {
                byteBuffer.flip();
                while(byteBuffer.hasRemaining())
                {
                    System.out.print((char)byteBuffer.get());
                }

                byteBuffer.compact();
                bytesRead = channel.read(byteBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            channel.close();
            byteBuffer.clear();
            file.close();
        }

    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root.left == null && root.right == null)
            return root.val == sum;
        return hasPathSum(root.left,sum - root.left.val) || hasPathSum(root.right,sum - root.right.val) ;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);

    }

    public int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if(root.left != null || root.right != null){
            sum += sumOfLeftLeaves(root.left, true);
            sum += sumOfLeftLeaves(root.right, false);
        }
        else if(isLeft) {
            sum += root.val;
        }

        return sum;
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null)
            return res;
        if(root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }
        List<String> leftS = binaryTreePaths(root.left);
        for (int i = 0; i < leftS.size(); i++) {
            res.add(String.valueOf(root.val) + "->" + leftS.get(i));
        }
        List<String> rightS = binaryTreePaths(root.right);
        for (int i = 0; i < rightS.size(); i++) {
            res.add(String.valueOf(root.val) + "->" + rightS.get(i));
        }
        return res;
    }
//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        List<List<Integer>> tmp = new ArrayList<>();
//        return res;
//    }
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return findPath(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }

    private int findPath(TreeNode root, int sum) {
        int res = 0;
        if(root == null)
            return 0;
        if(root.val == sum)
            res += 1;
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(p.val < root.val && q.val < root.val )
            return lowestCommonAncestor(root.left,p,q);
        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right,p,q);
        return root;
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
