package Lab5;

class X
{
    private static int a;
    private int b;

    public X(int n)
    {
        this.a = n;
        this.b = n;
    }

    public void print()
    {
        System.out.printf("a is %d,  b is %d\n", a, b);
    }
}

public class Main
{

    public static void main(String[] args)
    {
        X x1 = new X(1);
        X x2 = new X(2);
        X x3 = new X(3);
        x1.print();
        x2.print();
        x3.print();
    }
}
