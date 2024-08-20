
import java.util.LinkedList; // presente no arquivo
import java.util.Queue; // presente no arquivo

//ERRADO FALTOU O RETURN ALI Ó

public class B {
    public static int inverte(int num) {
    Queue<Integer> fila = new LinkedList<Integer>();
    for ( ; num > 0; ) {
        int resto = num % 10;
        num /= 10;
        fila.offer(resto);
                //<= AQUI Ó!
        }
    }
}
