import java.util.Scanner;
import java.io.*;
/**
 * Class for listing words found in a file, and their position numbers
 * @author Andrews Samuel
 * @version 15/5/17
 */
public class CrossReference{
    private ObjectBinaryTree bt;
    private HashTable ht;
    private PrintWriter pw;
    /**
     * Constructor
     * @param pwArg PrintWriter object for specifying destination of ouput file
     * @param htArg HashTable of words to be omitted
     */
    public CrossReference(PrintWriter pwArg, HashTable htArg){
        bt = new ObjectBinaryTree();
        pw = pwArg;
        ht = htArg;
    }
    /**
     * Reads a file for words to be stored in a binary tree and crossreferenced
     * @param fp file pointer from which words are to be processed
     */
    public void inputFile(File fp) throws IOException{
        int line = 0, position = 0;
        Scanner in = new Scanner(fp);   
        String token[], word, lineString;
        for(line = 1; in.hasNext(); ++line){
            lineString = in.nextLine();
            System.out.printf("\n%-3d %s", line, lineString);
            pw.printf("\n%-3d %s", line, lineString);
            token = lineString.split("[^a-zA-Z]+");
            for(position = 1; position <= token.length; ++position){
                word = token[position - 1].toLowerCase();
                if(!ht.contains(word))
                    bt.insertBSTDup(new Word(pw, token[position - 1].toLowerCase(), line, position));
            }
        }
    }
    /**
     * Performs a search for a spacific word
     * @param String representation of word to be searched for
     * @return the sought after word
     */
    public Word search(String s){
        Word w = new Word(pw,s,0,0);
        w.decreaseCount();
        if(bt.searchBST(w) == null)
            return w;
        return (Word)bt.searchBST(w).getInfo();
    }
    /**
     * Outputs the words alphabetically by performing an inOrder traversal on the tree to which they were stored
     */
    public void outputWords(){
        bt.inTrav(bt.getRoot());
    }
    /**
     * Outputs the header for crossreferenced words before they are displayed
     */
    public void outputHeader(){
        System.out.printf("\n%-13s%-6s Line-Position\n%s","Word","Count",
                            "---------------------------------");
        pw.printf("\n%-13s%-6s Line-Position\n%s","Word","Count",
                            "---------------------------------");
    }
}