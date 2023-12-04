public class Grid {

    private int dimensao;
    private int navio;
    private int offset = 2;
    public int pontos = 0;

    private String[][] posicoes;

    public Grid(int dimensao) {
        this.dimensao = dimensao;
        this.posicoes = new String[this.dimensao + offset][this.dimensao + offset];
        this.navio = 5;

        for (int i = 0; i < this.dimensao + offset; i++) {
            for (int j = 0; j < this.dimensao + offset; j++) {
                posicoes[i][j] = "0";
            }
        }
    }

    public void mostrarGrid() {
        for (int i = 1; i <= dimensao; i++) {
            for (int j = 1; j <= dimensao; j++) {
                System.out.print(" " + this.posicoes[i][j]);
            }
            System.out.println("");
        }
    }

    public void gerarNaviosAleatorios() {

        while (navio >= 2) {
            int direcao = (int)(Math.random()*2);
            boolean deuruim = false;

            if (direcao == 0) {
                //horizontal
                int posx = (int)((Math.random() * (this.dimensao - navio)) + 1);
                int posy = (int)((Math.random() * this.dimensao) + 1);
                

                for (int i = -1; i <= navio; i++) {
                    if (this.posicoes[posy][posx + i] != "0" ||
                        this.posicoes[posy - 1][posx + i] != "0" ||
                        this.posicoes[posy + 1][posx + i] != "0") {
                        deuruim = true;
                    }
                }

                if (!deuruim) {
                    for (int i = 0; i < navio; i++) {
                        this.posicoes[posy][posx + i] = "" + navio;
                    }
                    navio--;
                }
                
            } else {
                //vertical
                int posx = (int)((Math.random() * this.dimensao) + 1);
                int posy = (int)((Math.random() * (this.dimensao - navio)) + 1);
                
                for (int i = -1; i <= navio; i++) {
                    if (this.posicoes[posy + i][posx] != "0" ||
                    this.posicoes[posy + i][posx + 1] != "0" ||
                    this.posicoes[posy + i][posx - 1] != "0") {
                        deuruim = true;
                    }
                }

                if (!deuruim) {
                    for (int i = 0; i < navio; i++) {
                        this.posicoes[posy + i][posx] = "" + navio;
                    }
                    navio--;
                }
            }
        }
    }

    public void gerarIntermediario(int escolha){
        switch (escolha) {
            case 1:
                escolha = 5;
                break;
            case 2:
                escolha = 4;
                break;
            case 3:
                escolha = 3;
                break;
            case 4:
                escolha = 2;
                break;
            default:
                break;
        }
        while (navio >= 2) {
            if (navio == escolha) {
                navio--;
                continue;
            }
            int direcao = (int)(Math.random()*2);
            boolean deuruim = false;

            if (direcao == 0) {
                //horizontal
                int posx = (int)((Math.random() * (this.dimensao - navio)) + 1);
                int posy = (int)((Math.random() * this.dimensao) + 1);
                

                for (int i = -1; i <= navio; i++) {
                    if (this.posicoes[posy][posx + i] != "0" ||
                        this.posicoes[posy - 1][posx + i] != "0" ||
                        this.posicoes[posy + 1][posx + i] != "0") {
                        deuruim = true;
                    }
                }

                if (!deuruim) {
                    for (int i = 0; i < navio; i++) {
                        this.posicoes[posy][posx + i] = "" + navio;
                    }
                    navio--;
                }
                
            } else {
                //vertical
                int posx = (int)((Math.random() * this.dimensao) + 1);
                int posy = (int)((Math.random() * (this.dimensao - navio)) + 1);
                
                for (int i = -1; i <= navio; i++) {
                    if (this.posicoes[posy + i][posx] != "0" ||
                    this.posicoes[posy + i][posx + 1] != "0" ||
                    this.posicoes[posy + i][posx - 1] != "0") {
                        deuruim = true;
                    }
                }

                if (!deuruim) {
                    for (int i = 0; i < navio; i++) {
                        this.posicoes[posy + i][posx] = "" + navio;
                    }
                    navio--;
                }
            }
        }
    }

    public void gerarSubmarinoManual(int posx, int posy, int dir) {
            boolean deuruim = false;

            if (dir == 2) {
                //horizontal

                for (int i = -1; i <= 2; i++) {
                    if (this.posicoes[posy][posx + i] != "0" ||
                        this.posicoes[posy - 1][posx + i] != "0" ||
                        this.posicoes[posy + 1][posx + i] != "0") {
                        deuruim = true;
                    }
                }

                if (!deuruim) {
                    for (int i = 0; i < 2; i++) {
                        this.posicoes[posy][posx + i] = "" + 2;
                    }
                }else {
                    System.out.println("Posição inválida");
                }
                
            } else {
                //vertical

                for (int i = -1; i <= 2; i++) {
                    if (this.posicoes[posy + i][posx] != "0" ||
                    this.posicoes[posy + i][posx + 1] != "0" ||
                    this.posicoes[posy + i][posx - 1] != "0") {
                        deuruim = true;
                    }
                }

                if (!deuruim) {
                    for (int i = 0; i < 2; i++) {
                        this.posicoes[posy + i][posx] = "" + 2;
                    }
                } else {
                    System.out.println("posição inválida");
                }
            }
    }

    public void gerarDestroyerManual(int posx, int posy, int dir) {
        boolean deuruim = false;

            if (dir == 2) {
                //horizontal

                for (int i = -1; i <= 3; i++) {
                    if (this.posicoes[posy][posx + i] != "0" ||
                        this.posicoes[posy - 1][posx + i] != "0" ||
                        this.posicoes[posy + 1][posx + i] != "0") {
                        deuruim = true;
                    }
                }

                if (!deuruim) {
                    for (int i = 0; i < 3; i++) {
                        this.posicoes[posy][posx + i] = "" + 3;
                    }
                }else {
                    System.out.println("Posição inválida");
                }
                
            } else {
                //vertical

                for (int i = -1; i <= 3; i++) {
                    if (this.posicoes[posy + i][posx] != "0" ||
                    this.posicoes[posy + i][posx + 1] != "0" ||
                    this.posicoes[posy + i][posx - 1] != "0") {
                        deuruim = true;
                    }
                }

                if (!deuruim) {
                    for (int i = 0; i < 3; i++) {
                        this.posicoes[posy + i][posx] = "" + 3;
                    }
                } else {
                    System.out.println("posição inválida");
                }
            }
    }

    public void gerarEncouracadoManual(int posx, int posy, int dir) {
        boolean deuruim = false;

            if (dir == 2) {
                //horizontal

                for (int i = -1; i <= 4; i++) {
                    if (this.posicoes[posy][posx + i] != "0" ||
                        this.posicoes[posy - 1][posx + i] != "0" ||
                        this.posicoes[posy + 1][posx + i] != "0") {
                        deuruim = true;
                    }
                }

                if (!deuruim) {
                    for (int i = 0; i < 4; i++) {
                        this.posicoes[posy][posx + i] = "" + 4;
                    }
                }else {
                    System.out.println("Posição inválida");
                }
                
            } else {
                //vertical

                for (int i = -1; i <= 4; i++) {
                    if (this.posicoes[posy + i][posx] != "0" ||
                    this.posicoes[posy + i][posx + 1] != "0" ||
                    this.posicoes[posy + i][posx - 1] != "0") {
                        deuruim = true;
                    }
                }

                if (!deuruim) {
                    for (int i = 0; i < 4; i++) {
                        this.posicoes[posy + i][posx] = "" + 4;
                    }
                } else {
                    System.out.println("posição inválida");
                }
            }
    }

    public void gerarPortaAvioesManual(int posx, int posy, int dir) {
        boolean deuruim = false;

            if (dir == 2) {
                //horizontal

                for (int i = -1; i <= 5; i++) {
                    if (this.posicoes[posy][posx + i] != "0" ||
                        this.posicoes[posy - 1][posx + i] != "0" ||
                        this.posicoes[posy + 1][posx + i] != "0") {
                        deuruim = true;
                    }
                }

                if (!deuruim) {
                    for (int i = 0; i < 5; i++) {
                        this.posicoes[posy][posx + i] = "" + 5;
                    }
                }else {
                    System.out.println("Posição inválida");
                }
                
            } else {
                //vertical

                for (int i = -1; i <= 5; i++) {
                    if (this.posicoes[posy + i][posx] != "0" ||
                    this.posicoes[posy + i][posx + 1] != "0" ||
                    this.posicoes[posy + i][posx - 1] != "0") {
                        deuruim = true;
                    }
                }

                if (!deuruim) {
                    for (int i = 0; i < 5; i++) {
                        this.posicoes[posy + i][posx] = "" + 5;
                    }
                } else {
                    System.out.println("posição inválida");
                }
            }
    }

    public boolean atacar(int posx, int posy) {
        if(this.posicoes[posy][posx] != "0") {
            System.out.println("Você acertou");
            this.posicoes[posy][posx] = "0";
            return true;
        }else{
            System.out.println("Você errou");
            return false;
        }
    }

    public int verificar() {
        int quantidadeNaviosDestruidos = 0;
        boolean submarino = false;
        boolean portaAvioes = false;
        boolean encouracado = false;
        boolean destroyer = false;

        for (int i = 1; i <= this.dimensao; i++) {
            for (int j = 1; j <= this.dimensao; j++) {
                if (posicoes[i][j].equals("2")) {
                    submarino = true;
                } else if (posicoes[i][j].equals("3")) {
                    destroyer = true;
                } else if (posicoes[i][j].equals("4")) {
                    encouracado = true;
                } else if (posicoes[i][j].equals("5")) {
                    portaAvioes = true;
                }
            }
        }

        if (!submarino) {
            quantidadeNaviosDestruidos++;
        }
        if (!destroyer) {
            quantidadeNaviosDestruidos++;
        }
        if (!encouracado) {
            quantidadeNaviosDestruidos++;
        }
        if (!portaAvioes) {
            quantidadeNaviosDestruidos++;
        }

        return quantidadeNaviosDestruidos;
    }

    public int getDimensao() {
        return dimensao;
    }

    public void setDimensao(int dimensao) {
        this.dimensao = dimensao;
    }

    public String[][] getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(String[][] posicoes) {
        this.posicoes = posicoes;
    }

    
}
