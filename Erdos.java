public class Erdos{ 
    private int flag = 0; 
    private String array[] = new String [10];
    private Autor ordem[] = new Autor [100];
    private Autor [][] autores; 
    private String frase = " ";
    private int b = 0;
    private int pErdos = 0;
    private int infinito = 1000;
    //CONSTRUTOR DA CLASS; 
    public Erdos(int nArts){
        //CRIANDO MATRIZ DE autores;
        this.b = nArts;                      
        autores = new Autor[this.b][10];
    }
    //METODO PARA LER TODOS OS AUTORES POSSIVEIS;
    public void lerAutores(String q){

        this.frase = q;
        array = frase.split(","); 
        if(this.flag < this.b){
            for(int j = 0; j < array.length; j++){
                Autor aut = new Autor(array[j]);                
                if(j == 0){
                    if(autores[flag][j] != null && autores[flag][1]==null){
                    String corrigir1 = array[j].substring(0, array[j].length()-1);
                    Autor autorA = new Autor(corrigir1);
                    autores[flag][j]=autorA;         
                    }
                    else{
                        autores[flag][j]=aut;
                    }
                }
                else if(j == array.length-1){
                    String corrigir = array[j].substring(1, array[j].length()-1);
                    Autor auto = new Autor(corrigir);
                    autores[flag][j]=auto;
                }
                else {
                    String corrigir2 = array[j].substring(1, array[j].length());
                    Autor autor = new Autor(corrigir2);
                    autores[flag][j]=autor;
                }
            }
        this.flag++;
        }
    }

    //METODO PARA INICIALIZAR O NÚMERO DE ERDOS DE CADA autores;
    public void iniNumErdos(){
        for(int i = 0; i < b;i++){
            for(int j = 0; j < 10; j++){
                if(autores[i][j]!=null){
                //ATRIBUINDO O DEVIDO VALOR A P. ERDOS;
                    if(autores[i][j].getNome().equals("P. Erdos")){
                        autores[i][j].setNumErdos(pErdos);
                    }
                    //ATRIBUINDO VALOR AOS DEMAIS autoresES;
                    else{
                        autores[i][j].setNumErdos(infinito);
                    }
                }
            }
        }
    }
    //INICIALIZANDO O CALCULO DO NÚMERO DE ERDOS DE CADA autores;
    
    public void calcNumErdos(){
        for (int k = 0; k < b; k++) {
            for (int l = 0; l < 10; l++) {
                if(autores[k][l]!=null){
                    if (autores[k][l].getNome().equals("P. Erdos")) {
                        for (int m = 0; m < 10; m++) {
                            if(autores[k][m]!=null){
                                autores[k][m].setNumErdos(1);
                                sincronizaAutor(autores[k][m]);
                            }
                        }
                    }
                }
            }
        }//fim for

        int contaMenorErdos = 1;//2, 3

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < 10; j++) {

                for (int k = 0; k < b; k++) {
                    for (int l = 0; l < 10; l++) {

                        if(autores[k][l]!=null){
                            if (autores[k][l].getNumErdos() == contaMenorErdos) {
                                for (int m = 0; m < 10; m++) {
                                    if(autores[k][m]!=null){
                                        if (autores[k][m].getNumErdos() > contaMenorErdos) {
                                        
                                            autores[k][m].setNumErdos(contaMenorErdos+1);
                                            sincronizaAutor(autores[k][m]);                                   
                                        }
                                    }
                                }           
                            } 
                        }                       
                    }
                }//fim for
              
                contaMenorErdos++;
            }
        }//fim for
    }  
    public void sincronizaAutor(Autor autor){
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < 10; j++) {
                if(autores[i][j]!=null){
                    if (autor.iguais(autores[i][j])) {
                        autores[i][j].setNumErdos(autor.getNumErdos());
                    }
                }
            }
        }
    }//fim metodo
    public void print(){
        for(int i = 0; i < this.b;i++){
            
            for(int j = 0; j < 10; j++){
                if(autores[i][j] != null){
                    System.out.print(autores[i][j].getNome()+": ");
                    if(autores[i][j].getNumErdos() < 500){
                        System.out.println(autores[i][j].getNumErdos()+" ");
                    }
                    else{
                        System.out.println("infinito ");
                    }
                }
            }
        }
    }
}