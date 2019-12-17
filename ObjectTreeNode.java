/**
 * Class for tree nodes of an ObjectTree
 * @author Andrews Samuel
 * version 15/5/17
 */
public class ObjectTreeNode implements ObjectTreeNodeInterface {
    private Object info;
    private ObjectTreeNode left;
    private ObjectTreeNode right;
    /**
     * Default ObjectTreeNode constructor
     */
    public ObjectTreeNode() {
        info = null;
        left = null;
        right = null;
    }
    /**
     * Tree node constructor containing an object o
     * @param object o starting tree contents
     */
    public ObjectTreeNode (Object o) {
        info = o;
        left = null;
        right = null;
    }
    /**
     * Sets contents of tree node to object o
     * @param object contents to be placed in treenode
     */
    public void setInfo(Object o) {
        info = o;
    }
    /**
     * Retreives object contained in tree node
     * @return object contained in tree node
     */
    public Object getInfo() {
        return info;
    }
    /**
     * Sets left child of tree node
     * @param Tree node to be set as left child
     */
    public void setLeft(ObjectTreeNode p) {
        left = p;
    }
    /**
     * Retreives the left child to tree node
     * @return left child of tree node
     */
    public ObjectTreeNode getLeft() {
        return left;
    }
    /**
     * Sets right child of tree node
     * @param Tree node to be set as right child
     */
    public void setRight(ObjectTreeNode p) {
        right = p;
    }
    /**
     * Retreives the right child to tree node
     * @return right child of tree node
     */
    public ObjectTreeNode getRight() {
        return right;
    }
}
