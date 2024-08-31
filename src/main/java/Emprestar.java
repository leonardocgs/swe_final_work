public class Emprestar{

  Biblioteca biblioteca = Biblioteca.getInstance();
  
  public void emprestarLivro(String codigoUsuario, String codigoLivro) {
    Usuario usuario = biblioteca.buscarUsuario(codigoUsuario);
    Livro livro = biblioteca.buscarLivro(codigoLivro);

    if (livro == null){
      throw new IllegalArgumentException("Livro não encontrado.");
    }

    if (!livro.existeExemplarDisponivel()) {
      throw new IllegalArgumentException("Exemplar não disponivel.");
    }

    usuario.verificarPossibilidadeEmprestimo(livro);
    Emprestimo emprestimo = this.criarEmprestimo(livro,usuario);
    livro.adicionarEmprestimo(emprestimo);
    usuario.adicionarEmprestimo(emprestimo);

    if(livro.usuarioPossuiReserva(usuario)){
      FinalizadorDeReserva.finalizar(livro,usuario);
    }
  }
  private Emprestimo criarEmprestimo(Livro livro, Usuario usuario){

    int diasDeEmprestimo = usuario.getDiasEmprestimo();
    Exemplar exemplar = livro.getExemplarDisponivel();
    exemplar.emprestar();
    return new Emprestimo(usuario, exemplar, diasDeEmprestimo);

  }
}