/**
 * Synchronized callback runner in Java.
 */
public class SyncRunner extends RunnerBaseClass {
    public static void runMe() {
        final SyncRunner sr = new SyncRunner();
        final CallbackListener cl = new CallbackListener();

        sr.registerCallbackListener(cl);
        sr.doSynchronousTask();
    }

    /**
     * Doing the Synchronous task.
     */
    public void doSynchronousTask() {
        System.out.println("1. Synchronous task start.");

        if(m_listener != null) {
            m_listener.onCallbackEvent("Synchronous task called.");
        }

        System.out.println("3. Synchronous task end.");
    }
}
