package LAB2.TASK1;

import java.util.StringTokenizer;

public class IPCutter {
    String cmdLine;

    // class constructor
    public IPCutter(String cmdLine) {
        this.cmdLine = cmdLine;
    }

    int[] doIPSplit() {
        int[] arrayOfInts = new int[4];
        // split cmdLine
        String[] splittedString = this.cmdLine.split("\\.");
        for (int i = 0; i < splittedString.length; i++) {
            arrayOfInts[i] = Integer.parseInt(splittedString[i]);
        }
        return arrayOfInts;
    }

    void doIPSplitST() {
        StringTokenizer st = new StringTokenizer(this.cmdLine, ".");
        for (int i = 0; st.hasMoreTokens(); i++) {
            System.out.println(st.nextToken());
        }
    }
}