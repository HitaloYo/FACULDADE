import java.util.LinkedList; // presente no arquivo
import java.util.Queue; // presente no arquivo

public class C {
    public static int inverte(int num) {
        Queue<Integer> fila = new LinkedList<Integer>();
        do {
            int resto = num % 10; //ele não guarda o resto
            num /= 10;
            fila.offer(num); 
        } while(num > 0);
            for (int i=1; ! fila.isEmpty(); i*=10) 
            num += fila.poll() * i; //não sei como funcina
            return num;
    }
    public static void main(String[] args) {
        int teste1 = inverte(1234);
        int teste2 = inverte(1000);
        System.out.println("resposta 1234: "+ teste1); //RETORNO = 343
        System.out.println("resposta 1000: "+ teste2); //RETORNO = 300
    }
}
