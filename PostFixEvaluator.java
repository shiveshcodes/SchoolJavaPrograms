

package com.company;
import java.util.Scanner;
public class PostFixEvaluator {

    public static void main(String[]args)
    {
        System.out.print("Enter the Postfix Expression: ");
        String expression=new Scanner(System.in).nextLine();//Accept postfix expression as String

        String[] units=expression.split(" ");//Splits each member
        String operators="+-*/"; //To check is a unit member is a operator or not
        Stack calc=new Stack(); //Stores the intermediate calculation answers and final ans
        int isoperator;//stores position of an operator in the above string
        for(int i=0;i<units.length;i++)//iterating each unit
        {
            isoperator=operators.indexOf(units[i]);//if not operator it becomes -1

            if(isoperator==-1) calc.push(Integer.parseInt(units[i]));//if not operator stack the value

            else calc.push(calculate(isoperator,calc.pop(),calc.pop()));//when operator is found then operate the prev two values

        }
        System.out.println(calc.pop());//since the last value left in stack is the final ens


    }

    public static int calculate(int operator,int operand2,int operand1)
    {
        //it takes operator index and calculates the result using operands
        int res=-1;
        switch(operator)
        {
            case 0: res=operand1+operand2; break;
            case 1: res=operand1-operand2; break;
            case 2: res=operand1*operand2; break;
            case 3: res=operand1/operand2; break;
        }
        return res;
    }
}

class Node //To manage data members of a node and its creation
{
    int data;//stores data
    Node next;//reference to next Node
    Node(int data)//Constructor which adds default data value
    {
        this.data=data;
    }
}


class Stack//Linked Stack Implementation
{
    Node top;//reference to topmost element
    Stack()//constructor
    {
        top=null;
    }

    //All the methods below are standard Stack Implementation and self evident logically

    public boolean isEmpty()
    {
        return top==null;
    }

    public int peek()
    {
        if(!isEmpty())
            return top.data;
        else throw new RuntimeException();
    }

    public void push(int data)
    {
        try {
            Node newNode = new Node(data);
            if (isEmpty()) {
                top = newNode;
            } else {
                newNode.next = top;
                top = newNode;
            }
        }catch(OutOfMemoryError e)
        {
            throw new RuntimeException("Overflow");
        }
    }

    public int pop()
    {
        int data;
        if(!isEmpty())
        {
            data=top.data;
            top=top.next;
        }
        else
        {
            throw new RuntimeException("UnderFlow");
        }
        return data;
    }

}

