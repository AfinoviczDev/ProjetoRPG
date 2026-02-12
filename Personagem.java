package tech.buildrun.projetoRPG;

public abstract class Personagem {

    protected String nome;
    protected int vida;
    protected int ataque;
    protected int defesa;

    public Personagem(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public void atacar(Personagem alvo) {
        System.out.println(this.nome+ ": Ataque Realizado!");
        alvo.receberDano(ataque);
    }

    public void receberDano(int dano) {
        boolean podeDefender = this.executarJogadaEspecial();
        int danoReal = dano;
        if(podeDefender) {
            danoReal = dano - this.defesa;
            System.out.println(this.nome+ ": Defesa realizada!");
        }

        this.vida -= danoReal;
    }

    public boolean estaMorto() {
        return vida < 0;
    }

    public String getNome() {
        return this.nome;
    }

    public void mostrarVida() {
        System.out.println(this.nome+ " (Vida: " +this.vida+")");
    }

    public abstract void mostrarApresentacao();

    public abstract void usarAtaqueEspecial(Personagem alvo);

    protected boolean executarJogadaEspecial() {
        long  oneOrTwo = Math.round(1+ Math.random());

        if(oneOrTwo == 1) {
            return false;
        }

        return true;
    }
}
