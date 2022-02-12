class FibonacciRecursive
{
    public static int fibo(int n)
    {
        assert(n>=1);
        if(n<=2) return n+1;
        return fibo(n-1)+fibo(n-2);
    }
}