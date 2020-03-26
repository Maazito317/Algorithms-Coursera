package Stacks_Queues_Interview.In_Lecture;

public class ArrayStackOfStrings {
    private int N = 0;
    private String[] s;

    public ArrayStackOfStrings(){
        s = new String[1];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void push(String item){
        if (N == s.length) resize(2 * s.length);
        s[N++] = item;
    }

    private void resize(int capacity)
    {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++)
            copy[i] = s[i];
        s = copy;
    }

    public String pop(){
        //to avoid loitering: no reference to the popped item
        String item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length/4) resize(s.length/2);
        return item;
    }

}
