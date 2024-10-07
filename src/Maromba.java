// Ivo Junior e Ana Graziele - Academia Maromba
import java.util.Scanner;

public class Maromba {
    // Instanciamento de objetos
    public static Scanner keyboard = new Scanner(System.in);

    public static Aluno aluno1 = new Aluno("Ivo");
    public static Aluno aluno2 = new Aluno("Grazi");
    public static Aluno alunoAuxiliar = new Aluno();

    public static Colaborador colaborador1 = new Colaborador("Leandro");
    public static Colaborador colaborador2 = new Colaborador("Luís");
    public static Colaborador colaboradorAuxiliar = new Colaborador();

    public static Plano plano1 = new Plano();

    // Variáveis
    public static int opcaoAluno, opcaoColaborador, opcaoDado, opcaoObjeto;
    public static double valor;
    public static String nome;
    public static boolean condicao = false;
    public static double novoValor = 0.0;
    public static String novoNome = "";

    // Método principal
    public static void main(String[] args) throws Exception {
        int opcaoMenu = 0;

        // Programa principal
        do {
            System.out.println("\n=== *MENU DE OPÇÕES DO PLANO* ===");
            System.out.println("1. - Cadastrar dados");
            System.out.println("2. - Exibir dados");
            System.out.println("3. - Alterar dados");
            System.out.println("4. - Atualizar");
            System.out.println("5. - Sair");
            System.out.println("\nOpção desejada:");

            opcaoMenu = keyboard.nextInt();

            keyboard.nextLine(); // Limpando buffer

            switch (opcaoMenu) {
                // CADASTRAR
                case 1:
                    System.out.println("\nNome do plano:");
                    nome = escolherNome();

                    System.out.println("\nValor do plano:");
                    valor = escolherValor();

                    escolherAluno(false);

                    escolherColaborador(false);

                    settarObjetosAuxiliares();

                    plano1.cadastrarDados(nome, valor, alunoAuxiliar, colaboradorAuxiliar);
                    break;

                // IMPRIMIR
                case 2:
                    plano1.exibirDados();
                    break;

                // ALTERAR
                case 3:
                    // Checando se o plano foi cadastrado
                    if (plano1.nome == "Não Cadastrado" && plano1.valor == -1) {
                        System.out.println("\nPlano ainda não foi cadastrado");
                        break;
                    }

                    // Menu de opções
                    System.out.println("\nQual dado deseja alterar?");
                    System.out.println("1. - Nome");
                    System.out.println("2. - Valor");
                    System.out.println("3. - Aluno");
                    System.out.println("4. - Colaborador");
                    opcaoDado = escolherOpcao(4);

                    // Escolhendo o novo valor
                    System.out.println("\nDeseja mudar para que valor?");
                    switch (opcaoDado) {
                        case 1: // Nome
                            keyboard.nextLine();
                            novoNome = escolherNome();
                            break;
                        case 2: // Valor
                            novoValor = escolherValor();
                            break;
                        case 3: // Aluno
                            escolherAluno(true);
                            break;
                        case 4: // Colaborador
                            escolherColaborador(true);
                            break;
                    }

                    settarObjetosAuxiliares();

                    plano1.alterarDados(opcaoDado, novoNome, novoValor, alunoAuxiliar, colaboradorAuxiliar);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("\nOpção inválida");
                    break;
            }
        } while (opcaoMenu != 5);

        System.out.println("\nObrigado por usar nosso sistema\n");
    }

    public static int escolherOpcao(int numeroDeOpcoes) {
        int opcao;
        do {
            opcao = keyboard.nextInt();

            condicao = testarValidadeDaCondicao(
                       intervaloEntre(1, numeroDeOpcoes, opcao),
                       "Opção inválida"
                       );
        } while(condicao);
        return opcao;
    }

    public static String escolherNome() {
        String nomeString;
        do {
            nomeString = keyboard.nextLine();
            condicao = testarValidadeDaCondicao(
                       nomeString.isEmpty(),
                       "Não deixe o nome em vazio"
                       );
        } while(condicao);

        return nomeString;
    }

    public static double escolherValor() {
        double valor;
        do {
            valor = keyboard.nextDouble();
            condicao = testarValidadeDaCondicao(
                       valor < 0,
             "Valores válidos são de 0 em diante"
                       );
        } while(condicao);

        return valor;
    }

    public static void escolherAluno(boolean quebrarLinha) {
        String newline = (quebrarLinha) ? "\n" : "";
        System.out.printf("\nEscolha o aluno:\n", newline);
        System.out.println("1. - Ivo");
        System.out.println("2. - Grazi");
        opcaoAluno = escolherOpcao(2);
    }

    public static void escolherColaborador(boolean quebrarLinha) {
        String newline = (quebrarLinha) ? "\n" : "";
        System.out.printf("%sEscolha o colaborador:\n", newline);
        System.out.println("1. - Leandro");
        System.out.println("2. - Luís");
        opcaoColaborador = escolherOpcao(2);
    }

    public static boolean testarValidadeDaCondicao(boolean condicao, String textoErro) {
        if (condicao) {
            System.out.printf("\n%s\n", textoErro);
            System.out.println("Por favor, digite outro valor:");
            return true;
        }
        return false;
    }

    public static void settarObjetosAuxiliares() {
        switch(opcaoAluno) {
            case 1:
                alunoAuxiliar = aluno1;
                break;
            case 2:
                alunoAuxiliar = aluno2;
                break;
        }
        switch(opcaoColaborador) {
            case 1:
                colaboradorAuxiliar = colaborador1;
                break;
            case 2:
                colaboradorAuxiliar = colaborador2;
                break;
        }
    }

    public static boolean intervaloEntre(int menorNumero, int maiorNumero, int valor) {
        if (valor < menorNumero || valor > maiorNumero) {
            return true;
        }
        return false;
    }
}