package domain.entity;

public class AlunoGraduacao extends Usuario {

    private final int diasEmprestimo = 3;

    public AlunoGraduacao(String nome, String codigoUsuario) {
        this.nome = nome;
        this.codigoUsuario = codigoUsuario;
    }


    @Override
    public void verificarPossibilidadeEmprestimo(Livro livro) {
        if (this.possuiLivroAtrasado()) {
            throw new IllegalArgumentException("O aluno não pode pegar emprestado livros tendo emprestimos atrasados.");
        }
        if (this.emprestimos.size() == 3) {
            throw new IllegalArgumentException("O aluno não pode pegar emprestado mais do que 3 livros.");
        }
        if (livro.usuarioPossuiEmprestimo(this)) {
            throw new IllegalArgumentException("O aluno não pode pegar emprestado livros que ele atualmente está em posse.");
        }
        if (livro.quantidadeExemplaresDisponiveis() >= livro.quantidadeReservas() && !livro.usuarioPossuiReserva(this)) {
            throw new IllegalArgumentException("O aluno não fez reserva para o livro em questão e a quantide de reservas é maior ou igual que a quantidade de exemplares.");
        }
    }

    @Override
    public int getDiasEmprestimo() {
        return this.diasEmprestimo;
    }

}