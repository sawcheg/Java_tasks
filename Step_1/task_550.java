import java.io.*;

public class task_550 {
    public static void main(String[] args) {
        int day,i=Integer.parseInt(GetLineFromFile("INPUT.TXT"));
        if ((i%400==0)||(!(i%100==0)&&(i%4==0)))
            day=12;
        else
            day=13;
        String year = Integer.toString(i);
        while (year.length()<4)
            year='0'+year;

        WriteResult("OUTPUT.TXT",day+"/09/"+year);
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
