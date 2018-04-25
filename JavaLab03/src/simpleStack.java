import static java.lang.Character.*;

public class simpleStack<T extends Comparable<T>> {
    private static final int MAXN = 10;
    private int top;
    private T[] array;

    public simpleStack() {
        top = -1;
        array = (T[])new Comparable[MAXN];
    }

    public boolean push(T item) {
        if (top >= MAXN-1)
            return false;
        else
            array[++top] = item;
        return true;
    }

    public T pop() {
        if (top == -1)
            return null;
        else
            return array[top--];
    }

    public void print() {
        for (int i = top; i >= 0; i--)
            System.out.print(array[i] + " ");
    }

    public static void main(String[] args) {
        simpleStack<Character> stack = new simpleStack();
        Character             item;
        //123+=2-=1+=Q


        System.out.println("Enter a letter to push onto stack");
        System.out.println("or digit 1 to take a letter from stack");
        System.out.println("Return to end the program\n");
        try {
            item = new Character((char)System.in.read());
            while (item.compareTo(new Character('\n')) != 0) {

                if (item.compareTo(new Character('+')) == 0){
                    int sum = Character.getNumericValue(stack.pop()) + Character.getNumericValue(stack.pop());
                    stack.push(Integer.toString(sum).charAt(0));

                }else if (item.compareTo(new Character('-')) == 0){
                    int a = Character.getNumericValue(stack.pop());
                    int b = Character.getNumericValue(stack.pop());
                    int diff = b - a;
                    stack.push(Integer.toString(diff).charAt(0));
                }
                    else if (item.compareTo(new Character('=')) == 0){
                        int result = Character.getNumericValue(stack.pop());
                    stack.push(Integer.toString(result).charAt(0));
                    System.out.println("top value is "+result);

                }   else if (item.compareTo(new Character('Q')) == 0){
                    System.out.println("stack contained");
                    stack.print();
                    return;

                }   else {
                    stack.push(item);
                }
                System.out.println(item);
                item = new Character((char)System.in.read());
            }
            System.out.println();
        } catch(Exception e) {
            System.out.println("Exception " + e);
        }
    }
}

