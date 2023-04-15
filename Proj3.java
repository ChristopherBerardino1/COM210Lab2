import java.util.Scanner;
import java.util.Stack;

public class Proj3 {


    public static void main(String[] args) {
     
class StacksareFun{

    private int maxSize;
    private long[] stackArray;
    private int top;

    public StacksareFun(int s)
    {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }
    public void push(long j)
    {
        stackArray[++top] = j;
    }
    public long pop()
    {
        return stackArray[top--];
    }
}
Scanner userInput = new Scanner(System.in);

System.out.print("Enter your delimiters. Not properly inputting your delemiters, such as ensuring the opened delimiter has a matching closing delimiter will result in an error message.");

System.out.print(userInput);




    }
}
