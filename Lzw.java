import java.util.Scanner;

class Dicionario {
  public String[] table;

  public Dicionario() {
    table = new String[256];

    int i;
    for (i = 0; i < table.length; i++)
      table[i] = null;
  }

  public boolean exists(char c) {
    int i;
    boolean found = false;

    for (i = 0; i < table.length; i++) {
      if (table[i] != null && table[i].charAt(0) == c) {
        found = true;
      }
    }

    return found;
  }

  public int pos(char c) {
    int i = 0;

    for (i = 0; i < table.length; i++) {
      if (table[i] != null && table[i].charAt(0) == c) {
        break;
      }
    }

    return i;
  }

  public void preencherTabela(String str) {
    int index = 0;
    for (int i = 0; i < str.length(); i++) {
      if (table[index] == null && !exists(str.charAt(i))) {
        table[index] = str.charAt(i) + "";
        index++;
      }
    }
  }

  public void printarTabela() {
    int i;
    for (i = 0; i < table.length; i++) {
      if (table[i] != null) {
        System.out.println(i + " " + table[i]);
      }
    }
  }

  public boolean search(char c) {
    boolean found = false;
    int i;
    for (i = 0; i < table.length; i++) {
      if (table[i] != null && table[i].equals(c + "")) {
        found = true;
      }
    }

    return found;
  }

  public void aux(String aux) {
    int i;
    System.out.println();
    for (i = 0; i < aux.length(); i++) {
      if (search(aux.charAt(i))) {
        String binario = Integer.toBinaryString(pos(aux.charAt(i)));
        System.out.print(binario + " ");
      }
    }
    System.out.println();
  }
}

public class Lzw {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Dicionario d = new Dicionario();
    System.out.println("Digite a frase a ser comprimida: ");
    String input = sc.nextLine();
    d.preencherTabela(input);
    d.printarTabela();
    d.aux(input);

    sc.close();
  }
}
