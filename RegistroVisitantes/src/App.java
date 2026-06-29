import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
        titulo.setMaxWidth(Double.MAX_VALUE);
        titulo.setStyle("-fx-font-size: 28px;" + "-fx-font-weight: Bold;" + "-fx-alignment: center;" + "-fx-padding: 18px;" + "-fx-text-fill: white;" + "-fx-background-color: linear-gradient(to bottom, #eef2f7, #d9e4f5);" + "-fx-background-radius: 12px;" + "-fx-border-radius: 24px;");
        root.setStyle("-fx-background-color: #eef2f7");
        root.setTop(titulo);

        GridPane formulario = new GridPane();
        formulario.add(new Label("Nombre completo"), 0, 0);
        formulario.add(new Label("Cédula"), 0, 1);
        formulario.add(new Label("Teléfono"), 0, 2);
        Label motivoVisitalbl = new Label("Motivo de visita");
        formulario.add(motivoVisitalbl, 0, 3);
        formulario.add(new Label("Persona a visitar"), 2, 0);
        formulario.add(new Label("Fecha"), 2, 1);
        formulario.add(new Label("Tipo de visitante"), 2, 2);
        formulario.add(new Label("Documento entregado"), 4, 0);

        formulario.setMaxWidth(Double.MAX_VALUE);
        formulario.setStyle("-fx-background-color: white;" + "-fx-background-radius: 12;" + "-fx-border-radius: 12;");

        ComboBox<String> tipoVisitante = new ComboBox<>();
        tipoVisitante.getItems().add("Estudiante");
        tipoVisitante.getItems().add("Padre/Madre");
        tipoVisitante.getItems().add("Suplidor");
        tipoVisitante.getItems().add("Invitado");

        formulario.add(tipoVisitante, 3, 2);

        ToggleGroup grupoDocumentoEntregado = new ToggleGroup();
        RadioButton cedulaBtn = new RadioButton("Cédula");
        RadioButton pasaporteBtn = new RadioButton("Pasaporte");
        RadioButton carnetBtn = new RadioButton("Carnet");

        cedulaBtn.setStyle("-fx-font-size:14px;");
        pasaporteBtn.setStyle("-fx-font-size:14px;");
        carnetBtn.setStyle("-fx-font-size:14px;");

        cedulaBtn.setToggleGroup(grupoDocumentoEntregado);
        pasaporteBtn.setToggleGroup(grupoDocumentoEntregado);
        carnetBtn.setToggleGroup(grupoDocumentoEntregado);

        VBox documentoEntregado = new VBox();
        documentoEntregado.getChildren().addAll(cedulaBtn, pasaporteBtn, carnetBtn);

        documentoEntregado.setSpacing(10);

        formulario.add(documentoEntregado, 4, 1);

        TextField nombre = new TextField();
        TextField cedula = new TextField();
        TextField telefono = new TextField();
        TextField motivoVisita = new TextField();
        TextField personaVisitar = new TextField();
        TextField fecha = new TextField();

        GridPane.setMargin(motivoVisita, new Insets(28, 0, 0, 0));
        GridPane.setMargin(motivoVisitalbl, new Insets(28, 0, 0, 0));

        nombre.setStyle("-fx-font-size:14px;");
        cedula.setStyle(nombre.getStyle());
        telefono.setStyle(nombre.getStyle());
        motivoVisita.setStyle(nombre.getStyle());
        personaVisitar.setStyle(nombre.getStyle());
        fecha.setStyle(nombre.getStyle());

        formulario.add(nombre, 1, 0);
        formulario.add(cedula, 1, 1);
        formulario.add(telefono, 1, 2);
        formulario.add(motivoVisita, 1, 3);
        formulario.add(personaVisitar, 3, 0);
        formulario.add(fecha, 3, 1);

        Button btnRegistrar = new Button("Registrar");
        Button btnLimpiar = new Button("Limpiar");
        Button btnCancelar = new Button("Cancelar");

        btnRegistrar.setStyle("-fx-background-color: #83838382; -fx-text-fill: white;");
        btnLimpiar.setStyle("-fx-background-color: #83838382; -fx-text-fill: white;");
        btnCancelar.setStyle("-fx-background-color: #83838382; -fx-text-fill: white;");

        HBox botones = new HBox();
        botones.getChildren().addAll(btnRegistrar, btnLimpiar, btnCancelar);
        botones.setSpacing(15);

        formulario.add(botones, 0, 8, 3, 1);
        formulario.setHgap(30);
        formulario.setVgap(15);
        formulario.setPadding(new Insets(20));

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

        tituloTabla.setStyle("-fx-font-size: px;" + "-fx-font-weight: bold;" + "-fx-padding: 18px;");
        visitantesRegistrados.setStyle("-fx-background-color: white;" + "-fx-background-radius: 12;" + "-fx-border-radius: 12;");

        visitantesRegistrados.getColumns().addAll(columnaNombre, columnaCedula, columnaTelefono, columnaMotivoVisita, columnaPersonaVisitar, columnaTipoVisitante, columnaFecha, columnaDocumento);

        VBox general = new VBox(25);
        general.getChildren().addAll(formulario, visitantesRegistrados);
        general.setAlignment(Pos.TOP_CENTER);
        general.setPadding(new Insets(20));
        root.setCenter(general);

        Scene scene = new Scene(root, 1200, 700);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Registro de visitantes");
        primaryStage.show();
    }
}
