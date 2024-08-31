public class Reservar{


  public void reservarLivro(String codigoUsuario, String codigoLivro) {
    Biblioteca biblioteca = Biblioteca.getInstance();
    Usuario usuario = biblioteca.buscarUsuario(codigoUsuario);
    Livro livro = biblioteca.buscarLivro(codigoLivro);
    if (livro == null) {
      throw new IllegalArgumentException("Livro não encontrado.");
    }
    Reserva reserva =  this.criarReserva(livro,usuario);
    livro.adicionarReserva(reserva);
    usuario.adicionarReserva(reserva);
  }

  private Reserva criarReserva(Livro livro,Usuario usuario) {
    if (usuario.getQuantidadeDeReservas() >= 3) {
      throw new IllegalArgumentException("Não pode reservar mais que 3 livros.");
    }
    Reserva reserva = new Reserva(usuario, livro);
    return reserva;
  }
}