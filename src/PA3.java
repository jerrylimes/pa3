import java.util.Scanner;

public class PA3 {
    public static void main(String[] args) {
        Scanner inputScan = new Scanner(System.in);
        int testCases = inputScan.nextInt();
        inputScan.nextLine();
        for (int i = 0; i < testCases; i++) {
            String line = inputScan.nextLine();
            Scanner lineScan = new Scanner(line);
            /* The total number of zombies roaming around */
            int total = lineScan.nextInt();
            /* The number of remaining zombies as requested */
            int remain = lineScan.nextInt();
            /* The number of companies providing the cleaning service */
            int comp = lineScan.nextInt();
            /* Name of companies stored in an array */
            String[] companies = new String[comp];
            /* Array of costs for removing 1 zombie */
            int[] c = new int[comp];
            /* Array of costs for removing half of a group of zombies */
            int[] d = new int[comp];
            while (lineScan.hasNextLine()) {
                String compLine = inputScan.nextLine();
                Scanner compInfo = new Scanner(compLine);
                companies[i] = compInfo.next();
                c[i] = compInfo.nextInt();
                d[i] = compInfo.nextInt();
                i++;
            }
        }
    }
}