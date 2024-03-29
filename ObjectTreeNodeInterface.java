/**
 * Interface class for ObjectListNode class, see ObjectListNode class for method descriptions
 * @author Andrews Samuel
 * @version 23/4/17
 */
public interface ObjectTreeNodeInterface{  
    public void setInfo(Object o);
    public Object getInfo();
    public void setLeft(ObjectTreeNode p);
    public ObjectTreeNode getLeft();
    public void setRight(ObjectTreeNode p);
    public ObjectTreeNode getRight();
}