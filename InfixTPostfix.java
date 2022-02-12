package com.company;
import com.company.Stack;
import com.company.Node;
import java.util.Scanner;

public class InfixTPostfix {

    public static void main(String[]args)
    {
        String infix=new Scanner(System.in).nextLine();
        int n=infix.length();
        String postfix="";
        String priority="+- */ ^ ()";
        Stack s=new Stack();
        char ch;
        for(int i=0;i<n;i++)
        {
            ch=infix.charAt(i);
            if(priority.indexOf(ch)==-1)
            {
                postfix+=ch;
            }
            else if(s.isEmpty())
            {
                s.push(ch);
            }
            else
            {
                postfix+=priorityChecker(s,ch);
            }
        }
        System.out.println(postfix);

    }

    public static String priorityChecker(Stack s, char ch)
    {
        String ans="";
        String priority="+- */ ^";
        if(ch==')')
        {
            while(!s.isEmpty()&&s.peek()=='(')
            {
                ans+=s.pop();
            }
            return ans;
        }
        else if(s.peek()=='(')
        {
            s.push(ch);
            return "";
        }
        else
        while(!s.isEmpty()&&(priority.indexOf((char)s.peek())-priority.indexOf(ch)>1))
        {
            ans+=s.pop();
        }
        s.push(ch);
        return ans;
    }



}
