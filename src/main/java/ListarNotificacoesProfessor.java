import domain.entity.Usuario;
import domain.entity.Professor;

import java.util.ArrayList;
import java.util.List;

public class ListarNotificacoesProfessor {

    public String listar(String codigoUsuario) {
        Biblioteca biblioteca = Biblioteca.getInstance();
        Usuario usuario = biblioteca.buscarUsuario(codigoUsuario);

        if (!(usuario instanceof Professor professor)) {
            throw new IllegalArgumentException("Professor não encontrado ou código de usuário inválido.");
        }

        List<String> filaMensagens = new ArrayList<>();

        filaMensagens.add("O professor foi notificado " + professor.getQuantidadeDeNotificacoes() + " vezes sobre reservas simultâneas.");

        return String.join("\n", filaMensagens);
    }
}
