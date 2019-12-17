import java.util.Scanner;
import java.io.*;
/**
 * Class for a hash table to store String objects
 * @author Andrews Samuel
 * @version 15/5/17
 */
public class HashTable{
    final static int TABLESIZE = 37;
    private String[] table;
    PrintWriter pw;
    int maxCollisions;
    /**
     * Constructor for hash table
     * @param pwArg PrintWriter object to specify output destination
     */
    public HashTable(PrintWriter pwArg){
        table = new String[TABLESIZE];
        pw = pwArg;
        maxCollisions = 0;
    }
    /**
     * Function containing hash function
     * @param key hash function domain
     * @return hash function range
     */
    private int function(String key){
        int sum, i, primes[] = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103};
        for(i = 0, sum = 0; i < key.length(); ++i)
            sum += key.charAt(i);
        return primes[sum % primes.length] % TABLESIZE;
    }
    /**
     * Shows the function used for this hash table class
     */
    public void showFunction(){
         System.out.print("\nHash Function:\nh(key) = first27primes[charSum(key) MOD 27] MOD TABLESIZE\n");
         pw.print("\nHash Function:\nh(key) = first27primes[charSum(key) MOD 27] MOD TABLESIZE\n");
    }
    /**
     * Inputs file of words to be placed in hash table
     * @param fp file pointer to file containing words to be placed in hash table
     */
    public void buildTable(File fp) throws IOException{
        Scanner in = new Scanner(fp);
        while(in.hasNext()){
            String s = in.nextLine();
            table[probe(s)] = s.toLowerCase();
        }
    }
    /**
     * Performs a linear probe to find a vacant spot on a hash table and counts the number of occuring collisions
     * @param key domain of hash function
     * @return the index for vacant slot
     */
    private int probe(String key){
        String s = key.toLowerCase();
        int i, collisions, target = function(s);
        for(i = target, collisions = 0; table[i] != null && !s.equals(table[i]) && i != target - 1; ++i, ++collisions){
            if(i == TABLESIZE - 1)
                i = -1;
        }
        if(collisions > maxCollisions)
            maxCollisions = collisions;
        return i;
    }
    /**
     * Returns the location index of a certain key within the hash table
     * @param key String sought after
     * @return index location of String in hash table
     */
    public int location(String key){
        int i = probe(key);
        if(table[i] != null)
            return i;
        return -1;
    }
    /**
     * Determines whether or not String key appears in hash table
     * @param key sought after to deterimine if it appears in table
     * @return true if String can be found in hash table, false otherwise
     */
    public boolean contains(String key){
        if(location(key) == -1)
            return false;
        return true;
    }
    /**
     * Output all Strings found in hash table
     */
    public void outputTable(){
        for(int i = 0; i < TABLESIZE; ++i){
            if(table[i] == null){
                System.out.print("\n<EMPTY_SLOT>");
                pw.print("\n<EMPTY_SLOT>");
            }
            else{
                System.out.printf("\n%s", table[i]);
                pw.printf("\n%s", table[i]);
            }
        }
        System.out.printf("\n\nCollisions: %d -After 6 solid hours of trying anything, I gave up.\n", maxCollisions);
        pw.printf("\n\nCollisions: %d -After 6 solid hours of trying anything, I gave up.\n", maxCollisions);
    }
}