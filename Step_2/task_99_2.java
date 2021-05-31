import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class task_99_2 {
    public static void main(String[] args) {
        ArrayList<String> buffer = GetArrayFromFile("INPUT.TXT");
        int result = 0;
        int[] params = ReturnIntValues(buffer.get(0));
        int h = params[0], m = params[1], n = params[2];
        int curLine = 1;
        Location prince = new Location(0, 0, 0, 0), princess = new Location(0, 0, 0, 0);
        int[][][] Labyrynt = new int[h][m][n];
        //создаем массив, описывающий лабиринт
        for (int i = 0; i < h; i++) {
            for (int row = 0; row < m; row++) {
                char[] arr = buffer.get(curLine).toCharArray();
                for (int col = 0; col < n; col++) {
                    if (arr[col] == 'o')
                        Labyrynt[i][row][col] = 0;
                    else if (arr[col] == '1') {
                        Labyrynt[i][row][col] = 0;
                        prince = new Location(i, row, col, 0);
                    } else {
                        Labyrynt[i][row][col] = -1;
                        if (arr[col] == '2')
                            princess = new Location(i, row, col, 0);
                    }
                }
                curLine++;
            }
            curLine++;
        }
        Stack<Location> variants = new Stack<Location>();
        variants.push(new Location(prince.h, prince.m, prince.n, 0));
        Stack<Location> variants2 = new Stack<Location>(); //второй стек чтобы оптимизировать скорость обработки
        int new_step = 0, var = 1;
        //проход лабиринта
        while (var > 0) {
            Location p;
            if (var == 1 && variants.size() == 0) var = 2;
            else if (var == 2 && variants2.size() == 0)
                var = 1;
            if (var == 1)
                p = variants.pop();
            else
                p = variants2.pop();
            //   System.out.println(p.h+" "+p.m+" " +p.n+" "+p.step);
            if (p.h == princess.h && p.m == princess.m && p.n == princess.n) {
                result = p.step;
                break;
            } else {
                //проверяем  поэтапно все направления, добавляя в список новые точки и помечаем в массиве секунды
                if (p.h < h - 1) {
                    new_step = Labyrynt[p.h + 1][p.m][p.n];
                    if ((new_step == -1) || (new_step > p.step + 1)) {
                        Labyrynt[p.h + 1][p.m][p.n] = p.step + 1;
                        if (var == 1)
                            variants2.push(new Location(p.h + 1, p.m, p.n, p.step + 1));
                        else
                            variants.push(new Location(p.h + 1, p.m, p.n, p.step + 1));
                    }
                }
                if (p.m < m - 1) {
                    new_step = Labyrynt[p.h][p.m + 1][p.n];
                    if ((new_step == -1) || (new_step > p.step + 1)) {
                        Labyrynt[p.h][p.m + 1][p.n] = p.step + 1;
                        if (var == 1)
                            variants2.push(new Location(p.h, p.m + 1, p.n, p.step + 1));
                        else
                            variants.push(new Location(p.h, p.m + 1, p.n, p.step + 1));
                    }
                }
                if (p.m > 0) {
                    new_step = Labyrynt[p.h][p.m - 1][p.n];
                    if ((new_step == -1) || (new_step > p.step + 1)) {
                        Labyrynt[p.h][p.m - 1][p.n] = p.step + 1;
                        if (var == 1)
                            variants2.push(new Location(p.h, p.m - 1, p.n, p.step + 1));
                        else
                            variants.push(new Location(p.h, p.m - 1, p.n, p.step + 1));
                    }
                }
                if (p.n < n - 1) {
                    new_step = Labyrynt[p.h][p.m][p.n + 1];
                    if ((new_step == -1) || (new_step > p.step + 1)) {
                        Labyrynt[p.h][p.m][p.n + 1] = p.step + 1;
                        if (var == 1)
                            variants2.push(new Location(p.h, p.m, p.n + 1, p.step + 1));
                        else
                            variants.push(new Location(p.h, p.m, p.n + 1, p.step + 1));
                    }
                }
                if (p.n > 0) {
                    new_step = Labyrynt[p.h][p.m][p.n - 1];
                    if ((new_step == -1) || (new_step > p.step + 1)) {
                        Labyrynt[p.h][p.m][p.n - 1] = p.step + 1;
                        if (var == 1)
                            variants2.push(new Location(p.h, p.m, p.n - 1, p.step + 1));
                        else
                            variants.push(new Location(p.h, p.m, p.n - 1, p.step + 1));
                    }
                }
            }
        }
        WriteResult("OUTPUT.TXT", Integer.toString(result * 5));
    }

    static class Location {
        public int h = 0;
        public int m = 0;
        public int n = 0;
        public int step = 0;

        public Location(int h, int m, int n, int step) {
            this.h = h;
            this.n = n;
            this.m = m;
            this.step = step;
        }
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
