package LAB2.TASK1;

public class Lecture_Demo {
    public static void main(String[] args) {
        String commandLine = "163.121.12.30";
        IPCutter cut = new IPCutter(commandLine);
        System.out.println("the output of " + commandLine + " using split is");
        int[] out = cut.doIPSplit();
        for (int i = 0; i < out.length; i++) {
            System.out.println(out[i]);

        }
        System.out.println("the output of " + commandLine + " using StringTokenizer is");
        IPCutter cutST = new IPCutter(commandLine);
        cutST.doIPSplitST();
    }
}
