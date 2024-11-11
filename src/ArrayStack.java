import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<S>{
    //Variables
    private static final int Capacity = 4;
    private int top;
    private S[] stack;
    //Constractors
    ArrayStack(){
        this(Capacity);
    }
    ArrayStack(int capacity){
        top = 0;
        stack = (S[]) new Object[capacity];
    }
    //Methods/Operators
    private void expandCapacity(){
        stack = Arrays.copyOf(stack,stack.length * 2);
    }
    //Siz
    int size(){
        return top;
    }
    //isEmpty
    boolean isEmpty(){
        return top == 0;
    }
    //Push
    void push(S element){
        if (size()==stack.length)
            expandCapacity();
        stack[top]=element;
        top++;
    }
    //pop
    S pop()throws EmptyStackException{
        if (isEmpty())
            throw new EmptyStackException();
        top--;
        S RemovedElemenet = stack[top];
        stack[top] = null;
        return RemovedElemenet;
    }
    //peek
    S peek()throws EmptyStackException{
        if (isEmpty())
            throw new EmptyStackException();
        return stack[top--];
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "top=" + top +
                ", stack=" + Arrays.toString(stack) +
                '}';
    }

    //Duplicate
    private boolean Noq_noqdo(ArrayStack array, S element) {
        for (int i = 0; i < array.size(); i++) {
            if (array.stack[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void merge(ArrayStack<S> Arrey1, ArrayStack<S> Arrey2) {
        for (int i = 0; i < Arrey1.size(); i++) {
            boolean duplicated;
            duplicated = Noq_noqdo(this, Arrey1.stack[i]);
            if (!duplicated)
                this.push(Arrey1.stack[i]);
        }

        for (int i = 0; i < Arrey2.size(); i++) {
            boolean duplicated;
            duplicated = Noq_noqdo(this, Arrey2.stack[i]);
            if (!duplicated)
                this.push(Arrey2.stack[i]);
        }
    }
    public static void main(String[] args) {
        ArrayStack<String> D1 = new ArrayStack<>();
        ArrayStack<String> D2 = new ArrayStack<>();
        ArrayStack<String> D3 = new ArrayStack<>();
        D1.push("Abu bakar");
        D1.push("Abu osman");
        D1.push("Abu osman");
        D1.push("Abu osman");

        D2.push("Abu ahmed");
        D2.push("Abu ahmed");
        D2.push("Abu omar");

        D3.merge(D1,D2);

        System.out.println("Stacks are: "+D3);
    }
}
