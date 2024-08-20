import java.util.LinkedList; // presente no arquivo
import java.util.Queue; // presente no arquivo


//NÃO FAZ PORRA NENHUMA, MUITO CODIGO PRA POUCA BOSTA

public class D {
    public static int inverte(int num) {
    Queue<Integer> fila = new LinkedList<Integer>();
    while (num > 0) {
        int resto = num % 10;
        num /= 10;
        fila.offer(resto);
    }
    for (int i=1; ! fila.isEmpty(); i*=10)
        num += fila.poll() * i;
        return num;
    }
    public static void main(String[] args) {
    int teste1 = inverte(1234);
    int teste2 = inverte(1000);
    System.out.println("resposta 1234: "+ teste1);
    System.out.println("resposta 1000: "+ teste2); 
    }
}
