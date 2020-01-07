package Stacks_Queues_Interview;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueWithStacks<Item> {
    private Stack<Item> Stack1 = new Stack<Item>();
    private Stack<Item> Stack2 = new Stack<Item>();

    public QueueWithStacks(){}

    public int size(){
        return (Stack1.size()+Stack2.size());
    }

    public boolean isEmpty(){return size()==0;}

    public void enqueue(Item item){
        if(item == null) throw new NullPointerException();
        Stack1.push(item);
    }

    public Item dequeue(){
        if(isEmpty()) throw new NoSuchElementException();

        if (Stack2.isEmpty()){
            while(!Stack1.isEmpty()){
                Stack2.push(Stack1.pop());
            }
        }
        return Stack2.pop();
    }

    public static void main(String[] args){
        QueueWithStacks<Integer> q = new QueueWithStacks<Integer>();

        int i = 0;
        q.enqueue(i);

        for (i = 0; i <=10; i++){
            System.out.println("Size: "+ q.size());
            if (i % 2 == 0){
                System.out.println("Dequeue: "+ q.dequeue());
            }
            else{
                q.enqueue(i);
                System.out.println("Enqueue: "+ i);
            }
        }
    }
}
