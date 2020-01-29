package Sorting2_Interview;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ShuffleLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private Node first = null;
    private Node last = null;
    private int n;

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) <0; //returns true if v is less than w
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T t = current.element;
            current = current.next;
            return t;
        }
    }

    private class Node{
        T element;
        Node next;
    }

    public void add(T t){
        Node node = new Node();
        node.element = t;
        node. next = null;

        if(first == null && last == null){
            first = node;
            last = node;
        }
        else if (first != null && first == last){
            first.next = node;
            last = node;
        }
        else{
            last.next = node;
            last = node;
        }
        n++;
    }

    @Override
    public String toString(){
        Iterator<T> iter = iterator();
        String ret = iter.next().toString();
        while(iter.hasNext()){
            ret += ", "+iter.next().toString();
        }
        return ret;
    }

    private Node merge(Node left, Node right){
        Node copy = new Node();
        Node l= left;
        Node r = right;
        Node current = copy;

        while (l != null && r != null) {
            int rand = StdRandom.uniform(2);
            if (rand == 0) {
                current.next = r;
                current = current.next;
                r = r.next;
            } else {
                current.next = l;
                current = current.next;
                l = l.next;
            }
        }
            if ( r != null) current.next = r;
            else if (l != null) current.next = l;
            return copy.next;
    }

    private Node sort(Node head){
        if(head == null || head.next == null) return head;
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node left = head;
        Node right = slow.next;
        slow.next = null;
        left = sort(left);
        right = sort(right);
        return merge(left,right);
    }

    public void MergeSort(){
        first = sort(first);
    }

    public static void main(String[] args){
        ShuffleLinkedList<Integer> ll = new ShuffleLinkedList<>();
        ll.add(11);
        ll.add(1);
        ll.add(10);
        ll.add(3);
        ll.add(9);
        ll.add(6);
        ll.add(8);
        ll.MergeSort();
        System.out.println(ll);
    }
}
