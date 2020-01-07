package Stacks_Queues_Interview;

public class LinkedQueueOfStrings {
    private Node first, last;
    private class Node{
        String item;
        Node next;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public void enqueue(String item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (!isEmpty()) {
            oldLast.next = last;
        } else first = last;
    }

    public String dequeue(){
        String item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        return item;
    }
}
