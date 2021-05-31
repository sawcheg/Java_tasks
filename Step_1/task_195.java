import java.io.*;
import java.util.StringTokenizer;

public class task_195 {
    public static void main(String[] args) {
        String buffer =GetLineFromFile("INPUT.TXT");
        StringTokenizer st = new StringTokenizer(buffer, " ");

        int[] intArr = new int[st.countTokens()];
        int i = 0;
        while (st.hasMoreElements()) {
            intArr[i] = Integer.parseInt((String) st.nextElement());
            i++;
        }
        int result = intArr[0]*intArr[1]*intArr[2]*2;

        WriteResult("OUTPUT.TXT",Integer.toString(result));
    }

    static String GetLineFromFile(String inputFile)
    {
        try
        {
            File file = new File(inputFile);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String s = bufferedReader.readLine();
            bufferedReader.close(); // закрываем поток
            return s;
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    static void WriteResult(String ExportFile,String result)
    {
        try
        {
            File file = new File(ExportFile);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(result);
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
