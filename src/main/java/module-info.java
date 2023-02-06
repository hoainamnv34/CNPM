module Controller {
        requires javafx.controls;
        requires javafx.fxml;

        requires org.controlsfx.controls;
        requires org.kordamp.bootstrapfx.core;

        opens Controller to javafx.fxml;
        opens Models to javafx.base;

        exports Controller;
}