package helper.controller;

import helper.model.JavaFile;

public interface Controller {
    /**
     * This method should be invoked when user has inputted all data
     * for creating and have requested it.
     * @return dialog window which informates a user
     * about successful creation or about error.
     */
    void creatingRequested(JavaFile javaFile);
}
