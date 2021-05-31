import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class task_317 {
    public static void main(String[] args) {
        int[] params = ReturnIntValues(GetLineFromFile("INPUT.TXT"));
        int result = 0, x = params[0], y = params[1], z = params[2], w = params[3], rest, rest2;
        for (int i = w / x; i >= 0; i--) {
            rest = w - i * x;
            if (rest == 0) result++;
            else
                for (int j = rest / y; j >= 0; j--) {
                    rest2 = rest - j * y;
                    if ((rest2 == 0) || (rest2 % z == 0)) result++;
                }
        }
        WriteResult("OUTPUT.TXT", Integer.toString(result));
    }


    static int[] ReturnIntValues(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        int[] intArr = new int[st.countTokens()];
        int i = 0;
        while (st.hasMoreElements()) {
            intArr[i] = Integer.parseInt((String) st.nextElement());
            i++;
        }
        return intArr;
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
