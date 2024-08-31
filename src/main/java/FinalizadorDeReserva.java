public class FinalizadorDeReserva {
    public static void finalizar(Livro livro, Usuario usuario){
        usuario.finalizarReserva(livro);
        livro.finalizarReserva(usuario);
    }
}
