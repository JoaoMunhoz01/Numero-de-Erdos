/**************************************************************************
*Alunos: Gabriel Molina, João V. Munhóz.
*RGA'S: 2019-1907-003-6 , 2019-1907-056-7.
*Trabalho Pratico 1.
*Professor Phelipe Fabres.
*
* */
import java.util.Scanner;
public class ErdosMain{
    public static void main(String [] args){
        Scanner tc = new Scanner(System.in);

        for(int h = 1; h > 0; h++){

          
            int x = tc.nextInt()+1;

            if(x == 1){
                h = -1;
            }
            else{
                System.out.println("Teste "+h);
                Erdos numErd = new Erdos(x);

                for(int i = 0; i < x; i++){
                    numErd.lerAutores(tc.nextLine());               
                }
                numErd.iniNumErdos();        
                numErd.calcNumErdos();
                numErd.print();
                System.out.println(" ");
            }
        }
    }
}