import jdk.vm.ci.meta.Local;

import java.time.LocalDate;

public class Emprestimo {
  private Usuario usuario;
  private Livro livro;
  private Exemplar exemplar;
  private LocalDate dataEmprestimo;
  private LocalDate previsaoEntrega;
  private LocalDate dataDevolucaoReal;
  private boolean atrasado;

  public Emprestimo(Usuario usuario, Exemplar exemplar, int diasEmprestimo){
    this.usuario = usuario;
    this.exemplar = exemplar;
    this.dataEmprestimo = LocalDate.now();
    this.previsaoEntrega = dataEmprestimo.plusDays(diasEmprestimo);
  }

  public Usuario getUsuario() {
    return this.usuario;
  }

  public Livro getLivro() {
    return this.livro;
  }

  public Exemplar getExemplar() {
    return this.exemplar;
  }

  public boolean isDevolvido() {
    return this.dataDevolucaoReal != null;
  }

  public boolean isAtrasado() {
    LocalDate hoje = LocalDate.now();
    return this.previsaoEntrega.isBefore(hoje) && !this.isDevolvido();
  }
  public void finalizar(){
    this.dataDevolucaoReal = LocalDate.now();
  }

  public LocalDate getDataEmprestimo() {
    return this.dataEmprestimo;
  }

  public LocalDate getPrevisaoEntrega() {
    return this.previsaoEntrega;
  }

  public LocalDate getDataDevolucaoReal() {
    return this.dataDevolucaoReal;
  }
  public String getCodigoUsuario (){
    return this.usuario.getCodigoUsuario();
  }
  public String getCodigoLivro(){
    return this.livro.getCodigoLivro();
  }

}