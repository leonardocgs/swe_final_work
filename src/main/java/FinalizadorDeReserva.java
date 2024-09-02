import domain.entity.Livro;
import domain.entity.Usuario;

public class FinalizadorDeReserva {
    public static void finalizar(Livro livro, Usuario usuario){
        usuario.finalizarReserva(livro);
        livro.finalizarReserva(usuario);
    }
}
