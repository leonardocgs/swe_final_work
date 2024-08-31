public class Devolver{

  Biblioteca biblioteca = Biblioteca.getInstance();

  public void devolverLivro(String codigoUsuario, String codigoLivro){
    Usuario usuario = biblioteca.buscarUsuario(codigoUsuario);
    Livro livro = biblioteca.buscarLivro(codigoLivro);
    Emprestimo emprestimo = usuario.buscarEmprestimo(livro.getCodigoLivro());
    FinalizadorDeEmprestimo.finalizar(emprestimo,livro,usuario);
  }
}