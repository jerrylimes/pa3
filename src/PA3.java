import java.util.Arrays;
import java.util.Scanner;

public class PA3 {
    public static class Company {
        String name;
        int cost;

        public Company(String compName, int compCost) {
            name = compName;
            cost = compCost;
        }
    }

    /**
     * Compare and pick the approach that costs less.
     *
     * @param total
     * @param remain
     * @param oneByOneCost
     * @param halfCost
     */
    public static int decide(int total, int remain, int oneByOneCost, int halfCost) {
        if (total <= remain) {
            return 0;
        }
        int halfOfTotal = (total + 1) / 2;
        if (total - halfOfTotal < remain) {
            return oneByOneCost + decide(total - 1, remain, oneByOneCost, halfCost);
        }
        if (halfCost <= halfOfTotal * oneByOneCost) {
            return halfCost + decide(total - halfOfTotal, remain, oneByOneCost, halfCost);
        } else {
            return oneByOneCost + decide(total - 1, remain, oneByOneCost, halfCost);
        }
    }

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
            for (int j = 0; j < comp; j++) {
                String compLine = inputScan.nextLine();
                Scanner compInfo = new Scanner(compLine);
                companies[j] = compInfo.next();
                c[j] = compInfo.nextInt();
                d[j] = compInfo.nextInt();
            }
            /* testing input reading functionality */
//            System.out.println(testCases);
//            System.out.println(total);
//            System.out.println(remain);
//            System.out.println(comp);
//            for (int j = 0; j < comp; j++) {
//                System.out.println(companies[j] + " " + c[j] + " " + d[j]);
//            }
            /* test passed, TODO: implement algorithm */
            System.out.println("Case " + (i + 1));
            Company[] compWithCosts = new Company[comp];
            for (int j = 0; j < comp; j++) {
                int cost = decide(total, remain, c[j], d[j]);
                compWithCosts[j] = new Company(companies[j], cost);
            }
            Arrays.sort(compWithCosts, (a, b) -> {
                if (a.cost != b.cost) {
                    return Integer.compare(a.cost, b.cost);
                }
                /* If two companies end up having the same cost, return the one that's higher in ASCII */
                return a.name.compareTo(b.name);
            });
            for (int j = 0; j < comp; j++) {
                System.out.println(compWithCosts[j].name + " " + compWithCosts[j].cost);
            }
        }
    }
}