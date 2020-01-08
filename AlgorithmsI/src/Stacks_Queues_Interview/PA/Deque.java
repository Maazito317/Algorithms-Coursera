package Stacks_Queues_Interview.PA;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque <Item> implements Iterable<Item>{

    private Node first;
    private Node last;
    private int N;

    private class Node{
        Item item;
        Node next = null;
        Node prev = null;
    }
    public Deque(){
        first = null;
        last = null;
        N = 0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void addFirst(Item item){
        if (item == null) throw new NullPointerException();
        if(isEmpty()){
            first = new Node();
            first.item = item;
            last = first;
        } else{
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            oldfirst.prev = first;
        }
        N++;
    }

    public void addLast(Item item){
        if(item == null) throw new NullPointerException();
        if(isEmpty()){
            last = new Node();
            last.item = item;
            first = last;
        } else{
            Node oldlast = last;
            last = new Node();
            last.item = item;
            last.prev = oldlast;
            oldlast.next = last;
        }
        N++;
    }

    public Item removeFirst(){
        if(isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        if(first != null) first.prev = null;
        else last=null;
        N--;
        return item;
    }

    public Item removeLast(){
        if(isEmpty()) throw new NoSuchElementException();
        Item item = last.item;
        last = last.prev;
        if(last!=null) last.next = null;
        else first = null;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args){
        Deque<Integer> dq = new Deque<>();

        dq.addFirst(5);
        dq.addFirst(2);
        dq.addLast(3);
        dq.addLast(1);
        System.out.println("Size: "+dq.size());
        System.out.println("Remove first (Should be 2): "+ dq.removeFirst());
        System.out.println("Remove first (Should be 1): "+ dq.removeLast());
    }
}
