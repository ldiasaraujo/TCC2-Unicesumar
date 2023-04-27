import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaPortugues extends AnchorPane {
    private boolean todasPalavrasAcertadas = false;

    private boolean dolphinCorreto = false;
    private boolean birdCorreto = false;
    private boolean monkeyCorreto = false;
    private boolean whaleCorreto = false;


    private String animalDolphin = "";
    private String animalBird = "";
    private String animalMonkey = "";
    private String animalWhale = "";

    public void mostrar(Stage stage) {

        // Define o título da janela
        stage.setTitle("Português");

        // Criando as palavras em um GridPane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(50);
        gridPane.setVgap(50);
        gridPane.addRow(0, new Label("PTBR"), new Label("Bird"), new Label("Dolphin"), new Label("Monkey"));

        // Criando a imagem que será arrastada
        //ImageView imageView = new ImageView(new Image("C:\\Users\\Usuario\\IdeaProjects\\projetoArrastarSoltar\\src\\main\\resources\\com\\example\\projetoarrastarsoltar\\imagens\\dolphin.png"));
        ImageView imageDolphin = new ImageView(new Image("C:\\Users\\Usuario\\Desktop\\projeto javaFX\\arrastarSoltar\\src\\main\\resources\\com\\example\\projetoarrastarsoltar\\imagens\\dolphin.jpg"));
        ImageView imageBird = new ImageView(new Image("C:\\Users\\Usuario\\Desktop\\projeto javaFX\\arrastarSoltar\\src\\main\\resources\\com\\example\\projetoarrastarsoltar\\imagens\\bird.png"));
        ImageView imageMonkey = new ImageView(new Image("C:\\Users\\Usuario\\Desktop\\projeto javaFX\\arrastarSoltar\\src\\main\\resources\\com\\example\\projetoarrastarsoltar\\imagens\\monkey.png"));
        ImageView imageWhale = new ImageView(new Image("C:\\Users\\Usuario\\Desktop\\projeto javaFX\\arrastarSoltar\\src\\main\\resources\\com\\example\\projetoarrastarsoltar\\imagens\\whale.png"));
        

        imageDolphin.setFitWidth(50);
        imageDolphin.setFitHeight(50);

        imageBird.setFitWidth(50);
        imageBird.setFitHeight(50);

        imageMonkey.setFitWidth(50);
        imageMonkey.setFitHeight(50);

        imageWhale.setFitWidth(50);
        imageWhale.setFitHeight(50);

        //Chama o método que arrasta a imagem
        arrastarImagem(imageDolphin);
        arrastarImagem(imageBird);
        arrastarImagem(imageMonkey);
        arrastarImagem(imageWhale);

        // Botão para validar
        Button validarButton = new Button("Validar");
        validarButton.setOnAction(event -> {
            
            //Se todas as variáveis forem true, então, todasPalavrasAcertadas = true
            todasPalavrasAcertadas = dolphinCorreto && birdCorreto && monkeyCorreto && whaleCorreto;

            //se 4 imagens estão certas, palavraAcertada = true;

            if (todasPalavrasAcertadas) {
                System.out.println("Parabéns, você acertou!");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Parabéns");
                alert.setHeaderText(null);
                alert.setContentText("Você acertou! As palavras: " + " " + animalBird + ", "
                                                                         + animalDolphin + ", "
                                                                         + animalMonkey  + ", "
                                                                          + animalWhale + " estão corretas!");
                alert.showAndWait();
            } else {
                System.out.println("Ops, tente novamente.");

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ops");
                alert.setHeaderText(null);
                alert.setContentText("Ops, tente novamente.");
                alert.showAndWait();

            }
        });

        // Define a largura preferida do botão para 100 pixels
        validarButton.setPrefWidth(500);

        /* **************************** Voltar para tela principal ***************************************************************************/
         
        Button botaoVoltarTelaPrincipal = new Button("Voltar");
        botaoVoltarTelaPrincipal.setOnAction(event -> {
            // Cria uma nova instância da classe "NovaTela"
            App telaPrincipalApp = new App();

            // Exibe a nova tela
            telaPrincipalApp.start(stage);
        });
        // Define a largura preferida do botão para 100 pixels
        botaoVoltarTelaPrincipal.setPrefWidth(500);
        

        /******************************** Fim Voltar ***************************************************************************/ 


        // Adicionando os elementos em um VBox
        VBox vBox = new VBox(10, gridPane, imageDolphin, imageBird, imageMonkey, imageWhale, validarButton, botaoVoltarTelaPrincipal);
        vBox.setAlignment(Pos.CENTER);

        
        // Configurando a cena e exibindo o palco
        Scene scene = new Scene(vBox, 400, 400);

        // Cria uma nova cena com o painel de layout e tamanho de 200x100
        //Scene scene = new Scene(root, 200, 100);

        // Define a cena na janela e exibe-a
        stage.setScene(scene);
        stage.show();
    }


     /*Método para arrastar a imagem */
     public void arrastarImagem(ImageView imageView) {
        // Eventos de mouse para arrastar a imagem do Dolphin
        imageView.setOnMousePressed(event -> {
            imageView.setTranslateX(event.getSceneX() - imageView.getBoundsInParent().getMinX());
            imageView.setTranslateY(event.getSceneY() - imageView.getBoundsInParent().getMinY());
        });
        imageView.setOnMouseDragged(event -> {
            imageView.setTranslateX(event.getSceneX() - imageView.getBoundsInParent().getMinX());
            imageView.setTranslateY(event.getSceneY() - imageView.getBoundsInParent().getMinY());
        });
        imageView.setOnMouseReleased(event -> {

            //** Adao logica coordenada ************************************
            double posicaoX = imageView.getTranslateX();
            double posicaoY = imageView.getTranslateY();

            System.out.println("Posicao da imagem na tela: X=" + posicaoX + ", Y=" + posicaoY);

            //Onde estão as figuras
            boolean estahEmCimaDolphin = (posicaoX >= -80.0 && posicaoX <= 6.0) && (posicaoY >= -67.0 && posicaoY <= -16.0);
            boolean estahEmCimaBird = (posicaoX >= -132.0 && posicaoX <= -75.0) && (posicaoY >= -125.0 && posicaoY <= -98.0); //X=-132.0 a -75, Y=-125.0 a -98.0 
            boolean estahEmCimaMonkey = (posicaoX >= 25.0 && posicaoX <= 112.0) && (posicaoY >= -192.0 && posicaoY <= -135.0); //X=25.0 a 112.0, Y=-135.0 a 192.0
            boolean estahEmCimaWhale = (posicaoX >= -240.0 && posicaoX <= -143.0) && (posicaoY >= -234.0 && posicaoY <= -205.0); //X=-300.0 a -143.0, Y=-234.0 a -205

            if (estahEmCimaDolphin) { 
                System.out.println("Dolphin");
                System.out.println("Em cima do texto");
                animalDolphin = "Dolphin";
                dolphinCorreto = true;

            } else if (estahEmCimaBird){
                System.out.println("Bird");
                System.out.println("Em cima do texto");
                animalBird = "Bird";
                birdCorreto = true;

            } else if (estahEmCimaMonkey){
                System.out.println("Monkey");
                System.out.println("Em cima do texto");
                animalMonkey = "Monkey";
                monkeyCorreto = true;

            } else if (estahEmCimaWhale){
                System.out.println("Whale");
                System.out.println("Em cima do texto");
                animalWhale = "Whale";
                whaleCorreto = true;

            } else {
                System.out.println("Fora");
                todasPalavrasAcertadas = false;
            }
            
            //*******************************************
        });
     }
}
