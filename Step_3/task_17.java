import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class task_17 {
    public static void main(String[] args) {
        ArrayList<String> buffer = GetArrayFromFile("INPUT.TXT");
        int result = 0;
        int n = Integer.parseInt(buffer.get(0)) - 1;
        int[] arr = ReturnIntValues(buffer.get(1));
        int d = 1;
        boolean find = false, all = false;
        int count = 0, checked;
        while (result < 1) {
            if (n % d == 0) {
                count = n / d;
                if (count == 1)
                    result = d;
                else {
                    checked = 0;
                    for (int i = d - 1; i >= 0; i--) {
                        all = true;
                        for (int j = 1; j < count; j++)
                            if (arr[i] == arr[i + j * d])
                                checked++;
                            else {
                                all = false;
                                break;
                            }
                        if (!all)
                            break;
                    }
                    if (checked + d == n)
                        result = d;
                }
            }
            d++;
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
