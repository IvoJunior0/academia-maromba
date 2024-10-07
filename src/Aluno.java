public class Aluno {
    // Atributos
    private String nome;

    // Construtores
    public Aluno() {
        this.nome = "Auxiliar";
    }

    public Aluno(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}