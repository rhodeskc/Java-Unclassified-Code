/**
 * Provides the common methods to the AsyncRunner and the SyncRunner classes.
 */
public class RunnerBaseClass {
    protected CallbackListener m_listener;

    /**
     * Register the callback listener.
     * 
     * @return Whether the listener was registered.
     */
    public boolean registerCallbackListener(final CallbackListener listener) {
        if( m_listener == null) {
            m_listener = listener;
            return true;
        }

        return false;
    }
}
