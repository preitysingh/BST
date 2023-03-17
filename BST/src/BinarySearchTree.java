public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    public Node<Key, Value> root;

    public BinarySearchTree() { root = null; }

    public int size() {
        return size(root);
    }

    //use Node's recursive size
    private int size(Node x) {
        if (x==null) { //checks if Node x is empty
            return 0; //if yes, x has a size of 0
        } else {
            int s = size(x.getRight()) + size(x.getLeft()) + 1;
            return s; //adds up everything right of x, everything left, and +1 for x
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    //recursive put wrapper
    public void put(Key key, Value value) {
        root = put(root, key, value);

    }

    //recursive put
    //sets left/right or creates a new node appropriately, returns the
    //modified node n
    private Node<Key, Value> put(Node<Key, Value> n, Key key, Value val) {
        if(n == null){ //checks if Node n is empty
            return new Node<>(key,val,1); //makes a new Node object w/ a size of 1
        }
        if(n.getKey().compareTo(key) > 0){ //if the key is pos.
            n.setLeft(put(n.getLeft(),key,val));//set left
        } else if (n.getKey().compareTo(key) < 0) { //if key is neg.
            n.setRight(put(n.getRight(),key,val)); //set right
        } else {
            return n;
        }
        return n; //returns the node put in
    }

    //recursive get wrapper
    public Value get(Key key) {
        return get(root, key);
    }

    //recursive get
    //returns null if the key does not exist
    private Value get(Node<Key, Value> n, Key key) {
        if (n == null) { // if Node n is empty return null
            return null;
        } else if(n.getKey().compareTo(key) == 0) { //if key = 0
            return n.getValue(); //gets the value
        } else if(n.getKey().compareTo(key) > 0) { //if key pos.
            return get(n.getRight(), key); //gets value right of n
        } else if(n.getKey().compareTo(key) < 0) { //if key neg.
            return get(n.getLeft(), key); //gets value left of n
        }
        return null; //returning null otherwise
    }

    public boolean contains(Key key) {
        return this.get(key) != null; //returns true if key is not null
    }

    public Value remove(Key key) {
        Value v = get(key);
        root = remove(root, key);
        return v;
    }

    private Node remove(Node<Key, Value> n, Key key) { //Removes key from BST
        if (n == null) return null; //if Node n is empty, returns null
        int i = key.compareTo(n.getKey()); //int of key value
        if (i < 0) { //if key is neg.
            n.setLeft(remove(n.getLeft(), key)); //removes left of n
        } else if (i > 0) { //if key is pos.
            n.setRight(remove(n.getRight(), key)); //removes right of n
        } else {
            if (n.getRight() == null) return n.getLeft(); //if there is no right, return left
            if (n.getLeft() == null) return n.getRight(); //and vice versa
            Node min = min(n.getRight()); //the absolute right of BST
            min.setLeft(n.getLeft());
            n = n.getRight();
        }
        n.setSize(size(n.getRight()) + size(n.getLeft()) + 1);
        return n;
    }

    public Key min() {
        return min(root).getKey();
    }

    //returns the node at the left most left branch of n
    private Node<Key, Value> min(Node<Key, Value> n) {
        if(n.getLeft() == null) { //if there is nothing left of n
            return n; //n is the min
        } else {
            return min(n.getLeft()); //recursive loop to get most left(min)
        }
    }

    public Key max() {
        return max(root).getKey();
    }

    //returns the node at the right most right branch of n
    private Node<Key, Value> max(Node<Key, Value> n) {
        if(n.getRight() == null) { //if there is nothing right of n
            return n; //n is the max
        } else {
            return max(n.getRight()); //recursive loop to get most right(max)
        }
    }

    public String toString() {
        String temp = toString(root);
        temp = temp.substring(0, temp.length() - 2);
        return "{" + temp + "}";
    }

    private String toString(Node<Key, Value> n) {
        if (n == null) return "";
        return toString(n.getLeft()) +
                n.getKey() + "=" + n.getValue() + ", " +
                toString(n.getRight());

    }
}