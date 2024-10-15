public class Plano {
    // Atributos
    private static int contador;
    private int codigo;
    public String nome;
    public double valor;
    public Aluno alunoCadastrado;
    public Colaborador colaboradorCadastrado;

    // Construtor
    public Plano() {
        this.nome = "Não Cadastrado";
        this.valor = -1;
        contador++;
        this.codigo = contador;
    }

    // Métodos
    public void exibirDados() {
        if (this.nome == "Não Cadastrado" && this.valor < 0) {
            System.out.println("\nPlano ainda não foi cadastrado");
        } else {
            System.out.println("\n===== INFORMAÇÕES DO PLANO =====");
            System.out.println("Nome do plano: " + this.nome);
            System.out.println("Valor do plano: R$" + this.valor);
            System.out.println("Código do plano: " + this.codigo);
            System.out.println("Aluno: " + this.alunoCadastrado.getNome());
            System.out.println("Código do Aluno: " + this.alunoCadastrado.getID());
            System.out.println("Colaborador: " + this.colaboradorCadastrado.getNome());
            System.out.println("Código do colaborador: " + this.colaboradorCadastrado.getID());
        }
    }

    public void cadastrarDados(String nome, double valor, Aluno aluno, Colaborador colaborador) {
        this.nome = nome;
        this.valor = valor;
        this.alunoCadastrado = aluno;
        this.colaboradorCadastrado = colaborador;
    }

    public void alterarDados(int opcaoDado, String nome, double valor, Aluno aluno, Colaborador colaborador) {
        switch (opcaoDado) {
            case 1:
                this.nome = nome;
                System.out.println("\nNome do plano alterado com sucesso para: " + this.nome);
                break;
            case 2:
                this.valor = valor;
                System.out.println("\nValor do plano alterado com sucesso para: " + this.valor);
                break;
            case 3:
                this.alunoCadastrado = aluno;
                System.out.println("\nAluno alterado com sucesso para: " + this.alunoCadastrado.getNome());
                break;
            case 4:
                this.colaboradorCadastrado = colaborador;
                System.out.println("\nColaborador alterado com sucesso para: " + this.colaboradorCadastrado.getNome());
                break;
            default:
                System.out.println("\nOpção inválida");
                break;
        }
    }

    public void atualizarValor() {
        double taxa = 0.1;
        this.valor += this.valor * taxa;
        System.out.println("\nValor atualizado para R$" + this.valor);
    }

    public void atualizarValor(double valorTaxa) {
        double taxa = valorTaxa / 100;
        this.valor += this.valor * taxa;
        System.out.println("\nValor atualizado para R$" + this.valor);
    }

    // Getters e Setters
    public int getID() {
        return this.codigo;
    }

    public int getContagem() {
        return contador;
    }
}