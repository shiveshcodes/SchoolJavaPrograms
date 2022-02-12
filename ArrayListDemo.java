import java.util.*;
class ArrayListDemo
{
    public static void main(String[]args)
    {
        ArrayList<String> names=new ArrayList<>();
        names.add("Shivesh");
        names.add("Parth");
        names.add("Riddhi");
        names.add("Siddhi");
        names.add("Ved");
        
        System.out.println(names);
        System.out.println(names.get(0));
        names.set(0,"Robin");
        System.out.println(names);
        System.out.println(names.isEmpty());
        System.out.println(names.size());
        System.out.println(names.remove(4));
        System.out.println(names);
        System.out.println(names.remove("Ved"));
        System.out.println(names);
        names.removeIf(s->s.startsWith("R"));
        System.out.println(names);
        List<String> text=new ArrayList<>(names);//addAll() can also be used
        System.out.println(text);
        text.clear();
        System.out.println(text);
        System.out.println(names.contains("Riddhi"));//.indexOf() or.lastIndexOf() may also be used
        Collections.sort(names);
        //enhanced for loop and normal array method may be used to iterate through it
        Iterator ir=names.iterator();
        while(ir.hasNext())
        {
            System.out.println(ir.next());
        }
        //ListIterator can go backwards
        ListIterator lir=names.listIterator(names.size());
        while(lir.hasPrevious())
        {
            System.out.println(lir.previous());
        }
        
    }
}