/**
 * Asynchronized callback runner in Java.
 */
public class AsyncRunner extends RunnerBaseClass {
    public static void runMe() {
        final AsyncRunner asr = new AsyncRunner();
        final CallbackListener cl = new CallbackListener();

        asr.registerCallbackListener(cl);
        asr.doAsyncTask();
    }

    /**
     * Doing the Asynchronous task.
     */
    private void doAsyncTask() {
        System.out.println("1. Asynchronous task start.");

        // Same as the Sync task, except that it's running inside a thread.
        new Thread(new Runnable() {
            @Override
            // Create a new thread
            // Inside that new thread, define the run method.
            // In that run method, call the callback method.
            public void run() {
                if(m_listener != null) {
                    m_listener.onCallbackEvent("Asynchronous task called.");
                }
            }
        }).start();

        System.out.println("3. Aynchronous task end.");
    }
}
