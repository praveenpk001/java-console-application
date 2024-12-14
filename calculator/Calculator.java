

public class Calculator
{
    static double add(double a,double b)
    {
        return a+b;
    }
    static double add(double a,double b,double c)
    {
        return a+b+c;
    }

    static double sub(double a,double b)
    {
        return a-b;
    }
    static double sub(double a,double b,double c)
    {
        return a-b-c;
    }

    static double mul(double a,double b)
    {
        return a*b;
    }
    static double mul(double a,double b,double c)
    {
        return a*b*c;
    }

    static double div(double a,double b)
    {
        return a/b;
    }
    static double div(double a,double b,double c)
    {
        return a/b/c;
    }

    static double power(double a,double b)
    {
        return Math.pow(a,b);
    }
    static double power(double a,double b,double c)
    {
        return Math.pow(Math.pow(a,b),c);
    }

}