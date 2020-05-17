
class CallbackListener implements OnCallbackInterface {
    /**
     * Callback method to fire when an event occurs.
     */
    @Override
    public void onCallbackEvent(String message) {
        System.out.print("2. Callback event fired.  Message: ");
        System.out.println(message);
    }
}
