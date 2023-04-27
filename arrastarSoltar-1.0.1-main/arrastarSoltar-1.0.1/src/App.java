import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Define o título da janela
        primaryStage.setTitle("Seleção de Disciplinas");

        /* **************************** Abrir tela Ingles ***************************************************************************/
         
        Button botaoAbrirIngles = new Button("Inglês");
        botaoAbrirIngles.setOnAction(event -> {
            // Cria uma nova instância da classe "NovaTela"
            TelaIngles telaIngles = new TelaIngles();

            // Exibe a nova tela
            telaIngles.mostrar(primaryStage);
        });
        // Define a largura preferida do botão para 100 pixels
        botaoAbrirIngles.setPrefWidth(500);
        

        /******************************** Fim Abrir tela Ingles ***************************************************************************/ 

        /* **************************** Abrir tela Portugues ***************************************************************************/
         
        Button botaoAbrirPortugues = new Button("Português");
        botaoAbrirPortugues.setOnAction(event -> {
            // Cria uma nova instância da classe "NovaTela"
            TelaPortugues telaPortugues = new TelaPortugues();

            // Exibe a nova tela
            telaPortugues.mostrar(primaryStage);
        });

        // Define a largura preferida do botão para 100 pixels
        botaoAbrirPortugues.setPrefWidth(500);


        /******************************** Fim tela Portugues ***************************************************************************/ 

        /* **************************** Abrir tela Geografia ***************************************************************************/
         
        Button botaoAbrirGeografia = new Button("Geografia");
        botaoAbrirGeografia.setOnAction(event -> {
            // Cria uma nova instância da classe "NovaTela"
            TelaGeografia telaGeografia = new TelaGeografia();

            // Exibe a nova tela
            telaGeografia.mostrar(primaryStage);
        });

        // Define a largura preferida do botão para 100 pixels
        botaoAbrirGeografia.setPrefWidth(500);

        /******************************** Fim tela Geografia ***************************************************************************/


        // Adicionando os elementos em um VBox
        VBox vBox = new VBox(10,botaoAbrirIngles, botaoAbrirPortugues, botaoAbrirGeografia);
        vBox.setAlignment(Pos.CENTER);


        // Configurando a cena e exibindo o palco
        Scene scene = new Scene(vBox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
