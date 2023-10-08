//IMPORTES
import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.lang.Thread;

public class Tamagoshi {
    //ATRIBUTOS
    private String nome;
    private double fome; 
    private double tedio; 
    private int idade;

    Random valorRandom = new Random();
    //GETS SETS
    /**
     * Retorna o nome definido em {@code String nome}
     * 
     * @return {@code String nome}
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define um nome a {@code String nome}
     * 
     * @param nome {@code String} 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o valor de {@code double fome}
     * 
     * @return {@code double fome}
     */
    public double getFome() {
        return fome;
    }

    /**
     * Define o valor de {@code double fome}
     * 
     * @param fome {@code double}
     */
    public void setFome(double fome) {
        this.fome = fome;
    }

    /**
     * Retorna o valor de {@code double tedio}
     * 
     * @return {@code double tedio}
     */
    public double getTedio() {
        return tedio;
    }
    
    /**
     * Define o valor de {@code double tedio}
     * 
     * @param tedio {@code double}
     */
    public void setTedio(double tedio) {
        this.tedio = tedio;
    }

    /**
     * Retorna o valor de {@code int idade}
     * 
     * @return {@code int idade}
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Define o valor de {@code int idade}
     * 
     * @param idade {@code int}
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }
    //FUNCOES
    /**
     * <p>Adiciona valor à {@code @var double tedio} dependendo do valor passado como parametro. Brincar(1) = 1^³ 
     * 
     * <p>Pausa solucão por um tempo, o tempo pausado é definido acordo com o {@code valor int} passado em minutos.
     * Brincar(1) = 1 minuto.
     * 
     * @param minutos {@code int}
     */
    public void Brincar(int minutos) {
        //soma o novo valor para adicionar ao double tedio
        double tedioAtual = getTedio();
        int brincadeira = minutos * 3;
        double brincar = tedioAtual + brincadeira;

        //converte {minutos} passados para milisegundos
        int tempoBrincar = minutos * 60000;
        
        //tenta efetuar uma pausa na execução junto com uma mensagem na tela
        try {
            System.out.println("║ Brincando.. ║");
            Thread.sleep(tempoBrincar); 
        } catch (InterruptedException e) {
            
        }

        //verifica se o valor passou de 100
        if(brincar > 100) {
            //se sim, iguala a 100
            brincar = 100;
        }

        //define o novo valor de double tedio
        setTedio(brincar);
    }

    /**
     * <p>Adiciona valor à {@code @var double fome} dependendo do valor passado como parametro. Alimentar(10) = +10
     * 
     * <p>Pausa solucão por um tempo, o tempo pausado é definido de acordo com o {@code valor int} passado em minutos.
     * Alimentar(1) =  1 segundos.
     * 
     * @param quantidade {@code @var int} 
     */
    public void Alimentar(int quantidade) {
        //soma o novo valor para adicionar a double fome
        double fomeAtual = getFome();
        double alimentar = fomeAtual + quantidade;

        //converte {int quantidade} passada em milisegundos 
        int tempoComer = quantidade * 1000;

        //tenta efetuar uma pausa na execução junto com uma mensagem na tela
        try {
            System.out.println("║ Comendo.. ║");
            Thread.sleep(tempoComer);
        } catch (Exception e) {
            
        }
        
        //verifica se o valor passou de 100
        if(alimentar > 100) {
            //se sim, iguala a 100
            alimentar = 100;
        }
        //define o novo valor de double fome   
        setFome(alimentar);
    }

    /**
     * <p>Soma entre {@code double fome} e {@code double tedio} e cria um novo status
     * 
     * @return {@code double humor} 
     */
    public double getHumor() {
        //soma os valores double fome e double tedio e retorna a soma 
        double humor =  getFome() + getTedio();
        return humor;
    }

