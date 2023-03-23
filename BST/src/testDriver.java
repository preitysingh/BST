//author: Preity Singh
//March 2023
public class testDriver {
    public static void main(String[] args){
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<Integer, Integer>();

        //testing size and isEmpty
        System.out.println("size = " + bst.size()+ "--isEmpty = " + bst.isEmpty());

        //testing put()
        bst.put(10,1);
        bst.put(20,2);
        bst.put(30,1);
        bst.put(5,3);
        bst.put(15,3);
        bst.put(-10,4);
        bst.put(10,2); //this shouldn't be added to the BST b/c of the overlap

        System.out.println(bst);

        //testing isEmpty and size
        System.out.println("false: " + bst.isEmpty() + " --> size=6: " + bst.size());

        //testing get() and contains()
        System.out.println("1: " + bst.get(10) + "--> true: " + bst.contains(10));
        System.out.println("1: " + bst.get(30));
        System.out.println("2: " + bst.get(20));
        System.out.println("null: " + bst.get(40) + "--> false: " + bst.contains(40));

        //testing min and max
        System.out.println("-10: " + bst.min());
        System.out.println("30: " + bst.max());








    }
}
