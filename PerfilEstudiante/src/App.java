import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Contenedor principal
        BorderPane root = new BorderPane();

        root.setStyle("-fx-background-color: linear-gradient(to bottom right, #3df1ee, #243B55);");

        //Titulo principal de la aplicacion
        Label tituloLbl = new Label("Perfil de estudiante");

        tituloLbl.setStyle("-fx-font-size: 28px;" + "-fx-text-fill: white;");
        tituloLbl.setMaxWidth(Double.MAX_VALUE);
        tituloLbl.setAlignment(Pos.CENTER);

        //Agregar el titulo a la parte de arriba del contenedor principal
        root.setTop(tituloLbl);

        //Foto de perfil
        Circle fotoEstudiante = new Circle(30);

        fotoEstudiante.setStyle("-fx-fill: #000000;");
        fotoEstudiante.setRadius(45);

        //Contenedor del formulario de llenado
        VBox formularioVBox = new VBox(12);

        formularioVBox.setPadding(new Insets(30));
        formularioVBox.setPrefSize(300, 500);
        formularioVBox.setAlignment(Pos.TOP_CENTER);

        formularioVBox.getChildren().add(0, fotoEstudiante);

        formularioVBox.setStyle("-fx-background-color: white;" + "-fx-background-radius: 15;" + "-fx-border-radius: 15;");

        //Nombres de los campos del formulario
        Label matriculaLbl = new Label("Matrícula");
        Label nombreLbl = new Label("Nombre");
        Label carreraLbl = new Label("Carrera");
        Label correoLbl = new Label("Correo");
        Label telefonoLbl = new Label("Teléfono");
        Label direccionLbl = new Label("Dirección");

        matriculaLbl.setStyle("-fx-font-size: 16px");
        nombreLbl.setStyle(matriculaLbl.getStyle());
        carreraLbl.setStyle(matriculaLbl.getStyle());
        correoLbl.setStyle(matriculaLbl.getStyle());
        telefonoLbl.setStyle(matriculaLbl.getStyle());
        direccionLbl.setStyle(matriculaLbl.getStyle());

        //Para llenar los campos del formulario
        TextField matriculaTf = new TextField();
        TextField nombreTf = new TextField();
        TextField carreraTf = new TextField();
        TextField correoTf = new TextField();
        TextField telefonoTf = new TextField();
        TextField direccionTf = new TextField();

        matriculaTf.setPrefSize(240, 35);
        nombreTf.setPrefSize(240, 35);
        carreraTf.setPrefSize(240, 35);
        correoTf.setPrefSize(240, 35);
        telefonoTf.setPrefSize(240, 35);
        direccionTf.setPrefSize(240, 35);

        //Texto para "guiar" dentro de los campos del formulario
        matriculaTf.setPromptText("1000-5958");
        nombreTf.setPromptText("Saul Fabre Fernandez");
        carreraTf.setPromptText("Ing. Sistemas");
        correoTf.setPromptText("saul_fabre@ucne.edu.do");
        telefonoTf.setPromptText("849-470-6916");
        direccionTf.setPromptText("Sector");

        matriculaTf.setStyle("-fx-prompt-text-fill: gray;");
        nombreTf.setStyle(matriculaTf.getStyle());
        carreraTf.setStyle(matriculaTf.getStyle());
        correoTf.setStyle(matriculaTf.getStyle());
        telefonoTf.setStyle(matriculaTf.getStyle());
        direccionTf.setStyle(matriculaTf.getStyle());

        //ComboBox
        ComboBox<String> semestreCb = new ComboBox<>();

        //Agrego los semestres
        semestreCb.getItems().addAll("Primer semestre", "Segundo semestre", "Tercer semestre");

        semestreCb.setPromptText("Selecciona un semestre");
        semestreCb.setStyle("-fx-background-color: white;" + "-fx-prompt-text-fill: gray;");
        semestreCb.setPrefSize(240, 35);

        //Componentes agregados al contenedor formulario
        formularioVBox.getChildren().addAll(matriculaLbl, matriculaTf, nombreLbl, nombreTf, carreraLbl, carreraTf,
            correoLbl, correoTf, telefonoLbl, telefonoTf, direccionLbl, direccionTf, semestreCb
        );

        //ListView para materias inscritas
        ListView<String> listaMaterias = new ListView<String>();

        listaMaterias.getItems().addAll("Programacion 3", "Ecuaciones Diferenciales", "Base de Datos");

        listaMaterias.setPrefSize(450, 350);

        //Area de texto para las observaciones
        TextArea areaTexto = new TextArea();
        areaTexto.setPrefSize(450, 450);
        areaTexto.setPromptText("Observaciones");

        VBox contenedorDerecho = new VBox(15);
        contenedorDerecho.setPrefSize(500, 650);
        contenedorDerecho.setAlignment(Pos.CENTER);
        contenedorDerecho.getChildren().addAll(listaMaterias, areaTexto);

        listaMaterias.setStyle("-fx-background-color: white;");

        //Contenedor Vertical
        HBox contenedorCentro = new HBox(40);
        contenedorCentro.setAlignment(Pos.CENTER);
        contenedorCentro.setPadding(new Insets(30));

        //Agrego la tabla al contenedor principal
        contenedorCentro.setMaxWidth(Double.MAX_VALUE);

        //Contenedor de botones
        HBox botones = new HBox();

        Button guardarBtn = new Button("Guardar");
        Button actualizarBtn = new Button("Editar");
        Button imprimirBtn = new Button("Eliminar");

        guardarBtn.setStyle("-fx-background-color: #8787873f; -fx-text-fill: white;" + "-fx-background-radius: 10;");
        actualizarBtn.setStyle("-fx-background-color: #8787873f; -fx-text-fill: white;" + "-fx-background-radius: 10;");
        imprimirBtn.setStyle("-fx-background-color: #8787873f; -fx-text-fill: white;" + "-fx-background-radius: 10;");
        botones.setSpacing(15);
        botones.setAlignment(Pos.CENTER);

        guardarBtn.setPrefSize(100, 40);
        actualizarBtn.setPrefSize(100, 40);
        imprimirBtn.setPrefSize(100, 40);

        //Agrego los botones a su contenedor
        botones.getChildren().addAll(guardarBtn, actualizarBtn,imprimirBtn);

        //Contenedor para mantener el formulario y los botones juntos
        VBox contenedor = new VBox(20);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setPrefSize(300, 650);
        contenedor.getChildren().addAll(formularioVBox, botones);

        contenedorCentro.getChildren().addAll(contenedor, contenedorDerecho);

        //Agrego los contenedores al contenedor principal
        root.setCenter(contenedorCentro);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Perfil de Estudiante");
        primaryStage.show();  
    }
}