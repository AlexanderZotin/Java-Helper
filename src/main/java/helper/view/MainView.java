package helper.view;

import helper.controller.Listener;
import lombok.NonNull;

public interface MainView extends Visible {
    void subscribeToListener(@NonNull Listener listener);
    void showMessage(String message, int messageType);
}
