
/**
 * class CSCI463ProjFour. Add the following data one by one
 * to a binary search tree, then print out the tree
 * 65, 23, 45, 76, 54, 55, 98, 86
 * 
 * @author Hongbiao Zeng 
 * @version Dec 6, 2015
 */
import java.util.Scanner;
public class CSCI463ProjFour
{
    public static void main(String args[]){
        int data;
        int choice;
        Scanner input = new Scanner(System.in);
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
       
        do{
            menu();
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch(choice){
            case 1:
                System.out.print("Enter data that you will add to tree: ");
                data = input.nextInt();
                tree.insert(new Integer(data));
                System.out.println("The tree is: " + tree);
                break;
            case 2: 
                System.out.print("Enter data that you will remvoe from tree: ");
                data = input.nextInt();
                if(tree.search(data) == null)
                    System.out.println("No such data in tree");
                else{
                    tree.remove(new Integer(data));
                    System.out.println("The tree is: " + tree);
                }
                break;
            case 3:
                System.out.print("Enter data that you want to search for: ");
                data = input.nextInt();
                if(tree.search(data) == null)
                    System.out.println("No such data in tree");
                else
                    System.out.println("The tree is: " + tree + ". Data found in tree");
                break;
            case 4:
                if(tree.isEmpty())
                    System.out.println("Tree is empty");
                else{
                    System.out.println("The tree is: " + tree);
                    System.out.println("Tree size: " + tree.size());
                    System.out.println("Tree height: " + tree.height());
                }
                break;
            case 5:
                System.out.println("Make sure you run enough test before you turn it in");
                break;
            default:
                System.out.println("Wrong option. Please choose from menu");
                break;
            }
        }while(choice != 5);
        
    }
    
    private static void menu(){
        System.out.println("********************");
        System.out.println("*      MENU        *");
        System.out.println("* 1. Add a node    *");
        System.out.println("* 2. Remove a node *");
        System.out.println("* 3. Search a data *");
        System.out.println("* 4. Tree property *");
        System.out.println("* 5. Quit          *");
        System.out.println("********************");
    }
}
