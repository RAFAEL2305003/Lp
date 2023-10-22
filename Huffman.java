import java.util.Scanner;

class Table {
    public int[] table;

    public Table() {
        table = new int[128];

        for (int i = 0; i < table.length; i++)
            table[i] = 0;
    }

    public void fillTable(String str) {
        for (int i = 0; i < str.length(); i++) {
            table[str.charAt(i)]++;
        }
    }
}

class Node {
    public char data;
    public int frequency;
    public Node right, left, next;

    public Node(char data, int frequency, Node right, Node left, Node next) {
        this.data = data;
        this.frequency = frequency;
        this.right = right;
        this.left = left;
        this.next = next;
    }
}

class List {
    public Node first;
    private int size;
    public String[] dictionary;

    public List() {
        this.first = null;
        this.size = 0;
        dictionary = new String[128];

        for (int i = 0; i < dictionary.length; i++)
            dictionary[i] = " ";

    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public void insertInList(List list, Node node) {
        if (isEmpty()) {
            list.first = node;
        } else if (node.frequency < list.first.frequency) {
            node.next = list.first;
            list.first = node;
        } else {
            Node tmp = list.first;

            while (tmp.next != null && tmp.frequency <= node.frequency)
                tmp = tmp.next;

            node.next = tmp.next;
            tmp.next = node;
        }
        list.size++;
    }

    public void fillList(int[] table, List list) {
        Node node;
        for (int i = 0; i < table.length; i++) {
            if (table[i] > 0) {
                node = new Node((char) i, table[i], null, null, null);
                insertInList(list, node);
            }
        }
    }

    public void show() {
        int j = 0;
        for (Node i = first; j < size; i = i.next) {
            System.out.println("Elemento: " + i.data + " & Frequencia: " + i.frequency);
            j++;
        }
    }

    public Node removeFirst(List list) throws Exception {
        if (isEmpty()) {
            throw new Exception("Erro!!!Lista vazia!");
        }

        Node tmp = list.first;
        list.first = tmp.next;
        tmp.next = null;
        list.size--;

        return tmp;
    }

    public Node assembleTree(List list) throws Exception {
        Node firsNode, secondNode, newNode;

        while (list.size > 1) {
            firsNode = removeFirst(list);
            secondNode = removeFirst(list);

            newNode = new Node(' ', firsNode.frequency + secondNode.frequency, firsNode, secondNode, null);

            insertInList(list, newNode);
        }

        return list.first;
    }

    public void showTree(Node root, int len) {
        if (root.left == null && root.right == null) {
            System.out.println("Elemento: " + root.data + " & altura: " + len);
        } else {
            showTree(root.left, len + 1);
            showTree(root.right, len + 1);
        }
    }

    public int heightTree(Node root) {
        int l, r;
        if (root == null) {
            return -1;
        } else {
            l = heightTree(root.left) + 1;
            r = heightTree(root.right) + 1;

            if (l > r)
                return l;
            else
                return r;
        }
    }

    public void dictionary(Node root, String road, int columns) {
        String l = "", r = "";

        if (root.left == null && root.right == null) {
            dictionary[(int) root.data] = road;
        } else {
            l = road;
            r = road;

            l += '0';
            r += '1';

            dictionary(root.left, l, columns);
            dictionary(root.right, r, columns);
        }
    }

    public void showDictionary() {
        for (int i = 0; i < dictionary.length; i++)
            if (dictionary[i] != " ")
                System.out.println("Code: " + i + " Char: " + (char) i + " Dictionary: " + dictionary[i]);

    }

    public String encode(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            result += dictionary[(int) str.charAt(i)];
        }

        return result;
    }

    public String decode(String encoded, Node root) {
        String result = "";
        Node tmp = root;

        for (int i = 0; i < encoded.length(); i++) {
            if (encoded.charAt(i) == '0')
                tmp = tmp.left;
            else
                tmp = tmp.right;

            if (tmp.left == null && tmp.right == null) {
                result += tmp.data;
                tmp = root;
            }
        }

        return result;
    }
}

public class Huffman {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Table t = new Table();
        List l = new List();

        String str = sc.nextLine();

        t.fillTable(str);
        l.fillList(t.table, l);
        Node tree = l.assembleTree(l);
        int c = l.heightTree(tree);
        l.dictionary(tree, "", c);
        l.showDictionary();

        String encoded = l.encode(str);
        System.out.println("Texto codificado: " + encoded);

        String decoded = l.decode(encoded, tree);
        System.out.println("Texto decodificado: " + decoded);

        sc.close();
    }
}
