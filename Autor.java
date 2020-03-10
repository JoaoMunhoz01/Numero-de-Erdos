public class Autor{
    //VARIAVEIS;
	private String nome;
	private int numErdos;
        private char primeiraLetra;
	
    //CONSTRUTOR DA CLASS;
	public Autor(String nome){
		this.nome = nome;
		this.numErdos = 0;
	}	
    //SETTER NOME DO AUTOR;
	public void setNome(String nome){
		this.nome = nome;
	}
    //GETTER NOME DO AUTOR;
	public String getNome(){
		return this.nome;
	}
    //GETTER NUMERO DE ERDOS DO AUTOR;
	public int getNumErdos(){
		return this.numErdos;
	}
    //SETTER NUMERO DE ERDOS DO AUTOR;
    public void setNumErdos(int nE){
		this.numErdos = nE;
	}

    public char getPrimeiraLetra() {
        return primeiraLetra;
    }

    public void setPrimeiraLetra(char primeiraLetra) {
        this.primeiraLetra = primeiraLetra;
    }
    public boolean iguais(Autor a){
		if(this.getNome().equals(a.getNome())){
            return true;
        }
        return false;
    } 
}