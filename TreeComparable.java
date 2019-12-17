/**
 * Interface class for TreeComparable class and Word class. See Word class for method descriptions
 * @author Andrews Samuel
 * @version 23/4/17
 */
public interface TreeComparable{
    public int compareTo(Object o);
    public void operate(Object o);
    public void visit();
}