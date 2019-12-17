import java.util.Scanner;
import java.io.*;
/**
 * Driver for word search lab
 * @author Andrews Samuel
 * @version 15/5/17
 */
public class Query{
    /**
     * Main method for implementing the word search and query
     */
    public static void main(String[] args)throws IOException{
        File hashWords, getty;
        PrintWriter pw = new PrintWriter("csis.txt");
        hashWords = new File("hashWords.txt");
        getty = new File("getty.txt");
        HashTable ht = new HashTable(pw);
        ht.buildTable(hashWords);
        CrossReference xr = new CrossReference(pw, ht);
        System.out.print("File read:\n");
        pw.print("File read:\n");
        xr.inputFile(getty);
        System.out.print("\n\nList of words:\n");
        pw.print("\n\nList of words:\n");
        xr.outputHeader();
        xr.outputWords();
        System.out.print("\n\nWord Search:\n");
        pw.print("\n\nWord Search:\n");
        String[] sa = {"dedicate","devotion","gave","people","soldier","us","vain","war"};
        for(int i = 0; i < sa.length; ++i)
            xr.search(sa[i]).visit();
        System.out.print("\n\nHash Table:\n");
        pw.print("\n\nHash Table:\n");
        ht.outputTable();
        ht.showFunction();
        pw.close();
    }
}