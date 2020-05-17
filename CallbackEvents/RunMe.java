public class RunMe {
    /**
     * Run the main simulation.  In one case the statements should print in order (synchronous)
     * In the other, the statements could print in order, but probably won't (asynchronous)
     * @param args Not used by this program.
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting simulation.");
        
        // Run the Synchronous runner.
        System.out.println(">>>> SyncRunner.runMe()");
        printHyphens(80);
        Thread.sleep(1000);
        SyncRunner.runMe();
        Thread.sleep(1000);

        // Run the Asynchronous runner.
        System.out.println();
        System.out.println(">>>> AsyncRunner.runMe()");
        printHyphens(80);
        Thread.sleep(1000);
        AsyncRunner.runMe();
        Thread.sleep(1000);
        printHyphens(80);

        System.out.println("Finished simulation.");
    }

    /**
     * Print a bunch of hyphons
     * @param n Number of hyphens to output.
     */
    private static void printHyphens(int n) {
        for(int i = 0; i < n; i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
