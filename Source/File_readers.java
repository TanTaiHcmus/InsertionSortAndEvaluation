import java.util.Scanner;

public class File_readers
{
    public static int []readDataFromFile(Scanner reader)
    {
        int n = reader.nextInt();
        int []result = new int[n];
        for (int i = 0; i < n; i++) 
            result[i] = reader.nextInt();
        return result;
    }
}