import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class task_175 {
    public static void main(String[] args) {
        String row = GetLineFromFile("INPUT.TXT");
        char[] chars = row.toCharArray();
        int countMin = 0;
        ArrayList<Element> clock_face = new ArrayList<Element>();
        clock_face.add(new FirstElement(Character.getNumericValue(chars[0])));
        clock_face.add(new TwoElement(Character.getNumericValue(chars[1]), clock_face.get(0)));
        clock_face.add(new Element(Character.getNumericValue(chars[3]), 5, false));
        clock_face.add(new Element(Character.getNumericValue(chars[4]), 9, false));

        boolean finish = false;
        while (!finish) {
            countMin++;
            if (clock_face.get(3).addVal(false))
                if (clock_face.get(2).addVal(false))
                    if (clock_face.get(1).addVal(false))
                        if (clock_face.get(0).addVal(false))
                            clock_face.get(1).CheckMax(clock_face.get(0).curVal);
            if (clock_face.get(3).cheked && clock_face.get(2).cheked && clock_face.get(1).cheked && clock_face.get(0).cheked)
                finish = true;
        }
        WriteResult("OUTPUT.TXT", Integer.toString(countMin));
    }

    static class Element {
        boolean[][] work;
        int curVal;
        int max;
        boolean cheked;

        public Element(int i, int max, boolean first) {
            work = new boolean[2][7];  //проверка работоспособности каждой линии (0-на вкл., 1 - на выкл)
            curVal = i;
            cheked = false;
            this.max = max;
            if (!first)
                SetVal();
        }

        void SetVal() {
            if (curVal == 0) {
                work[0][0] = true;
                work[1][1] = true;
                work[0][2] = true;
                work[0][3] = true;
                work[0][4] = true;
                work[0][5] = true;
                work[0][6] = true;
            } else if (curVal == 1) {
                work[1][0] = true;
                work[1][1] = true;
                work[1][2] = true;
                work[1][3] = true;
                work[0][4] = true;
                work[1][5] = true;
                work[0][6] = true;
            } else if (curVal == 2) {
                work[0][0] = true;
                work[0][1] = true;
                work[0][2] = true;
                work[1][3] = true;
                work[0][4] = true;
                work[0][5] = true;
                work[1][6] = true;
            } else if (curVal == 3) {
                work[0][0] = true;
                work[0][1] = true;
                work[0][2] = true;
                work[1][3] = true;
                work[0][4] = true;
                work[1][5] = true;
                work[0][6] = true;
            } else if (curVal == 4) {
                work[1][0] = true;
                work[0][1] = true;
                work[1][2] = true;
                work[0][3] = true;
                work[0][4] = true;
                work[1][5] = true;
                work[0][6] = true;
            } else if (curVal == 5) {
                work[0][0] = true;
                work[0][1] = true;
                work[0][2] = true;
                work[0][3] = true;
                work[1][4] = true;
                work[1][5] = true;
                work[0][6] = true;
            } else if (curVal == 6) {
                work[0][0] = true;
                work[0][1] = true;
                work[0][2] = true;
                work[0][3] = true;
                work[1][4] = true;
                work[0][5] = true;
                work[0][6] = true;
            } else if (curVal == 7) {
                work[0][0] = true;
                work[1][1] = true;
                work[1][2] = true;
                work[1][3] = true;
                work[0][4] = true;
                work[1][5] = true;
                work[0][6] = true;
            } else if (curVal == 8) {
                work[0][0] = true;
                work[0][1] = true;
                work[0][2] = true;
                work[0][3] = true;
                work[0][4] = true;
                work[0][5] = true;
                work[0][6] = true;
            } else if (curVal == 9) {
                work[0][0] = true;
                work[0][1] = true;
                work[0][2] = true;
                work[0][3] = true;
                work[0][4] = true;
                work[1][5] = true;
                work[0][6] = true;
            }

        }

        public boolean addVal(boolean first) {
            boolean res = false;
            if (curVal == max) {
                curVal = 0;
                res = true;
            } else
                curVal++;
            SetVal();
            if (!cheked)
                CheckWork();
            return res;
        }

        public void CheckMax(int val) {
            if (val == 2)
                max = 3;
            else
                max = 9;
        }

        public void CheckWork() {
            int count = 0;
            for (int j = 0; j < 2; j++)
                for (int i = 0; i < 7; i++)
                    if (work[j][i])
                        count++;
            if (count == 14)
                cheked = true;
        }
    }

    static class TwoElement extends Element {
        public TwoElement(int i, Element e) {
            super(i, e.curVal == 2 ? 3 : 9, false);
        }
    }

    static class FirstElement extends Element {
        public FirstElement(int i) {
            super(i, 2, true);
            work[0][curVal] = true;
        }

        @Override
        public boolean addVal(boolean first) {
            if (curVal == 2)
                curVal = 0;
            else
                curVal++;
            work[0][curVal] = true;
            CheckWork();
            return true;
        }

        @Override
        public void CheckWork() {
            if (work[0][0] && work[0][1] && work[0][2])
                cheked = true;
        }
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
