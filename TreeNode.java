import java.util.Comparator;

//
// TreeNode class gives us the capabilities of creating
//  Tree node
//
public class TreeNode<E> {

    //properties
    private E value;
    private TreeNode<E> parent;
    private TreeNode<E> left;
    private TreeNode<E> right;
    private boolean visit=false;

    public TreeNode(E val,TreeNode<E> par){
        this.value=val;
        this.parent=par;
        this.left=null;
        this.right=null;
    }
    // getters of the properties

    public E getValue() {
        return value;
    }


    public TreeNode<E> getLeftChild() {
        return this.left;
    }
    public TreeNode<E> getRightChild(){
        return this.right;
    }

    //setters of the properties

    public TreeNode<E> addLeftChild(E val){
        // this itself is the parent of iteself
        //create a node and add it to the left
        // parent of the node would be the node adding and creaating it
        //which is this/self node

        this.left=new TreeNode<E>(val,this);
        return this.left;
    }

    public TreeNode<E> addRightChild(E val){
        // this itself is the parent of iteself
        //create a node and add it to the left
        // parent of the node would be the node adding and creaating it
        //which is this/self node

        this.right=new TreeNode<E>(val,this);
        return this.right;
    }
    public void visit(){
        this.visit=true;
    }


}
