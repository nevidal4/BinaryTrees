import java.io.*;
/**
 * Word class for words found in a file
 * @author Andrews Samuel
 * @version 15/5/17
 */
public class Word implements TreeComparable{
    private String word;
    private int count;
    private ObjectList list;
    PrintWriter pw;
    /**
     * Word constructor
     * @param pw Printwriter object to specify location of output file
     * @param w the String representation of the word object
     * @param line position in which the word is found in a file
     * @param position of the word on the given line
     */
    public Word(PrintWriter pwArg, String w, int line, int position){
        count = 1;
        word = new String(w.trim().toLowerCase().replaceAll("[^a-z]",""));
        list = new ObjectList();
        list.addFirst(new ObjectListNode(new LinePosition(line, position)));
        pw = pwArg;
    }
    /**
     * Increases the number of times a given word is found
     */
    public void increaseCount(){
        ++count;
    }
    /**
     * Decreases the number of times a given word is found
     */
    public void decreaseCount(){
        --count;
    }
    /**
     * Retreives number of times a given word is found
     * @return count number of times this word is found in file
     */
    public int getCount(){
        return count;
    }
    /**
     * Retreives the String representation of the word
     * @return word String of word
     */
    public String getWord(){
        return word;
    }
    /**
     * Compares one word with another lexicographically
     * @param o Word to be compared with this word
     * @return positive number if this word is lexicographically greater than o, 0 if equal, negative if less
     */
    public int compareTo(Object o){
        Word w = (Word)o;
        return word.compareTo(w.getWord());
    }
    /**
     * Visits a word by ouptuting its content to System.out and output file
     */
    public void visit(){
        System.out.printf("\n%-13s%-5d ", word, count);
        pw.printf("\n%-13s%-5d ", word, count);
        ObjectListNode p = list.getFirst();
        LinePosition lp;
        while(p != null){
            lp = (LinePosition)p.getInfo();
            System.out.printf("%d-%d ",lp.getLine(),lp.getPosition());
            pw.printf("%d-%d ",lp.getLine(),lp.getPosition());
            p = p.getNext();
        }
    }
    /**
     * Increases the number of times a word is found in file
     */
    public void operate(Object o){
        Word w = (Word)o;
        ++count;
        list.addLast(w.list.getFirst());
    }
}