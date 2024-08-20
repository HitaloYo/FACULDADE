import java.util.Stack; // presente no arquivo

public class E {
    public static int inverte(int num) {
        Stack<Integer> pilha = new Stack<Integer>();
        while(num > 0) {
            int resto = num % 10;
            num /= 10;
            pilha.push(num);
        }
        for (int i=1; ! pilha.isEmpty(); i*=10)
            num += pilha.pop() * i;
            return num;
    }
    public static void main(String[] args) {
        int teste1 = inverte(1234);
        int teste2 = inverte(1000);
        System.out.println("resposta 1234: "+ teste1); //RETORNO = 124210
        System.out.println("resposta 1000: "+ teste2); //RETORNO = 101010
    }
}
