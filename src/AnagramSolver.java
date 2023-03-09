/* CS 314 STUDENTS: FILL IN THIS HEADER.
 *
 * Student information for assignment:
 *
 *  On my honor, <NAME>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID:
 *  email address:
 *  TA name:
 *  Number of slip days I am using:
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class AnagramSolver {

    private HashMap<String, LetterInventory> dictionaryMap;

    /*
     * pre: list != null
     * @param list Contains the words to form anagrams from.
     */
    public AnagramSolver(Set<String> dictionary) {
        // CS314 Students, add your code here
        dictionaryMap = new HashMap<>();
        for(String word : dictionary){
            LetterInventory inventory = new LetterInventory(word);
            dictionaryMap.put(word, inventory);
        }
    }

    /*
     * pre: maxWords >= 0, s != null, s contains at least one
     * English letter.
     * Return a list of anagrams that can be formed from s with
     * no more than maxWords, unless maxWords is 0 in which case
     * there is no limit on the number of words in the anagram
     */
    public List<List<String>> getAnagrams(String s, int maxWords) {
        // ADD PRE CONDITION AND THROW ILLEGAL ARGUMENT EXCEPTION IF !NOT

        ArrayList<List<String>> result = new ArrayList<>();
        LetterInventory tgt = new LetterInventory(s);
        ArrayList<String> curWords = new ArrayList<>();

        doRecursiveAnagramSolver(0, tgt, maxWords, curWords, result); //add index later
        return result;
    }

    public void doRecursiveAnagramSolver(int index,LetterInventory tgt, int maxWords, List<String> curWords,
                                         List<List<String>> result){
        if(tgt.isEmpty()){
            result.add(new ArrayList<>(curWords));
        }else if(maxWords == 0 || curWords.size() <= maxWords){
            List<String> keys = new ArrayList<>(dictionaryMap.keySet());
            for(int i = index; i < keys.size(); i++){
                String word = keys.get(i);
                LetterInventory wordInv = dictionaryMap.get(word);
                if(tgt.subtract(wordInv) != null){
                    curWords.add(word);
                    doRecursiveAnagramSolver(i, tgt.subtract(wordInv), maxWords, curWords, result);
                    curWords.remove(curWords.size() - 1);
                }
            }
        }
    }
}
