
/**
 * BinearySearchTree. Represent a binary search tree
 * The student cannot change the public interface
 * 
 * @author Your Name
 * @version Date Starts
 */
public class BinarySearchTree<E extends Comparable<E>>
{
    TreeNode<E> root; // the root of the tree
    
    /**
     * constructor create a empty binary search tree by setting root to be null
     */
    public BinarySearchTree(){ 
        this.root = null;
    }
    
    /**
     * search the given data in this binary search tree
     * If the data is found, return a reference to the tree node
     * othewise, return null
     * @param data The target to search
     * @return a TreeNode reference to the node that contains the data
     *         if no node contains data, return null
     */
    public TreeNode<E> search(E data){
        TreeNode<E> test = new TreeNode<E>();
        return test;
        
    }
    public TreeNode<E> successor(TreeNode<E> node) {
        if(node.getRight() == null){
            while(node.getParent() != null){
                if(node.isLeftChild()){
                    return node.getParent();
                }
                else {
                    node = node.getParent();
                }
            }
            return null;
        }
        else {
            node = node.getRight();
            while(node.getLeft() != null){
                node = node.getLeft();
            }
            return node;
        }
    }
    
    /**
     * insert given node to this binary search tree. If this tree 
     * was empty, the given node becomes the root of this tree.
     * @param newNode the given node to be inserted
     */
    public void insert(TreeNode<E> newNode){
        insert(newNode.getData());
    }
    
    /**
     * insert given data to this binary search tree. If this tree 
     * was empty, the given node becomes the root of this tree.
     * @param data the given data to be inserted
     */
    public void insert(E data){
        TreeNode<E> insertNode = new TreeNode<E> (data);
        if (root == null){
            root = insertNode;
            return;
        }
        TreeNode<E> insertAfter= root;
        while(insertAfter != null) {
            if(insertAfter.getData().compareTo(data) < 0){
                if(insertAfter.getRight() == null){
                    insertAfter.setRight(insertNode);
                    insertNode.setParent(insertAfter);
                    return;
                }
                else {
                    insertAfter = insertAfter.getRight();
                }
            }
            else {
                if(insertAfter.getLeft() == null){
                    insertAfter.setLeft(insertNode);
                    insertNode.setParent(insertAfter);
                    return;
                }
                else {
                    insertAfter = insertAfter.getLeft();
                }
            }
        }
    }
    
    /**
     * remove the given data from this binary search tree and return
     * true. If the data is not in the tree, return false
     */
    public boolean remove(E data){
        TreeNode<E> nodeToRemove = search(data);
        if (nodeToRemove == null) {
            return false;
        }
        return remove(nodeToRemove);

    }
    private boolean remove(TreeNode<E> nodeToRemove){
        if(nodeToRemove.isLeaf()) {
            if(nodeToRemove.isRoot()){
                root = null;
                return true;
            }
            if(nodeToRemove.isLeftChild()){
                nodeToRemove.getParent().setLeft(null);
            }
            else{
                nodeToRemove.getParent().setRight(null);
            }
            nodeToRemove.setParent(null);
        }
        else if(nodeToRemove.getLeft() == null) {
            nodeToRemove.getRight().setParent(nodeToRemove.getParent());
            if(nodeToRemove.isRoot()) {
                root = nodeToRemove.getRight();
            }
            else if (nodeToRemove.isLeftChild()) {
                nodeToRemove.getParent().setLeft(nodeToRemove.getRight());
            }
            else{
                nodeToRemove.getParent().setRight(nodeToRemove.getRight());
            }
            nodeToRemove.setParent(null);
            nodeToRemove.setRight(null);
        }
        else {
            TreeNode<E> succ = successor(nodeToRemove);
            nodeToRemove.setData(succ.getData());
            return remove(succ);
        }
        return true;
    }
    
    /**
     * return a string representation of the tree
     * @return a String representation of the tree
     */
    public String toString(){
        return "(" + toString(root) + ")";
    }
    
    private String toString(TreeNode<E> node) {
        if (node == null){
            return "_";
        }
        return node.getData() + "(" + toString(node.getLeft()) + ", " + toString(node.getRight()) + ")";
    }
    
    /**
     * return true if the tree is empty. False otherwise
     * @return true if the tree is empty; false othewise
     */
    public boolean isEmpty(){
        return this.root == null;
    }
    
    /**
     * return the height of the tree. Notice the height is defined as
     * the length of the longest path from nodes to root
     * @return the height of the tree
     */
    public int height(){
        return height(root);
    }
    
    private int height(TreeNode<E> node) {
        if(node == null || node.isLeaf()) {
            return 0;
        }
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }
    
    /**
     * return the number of nodes in the tree
     * @return the number of nodes in this tree
     */
    public int size(){
        return size(root);
    }
    
    private int size(TreeNode<E> node) {
        if (node == null){
            return 0;
        }
        return size(node.getRight()) + size(node.getLeft()) + 1;
    }
}
