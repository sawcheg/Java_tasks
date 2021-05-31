import java.io.*;

public class task_2 {
    public static void main(String[] args) {
        int x,n,result;
        x=Integer.parseInt(GetLineFromFile("INPUT.TXT"));

        if (x==0)
            result=1;
        else {
            if (x > 0)
                n = x;
            else
                n = -x + 2;
            result = (1 + x) * n / 2;
        }

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
