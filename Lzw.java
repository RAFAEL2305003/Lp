import java.util.*;

public class Lzw {
    static Map<Integer, String> MapDecompress = new HashMap<>();
    static Map<String, Integer> MapCompress = new HashMap<>();

    public static int[] compress(String input) {
        int j = 0, code = 0, x = 0, index = 0;
	
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(!MapCompress.containsKey(String.valueOf(c))) {
                MapCompress.put(String.valueOf(c), j++);
                MapDecompress.put(x++ ,String.valueOf(c));
            }
        }

        int[] v = new int[500];

        String p = String.valueOf(input.charAt(0)); 
        j = 1;
        
        for(int i = 0; i < v.length; i++)
          v[i] = -1;

        while(j < input.length()) {
            String c = String.valueOf(input.charAt(j));
            String pc = p + c;

            if(MapCompress.containsKey(String.valueOf(p+c))) {
                p = pc;
            } else {
                code = MapCompress.get(p);
                v[index++] = code;
                MapCompress.put(pc, MapCompress.size());
                p = String.valueOf(c);
            }

            j++;
        }

        int codeLast = MapCompress.get(p);
        v[index] = codeLast;

        return v;
    }
    
    public static int posMax(int[] v) {
      int i;
      boolean aux = false;

      for(i = 0; !aux && i < v.length; i++) 
        if(v[i] == -1)
          aux = true;

      return i;
    }

    public static String decompress(int[] compressedText) {
        String result = "", s = "", c = "";
        int pos = compressedText[0], i = 1, newPos = 0, length = posMax(compressedText);
        result += MapDecompress.get(pos);
        
        while(i < length) {
          newPos = compressedText[i];
          
          if(!MapDecompress.containsKey(newPos)) {
            s = MapDecompress.get(pos);
            s = s + c;
          } else {
            s = MapDecompress.get(newPos);
          }

          if(i != length - 1) {
            result += s;
            c = s.charAt(0) + "";
            MapDecompress.put(MapDecompress.size(), MapDecompress.get(pos) + c);
            pos = newPos;
          }

          i++;
        }
        
        return result;
    }
    
    public static void showCompressedMap () {
        System.out.println("\nDictionary of compression:\n");
        List<Map.Entry<String, Integer>> list = new ArrayList<>(MapCompress.entrySet());

        list.sort(Comparator.comparing(Map.Entry::getValue));

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getValue() + ": " + entry.getKey());
        }
    }

    public static void showDecompressedMap() {
        System.out.println("\nDictionary of decompression:\n");
        for(int key : MapDecompress.keySet()) {
            System.out.println(key + ": " + MapDecompress.get(key));
        }
      }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Your input: ");
        String input = sc.nextLine();
        System.out.println();
        int[] result = compress(input);
        
        System.out.print("Compressed text: ");

        for (int i = 0; i < result.length; i++) 
          if(result[i] != -1)
            System.out.print(result[i] + " ");
         
        System.out.println("\nDescompressed text: " + decompress(result) + "\n");
        
        showCompressedMap();
        showDecompressedMap();

        sc.close();
    }
}
