import java.util.*;

public class LZWCompression {
    static Map<Integer, String> MapDecompress = new HashMap<>();
    
    public static String compress(String input) {
        Map<String, Integer> MapCompress = new HashMap<>();

        int j = 0, code = 0, x = 0;
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(!MapCompress.containsKey(String.valueOf(c))) {
                MapCompress.put(String.valueOf(c), j++);
                MapDecompress.put(x++ ,String.valueOf(c));
            }
        }

        String p = String.valueOf(input.charAt(0));
        j = 1;

        while(j < input.length()) {
            String c = String.valueOf(input.charAt(j));
            String pc = p + c;
            if(MapCompress.containsKey(String.valueOf(p+c))) {
                p = pc;
            } else {
                code = MapCompress.get(p);
                result += code + "";
                MapCompress.put(pc, MapCompress.size());
                p = String.valueOf(c);
            }
            j++;
        }

        int codeLast = MapCompress.get(p);
        result += codeLast + "";

        return result;
    }

    public static String decompress(String compressedText) {
        String result = "", s = "", c = "";
        int tmp = 0, i = 0;

        int code = Character.getNumericValue(compressedText.charAt(i));
        i++;

        s = MapDecompress.get(code);
        result += s;

        while (i < compressedText.length()) {
            code = Character.getNumericValue(compressedText.charAt(i));
            i++;

            if (!MapDecompress.containsKey(code)) {
                tmp = Character.getNumericValue(compressedText.charAt(i - 1));
                String old = MapDecompress.get(tmp);
                s = old + c;
            } else {
                s = MapDecompress.get(code);
            }

            result += s;
            c = String.valueOf(s.charAt(0));
            MapDecompress.put(MapDecompress.size(), MapDecompress.get(Character.getNumericValue(compressedText.charAt(i - 2))) + c);
        }

        return result;
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Your input: ");
        String input = sc.nextLine();
        System.out.println();
        String result = compress(input);
        
        char[] str = result.toCharArray();
        System.out.print("Compressed text: ");
        
        for(int i = 0; i < str.length; i++) 
            System.out.print(str[i] + " ");    
        System.out.println();
        
        System.out.println("Descompressed text: " + decompress(result));
    }
}
