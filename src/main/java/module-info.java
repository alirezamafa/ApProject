module shopOfProject {
    requires javafx.fxml;
    requires javafx.controls;

    exports View;
    opens View to javafx.fxml,javafx.controls;
}