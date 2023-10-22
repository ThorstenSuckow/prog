public class AufgabeElemProg
{


    public static void main (String[] args)
    {
        System.out.println("abgerDurch (1 , 3, 3) -> " + abgerDurch(1, 3, 3)) ;
        System.out.println("max (43 , 121) -> " + max(43 , 121 )) ;
        System.out.println("ohneRest (10 , 2) -> " + ohneRest(10, 2)) ;
    }

    public static int abgerDurch (int a1 , int a2, int a3)
    {
        return (a1 + a2 + a3) / 3 ;
    }

    public static int max(int a1, int a2)
    {
        return a1 <= a2 ? a2 : a1;
    }

    public static boolean ohneRest(int dividend, int divisor)
    {
        return (dividend % divisor) == 0;
    }
}