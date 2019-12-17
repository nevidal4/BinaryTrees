/**
 * Class for representing the position of a word in a file
 * @author Andrews Samuel
 * @version 15/5/17
 */
public class LinePosition implements Comparable{
    private int line;
    private int position;
    /**
     * Constructor
     * @param l line word is found
     * @param p position of word in line
     */
    public LinePosition(int l, int p){
        line = l;
        position = p;
    }
    /**
     * Retreives line word is found
     * @return word line number
     */
    public int getLine(){
        return line;
    }
    /**
     * Retreives position in line word is found
     * @return word position in line
     */
    public int getPosition(){
        return position;
    }
    /**
     * Compares one line position with another to determine which word appears first in a file
     * @param o Line position to be compared with this line position
     */
    public int compareTo(Object o){
        LinePosition lp = (LinePosition)o;
        if(line < lp.line)
            return 1;
        else if(line > lp.line)
            return -1;
        else{
            if(position < lp.position)
                return 1;
            else
                return -1;
        }
    }
}