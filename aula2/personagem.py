class Personagem:
    def __init__(self):
        self.nome = ""
        self.vida = 100
        self.forca = 10

    def receber_dano(self, dano):
        self.vida = self.vida - dano
        if self.vida < 0:
            self.vida = 0

    def esta_vivo(self):
        return self.vida > 0

    def ficha(self):
        print("Nome:", self.nome, "| Vida:", self.vida, "| Força:", self.forca)

    def atacar(self, alvo):
        print(self.nome, "ataca", alvo.nome)
        alvo.receber_dano(self.forca)


if __name__ == '__main__':
    heroi = Personagem()
    heroi.nome = "Heroi Link"
    heroi.vida = 100
    heroi.forca = 20

    chefe = Personagem()
    chefe.nome = "Skull Kid"
    chefe.vida = 120
    chefe.forca = 15

    print("--- FICHA INICIAL ---")
    heroi.ficha()
    chefe.ficha()

    while heroi.esta_vivo() and chefe.esta_vivo():
        heroi.atacar(chefe)
        if not chefe.esta_vivo():
            print(chefe.nome, "morreu!")
            break
            
        chefe.atacar(heroi)
        if not heroi.esta_vivo():
            print(heroi.nome, "morreu!")
            break
            
        print("--------------------")

    print("\n--- FICHA FINAL ---")
    heroi.ficha()
    chefe.ficha()
