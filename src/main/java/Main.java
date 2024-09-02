// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("Digite um comando");
                EntradaObj entradaObj = Input.ler();
                String res = Sistema.getInstance().executar(entradaObj.getComando(), entradaObj.getParametros());
                if(res == null){
                    System.out.println("Saindo");
                    break;
                }
                System.out.println(res);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}