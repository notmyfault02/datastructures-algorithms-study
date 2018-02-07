package cc.yaboong.ds.array;

/**
 * Created by yaboong on 2018. 1. 15..
 */
public class ArrayOfStringStack {
    private String[] s;
    private int N = 0;

    public ArrayOfStringStack(int capacity){
        s = new String[capacity];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void push(String item){
        if(s.length == N) resize(2*s.length);
        s[N++] = item;
    }

    public String pop(){
        String item = s[--N];
        s[N] = null;
        if(N > 0 && s.length == s.length/4) resize(s.length/2);
        return item;
    }

    public void resize(int capacity){
        String[] copy = new String[capacity];
        for(int i=0; i<N; i++){
            copy[i] = s[i];
        }
        s = copy;
    }

    public void print(){
        for(int i=0; i<N; i++){
            System.out.println(s[i] + " ");
        }
    }

    public static void main(String[] args) {
        ArrayOfStringStack stack = new ArrayOfStringStack(1);

        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");

        System.out.println("After Push");
        stack.print();

        System.out.println("Popped item: " + stack.pop());
        stack.print();
    }
}
