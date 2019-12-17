/**
 * Class for a binary tree
 * @author Andrews Samuel
 * @version 15/5/17
 */
public class ObjectBinaryTree implements ObjectBinaryTreeInterface{
    private ObjectTreeNode root;
    /**
     * Default constructor
     */
    public ObjectBinaryTree() {
        root = null;
    }
    /**
     * Retreives the root of the tree
     * @return tree root
     */
    public ObjectTreeNode getRoot() {
        return root;
    }
    /**
     * Sets a tree node as the left child of this tree node
     * @param parent tree node
     * @param r tree node to be set as left child to parent
     */
    public void setLeftChild(ObjectTreeNode parent, ObjectTreeNode r) {
        if (parent == null || parent.getLeft() != null) {
            System.out.println("Runtime Error: setLeftChild()");
            System.exit(1);
        }
        parent.setLeft(r);
    }
    /**
     * Sets a tree node as the right child of this tree node
     * @param parent tree node
     * @param r tree node to be set as right child to parent
     */
    public void setRightChild(ObjectTreeNode parent, ObjectTreeNode r){
        if (parent == null || parent.getRight() != null) {
            System.out.println("Runtime Error: setRightChild()");
            System.exit(1);
        }
        parent.setRight(r);
    }
    /**
     * Inserts an object o into its proper place on the tree
     * @param Object o to be placed in place on the tree respective of object higherarchy (see Compare.CompareTo())
     */
    public void insertBST(Object o) {
        ObjectTreeNode p, q;           
        ObjectTreeNode r = new ObjectTreeNode(o);
        if (root == null)
            root = r;
        else {
            p = root;
            q = root;
            while (q != null) {
                p = q;
                if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0 )
                    q = p.getLeft();
                else
                    q = p.getRight();
            }
            if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                setLeftChild(p, r);
            else
                setRightChild(p, r);
        }
    }
    /**
     * Inserts an object o onto its proper place on the tree, and takes appropriate action when duplicates are found
     * (see Compare.operate())
     * @param object o to be placed in its proper place on the tree
     */
    public void insertBSTDup(Object o) {
        ObjectTreeNode p, q;           
        ObjectTreeNode r = new ObjectTreeNode(o);
        if (root == null)
            root = r;
        else {
            p = root;
            q = root;
            while (q != null && ((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) != 0) {
                p = q;
                if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                    q = p.getLeft();
                else
                    q = p.getRight();
            }
            if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                setLeftChild(p, r);
            else if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) > 0)
                setRightChild(p, r);
            else ((TreeComparable)(p.getInfo())).operate((TreeComparable)(r.getInfo()));
        }
    }
    /**
     * Searches tree for object o
     * @param object sought after
     * @return tree node containing desired object
     */
    public ObjectTreeNode searchBST(Object o) {
        ObjectTreeNode p;
        ObjectTreeNode r = new ObjectTreeNode(o);
        if(root != null) {
            p = root;
            while (p != null) {
                if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                    p = p.getLeft();
                else if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) > 0)
                    p = p.getRight();
                else 
                    return p;
            }
        }
        return null;
    }
    /**
     * Visits (see TreeComparable) each node in preOrder fashion
     * @param parent node to be traversed from in preOrder
     */
    public void preTrav(ObjectTreeNode tree) {
        if (tree != null) {
            ((TreeComparable)tree.getInfo()).visit();
            preTrav(tree.getLeft());
            preTrav(tree.getRight());
        }
    }
    /**
     * Visits (see TreeComparable) each node in inOrder fashion
     * @param parent node to be traversed from in inOrder
     */
    public void inTrav(ObjectTreeNode tree) {
        if (tree != null) {
            inTrav(tree.getLeft());
            ((TreeComparable)tree.getInfo()).visit();
            inTrav(tree.getRight());
        }
    }
    /**
     * Visits (see TreeComparable) each node in postOrder fashion
     * @param parent node to be traversed from in postOrder
     */
    public void postTrav(ObjectTreeNode tree) {
        if (tree != null) {
            postTrav(tree.getLeft());
            postTrav(tree.getRight());
            ((TreeComparable)tree.getInfo()).visit();
        }
    }
    /**
     * Finds and removes Object o from tree if found and replaces it with its inOrder successor
     * @param Object to be found and removed from tree
     */
    public void delete(Object o) {
        ObjectTreeNode s, t, v;
        boolean found = false;
        ObjectTreeNode r = new ObjectTreeNode(o);
        ObjectTreeNode p = root;
        ObjectTreeNode q = null;
        // Search for the node with info key, set p to point to 
        //   that node and set q to point to its parent, if any.
        while (p != null && !found) {
            if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) == 0)
                found = true;
            else {
                q = p;
                if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                    p = p.getLeft();
                else
                    p = p.getRight();
            }
        }
        if (found) {
            // Set v to point to the node that will replace the node 
            // that p points to.
            if (p.getLeft() == null)
                v = p.getRight();
            else if (p.getRight() == null)
                v = p.getLeft();
            else {
                // the node that p points to has two children;
                // set v to the inorder successor of p;
                // set t to the parent of v
                t = p;
                v = p.getRight();
                s = v.getLeft();  // s is the left child of v
                while (s != null) {
                    t = v;
                    v = s;
                    s = v.getLeft();
                }
                // At this point, v is the inorder successor of p
                if (t != p) {
                    // p is not the parent of v and v = t.getLeft()
                    t.setLeft(v.getRight());
                    // Remove the node that v points to from its
                    // current position to take the place of the 
                    // node that p points to.
                    v.setRight(p.getRight());
                }
                v.setLeft(p.getLeft());
            }
            // Insert the node that v points to into the position
            // formally occupied by the node that p points to
            if (q == null)
                // The node that p points to was the root of the tree
                root = v;
            else if (p == q.getLeft())
                q.setLeft(v);
            else q.setRight(v);
        }
    }
}