import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Generators {
    public static boolean CreateArrayWithCases() {
        boolean check = true;
        check = check & CreateArrayWithCase1();
        check = check & CreateArrayWithCase2();
        check = check & CreateArrayWithCase3();
        return check;
    }

    private static boolean CreateArrayWithCase3() {
        FileWriter writer = null;

        try {
            String fileName = "Average.txt";
            writer = new FileWriter(fileName);
            Random random = new Random();
            for (int i = 0; i < 1000; i++){
                for (int n = 100; n <= 1000; n = n + 100) 
                {
                    writer.append(String.valueOf(n) + "\n");
                    for (int j = 0; j < n; j++) {
                        int k = random.nextInt(1000000);
                        writer.append(String.valueOf(k) + " ");
                    }
                    writer.append("\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi tạo file");
        }
        finally{
            if (writer != null)
                closeFile(writer);
            else 
                return false;
        }
        return true;
    }

    private static boolean CreateArrayWithCase2() {
        FileWriter writer = null;

        try {
            String fileName = "Best.txt";
            writer = new FileWriter(fileName);
            Random random = new Random();
            for (int i = 0; i < 1000; i++) {
                for (int n = 100; n <= 1000; n = n + 100) {
                    int []arr = new int[n];
                    arr[0] = random.nextInt(1000);
                    for (int j = 1; j < n; j++)
                        arr[j] = arr[j - 1] + random.nextInt(1000);
                    writer.append(String.valueOf(n) + "\n");
                    for (int j = n - 1; j >= 0; j--) {
                        writer.append(String.valueOf(arr[j]) + " ");
                    }    
                    writer.append("\n");  
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi tạo file");
        }
        finally{
            if (writer != null)
                closeFile(writer);
            else 
                return false;
        }
        return true;
    }

    private static boolean CreateArrayWithCase1() {
        FileWriter writer = null;

        try {
            String fileName = "Worst.txt";
            writer = new FileWriter(fileName);
            Random random = new Random();
            for (int i = 0; i < 1000; i++) {
                for (int n = 100; n <= 1000; n = n + 100) {
                    writer.append(String.valueOf(n) + "\n");
                    int k = 0;
                    for (int j = 0; j < n; j++) {
                        k = k + random.nextInt(1000);
                        writer.append(String.valueOf(k) + " ");
                    } 
                    writer.append("\n");  
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi tạo file");
        }
        finally{
            if (writer != null)
                closeFile(writer);
            else 
                return false;
        }
        return true;
    }

    private static void closeFile(FileWriter writer) {
        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}