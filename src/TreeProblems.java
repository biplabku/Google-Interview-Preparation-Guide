import com.sun.source.tree.Tree;

public class TreeProblems {

    public TreeNode buildTree(int[] preorder, int [] inorder) {
        TreeNode root = addNode(preorder, 0, preorder.length - 1, inorder,
                0, inorder.length - 1);
        System.out.println(" Height of the tree is  -- > " + treeHeight(root));
        TreeNode t = greaterTree(root, 0);
        inOrder(t);
        return root;
    }

    public TreeNode greaterTree(TreeNode root, int sum) {
        if(root != null) {
            greaterTree(root.rightChild, sum);
            sum += root.data;
            root.data = sum;
            greaterTree(root.leftChild, sum);
        }
        return root;
    }


    public int treeHeight(TreeNode root) {
        if(root == null) {
            return -1;
        }
        int left = 1 + treeHeight(root.leftChild);
        int right = 1 + treeHeight(root.rightChild);
        return Math.max(left, right);
    }

    public void inOrder(TreeNode root) {
        if(root != null) {
            inOrder(root.leftChild);
            System.out.println(root.data);
            inOrder(root.rightChild);
        }
    }


    public boolean isUnivalued(TreeNode root) {
        boolean left = (root.leftChild == null || (root.data == root.leftChild.data
        && isUnivalued(root.leftChild)));
        boolean right = (root.rightChild == null || (root.data == root.rightChild.data
        && isUnivalued(root.rightChild)));

        return left && right;
    }


    public TreeNode addNode(int[] preorder, int prestart, int preend, int[]
            inorder, int instart, int inend) {
        if(prestart > preend) {
            return  null;
        }
        if(prestart == preend) {
            return new TreeNode(preorder[prestart]);
        }
        int idx = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[prestart]) {
                idx = i;
                break;
            }
        }
        TreeNode root = new TreeNode(inorder[idx]);
        root.leftChild = addNode(preorder, prestart + 1,
                idx - instart + prestart, inorder, instart, idx - 1);
        root.rightChild = addNode(preorder, idx - instart + prestart + 1, preend,
                inorder, idx + 1, inend);
        return root;
    }

    public int sum = 0;
    public int findTilt(TreeNode root) {
        getTilt(root);
        return sum;
    }

    public int getTilt(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = getTilt(root.leftChild);
        int right = getTilt(root.rightChild);

        sum += Math.abs(left - right);
        return left + right + root.data;
    }

    int depth = Integer.MAX_VALUE;
    public int minimumDepth(TreeNode root) {
        minDepth(root);
        return depth;
    }
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = 1 + minimumDepth(root.leftChild);
        int right = 1 + minimumDepth(root.rightChild);
        if(left == 1) {
            return right;
        }else if(right == 1) {
            return left;
        }
        depth = Math.min(left, right);
        return depth;
    }


    public int fibonacci(int number) {
        if(number == 0 || number == 1) {
            return 1;
        }
        return number * fibonacci(number - 1);
    }

    public int result = 0;
    public int evaluateBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.leftChild == null && root.rightChild != null) {
            return root.data;
        }
        int left = evaluateBinaryTree(root.leftChild);
        int right = evaluateBinaryTree(root.rightChild);
        if(root.data == '+') {
            result = left + right;
        }else if(root.data == '-') {
            result = left - right;
        }else if(root.data == '*') {
            result = left * right;
        }else if(root.data == '/') {
            result = left/ right;
        }
        return result;

    }


    public boolean isSymmetric(TreeNode root) {
        return checkSymetric(root, root);
    }

    public boolean checkSymetric(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        boolean left = checkSymetric(root1.leftChild, root2.rightChild);
        boolean right = checkSymetric(root1.rightChild, root2.leftChild);
        return (root1.data == root2.data) && left && right;
    }

    public boolean checkSameTree(TreeNode root1, TreeNode root2) {
        return isSameTree(root1, root2);
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if((root1 == null && root2 != null) || (root1 != null && root2 == null) ) {
            return false;
        }

        boolean left = isSameTree(root1.leftChild, root2.leftChild);
        boolean right = isSameTree(root1.rightChild, root2.rightChild);
        boolean value = root1.data == root2.data;

        return value && left && right;
    }








































    public static void main(String[] args) {
        int[] arr = {3,9,20,15,7};
        int[] arr2 = {9,3,15,20,7};
        TreeProblems ts = new TreeProblems();
        System.out.println(ts.fibonacci(3));
    }
}