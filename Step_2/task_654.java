import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class task_654 {
    public static void main(String[] args) {
        ArrayList<String> buffer = GetArrayFromFile("INPUT.TXT");
        long result = 0;
        int N = Integer.parseInt(buffer.get(0));
        long[] arr = ReturnIntValues(buffer.get(1));
        long max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                result += arr[i] - max;
                max = arr[i];
            }
            if (arr[i] < arr[i - 1])
                result += arr[i - 1] - arr[i];
        }
        WriteResult("OUTPUT.TXT", Long.toString(result));
    }

    static long[] ReturnIntValues(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        long[] intArr = new long[st.countTokens()];
        int i = 0;
        while (st.hasMoreElements()) {
            intArr[i] = Long.parseLong((String) st.nextElement());
            i++;
        }
        return intArr;
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
