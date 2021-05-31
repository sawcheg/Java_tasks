import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class task_7 {
    public static void main(String[] args) {
        ArrayList<String> arr = ReturnStringValues(GetLineFromFile("INPUT.TXT"));
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    int i = 0;
                    char[] ch1 = o1.toCharArray();
                    char[] ch2 = o2.toCharArray();
                    while (i < o1.length()) {
                        if (ch1[i] == ch2[i])
                            i++;
                        else
                            return -Character.compare(ch1[i], ch2[i]);
                    }
                    return 0;
                } else
                    return o2.length() - o1.length();
            }
        };
        Collections.sort(arr, comparator);
        WriteResult("OUTPUT.TXT", arr.get(0));
    }

    static ArrayList<String> ReturnStringValues(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        ArrayList<String> arr = new ArrayList<String>();
        while (st.hasMoreElements())
            arr.add((String) st.nextElement());
        return arr;
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
