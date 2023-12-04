import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        boolean rodando = true;
        Grid jogador1 = null;
        Grid jogador2 = null;
        boolean grids = true;
        int escolha;
        int tamanho;
        boolean jogando = true;

        Scanner sc = new Scanner(System.in);

        try {
            do {
                System.out.println("1. INICIAR NOVO JOGO");
                System.out.println("2. SAIR");
                //validar com um while?
                escolha = sc.nextInt();

                switch (escolha) {
                    case 1:

                    int escolhaMostrarGrid;
                    //validar com um while
                    System.out.println("1 - mostrar grids");
                    System.out.println("2 - não mostrar grids");
                    escolhaMostrarGrid = sc.nextInt();
                    switch (escolhaMostrarGrid) {
                        case 1:
                            grids = true;
                            break;
                        
                        case 2:
                            grids = false;
                            break;
                        default:
                            break;
                    }
                    int escolhaTamanho;
                    do {
                        System.out.println("Tamanho do tabuleiro");
                        System.out.println("1. Tabuleiro padrão (10x10)");
                        System.out.println("2. Tabuleiro personalizado (Min.: 7x7 | Max.: 20x20)");
                        escolhaTamanho = sc.nextInt();
                        if (escolhaTamanho != 1 && escolhaTamanho != 2) {
                            System.out.println("Selecione uma opção válida");
                        }
                    } while (escolhaTamanho != 1 && escolhaTamanho != 2);
                        switch (escolhaTamanho) {
                            case 1:
                                jogador1 = new Grid(10);
                                jogador2 = new Grid(10);
                                break;
                            case 2:
                                do {
                                    System.out.println("Insira o tamanho do tabuleiro (entre 7 e 20): ");
                                    tamanho = sc.nextInt();
                                    if (tamanho < 7 || tamanho > 20) {
                                        System.out.println("Insira um tamanho válido");
                                    }
                                } while (tamanho < 7 || tamanho > 20);
                                jogador1 = new Grid(tamanho);
                                jogador2 = new Grid(tamanho);
                                break;
                            default:
                                break;
                        }
                        do {
                            System.out.println("Posicionamento dos navios do jogador 1");
                            System.out.println("1. Posicionamento aleatório");
                            System.out.println("2. Posicionamento personalizado");
                            System.out.println("3. Posicionamento intermediário");
                            escolha = sc.nextInt();
                        
                        
                            switch (escolha) {
                            case 1:
                                jogador1.gerarNaviosAleatorios();
                                break;
                            case 2:
                                posicionarNaviosPersonalizados(jogador1);
                                break;
                            case 3:
                               posicionamentoIntermediario(jogador1);
                                break;
                            default:
                                System.out.println("Selecione uma opção válida");
                                break;
                            }
                        } while (escolha < 1 || escolha > 3);
                        //mostrando grids na tela
                        if (grids) {
                            System.out.println("Tabuleiro do jogador 1:");
                            jogador1.mostrarGrid();
                        }

                        do {
                            System.out.println("Posicionamento dos navios do jogador 2");
                            System.out.println("1. Posicionamento aleatório");
                            System.out.println("2. Posicionamento personalizado");
                            System.out.println("3. Posicionamento intermediário");
                            escolha = sc.nextInt();

                        
                            switch (escolha) {
                            case 1:
                                jogador2.gerarNaviosAleatorios();
                                break;
                            case 2:
                                posicionarNaviosPersonalizados(jogador2);
                                break;
                            case 3:
                               posicionamentoIntermediario(jogador2);
                                break;
                            default:
                                System.out.println("Selecione uma opção válida");
                                break;
                        }
                        } while (escolha < 1 || escolha > 3);
                        //mostrando grid 2 na tela
                        if (grids) {
                            System.out.println("Tabuleiro do jogador 2:");
                            jogador2.mostrarGrid();
                        }
                        

                        //começando ataques
                        do {
                            //ataque do jogador 1
                            System.out.println("Coordenadas do ataque do jogador 1(x e y): ");
                            //validar com um while??????
                            int x = sc.nextInt();
                            int y = sc.nextInt();

                            jogador2.atacar(x, y);

                            //verificar
                            if (jogador2.verificar() == 4) {
                                System.out.println("Navios destruídos do jogador 2: " + jogador2.verificar());
                                System.out.println("Jogador 1 ganhou");
                                break;
                            } else {
                                System.out.println("Navios destruídos do jogador 2: " + jogador2.verificar());
                            }
                            //mostrar na tela
                            if (grids) {
                                System.out.println("Tabuleiro do jogador 2:");
                                jogador2.mostrarGrid();
                            }

                            //ataque do jogador 2
                            System.out.println("Cooderadas do ataque do jogador 2(x e y): ");
                            //validar com um while???????
                            x = sc.nextInt();
                            y = sc.nextInt();

                            jogador1.atacar(x, y);
                            //verificar
                            if (jogador1.verificar() == 4) {
                                System.out.println("Navios destruídos do jogador 1: " + jogador1.verificar());
                                System.out.println("Jogador 2 ganhou");
                                break;
                            } else {
                                System.out.println("Navios destruídos do jogador 1: " + jogador1.verificar());
                            }
                            
                            //mostrar na tela
                            if (grids) {
                                System.out.println("Tabuleiro do jogador 1:");
                                jogador1.mostrarGrid();
                            }
                        } while(true);
                        break;
                    case 2:
                        System.out.println("Programa encerrado");
                        sc.close();
                        rodando = false;
                        break;
                    default:
                        System.out.println("Selecione uma opção válida");
                        break;
                }

            } while (rodando);
        } catch (InputMismatchException e) {
            System.out.println("Entrada incorreta. O programa será encerrado.");
        } catch (NumberFormatException e) {
            System.out.println("Número inserido incorretamente. O programa será encerrado.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Pocisionamento inválido. O programa será encerrado");
        }
    }

    private static void posicionarNaviosPersonalizados(Grid jogador) {
        int direcao, posX, posY;
        Scanner sc = new Scanner(System.in);

        System.out.println("Porta aviâo | 5 celulas");

        do {
            System.out.println("Direção:");
            System.out.println("1. Vertical");
            System.out.println("2. Horizontal");
            direcao = sc.nextInt();
            if (direcao != 1 && direcao != 2) {
                System.out.println("Insira uma opção válida");
            }
        } while (direcao != 1 && direcao != 2);
       
        System.out.println("Insira posição X na tabela:");
        posX = sc.nextInt();
        System.out.println("Insira posição Y na tabela:");
        posY = sc.nextInt();
        
        jogador.gerarPortaAvioesManual(posX, posY, direcao);
        
        System.out.println("Encouraçado | 4 celulas");
    
        do {
            System.out.println("Direção:");
            System.out.println("1. Vertical");
            System.out.println("2. Horizontal");
            direcao = sc.nextInt();
            if (direcao != 1 && direcao != 2) {
                System.out.println("Insira uma opção válida");
            }
        } while (direcao != 1 && direcao != 2);

        System.out.println("Insira posição X na tabela:");
        posX = sc.nextInt();
        System.out.println("Insira posição Y na tabela:");
        posY = sc.nextInt();
        
        jogador.gerarEncouracadoManual(posX, posY, direcao);

        System.out.println("Destroyer | 3 celulas");

        do {
            System.out.println("Direção:");
            System.out.println("1. Vertical");
            System.out.println("2. Horizontal");
            direcao = sc.nextInt();
            if (direcao != 1 && direcao != 2) {
                System.out.println("Insira uma opção válida");
            }
        } while (direcao != 1 && direcao != 2);

        System.out.println("Insira posição X na tabela:");
        posX = sc.nextInt();
        System.out.println("Insira posição Y na tabela:");
        posY = sc.nextInt();

        jogador.gerarDestroyerManual(posX, posY, direcao);
        

        System.out.println("Submarino | 2 celulas");
        
        do {
            System.out.println("Direção:");
            System.out.println("1. Vertical");
            System.out.println("2. Horizontal");
            direcao = sc.nextInt();
            if (direcao != 1 && direcao != 2) {
                System.out.println("Insira uma opção válida");
            }
        } while (direcao != 1 && direcao != 2);

        System.out.println("Insira posição X na tabela:");
        posX = sc.nextInt();
        System.out.println("Insira posição Y na tabela:");
        posY = sc.nextInt();

        jogador.gerarSubmarinoManual(posX, posY, direcao);
    }

    private static void posicionamentoIntermediario(Grid jogador){
        int direcao, posX, posY, escolha;
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha a frota");
        System.out.println("1. Porta avião");
        System.out.println("2. Encouraçado");
        System.out.println("3. Destroyer");
        System.out.println("4. Submarino");
        escolha = sc.nextInt();
        switch (escolha) {
            case 1:
                System.out.println("Porta aviâo | 5 celulas");

                do {
                    System.out.println("Direção:");
                    System.out.println("1. Vertical");
                    System.out.println("2. Horizontal");
                    direcao = sc.nextInt();
                    if (direcao != 1 && direcao != 2) {
                        System.out.println("Insira uma opção válida");
                    }
                } while (direcao != 1 && direcao != 2);

                System.out.println("Insira posição X na tabela:");
                posX = sc.nextInt();
                System.out.println("Insira posição Y na tabela:");
                posY = sc.nextInt();
                
                jogador.gerarPortaAvioesManual(posX, posY, direcao);

                break;
            case 2:
                System.out.println("Encouraçado | 4 celulas");
        
                do {
                    System.out.println("Direção:");
                    System.out.println("1. Vertical");
                    System.out.println("2. Horizontal");
                    direcao = sc.nextInt();
                    if (direcao != 1 && direcao != 2) {
                        System.out.println("Insira uma opção válida");
                    }
                } while (direcao != 1 && direcao != 2);

                System.out.println("Insira posição X na tabela:");
                posX = sc.nextInt();
                System.out.println("Insira posição Y na tabela:");
                posY = sc.nextInt();
            
                jogador.gerarEncouracadoManual(posX, posY, direcao);
                
                break;
            case 3:
                System.out.println("Destroyer | 3 celulas");

                do {
                    System.out.println("Direção:");
                    System.out.println("1. Vertical");
                    System.out.println("2. Horizontal");
                    direcao = sc.nextInt();
                    if (direcao != 1 && direcao != 2) {
                        System.out.println("Insira uma opção válida");
                    }
                } while (direcao != 1 && direcao != 2);

                System.out.println("Insira posição X na tabela:");
                posX = sc.nextInt();
                System.out.println("Insira posição Y na tabela:");
                posY = sc.nextInt();

                jogador.gerarDestroyerManual(posX, posY, direcao);
                
                break;
            case 4:
                System.out.println("Submarino | 2 celulas");
            
                do {
                    System.out.println("Direção:");
                    System.out.println("1. Vertical");
                    System.out.println("2. Horizontal");
                    direcao = sc.nextInt();
                    if (direcao != 1 && direcao != 2) {
                        System.out.println("Insira uma opção válida");
                    }
                } while (direcao != 1 && direcao != 2);

                System.out.println("Insira posição X na tabela:");
                posX = sc.nextInt();
                System.out.println("Insira posição Y na tabela:");
                posY = sc.nextInt();

                jogador.gerarSubmarinoManual(posX, posY, direcao);
                break;
            default:
                break;
        }
        jogador.gerarIntermediario(escolha);
    }
}