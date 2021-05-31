import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class task_53 {
    public static void main(String[] args) {
        int[] params = ReturnIntValues(GetLineFromFile("INPUT.TXT"));
        String result = "";
        int n = params[0], m = params[1];
        int black = n * m, red = 0, blue = 0, green = 0, b_n = 0, g_n = 0, r_n = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                blue += m;
                b_n++;
            } else if (i % 3 == 0) {
                green += m;
                g_n++;
            } else if (i % 2 == 0) {
                red += m;
                r_n++;
            }
        }
        for (int i = 1; i <= m; i++) {
            if (i % 5 == 0) {
                blue += n - b_n;
                green -= g_n;
                red -= r_n;
            } else if (i % 3 == 0) {
                green += n - b_n - g_n;
                red -= r_n;
            } else if (i % 2 == 0) {
                red += n - b_n - g_n - r_n;
            }
        }
        result += "RED : " + red + "\n";
        result += "GREEN : " + green + "\n";
        result += "BLUE : " + blue + "\n";
        result += "BLACK : " + (black - red - green - blue);
        WriteResult("OUTPUT.TXT", result);
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
