import java.util.ArrayList;

public abstract class Usuario {

    protected String nome;
    protected String codigoUsuario;
    protected ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    protected ArrayList<Reserva> reservas = new ArrayList<>();
    protected ArrayList<Emprestimo> emprestPerma = new ArrayList<>();
    protected ArrayList<Reserva> reserPerma = new ArrayList<>();


    public abstract void verificarPossibilidadeEmprestimo(Livro livro);


    public Emprestimo buscarEmprestimo(String codigoLivro){
        return this.emprestimos.stream().filter(emp -> emp.getCodigoUsuario().equals(codigoLivro)).findFirst().orElse(null);
    }
    public abstract int getDiasEmprestimo();
    public int quantidadeDeEmprestimosAbertos(){
        return this.emprestimos.size();
    }

    public boolean possuiLivroAtrasado() {
        return this.emprestimos.stream().anyMatch(Emprestimo::isAtrasado);
    }

    public void finalizarReserva(Livro livro) {
        Reserva reserva = livro.buscarReserva(this);
        reservas.remove(reserva);
    }
    public void adicionarEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
        this.emprestPerma.add(emprestimo);
    }
    public void adicionarReserva(Reserva reserva) {
        this.reservas.add(reserva);
        this.reserPerma.add(reserva);
    }

    public void finalizarEmprestimo(Emprestimo emprestimo){
        this.emprestimos.remove(emprestimo);
    }
    public int getQuantidadeDeReservas(){
        return this.reservas.size();
    }

    public String getNome(){
        return this.nome;
    }

    public String getCodigoUsuario(){
        return this.codigoUsuario;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCodigoUsuario(String codigoUsuario){
        this.codigoUsuario = codigoUsuario;
    }
}