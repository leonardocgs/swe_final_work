import java.util.ArrayList;
import java.util.Optional;

/*Armazenamento  e  de gerencia de regras de negocio*/
/* Cada metodo sem ser de armazenamento (sem ser buscarX) representa uma funcionalidade do sistema*/

public class Biblioteca {
  private static Biblioteca instance;

  private final ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
  private final ArrayList<Livro> livros = new ArrayList<Livro>();

  private Biblioteca(){}

  public static Biblioteca getInstance(){
    if (instance == null){
      instance = new Biblioteca();
    }
    return instance;
  }

  public Usuario buscarUsuario(String codigoUsuario) {
    return this.usuarios.stream().filter(usuario -> usuario.getCodigoUsuario().equals(codigoUsuario)).findFirst().orElse(null);
  }

  public Livro buscarLivro(String codigoLivro) {
    return this.livros.stream().filter(livro -> livro.getCodigoLivro().equals(codigoLivro)).findFirst().orElse(null);
  }

  public void adicionarUsuario(Usuario usuario) {
    this.usuarios.add(usuario);
  }

  public void adicionarLivro(Livro livro) {
    this.livros.add(livro);
  }
}
