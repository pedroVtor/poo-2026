public class Personagem {
    String nome;
    int vida;
    int forca;

    void receberDano(int dano) {
        vida = vida - dano;
        if (vida < 0) {
            vida = 0;
        }
    }

    boolean estaVivo() {
        return vida > 0;
    }

    void ficha() {
        System.out.println("Nome: " + nome + " | Vida: " + vida + " | Força: " + forca);
    }

    void atacar(Personagem alvo) {
        System.out.println(nome + " ataca " + alvo.nome);
        alvo.receberDano(forca);
    }

    public static void main(String[] args) {
        Personagem heroi = new Personagem();
        heroi.nome = "Heroi Link";
        heroi.vida = 100;
        heroi.forca = 20;

        Personagem chefe = new Personagem();
        chefe.nome = "Skull Kid";
        chefe.vida = 120;
        chefe.forca = 15;

        System.out.println("--- FICHA INICIAL ---");
        heroi.ficha();
        chefe.ficha();

        while (heroi.estaVivo() && chefe.estaVivo()) {
            heroi.atacar(chefe);
            if (chefe.estaVivo() == false) {
                System.out.println(chefe.nome + " morreu!");
                break;
            }

            chefe.atacar(heroi);
            if (heroi.estaVivo() == false) {
                System.out.println(heroi.nome + " morreu!");
                break;
            }
            
            System.out.println("--------------------");
        }

        System.out.println("\n--- FICHA FINAL ---");
        heroi.ficha();
        chefe.ficha();
    }
}
