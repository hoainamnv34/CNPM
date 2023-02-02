module View {
        requires javafx.controls;
        requires javafx.fxml;

        requires org.controlsfx.controls;
        requires org.kordamp.bootstrapfx.core;

        opens View to javafx.fxml;
        exports View;
        exports Controller;
        opens Controller to javafx.fxml;
}