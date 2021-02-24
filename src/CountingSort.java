public class CountingSort<T>
{
    // Counting sort is a stable and non-comparison-based sorting algorithm.
    // Its Landau notation is: O(k+n) | n = amount of input elements, k = size of the number interval¹.

    // Note! This implementation will fail if one of the input values is below 0 (zero).

    // Returns the maximum value of the array.
    public int maxValue(int[] array)
    {
        int max = Integer.MIN_VALUE;

        for(int i : array)
        {
            max = Math.max(i, max);
        }

        return max;
    }

    public void print(int[] array)
    {
        System.out.println();
        System.out.println();

        for(int i : array)
        {
            System.out.print("| " + i + " ");
        }
    }

    public int[] sort(int[] unsorted)
    {
        // The 'length' equals to the largest value in the array + 1 (due to index starting from 0 (zero)).
        // Therefore the 'length' (meaning the largest number) is NOT made up from the last number in the unsorted array (assuming it was pre-sorted and is the highest),
        // the sorting algorithm works always with every array.
        int length = maxValue(unsorted) + 1;

        // Used to count the occurrences of the numbers in 'unsorted'.
        // Every number there has its own representation (index) on how often it appears,
        // even if there is nothing (zero / 0).
        //
        // ¹number interval relates to the 'length' of the array here (see description of Landau complexity in the head of the class).
        int[] countArray = new int[length];

        // Will be returned. Self-explaining.
        int[] sorted = new int[unsorted.length];

        // Will count the occurrences as described for the variable 'countArray' above.
        for(int i = 0; i < unsorted.length; i++)
        {
            int pointer = unsorted[i];

            countArray[pointer]++;
        }

        print(countArray);

        // Add every preceded neighbour with the current array content.
        for(int i = 0; i < countArray.length; i++)
        {
            if(i > 0)
            {
                countArray[i] = countArray[i - 1] + countArray[i];
            }
        }

        print(countArray);

        // Will load every value of the unsorted array into the sorted array to its corresponding position.
        for(int i = 0; i < unsorted.length; i++)
        {
            int unsortedValue = unsorted[unsorted.length-1 - i];

            int ptrSortedArr = countArray[unsortedValue];

            sorted[ptrSortedArr - 1] = unsortedValue;

            countArray[unsortedValue]--;
        }

        return sorted;
    }
}
