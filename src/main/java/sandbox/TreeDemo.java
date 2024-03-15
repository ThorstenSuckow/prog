package sandbox;

public class TreeDemo {

    private static class Node {
        public int data;
        public Node left;
        public Node right;
        public Node(int data) {
            this.data = data;
        }

        public String toString(){
            return String.valueOf(data);
        }
    }

    private static class SearchTree {
        private Node root;

        public SearchTree(Node root) {
            this.root = root;
        }

        public SearchTree leftTree() {
            return root.left == null ? null : new SearchTree(root.left);
        }


        public SearchTree rightTree() {
            return root.right == null ? null : new SearchTree(root.right);
        }

        public int anzahlBlaetter() {

            return anzahlBlaetter(root);

          /*  if (root.left == null && root.right == null) {
                return 1;
            }

            return (root.left != null ? leftTree().anzahlBlaetter() : 0) +
                    (root.right != null ? rightTree().anzahlBlaetter() : 0);*/
        }

        public int anzahlBlaetter(Node root) {

            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }

            return anzahlBlaetter(root.left) + anzahlBlaetter(root.right);

        }

        public void traverseInorder() {

            if (root.left != null) {
                leftTree().traverseInorder();
            }
            System.out.print(root + "  ");
            if (root.right != null) {
                rightTree().traverseInorder();
            }
        }

        public void traversePreorder() {

            System.out.print(root + "  ");

            if (root.left != null) {
                leftTree().traversePreorder();
            }
            if (root.right != null) {
                rightTree().traversePreorder();
            }
        }

        public void traversePostorder() {

            if (root.left != null) {
                leftTree().traversePostorder();
            }
            if (root.right != null) {
                rightTree().traversePostorder();
            }

            System.out.print(root + "  ");
        }


    }


    public static void main (String... args) {

        Node root = new Node(10);

        root.left = new Node(5);
        root.left.right = new Node(6);
        root.left.left = new Node(4);


        root.right = new Node(11);

        SearchTree tree = new SearchTree(root);

        tree.traverseInorder();
        System.out.println("---");
        tree.traversePreorder();
        System.out.println("---");
        tree.traversePostorder();
        System.out.println("---");
        System.out.println(tree.anzahlBlaetter());

    }

}
