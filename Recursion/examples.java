package Recursion;

public class examples{
    public static void main(String[] args)
    {
        // int[] a = {10,20,30};
        // System.out.println(countDig(149789));
        // System.out.println(binDig(100));
        // System.out.println(sum(a,a.length));
        // int n=173;
        // System.out.println(isprime(n,n/2));
        // System.out.println(gcd(300,210));
        // toh(3,'A','C','B');
    }
    public static int countDig(int n)
    {
        if(n>0)
        return countDig(n/10)+1;
        else 
        return 0;
    }
    public static int binDig(int n)
    {
        if(n==1)
        return 1;
        else 
        return binDig(n/2)+1;
    }
    public static int sum(int[] a, int n)
    {
        if(n==0)
        return n;
        else
        return a[n-1]+sum(a,n-1);
    }
    public static boolean isprime(int n,int i)
    {
        if(i==1)
        return true;
        else if(n%i==0)
        return false;
        else
        return isprime(n, i-1);
    }
    public static int gcd(int n1,int n2)
    {
        if(n2!=0)
        return gcd(n2,n1%n2);
        else 
        return n1;
    }
    public static void toh(int n,char from,char to,char aux)
    {
        if(n==1)
        {
        System.out.println("move disk from "+from+" to"+to);
        return;
        }
        else
        {
            toh(n-1,from,aux,to);
            System.out.println("move disk from "+from+" to"+to);
            toh(n-1,aux,to,from);
        }
    }
}
