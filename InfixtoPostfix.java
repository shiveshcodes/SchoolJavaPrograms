package com.company;

import java.util.Scanner;

class node
{
    char data;
    node next;
    node(char data)
    {
        this.data=data;
    }
}
class stack
{
    node top;
    stack()
    {
        top=null;
    }

    public char peek()
    {
        if(!isEmpty())
            return top.data;
        else throw new RuntimeException();
    }

    public boolean isEmpty()
    {
        return top==null;
    }

    public void push(char data)
    {
        try {
            node newNode = new node(data);
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

    public char pop()
    {
        char data;
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

public class InfixtoPostfix {

    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t >= 1) {
            t--;
            String s=sc.nextLine();
            stack op=new stack();
            stack opr=new stack();
            String oprt="+-*/^";
            char ch;
            for(int i=0;i<s.length();i++)
            {
                ch=s.charAt(i);
                if(oprt.indexOf(ch)!=-1)
                {
                    opr.push(ch);
                }
                else if(ch==')')
                {
                    op.push(opr.pop());
                }
                else if(ch!='(')
                {
                    op.push(ch);
                }
            }
            oprt="";
            while(!op.isEmpty())
            {
                oprt+=op.pop();

            }

            System.out.println(new StringBuffer(oprt).reverse());

        }
    }

}
