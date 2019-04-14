import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Trie {

    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // insert the characters from the string one by one
    public void insert(String word) {
        // this line is for getting the TrieNode
        HashMap<Character, TrieNode> children = root.children;

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode t;
            if(children.containsKey(ch)) {
                t = children.get(ch);
            }else { //  if the character does not exists
                t = new TrieNode(ch);
                children.put(ch, t);
            }

            children  = t.children;
            if(i == word.length() - 1) {
                t.isEnd = true;
            }
        }
    }

    public boolean search(String word) {
        TrieNode t = searchNode(word);

        if(t != null && t.isEnd) {
            return true;
        }
        return  false;
    }

    public TrieNode searchNode(String word) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            }else {
                return null;
            }
        }
        return t;
    }

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    public void BSTIterator(TreeNode root) {
        inOrder(root);
    }



    public void inOrder(TreeNode root) {
        if(root != null) {
            queue.add(root.data);
            inOrder(root.leftChild);
            inOrder(root.rightChild);
        }
    }

    public int next() {
        return queue.remove();
    }

    public boolean hasNext() {
        return queue.size() != 0;
    }

    public void nextPermutation(int[] nums) {
        int index = -1;
        for(int i = nums.length - 1; i >= 1; i--) {
            if(nums[i - 1] >= nums[i]) {
                index = i - 1;
            }
        }
        if(index >= 0) {
            int j = nums.length - 1;
            while(j >= 0 && nums[index] >= nums[j]) {
                j--;
            }
            swap(nums, index, j);
        }
        reverse(nums, index + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    public static void main(String[] args) {
        Trie ts = new Trie();
        //ts.insert("Biplab");
        //ts.search("Biplab");

        TreeNode t = new TreeNode(7);
        t.leftChild = new TreeNode(3);
        t.rightChild = new TreeNode(15);
        t.rightChild.leftChild = new TreeNode(9);
        t.rightChild.rightChild = new TreeNode(20);

        int[] nums = {1,2,3};
        ts.nextPermutation(nums);
    }

}
