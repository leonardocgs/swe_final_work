import domain.entity.Emprestimo;
import domain.entity.Livro;
import domain.entity.Usuario;

public class FinalizadorDeEmprestimo {

    public static void finalizar(Emprestimo emprestimo, Livro livro, Usuario usuario){
        livro.finalizarEmprestimo(emprestimo);
        usuario.finalizarEmprestimo(emprestimo);
        emprestimo.finalizar();
    }
}
