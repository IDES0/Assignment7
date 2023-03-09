public class LetterInventory {

    private static final int ALPHABET_SIZE = 26;
    int[] wordNum = new int[ALPHABET_SIZE];
    int sizeList;

    public LetterInventory(String word){
        if(word == null){
            throw new IllegalArgumentException("Illegal Value: Word must not be null");
        }
        //sends word toLowerCase
        word = word.toLowerCase();
        //adds num of instances of a letter to the int array wordNum
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z'){
                wordNum[word.charAt(i)-'a']++;
                sizeList++;
            }
        }
    }

    //gets and returns num instances of letter in LetterInventory
    public int get(char letter){
        if(letter >= 'a' && letter <= 'z'){return wordNum[letter-'a'];}
        if(letter >= 'A' && letter <= 'Z'){return wordNum[letter-'A'];}
        throw new IllegalArgumentException("Invalid Value: character is not english letter");
    }

    public int size(){
        return sizeList;
    }

    public boolean isEmpty(){
        return (sizeList == 0);
    }

    //ToString method to print letterinventory in alphabetical order
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < wordNum.length; i++){
            str.append(String.valueOf((char) (i + 'a')).repeat(Math.max(0, wordNum[i])));
        }
        return str.toString();
    }

    //adds all values in the int array together, and then adds sizes together and returns result.
    public LetterInventory add(LetterInventory other){
        if(other == null){
            throw new IllegalArgumentException("Invalid Parameter: parameter must not be null");
        }
        LetterInventory result = new LetterInventory("");
        result.sizeList = this.sizeList + other.sizeList;
        for(int i = 0; i < ALPHABET_SIZE; i++){
            result.wordNum[i] = this.wordNum[i] + other.wordNum[i];
        }
        return result;
    }

    public LetterInventory subtract(LetterInventory other){
        LetterInventory result = new LetterInventory("");
        if(other == null){
            throw new IllegalArgumentException("Invalid Parameter: parameter must not be null");
        }
        result.sizeList = this.sizeList - other.sizeList;
        for(int i = 0; i < ALPHABET_SIZE; i++){
            result.wordNum[i] = this.wordNum[i] - other.wordNum[i];
            if (result.wordNum[i] < 0) {
                return null;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object other){
        if (!(other instanceof LetterInventory)) {return false;}

        LetterInventory otherInv = (LetterInventory) other;

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (this.wordNum[i] != otherInv.wordNum[i]) {
                return false;
            }
        }

        return true;
    }



}
