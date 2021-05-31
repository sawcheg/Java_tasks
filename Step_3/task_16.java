import java.io.*;
import java.util.ArrayList;

public class task_16 {
    static int result;

    public static void main(String[] args) {
        result = 1;
        int n = Integer.parseInt(GetLineFromFile("INPUT.TXT"));
        RecureLevel(n, n, 0);
        WriteResult("OUTPUT.TXT", Integer.toString(result));
    }

    static void RecureLevel(int count, int max, int level) {
        int q;
        if (count >= max)
            q = max - 1;
        else
            q = count;
        for (int i = q; i > 0; i--) {
            if (count - i == 0)
                result++;
            else if (count - i > 0) {
                RecureLevel(count - i, i, level + 1);
            }
        }
    }

    static String GetLineFromFile(String inputFile) {
        try {
            File file = new File(inputFile);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String s = bufferedReader.readLine();
            bufferedReader.close(); // закрываем поток
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    static void WriteResult(String ExportFile, String result) {
        try {
            File file = new File(ExportFile);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(result);
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
