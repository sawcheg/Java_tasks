import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class task_254 {
    public static void main(String[] args) {
        ArrayList<String> buffer = GetArrayFromFile("INPUT.TXT");
        String result="";
        int N = Integer.parseInt(buffer.get(0));
        int[] values = ReturnIntValues(buffer.get(1)), new_values = Arrays.copyOf(values,values.length);
        int countRequest=Integer.parseInt(buffer.get(2));
        int curLine=3;
        while (countRequest>0)
        {
            int[] req_info = ReturnIntValues(buffer.get(curLine));
            curLine++;
            for(int i=0;i<N;i++)
                if(values[i] == req_info[0])
                    new_values[i]=req_info[1];
            countRequest--;
        }
        for(int i=0;i<N;i++)
        {
            if (i>0)
                result+=' ';
            result +=new_values[i];
        }


        WriteResult("OUTPUT.TXT",result);
    }
    static int[] ReturnIntValues(String s)
    {
        StringTokenizer st = new StringTokenizer(s, " ");
        int[] intArr = new int[st.countTokens()];
        int i = 0;
        while (st.hasMoreElements()) {
            intArr[i] = Integer.parseInt((String) st.nextElement());
            i++;
        }
        return intArr;
    }

    static ArrayList<String> GetArrayFromFile(String inputFile)
    {
        String line;
        ArrayList<String> array = new ArrayList<String>();
        try
        {
            File file = new File(inputFile);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while((line = bufferedReader.readLine()) != null) {
                array.add(line);
            }
            bufferedReader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            return array;
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