    /**
     * <p>Subtrai o valor de {@code double tedio} nos valores excedidos e {@link Tamagoshi#Delay() pausa a solução}
     * 
     * @param punicao {@code double}
     */
    public void Punir(double punicao) {
        //subtrai o valor de tedio pela metade do excesso
        punicao = punicao / 2;
        double penalidade = getTedio() - punicao;

        //verifica se o valor ficou menos que 0
        if(penalidade < 0) {
            //se sim, iguala a 0
            penalidade = 0;
        }

        //define o novo valor de double tedio e exibe a mensagem na tela
        setTedio(penalidade);
        System.out.println("\n║ " + getNome() + " não gostou disso ║\n║ Menos DIVESÃO ║");

        //pausa a solução para leitura
        Delay();
    }

    /**
     * <p>Tenta pausar a solucão por '2' segundos
     */
    public void Delay() {
        //tenta efetuar uma pausa na execução
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            
        }
    }

    
    /**
     * Encerra a solução sem salvar os valores atuais
     * 
     * @return {@code String tomada}
     */
    public String Desligar() {
        //exibe uma mensagem na tela
        System.out.println("\n║ Tchau Jogador ║\n\n");

        //define um novo valor a String tomada e a retorna
        String tomada = "Desligada";
        return tomada;
    }

    /**
     * <p>Metodo construtor que inicia definindo o nome a {@code String nome} e adicionando valores aleatorios a {@code double fome}, 
     * {@code double tedio} e o valor '1' a {@code int idade}
     * 
     * @param apelidado {@code String}
     */
    public Tamagoshi(String apelidado) {
        //pre-definições no inicio da solução 
        setNome(apelidado);
        setFome(valorRandom.nextDouble(100));
        setTedio(valorRandom.nextDouble(100));
        setIdade(1);
    }

    /**
     * Funcão main/controladora de toda a solução e recebidora de informações dos metodos da classe
     * 
     * @param args array do algoritmo
     */
    public static void main(String[] args) {
        //INSTANCIAS
        Tamagoshi stmt;
        Scanner leia = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("000");
        //ATRIBUTOS MAIN
        String apelido;
        String tomada = "Ligada";
        int interacao;
        int quantidade;
        double acao;
        double multa;
        //METODOS MAIN
        
        //imprime na tela um layout para nomear e espera retorno String
        System.out.println("╔═════════════════════════════╗\n║ Dé um nome ao seu Tamagoshi ║\n");
        apelido = leia.next();
        
        //inicia o metodo construtor
        stmt = new Tamagoshi(apelido);
        
        //imprime o nome
        System.out.println("\n║ O nome dele agora é: " + stmt.getNome() + " ║");

        //verifica se a solução ainda está em atividade repetidamente
        while(tomada == "Ligada") {
            //verifica se os valores se iniciaram maiores que 100
            if(stmt.getFome() > 100) {
                //se sim, adiciona o valor 100
                stmt.setFome(100);
            }
            
            //verifica se os valores se iniciaram maiores que 100
            if(stmt.getTedio() > 100) {
                //se sim, adiciona o valor 100
                stmt.setTedio(100);
            }
            
            //imprime os status atuais
            System.out.println("\n║ STATUS DE " + stmt.getNome() + " ║\n\n" +
                               "║ FELICIDADE: " + df.format(stmt.getHumor()) + " DE 200" + "\n║------------\n" +
                               "║ FOME: " + df.format(stmt.getFome()) + "%" + "\n║------------\n" +
                               "║ DIVERTIDO: " + df.format(stmt.getTedio()) + "%" + "\n║------------\n" +
                               "║ IDADE: " + df.format(stmt.getIdade()) + "\n");
            
            //imprime as ações e espera um retorno int
            System.out.println("╔═══════════════════════════════════╗\n" + 
                               "║ QUER INTERAGIR COM SEU TAMAGOSHI? ║\n" + "╠═══════════════════════════════════╣\n" +
                               "║ Digite 1 para Alimentar           ║\n" +
                               "║ Digite 2 para Brincar             ║\n" +
                               "║ Digite 3 para Desligar            ║\n");
            interacao = leia.nextInt();

            //verifica qual acão foi selecionada
            switch (interacao) {
                case 1:
                    //atribui o valor atual de double fome
                    double fomeAtual = stmt.getFome();

                    //verifica se o valor e maior ou igual a 90, se sim
                    if(fomeAtual >= 90) {
                        //exibe uma mensagem
                        System.out.println("\n║ " + stmt.getNome() + " está de barriga cheia ║\n");

                        //pausa a solução para leitura e encerra essa ação
                        stmt.Delay();
                        break;
                    //se não, 
                    } else {
                        //exibe uma mensagem e espera um retorno int
                        System.out.println("\n║ Quanto de comida? ║\n");
                        quantidade = leia.nextInt();

                        //efetua uma soma entre o int retornado e a valor atual de double fome
                        acao = fomeAtual + quantidade;

                        //verifica se essa soma passou de 100, se sim
                        if(acao > 100) {
                            //imprime uma mensagem na tela e espera um retorno
                            System.out.println("\n║ Ele vai despedicar comida \n║ Deseja continuar?\n║\n║ 1 = \"Sim\"\n║------------\n" +
                                               "║ 2 = \"Não\"\n");
                            int resposta = leia.nextInt();

                            //verifica qual foi a resposta
                            switch (resposta) {
                                case 1:
                                    //atribui o valor excedido de 100 e faz uma chamada ao metodo Alimentar()
                                    multa = acao - 100;
                                    stmt.Alimentar(quantidade);

                                    //faz uma chamada ao metodo Punir e encerra essa ação
                                    stmt.Punir(multa);
                                    break;
                                case 2:
                                    //exibe uma mensagem na tela
                                    System.out.println("\n║ Consciente! ║");

                                    //pausa a solução para a leitura e encerra essa ação
                                    stmt.Delay();
                                    break;
                            }
                        //se não,
                        } else {
                            //faz uma chamada ao metodo Alimentar()
                            stmt.Alimentar(quantidade);
                        }
                        //encerra a sloução
                        break;
                    }

                case 2:
                    //atribiu o valor de double tedio
                    double tedioAtual = stmt.getTedio();

                    //verifica se o valor é maior ou igual a 90, se sim
                    if(tedioAtual >= 90) {
                        //exibe uma mensagem na tela
                        System.out.println("\n║ " + stmt.getNome() + " está muito entretido no momento ║\n");

                        //pausa a solução para leitura e encerra essa ação
                        stmt.Delay();
                        break;
                    //se não,
                    } else {
                        //exibe uma mensagem na tela e espera um retorno int
                        System.out.println("\n║ Brincar por quantos minutos? ║\n");
                        quantidade = leia.nextInt();

                        //multiplica o valor passado por '3' depois soma com o valor de double tedio
                        int conversao = quantidade * 3;
                        acao = stmt.getTedio() + conversao;

                        //verifica se o valor é maior que 100, se sim,
                        if(acao > 100) {
                            //imprime uma mensagem na tela e espera um retorno int
                            System.out.println("\n║ Ele ira se cansar muito \n║ Deseja continuar?\n║\n║ 1 = \"Sim\"\n║------------\n" +
                                            "║ 2 = \"Não\"\n");
                            int resposta = leia.nextInt();

                            //verifica qual foi a resposta
                            switch (resposta) {
                                case 1:
                                    //atribui o valor excedido de 100 e faz uma chamada ao metodo Brincar()
                                    multa = acao - 100;
                                    stmt.Brincar(quantidade);

                                    //faz uma chamada ao metodo Punir e encerra essa ação
                                    stmt.Punir(multa);
                                    break;
                            
                                case 2:
                                    //exibe uma mensagem na tela e encerra a ação
                                    System.out.println("║ Consciente! ║");
                                    break;
                            }
                        //se não,
                        } else {
                            //faz uma chamada ao metodo Brincar()
                            stmt.Brincar(quantidade);
                        }
                        //encerra a ação
                        break;
                    }

                case 3:
                    //faz uma chamada ao metodo Desligar() e encerra a ação
                    tomada = stmt.Desligar();
                    break;

                default:
                    //imprime uma mensagem na tela e encerra a ação
                    System.out.println("Interação não encontrada");
                    break;
            }
        }
        //encerra os retornos
        leia.close();
    }
}