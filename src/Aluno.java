public class Aluno {
    // Atributos
    private static int contador;
    private int codigo;
    private String nome;

    // Construtores
    public Aluno() {
        this.nome = "Auxiliar";
        contador++;
        this.codigo = contador;
    }

    public Aluno(String nome) {
        this.nome = nome;
        contador++;
        this.codigo = contador;
    }

    // Getters e Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getID() {
        return this.codigo;
    }

    public int getContagem() {
        return contador;
    }
}