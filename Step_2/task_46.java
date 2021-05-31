import java.io.*;

public class task_46 {
    public static void main(String[] args) {
        int n = Integer.parseInt(GetLineFromFile("INPUT.TXT"));
        String e = "2.7182818284590452353602875";
        String result = "";
        if (n == 25)
            result = e;
        else {
            char[] arr = e.toCharArray();
            int prev;
            boolean plus_one = false;
            prev = Character.getNumericValue(arr[n + 2]);
            if (prev >= 5) plus_one = true;
            for (int i = n + 1; i >= 0; i--) {
                if (i != 1) {
                    if (plus_one) {
                        prev = Character.getNumericValue(arr[i]) + 1;
                        if (prev < 10) {
                            plus_one = false;
                            result = prev + result;
                        } else
                            result = '0' + result;
                    } else result = arr[i] + result;
                } else if (n > 0)
                    result = '.' + result;
            }
        }
        WriteResult("OUTPUT.TXT", result);
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
