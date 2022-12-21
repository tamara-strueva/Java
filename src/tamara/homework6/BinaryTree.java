package tamara.homework6;

public class BinaryTree {

    static class Node {
        int key;
        Node leftBranch;
        Node rightBranch;


        Node (int key) {
            this.key = key;
        }
    }

    int value; // корень дерева
    BinaryTree leftBranch; // левая ветка
    BinaryTree rightBranch; // правая ветка

    public BinaryTree(int value, BinaryTree leftBranch, BinaryTree rightBranch) {
        this.value = value;
        this.leftBranch = leftBranch;
        this.rightBranch = rightBranch;
    }
}
