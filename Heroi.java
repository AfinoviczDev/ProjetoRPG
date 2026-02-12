package tech.buildrun.projetoRPG;

public class Heroi extends Personagem{

    private String classe;
    private int qtdAtaqueEspecial;
    private int qtdPocaoVida;
    private String nomeAtaque;

    public Heroi(String nome, int vida, int ataque, int defesa, String classe, int qtdAtaqueEspecial, int qtdPocaoVida, String nomeAtaque) {
        super(nome, vida, ataque, defesa);
        this.classe = classe;
        this.qtdAtaqueEspecial = qtdAtaqueEspecial;
        this.qtdPocaoVida = qtdPocaoVida;
        this.nomeAtaque = nomeAtaque;
    }

    public void usarPocaoVida() {
        System.out.println("Herói usando poção de vida...");
        this.vida += 50;
        this.qtdPocaoVida--;
        System.out.println("Poções de vida no inventário do herói: " +this.qtdPocaoVida);
    }

    @Override
    public void mostrarApresentacao() {
        System.out.println(this.nome+ " (Vida: " +this.vida+ ", Ataque: " +this.ataque+ ", Defesa: " +this.defesa+ ", Especial: "
                +this.qtdAtaqueEspecial+ ", Poção de vida: " +qtdPocaoVida+ ")");
    }

    @Override
    public void usarAtaqueEspecial(Personagem alvo) {
          boolean executarJogadaEspecial =  this.executarJogadaEspecial();

          if(executarJogadaEspecial && qtdAtaqueEspecial > 0) {
              int danoEspecial = (int) (this.ataque * 0.1);
              alvo.receberDano(danoEspecial);
              this.qtdAtaqueEspecial--;
              System.out.println(this.nome+ ": Ataque especial realizado ["+this.nomeAtaque+ "] realizado!");
          } else {
              System.out.println(this.nome+ ": Arrrg! Ataque especial não realizado!");
          }
    }
}
