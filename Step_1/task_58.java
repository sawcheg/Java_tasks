import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class task_58 {
    public static void main(String[] args) {
        ArrayList<String> buffer = GetArrayFromFile("INPUT.TXT");
        String result="";
        int countTable = Integer.parseInt(buffer.get(0)),curLine=1,n,m;
        while (countTable>0)
        {
            //получаем N и M
            int[] intArr = ReturnIntValues(buffer.get(curLine));
            curLine++;
            n=intArr[0];
            m=intArr[1];
            //считываем таблицу из файла
            int [][] table = new int[n][m];
            for (int i=0;i<n;i++) {
                intArr = ReturnIntValues(buffer.get(curLine));
                curLine++;
                for (int j = 0; j < m; j++)
                    table[i][j] = intArr[j];
            }
            // проверяем таблицу на наличие квадрата 2х2 с одним значением
            boolean find = false;
            for (int i=1;i<n;i++)
                for (int j = 1; j < m; j++)
                    if((table[i-1][j]==table[i][j])&&(table[i][j-1]==table[i][j])&&(table[i-1][j-1]==table[i][j]))
                    {
                        find=true;
                        break;
                    }
            // вывод результата по текущей таблице
            if (find)
                result+="NO\n";
            else
                result+="YES\n";
            countTable--;
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
