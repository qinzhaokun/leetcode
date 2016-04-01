/*
Implement a trie with insert, search, and startsWith methods.
*/


class TrieNode {
    // Initialize your data structure here.
    TrieNode [] arr = new TrieNode [26];
    boolean isEdge;
    public TrieNode() {
        
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0;i < word.length();i++){
            if(cur.arr[word.charAt(i)-'a'] == null){cur.arr[word.charAt(i)-'a'] = new TrieNode();}
            cur = cur.arr[word.charAt(i)-'a'];
        }
        cur.isEdge = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0;i < word.length();i++){
            if(cur.arr[word.charAt(i)-'a'] == null) return false;
            cur = cur.arr[word.charAt(i)-'a'];
        }
        return cur.isEdge;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0;i < prefix.length();i++){
            if(cur.arr[prefix.charAt(i)-'a'] == null) return false;
            cur = cur.arr[prefix.charAt(i)-'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
