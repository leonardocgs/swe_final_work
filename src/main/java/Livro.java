import domain.entity.Observador;

import java.util.ArrayList;

public class Livro {
  private String titulo;
  private String codigoLivro;
  private String autor;
  private String editora;
  private int ano;
  private int edicao;
  private final ArrayList<Exemplar> exemplares = new ArrayList<>();
  private final ArrayList<Emprestimo> emprestimos = new ArrayList<>();
  private final ArrayList<Reserva> reservas = new ArrayList<>();
  private final ArrayList<Observador> observadores = new ArrayList<>();

  public Livro(String titulo, String codigoLivro, String autor, String editora, int ano, int edicao) {
    this.titulo = titulo;
    this.codigoLivro = codigoLivro;
    this.autor = autor;
    this.editora = editora;
    this.ano = ano;
    this.edicao = edicao;
  }

  public Exemplar getExemplarDisponivel(){
    return this.exemplares.stream().filter(Exemplar::isDisponivel).findFirst().orElse(null);
  }

  public boolean existeExemplarDisponivel() {
    for (Exemplar exemplar : this.exemplares) {
      if (exemplar.isDisponivel() == true) {
        return true;
      }
    }
    return false;
  }
  public int quantidadeDeReservas(){
    return this.reservas.size();
  }

  public boolean usuarioPossuiReserva(Usuario usuario){
    return this.reservas.stream().anyMatch(reserva -> reserva.getCodigoUsuario().equals(usuario.getCodigoUsuario()));
  }
  public Reserva obterReservaUsuario(Usuario usuario){
    return this.reservas.stream().filter(reserva -> reserva.getCodigoUsuario().equals(usuario.getCodigoUsuario())).findFirst().orElse(null);
  }
  public void finalizarReserva(Usuario usuario){
    Reserva reserva = this.obterReservaUsuario(usuario);
    this.reservas.remove(reserva);
  }
  public void finalizarEmprestimo(Emprestimo emprestimo){
    this.emprestimos.remove(emprestimo);
  }

  public boolean usuarioPossuiEmprestimo(Usuario usuario){
    for(Emprestimo emprestimo : this.emprestimos){
      if(emprestimo.getUsuario().equals(usuario)){
        return true;
      }
    }
    return false;
  }

  public Emprestimo buscarEmprestimo(Usuario usuario){
    for(Emprestimo emprestimo : this.emprestimos){
      if(emprestimo.getUsuario().equals(usuario)){
        return emprestimo;
      }
    }
    return null;
  }

  public Reserva buscarReserva(Usuario usuario){
    for(Reserva reserva : this.reservas){
      if(reserva.getUsuario().equals(usuario)){
        return reserva;
      }
    }
    return null;
  }
  
  public void adicionarEmprestimo(Emprestimo emprestimo) {
    this.emprestimos.add(emprestimo);
  }

  public void adicionarReserva(Reserva reserva) {
    this.reservas.add(reserva);
    if(this.quantidadeReservas() > 2){
      this.notificarObservador();
    }
  }

  public void adicionarExemplar(Exemplar exemplar) {
    this.exemplares.add(exemplar);
  }

  public void adicionarObservador(Observador observador){
    this.observadores.add(observador);
  }


  public void removerObservador(Observador observador){
    this.observadores.remove(observador);
  }

  public int quantidadeExemplaresDisponiveis() {
    int quantidade = 0;
    for (Exemplar exemplar : this.exemplares) {
      if (exemplar.isDisponivel() == true) {
        quantidade++;
      }
    }
    return quantidade;
  }

  public int quantidadeReservas() {
    return this.reservas.size();
  }

  public void notificarObservador(){
    observadores.forEach(Observador::notificarReserva);
  }

  /*
  public void usuariosComReserva(){
    for (Reserva reserva : this.reservas) {
      System.out.println("Usuario: " + reserva.getUsuario().getNome());
    }
  }

  public void dadosExemeplares(){
    for (Exemplar exemplar : this.exemplares) {
      System.out.println("\\\\\\\\\\\\");
      System.out.println("Exemplar: " + exemplar.getCodigoExemplar());
      System.out.println("Disponível: " + exemplar.isDisponivel());
      System.out.println("Emprestado: " + exemplar.isDisponivel());
      if (exemplar.isDisponivel() == false) {
        for(Emprestimo emprestimo : this.emprestimos){
          if(emprestimo.getExemplar().equals(exemplar)){
            System.out.println("Usuario detentor: " + emprestimo.getUsuario().getNome());
            System.out.println("Data do emprestimo: " + emprestimo.getDataEmprestimo());
            System.out.println("Data de devolução prevista: " + emprestimo.getDataDevolucaoPrevista());
            break;
          }
        }
      }
      System.out.println("\\\\\\\\\\\\");
    }
  }

  /*public boolean buscarReserva(Usuario usuario){
    for(Reserva reserva : this.reservas){
      if(reserva.getUsuario().equals(usuario)){
        return true;
      }
      return false;
    }
  }
  
/*public List obterReservasEmCr(){
   List<Exemplar> exemplaresEmprestados = new ArrayList();
    for(Exemplar exemplar: this.exemplares){
      if(exemplar.isEmprestado()){
        exemplaresEmprestados.add(exemplar);  
      }
    }
  return exemplaresEmprestados;
}*/

/*
  public boolean encontrarExemplar() {
    for (Exemplar exemplar : this.exemplares) {
      if (exemplar.getDisponivel() == true) {
        return true;
      }
    }
    return false;
  }*/
/*
  public Livro pegarExemplar() {
    for (Exemplar exemplar : this.exemplares) {
      if (exemplar.getDisponivel() == true) {
        exemplar.setDisonivel(false);
        return exemplar.getLivro();
      }
    }
    return null;
  }*/

  public String getTitulo() {
    return this.titulo;
  }

  public String getAutor() {
    return this.autor;
  }

  public String getCodigoLivro() {
    return this.codigoLivro;
  }

  public String getEditora() {
    return this.editora;
  }

  public int getAno() {
    return this.ano;
  }

  public int getEdicao() {
    return this.edicao;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public void setCodigoLivro(String codigoLivro) {
    this.codigoLivro = codigoLivro;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public void setEditora(String editora) {
    this.editora = editora;
  }

  public void setEdicao(int edicao) {
    this.edicao = edicao;
  }

  public Livro pegarExemplar() {
    return null;
  }
}