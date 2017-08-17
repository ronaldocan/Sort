package search;

/**
 * Created by Administrator on 2017/6/4.
 */
// 二分搜索树
// 由于Key需要能够进行比较，所以需要extends Comparable<Key>
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;  // 根节点
    private int count;  // 树种的节点个数

    public BST() {
        root = null;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    // 树中的节点为私有的类, 外界不需要了解二分搜索树节点的具体实现
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
        // 构造函数, 默认构造一棵空二分搜索树


    }

    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    public boolean contain(Key key) {
        return contain(root, key);
    }

    private boolean contain(Node node, Key key) {
        if (node == null)
            return false;

        if (key.compareTo(node.key) == 0)
            return true;
        else if (key.compareTo(node.key) < 0)
            return contain(node.left, key);
        else // key > node->key
            return contain(node.right, key);

    }

    private Node insert(Node node, Key key, Value value) {
        if (node == null) {
            Node tmp = new Node(key, value);
            return tmp;
        }
        if (key.compareTo(node.key) == 0)
            node.value = value;
        else if (key.compareTo(node.key) < 0)
            node.left = insert(node.left, key, value);
        else    // key > node->key
            node.right = insert(node.right, key, value);
        return node;
    }

    public void removeMin() {
        if (root != null) {
            removeMin(root);
        }
    }

    private Node removeMin(Node node) {
        if(node.left == null)
        {
            Node rightNode = node.right;
            count--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
    public void removeMax() {
        if (root != null) {
            removeMax(root);
        }
    }

    private Node removeMax(Node node) {
        if(node.left == null)
        {
            Node leftNode = node.left;
            count--;
            return leftNode;
        }
        node.right = removeMin(node.right);
        return node;
    }

    public Key minimun() {
        root = minimum(root);
        return root.key;
    }
    private Node minimum(Node node) {
        if (node.left != null) {
            return minimum(node.left);
        }else
            return node;
    }
    public Key maxmun() {
        root = maxmun(root);
        return root.key;
    }
    private Node maxmun(Node node) {
        if (node.right != null) {
            return maxmun(node.left);
        }else
            return node;
    }

    public void remove(Key key) {
        root = remove(root, key);
    }

    private Node remove(Node node, Key key) {
        if(node == null)
            return null;
        if (node.key.compareTo(key) > 0) {
            node.left = remove(node.left,key);
            return node;
        }
        if(node.key.compareTo(key) < 0){
            node.right = remove(node.right,key);
            return node;
        }
        else{
            if(node.left == null){
                Node right = node.right;
                count --;
                return right;
            }else if(node.right == null){
                Node left = node.left;
                count --;
                return left;
            }else { 
//                Node successor2 = maxmun(node.left);
//                count ++;
//                successor2.left = removeMax(node.left);
//                successor2.right = node.right;
//                count --;
//                return successor2
                Node successor = minimum(node.right);
                count ++;
                successor.right = removeMin(node.right);
                successor.left = node.left;
                count --;
                return successor;
            }
        }


    }
}