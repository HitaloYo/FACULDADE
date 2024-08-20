import java.util.Stack; // presente no arquivo

//FUNCIONA PERFEIRAMENTE

public class A {
    public static int inverte(int num) {
    Stack<Integer> pilha = new Stack<Integer>();
    do {
        int resto = num % 10;//4, 3, 2, 1 (faz um looping e separa cada numero)
        num /= 10;  // 1234, 123, 12, 1, 0 (no zero ele só skipa!)
        pilha.push(resto); //Guarda o (4, 3, 2, 1) na pilha
        int resp = pilha.peek();
        System.out.println(pilha + " aaa " + resp);

        } while(num > 0);
    for (int i=1; ! pilha.isEmpty(); i*=10)
        num += pilha.pop() * i; // como ele soma?
        return num;
    }

    public static void main(String[] args) {
        int teste1 = inverte(1234);
        int teste2 = inverte(1000);
        System.out.println("resposta 1234: "+ teste1); //RETORNO = 4321
        System.out.println("resposta 1000: "+ teste2); //RETORNO = 1
    }
}

