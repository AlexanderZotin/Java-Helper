package helper.view;

public interface MainView extends Visible {
    void subscribeToListener(Listener listener);
    void showInfo(String info, int messageType);
}
