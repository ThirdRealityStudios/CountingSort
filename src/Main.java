public class Main
{
    public static void main(String[] args)
    {
        CountingSort cS = new CountingSort();

        int[] unsorted = new int[]{5,2,8,4,9,1};

        int[] sorted = cS.sort(unsorted);

        cS.print(sorted);
    }
}
