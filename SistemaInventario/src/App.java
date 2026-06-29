import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Contenedor principal
        BorderPane root = new BorderPane();

        root.setStyle("-fx-background-color: linear-gradient(to bottom right, #141E30, #243B55);");

        //Titulo principal de la aplicacion
        Label tituloLbl = new Label("Sistema de inventario");

        tituloLbl.setStyle("-fx-font-size: 28px;" + "-fx-text-fill: white;" + "-fx-background-color: black");
        tituloLbl.setMaxWidth(Double.MAX_VALUE);
        tituloLbl.setAlignment(Pos.CENTER);

        //Agregar el titulo a la parte de arriba del contenedor principal
        root.setTop(tituloLbl);

        //Contenedor del formulario de llenado
        VBox formularioVBox = new VBox(12);
        formularioVBox.setPadding(new Insets(30));
        formularioVBox.setMaxSize(300, 650);

        formularioVBox.setStyle("-fx-background-color: white;" + "-fx-background-radius: 15;" + "-fx-border-radius: 15;");

        //Nombres de los campos del formulario
        Label codigoProductoLbl = new Label("Código del producto");
        Label nombreProductoLbl = new Label("Nombre del producto");
        Label categoriaLbl = new Label("Categoria");
        Label precioLbl = new Label("Precio");
        Label cantidadLbl = new Label("Cantidad");
        Label proveedorLbl = new Label("Proveedor");
        Label estadolbl = new Label("Estado");

        codigoProductoLbl.setStyle("-fx-font-size: 14px");
        nombreProductoLbl.setStyle(codigoProductoLbl.getStyle());
        categoriaLbl.setStyle(codigoProductoLbl.getStyle());
        precioLbl.setStyle(codigoProductoLbl.getStyle());
        cantidadLbl.setStyle(codigoProductoLbl.getStyle());
        proveedorLbl.setStyle(codigoProductoLbl.getStyle());
        estadolbl.setStyle(codigoProductoLbl.getStyle());

        //Para llenar los campos del formulario
        TextField codigoProductoTf = new TextField();
        TextField nombreProductoTf = new TextField();
        TextField categoriaTf = new TextField();
        TextField precioTf = new TextField();
        TextField cantidadTf = new TextField();
        TextField proveedorTf = new TextField();

        codigoProductoTf.setPrefSize(240, 35);
        nombreProductoTf.setPrefSize(240, 35);
        categoriaTf.setPrefSize(240, 35);
        precioTf.setPrefSize(240, 35);
        cantidadTf.setPrefSize(240, 35);
        proveedorTf.setPrefSize(240, 35);

        //Texto para "guiar" dentro de los campos del formulario
        codigoProductoTf.setPromptText("001");
        nombreProductoTf.setPromptText("NVIDIA GeForce RTX 5090");
        categoriaTf.setPromptText("Tecnologia");
        precioTf.setPromptText("$2500");
        cantidadTf.setPromptText("100");
        proveedorTf.setPromptText("NVIDIA");

        codigoProductoTf.setStyle("-fx-prompt-text-fill: gray;");
        nombreProductoTf.setStyle(codigoProductoTf.getStyle());
        categoriaTf.setStyle(codigoProductoTf.getStyle());
        precioTf.setStyle(codigoProductoTf.getStyle());
        cantidadTf.setStyle(codigoProductoTf.getStyle());
        proveedorTf.setStyle(codigoProductoTf.getStyle());

        //ComboBox
        ComboBox<String> estadoCb = new ComboBox<>();

        //Agrego los estados
        estadoCb.getItems().addAll("Disponible", "Agotado", "Bajo inventario");

        estadoCb.setPromptText("Selecciona un estado");
        estadoCb.setStyle("-fx-background-color: white;" + "-fx-prompt-text-fill: gray;");
        estadoCb.setPrefSize(240, 35);

        //CheckBoxes
        VBox checkBoxes = new VBox(15);
        CheckBox perecederoCb = new CheckBox("Producto perecedero");
        CheckBox refrigeracionCb = new CheckBox("Requiere refrigeración");
        CheckBox importadoCb = new CheckBox("Producto importado");

        //Agrego al contenedor de CheckBoxes
        checkBoxes.getChildren().addAll(perecederoCb, refrigeracionCb, importadoCb);

        //Componentes agregados al contenedor formulario
        formularioVBox.getChildren().addAll(codigoProductoLbl, codigoProductoTf, nombreProductoLbl, nombreProductoTf, categoriaLbl, categoriaTf,
            precioLbl, precioTf, cantidadLbl, cantidadTf, proveedorLbl, proveedorTf, estadolbl, estadoCb, checkBoxes
        );

        //Tabla del inventario
        TableView<String> tablaInventario = new TableView<>();

        //Columnas del inventario
        TableColumn<String, String> codigoTc = new TableColumn<>("Código");
        TableColumn<String, String> productoTc = new TableColumn<>("Producto");
        TableColumn<String, String> categoriaTc = new TableColumn<>("Categoria");
        TableColumn<String, String> precioTc = new TableColumn<>("Precio");
        TableColumn<String, String> cantidadTc = new TableColumn<>("Cantidad");
        TableColumn<String, String> estadoTc = new TableColumn<>("Estado");

        //Las columnas a la tabla
        tablaInventario.getColumns().addAll(codigoTc, productoTc, categoriaTc, precioTc, cantidadTc, estadoTc);

        tablaInventario.setMinSize(1150, 650);
        tablaInventario.setMaxSize(1150, 650);
        tablaInventario.setStyle("-fx-background-color: white;" + "-fx-background-radius: 15;" + "-fx-border-radius: 15;");

        //Contenedor Horizontal
        HBox contenedorCentro = new HBox(20);
        contenedorCentro.setPadding(new Insets(30));

        //Agrego la tabla al contenedor principal
        contenedorCentro.setMaxWidth(Double.MAX_VALUE);

        //Contenedor de botones
        HBox botones = new HBox();

        Button guardarBtn = new Button("Guardar");
        Button editarBtn = new Button("Editar");
        Button eliminarBtn = new Button("Eliminar");
        Button buscarBtn = new Button("Buscar");

        guardarBtn.setStyle("-fx-background-color: #8787873f; -fx-text-fill: white;" + "-fx-background-radius: 10;");
        editarBtn.setStyle("-fx-background-color: #8787873f; -fx-text-fill: white;" + "-fx-background-radius: 10;");
        eliminarBtn.setStyle("-fx-background-color: #8787873f; -fx-text-fill: white;" + "-fx-background-radius: 10;");
        buscarBtn.setStyle("-fx-background-color: #8787873f; -fx-text-fill: white;" + "-fx-background-radius: 10;");
        botones.setSpacing(15);
        botones.setAlignment(Pos.CENTER);

        guardarBtn.setPrefSize(100, 40);
        editarBtn.setPrefSize(100, 40);
        eliminarBtn.setPrefSize(100, 40);
        buscarBtn.setPrefSize(100, 40);

        //Agrego los botones a su contenedor
        botones.getChildren().addAll(guardarBtn, editarBtn, eliminarBtn, buscarBtn);

        //Contenedor para mantener el formulario y los botones juntos
        VBox contenedor = new VBox(15);
        contenedor.setPrefWidth(300);
        contenedor.getChildren().addAll(formularioVBox, botones);

        contenedorCentro.getChildren().addAll(contenedor, tablaInventario);

        //Agrego los contenedores al contenedor principal
        root.setCenter(contenedorCentro);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sistema de Inventario");
        primaryStage.show();  
    }
}