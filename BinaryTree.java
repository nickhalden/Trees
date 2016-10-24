import javax.print.attribute.IntegerSyntax;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nxc141130 on 9/29/16.
 */
// Description: Have a linked list data structure
// we only need root node ( like a list needs head or tail)
// one reference to a node the root node.
// Each node needs
////          *
//           /  \
//           *   *
//          /\   /\
//    1) A value
//    2) A parent
//    3) A left child
//    4) A right child


public class BinaryTree<E extends  Comparable<? super E>> {

    //private =null;
    private TreeNode<E> root;

    public TreeNode <E>  getroot(){
        return this.root;
    }

    // postOrder and preOrder are DFS
    // Pre order Traversal
    // Visit Yourself
    // Recursively
    // Then Visit all your left subtree
    // Then Visit all your subtree

    // Level order is also BFS

    private void levelOrder(TreeNode node){
        Queue <TreeNode<E>> queue=new LinkedList<>();
        queue.add(root);
        // while the queue has elements remove from the queue
        while(!queue.isEmpty()){
            TreeNode<E> curr= queue.remove();
            if (curr!=null){
                curr.visit();
                if (curr.getLeftChild()!=null){
                    queue.add(curr.getLeftChild());
                }
                if (curr.getRightChild()!=null){
                    queue.add(curr.getRightChild());
                }

            }

        }
    }


    //POST ORDER TRAVERSAl
    // Visit all your left subtree
    // Visit all your right subtree
    // Visit yourself

    private void postOrder(TreeNode<E> node){
        if (node!=null){
            postOrder(node.getLeftChild());
            System.out.println(node.getValue());
            postOrder(node.getRightChild());
        }

    }

    public void search(E val){
        TreeNode<E> position=root;
        int comp;
        while (position!=null){
            comp=val.compareTo(position.getValue());
            if (comp<0){
                System.out.println(comp+" "+val+" "+position.getValue());
                position=position.getLeftChild();
            }else if (comp>0){
                System.out.println(val+" "+position.getValue());
                position=position.getRightChild();
            }else {
                System.out.println("Found the element: "+ position.getValue());
                return;
            }

        }
    }

    // my implementation of maintain a pointer to the current pointer iteself
    // and wherever it falls of create a new node ad the pointer to pointer will
    // help know where to go
    public void insertNode(E val){
        TreeNode<E> curr;
        TreeNode<E> pointerToCurrent=null;
        if (root==null){
            root= new TreeNode(val,null);
            return;
        }else {
            curr= root;
            while (curr!=null){
                int comp=val.compareTo(curr.getValue());
                if (comp<0){
                    pointerToCurrent=curr;
                    curr=curr.getLeftChild();
                }else if (comp>0){
                    pointerToCurrent=curr;
                    curr=curr.getRightChild();
                }

            }
            if (val.compareTo(pointerToCurrent.getValue())<0){
                pointerToCurrent.addLeftChild(val);
            }else {
                pointerToCurrent.addRightChild(val);
            }

        }


    }


    // go in the tree until the point where you know you won't fall off
    // after that compare the values and see where to insert
    public boolean  insertNode2(E val){


        if (root==null){
            root=new TreeNode<>(val,null);
            return true;
        }
        TreeNode<E> curr=root;

        if (val.compareTo(curr.getValue())==0){
            System.out.println("Node already existing as the root "
                    +curr.getValue());
            return false;
        }

        int comp=val.compareTo(curr.getValue());
        while (comp<0 && curr.getLeftChild()!=null
                || comp>0 && comp>0 &&curr.getRightChild()!=null){
            if (comp>0) curr=curr.getRightChild();
            else curr=curr.getLeftChild();

        }
        if (comp>0){
            curr.addRightChild(val);
        }else if (comp>0) {
            curr.addLeftChild(val);
        }else {
            return false;
        }
        return true;
    }


    private void preOrder(TreeNode<E> node){
        if (node!=null){
            node.visit();// mark the visited node to be true
            System.out.println(node.getValue());
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }





    public boolean contains(E toFind){
        TreeNode<E> curr=root;
        int comp;
        while (curr!=null){
            comp=toFind.compareTo(curr.getValue());
            if (comp>0) {
                curr= curr.getLeftChild();
            }else if (comp<0){
                curr= curr.getRightChild();
            }else{
                    return true;
            }
        }
        return false;
    }




    public void preOrder(){
        this.preOrder(root);
    }

    public void postOrder(){
        this.postOrder(root);
    }

    public void levelOrder(){ this.levelOrder(root);}





    public static void main(String[] args) {

        BinaryTree b= new BinaryTree();
        b.insertNode2(11);
        b.insertNode2(10);
        b.insertNode2(3);
        b.insertNode2(5);
        b.insertNode2(11);


        b.search(5);



    }



}


