import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        BorderPane root = new BorderPane();
        Label titulo = new Label("REGISTRO DE VISITANTES");
        root.setTop(titulo);

        GridPane formulario = new GridPane();
        formulario.add(new Label("Nombre completo"), 0, 0);
        formulario.add(new Label("Cédula"), 0, 2);
        formulario.add(new Label("Teléfono"), 0, 4);
        formulario.add(new Label("Motivo de visita"), 0, 6);
        formulario.add(new Label("Persona a visitar"), 1, 0);
        formulario.add(new Label("Fecha"), 1, 2);
        formulario.add(new Label("Tipo de visitante"), 1, 4);
        formulario.add(new Label("Documento entregado"), 2, 0);

        ComboBox<String> tipoVisitante = new ComboBox<>();
        tipoVisitante.getItems().add("Estudiante");
        tipoVisitante.getItems().add("Padre/Madre");
        tipoVisitante.getItems().add("Suplidor");
        tipoVisitante.getItems().add("Invitado");

        formulario.add(tipoVisitante, 1, 5);

        ToggleGroup grupoDocumentoEntregado = new ToggleGroup();
        RadioButton cedulaBtn = new RadioButton("Cédula");
        RadioButton pasaporteBtn = new RadioButton("Pasaporte");
        RadioButton carnetBtn = new RadioButton("Carnet");
        cedulaBtn.setToggleGroup(grupoDocumentoEntregado);
        pasaporteBtn.setToggleGroup(grupoDocumentoEntregado);
        carnetBtn.setToggleGroup(grupoDocumentoEntregado);

        VBox documentoEntregado = new VBox();
        documentoEntregado.getChildren().addAll(cedulaBtn, pasaporteBtn, carnetBtn);

        formulario.add(documentoEntregado, 2, 1);

        TextField nombre = new TextField();
        TextField cedula = new TextField();
        TextField telefono = new TextField();
        TextField motivoVisita = new TextField();
        TextField personaVisitar = new TextField();
        TextField fecha = new TextField();
        formulario.add(nombre, 0, 1);
        formulario.add(cedula, 0, 3);
        formulario.add(telefono, 0, 5);
        formulario.add(motivoVisita, 0, 7);
        formulario.add(personaVisitar, 1, 1);
        formulario.add(fecha, 1, 3);

        TableView<String> visitantesRegistrados = new TableView<>();
        Label tituloTabla = new Label("VISITANTES REGISTRADOS");
        TableColumn<String, String> columnaNombre = new TableColumn<>("Nombre completo");
        TableColumn<String, String> columnaCedula = new TableColumn<>("Cédula");
        TableColumn<String, String> columnaTelefono = new TableColumn<>("Telefono");
        TableColumn<String, String> columnaMotivoVisita = new TableColumn<>("Motivo de visita");
        TableColumn<String, String> columnaPersonaVisitar = new TableColumn<>("Persona a visitar");
        TableColumn<String, String> columnaTipoVisitante = new TableColumn<>("Tipo de visitante");
        TableColumn<String, String> columnaFecha = new TableColumn<>("Fecha");
        TableColumn<String, String> columnaDocumento = new TableColumn<>("Documento");

        visitantesRegistrados.getColumns().addAll(columnaNombre, columnaCedula, columnaTelefono, columnaMotivoVisita, columnaPersonaVisitar, columnaTipoVisitante, columnaFecha, columnaDocumento);

        VBox general = new VBox();
        general.getChildren().addAll(formulario, tituloTabla, visitantesRegistrados);
        root.setCenter(general);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
