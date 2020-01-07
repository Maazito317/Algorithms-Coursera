package Stacks_Queues_Interview;

import java.util.Stack;
import java.util.TreeSet;

public class StackMax<Item> extends Stack<Item> {
    TreeSet<Item> treeSet = new TreeSet<>();

    public Item getMax(){
        return treeSet.last();
    }

    public Item push(Item item){
        super.push(item);
        treeSet.add(item);
        return item;
    }

    public Item pop(){
        Item item = super.pop();
        treeSet.remove(item);
        return item;
    }

    public static void main(String[] args){
        StackMax<Integer> stMax = new StackMax<>();
        int i = 0;
        stMax.push(i);

        for (i = 0; i <=50; i++){
            if (i % 4 == 0){
                System.out.println("Max: "+ stMax.getMax());
            }
            else if (i % 3 == 0) System.out.println("Pop: "+ stMax.pop());
            else{
                stMax.push(i);
                System.out.println("Push: "+ i);
            }
        }
    }

}
