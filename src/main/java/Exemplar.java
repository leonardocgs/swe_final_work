public class Exemplar{
  private Livro livro;
  private String codigoExemplar;
  private boolean disponivel = true;

  public Exemplar(Livro livro, String codigoExemplar){
    this.livro = livro;
    this.codigoExemplar = codigoExemplar;
  }

  public String getCodigoExemplar(){
    return this.codigoExemplar;
  }

  public Livro getLivro(){
    return this.livro;
  }

  public void setLivro(Livro livro){
    this.livro = livro;
  }

  public boolean isDisponivel(){
    return this.disponivel;
  }

  public void setDisponivel(boolean disponivel){
    this.disponivel = disponivel;
  }
  public void emprestar(){
    this.disponivel = false;
  }

}