module com.example.loginmemory {
    requires javafx.controls;
    requires javafx.fxml;


    opens memory to javafx.fxml;
    exports memory;
}