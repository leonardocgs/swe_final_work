public class Informacoes{

  Biblioteca biblioteca = Biblioteca.getInstance();

  public void informacoesLivro(String codigoLivro) {
    Livro livro = biblioteca.buscarLivro(codigoLivro);
    System.out.println("Título: " + livro.getTitulo());
    livro.usuarioComReserva();
    int quantidade = livro.quantidadeReservas();
    System.out.println("Quantidade de reservas: " + quantidade);
    livro.dadosExeemplares(codigoLivro);
  }

  public void informacoesUsuario(Usuario usuario){
    System.out.println("Estes são os livros que estão em sua posse: ");
    
  }
}