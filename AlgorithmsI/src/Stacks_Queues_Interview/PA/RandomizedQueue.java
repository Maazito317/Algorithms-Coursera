package Stacks_Queues_Interview.PA;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] queue;
    private int N;
    private Random r = new Random();

    // construct an empty randomized queue
    public RandomizedQueue(){
        N = 0;
        queue = (Item[]) new Object[2];
    }

    private void resize(int capacity){
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++)
            copy[i] = queue[i];
        queue = copy;
    }

    // is the randomized queue empty?
    public boolean isEmpty(){
        return N==0;
    }

    // return the number of items on the randomized queue
    public int size(){
        return N;
    }

    // add the item
    public void enqueue(Item item){
        if (item == null) throw new NullPointerException();
        if (N == queue.length) resize(2 * queue.length);
        queue[N] = item;
        N++;
    }

    // remove and return a random item
    public Item dequeue(){
        if(isEmpty()) throw new NoSuchElementException();
        int id = r.nextInt(N);
        Item item = queue[id];
        exchange(queue,id,N-1);
        N--;
        if (N > 0 && N == queue.length / 4) resize(queue.length / 2);
        return item;
    }

    private void exchange(Item[] arr, int q, int p){
        if (q==p) return;
        Item tmp = arr[q];
        arr[q] = arr[p];
        arr[p]=tmp;
    }

    // return a random item (but do not remove it)
    public Item sample(){
        if(isEmpty()) throw new NoSuchElementException();
        int id = r.nextInt(N);
        return queue[id];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item>{
        private Item[] randomQueue;
        private int current;
        private Random r = new Random();
        public RandomizedQueueIterator() {
            randomQueue = (Item[]) new Object[N];
            for (int i = 0; i < N; ++i)
                randomQueue[i] = queue[i];
            for (int i = 1; i < randomQueue.length; ++i) {
                int id = r.nextInt(i+1);
                exchange(randomQueue, id, i);
            }
            current = 0;
        }

        public boolean hasNext() {
            return current < randomQueue.length;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();

            Item item = randomQueue[current];
            current++;
            return item;
        }

    }
    // unit testing (required)
    public static void main(String[] args){
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
        rq.enqueue(4);
        rq.enqueue(5);
        System.out.println("Size: "+ rq.size());
        System.out.println("Random number: "+ rq.dequeue());
        System.out.println("Size: "+ rq.size());
        System.out.println("Random sample: "+ rq.sample());
        System.out.println("Size: "+ rq.size());


    }

}