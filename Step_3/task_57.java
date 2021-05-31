import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class task_57 {
    public static void main(String[] args) {
        ArrayList<String> buffer = GetArrayFromFile("INPUT.TXT");
        String result = "NO";
        long[] params = ReturnLongValues(buffer.get(0));
        long n = params[0], c = params[1], p = params[2];
        int[] intArr;
        ArrayList<Point> arr = new ArrayList<Point>();
        int curLine = 1;
        for (int i = 0; i <= n; i++) {
            intArr = ReturnIntValues(buffer.get(curLine));
            arr.add(new Point(intArr[0], intArr[1]));
            curLine++;
        }
        for (int i = 0; i < n; i++)
            if (CheckLengthCable(arr, i) * c <= p) {
                result = "YES";
                break;
            }
        WriteResult("OUTPUT.TXT", result);
    }

    static double CheckLengthCable(ArrayList<Point> arr, int i) {
        Point p = arr.get(i);
        double length = 0;
        for (int j = 0; j < arr.size(); j++)
            if (j != i)
                length += p.distance(arr.get(j));
        return length;
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

    static long[] ReturnLongValues(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        long[] longArr = new long[st.countTokens()];
        int i = 0;
        while (st.hasMoreElements()) {
            longArr[i] = Long.parseLong((String) st.nextElement());
            i++;
        }
        return longArr;
    }

    static ArrayList<String> GetArrayFromFile(String inputFile) {
        String line;
        ArrayList<String> array = new ArrayList<String>();
        try {
            File file = new File(inputFile);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((line = bufferedReader.readLine()) != null) {
                array.add(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return array;
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
