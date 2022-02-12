class CustomLinkedList
{
    Noder head=null;
    public void insert(int val)
    {
        if(head==null)
        {
            head=new Noder();
            head.data=val;
            head.next=null;
        }
        else
        {
            Noder n=head;
            while(n.next!=null)
            {
                n=n.next;
            }
            n.next=new Noder();
            n.next.data=val;
            n.next.next=null;           
        }
    }

    public void insertAt(int index,int val)
    {
        if(index==0)
        {
            Noder n=new Noder();
            n.next=head;
            head=n;
            head.data=val;
            return ;
        }
        Noder n=head;
        for(int i=0;i<index-1;i++)
        {
            n=n.next;
        }
        Noder n2=new Noder();
        n2.data=val;
        n2.next=n.next;
        n.next=n2;

    }

    public void show()
    {
        Noder n=head;
        while(n.next!=null)
        {
            System.out.println(n.data);
            n=n.next;
        }
        System.out.println(n.data);
    }
}