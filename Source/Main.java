import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class Main
{
    private final static String strThongKe = "m,1000\n"
                                            + "n,100,,200,,300,,400,,500,,600,,700,,800,,900,,1000\n"
                                            + "assign (avg),=AVERAGE(B$6:B$1005),,=AVERAGE(D$6:D$1005),,=AVERAGE(F$6:F$1005),,=AVERAGE(H$6:H$1005),,=AVERAGE(J$6:J$1005),,=AVERAGE(L$6:L$1005),,=AVERAGE(N$6:N$1005),,=AVERAGE(P$6:P$1005),,=AVERAGE(R$6:R$1005),,=AVERAGE(T$6:T$1005)\n"
                                            + "compare (avg),=AVERAGE(C$6:C$1005),,=AVERAGE(E$6:E$1005),,=AVERAGE(G$6:G$1005),,=AVERAGE(I$6:I$1005),,=AVERAGE(K$6:K$1005),,=AVERAGE(M$6:M$1005),,=AVERAGE(O$6:O$1005),,=AVERAGE(Q$6:Q$1005),,=AVERAGE(S$6:S$1005),,=AVERAGE(U$6:U$1005)\n"
                                            + ",assign,compare,assign,compare,assign,compare,assign,compare,assign,compare,assign,compare,assign,compare,assign,compare,assign,compare,assign,compare\n";
    public static void main(String[] args) {
        boolean check = Generators.CreateArrayWithCases();
        if (!check)
        {
            System.out.println("Tạo test không thành công");
            return;
        }
        Execute("Best.txt", "Best.csv");
        Execute("Worst.txt", "Worst.csv");
        Execute("Average.txt", "Average.csv");
    }

    private static void Execute(String strFileReader, String strFileWriter) {
        Scanner reader = null;
        FileWriter writer = null;
        try
        {
            reader = new Scanner(new File(strFileReader));
            writer = new FileWriter(new File(strFileWriter));
            writer.append(strThongKe);
            for (int i = 0; i < 1000; i++)
            {
                for (int j = 0; j < 10; j++)
                {
                    int []arr = File_readers.readDataFromFile(reader);
                    int []result = Algorithms.InsertionSort(arr);
                    writer.append("," + String.valueOf(result[0]) + "," + String.valueOf(result[1]));
                }
                writer.append("\n");
            }
        }
        catch(Exception e)
        {
            System.out.println("Lỗi mở file");
        }
        finally
        {
            if (reader != null)
                reader.close();
            if (writer != null)
                closeFile(writer);
        }
    }

    private static void closeFile(FileWriter writer) {
        try {
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}