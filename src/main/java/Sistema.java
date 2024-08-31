public class Sistema{
  Biblioteca biblioteca = new Biblioteca();

  public void inserirComando(String comando, String codigoUsuario, String codigoLivro){
    if(comando.equals("emp")){
      biblioteca.emprestarLivro(codigoUsuario, codigoLivro);
    }
    if(comando.equals("dev")){
      biblioteca.devolverLivro(codigoUsuario, codigoLivro);
    }
    if(comando.equals("res")){
      biblioteca.reservarLivro(codigoUsuario, codigoLivro);
    }
  }
}