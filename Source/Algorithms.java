public class Algorithms
{
    public static int []InsertionSort(int []arr)
    {
        int countAssign = 0; int countCompare = 0;
        int i, j, key, numLength;
	    numLength = arr.length; countAssign++;
        for (j = 1; j < numLength; j = j + 1)
        {
            countAssign++; countCompare++;
            key = arr[j]; countAssign++;
            for (i = j - 1; ((i >= 0) && (arr[i] < key)); i = i - 1)
            {
                countAssign++; countCompare += 2;
                arr[i+ 1] = arr[i]; countAssign++;
            }
            countAssign++; countCompare += 2;
            arr[i + 1] = key; countAssign++;
        }
        countAssign++; countCompare++;
        int []result = {countAssign, countCompare};
        return result;
    }
}