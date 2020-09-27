
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author caiod
 */
public class parser {

    /**
     * @param args the command line arguments
     * @throws Exception
     */
    public static void Valida(char[] linha, int contador, ArrayList<Character> pilha) throws Exception {
        if ((linha[contador] == '(' || linha[contador] == '{' || linha[contador] == '[' || linha[contador] == '<'
                || linha[contador] == ')' || linha[contador] == '}' || linha[contador] == ']'
                || linha[contador] == '>')) {
            if (linha[contador] == '(' || linha[contador] == '{' || linha[contador] == '[' || linha[contador] == '<') {
                pilha.add(linha[contador]);
                if(linha.length == contador + 1){
                    System.out.println("Invalido");
                    throw new Exception();
                }
                else{
                Valida(linha, (contador + 1), pilha);
                }
            }
            if (linha[contador] == ')') {
                int ultimo = pilha.size() - 1;
                if (pilha.size() != 0) {
                    if (pilha.get(ultimo) != '(') {
                        System.out.println("Invalido");
                        throw new Exception();
                    } else if (pilha.get(ultimo) == '(') {
                        pilha.remove(ultimo);
                        if(linha.length == contador + 1){
                        }
                        else{
                        Valida(linha, (contador + 1), pilha);
                        }
                    }
                }else {
                    System.out.println("Invalido");
                    throw new Exception();
                }
            }
            if (linha[contador] == '}') {
                if (pilha.size() != 0) {
                    int ultimo = pilha.size() - 1;
                    if (pilha.get(ultimo) != '{') {
                        System.out.println("Invalido");
                        throw new Exception();
                    } else if (pilha.get(ultimo) == '{') {
                        pilha.remove(ultimo);
                    }
                    if(linha.length == contador + 1){
                    }
                    else{
                    Valida(linha, (contador + 1), pilha);
                    }
                }else {
                    System.out.println("Invalido");
                    throw new Exception();
                }
            }
            if (linha[contador] == ']') {
                if (pilha.size() != 0) {
                    int ultimo = pilha.size() - 1;
                    if (pilha.get(ultimo) != '[') {
                        System.out.println("Invalido");
                        throw new Exception();
                    } else if (pilha.get(ultimo) == '[') {
                        pilha.remove(ultimo);
                    }
                    if(linha.length == contador + 1){
                    }
                    else{
                    Valida(linha, (contador + 1), pilha);
                    }
                }else {
                    System.out.println("Invalido");
                    throw new Exception();
                }
            }
            if (linha[contador] == '>') {
                if (pilha.size() != 0) {
                    int ultimo = pilha.size() - 1;
                    if (pilha.get(ultimo) != '<') {
                        System.out.println("Invalido");
                        throw new Exception();
                    } else if (pilha.get(ultimo) == '<') {
                        pilha.remove(ultimo);
                    }
                    if(linha.length == contador + 1){
                    }
                    else{
                    Valida(linha, (contador + 1), pilha);
                    }
                }else {
                    System.out.println("Invalido");
                    throw new Exception();
                }
            }
        } else {
            System.out.println("Invalido");
            throw new Exception();
        }
    }

    public static void main(String[] args) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Digite a linha para ser validada");
            String linha = scan.next();
            char[] lchar = linha.toCharArray();
            ArrayList<Character> pilha = new ArrayList<>();
            try{
            Valida(lchar, 0, pilha);
            if (pilha.size() != 0) {
                System.out.println("Invalido");
            } else {
                System.out.println("Valido");
            }
        }catch(Exception e){
        }
        }
    }

}
