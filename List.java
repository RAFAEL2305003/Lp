/**
 * Lista linear
 * @author Rafael Rodrigues Oliveira
 * @version 1 10/2023
**/

@SuppressWarnings("unchecked")
class List<T> {
    private int sizeList;
    private T[] list;

    public List(int size) {
        list = (T[]) new Object[size];
        sizeList = 0;
    }

    public void insertAtBeginning(T data) throws Exception {
        if(isFull()) 
            throw new Exception("Erro! A lista esta cheia!");
        
        for(int i = n; i > 0; i--) 
            list[i] = list[i-1];
        
        list[0] = data;
        sizeList++;
    }

    public void insertAtTheEnd(T data) throws Exception {
        if(isFull()) 
            throw new Exception("Erro! A lista esta cheia!");

        list[sizeList] = data;
        sizeList++;
    }

    public void insert(T data, int index) throws Exception {
        if(index >= sizeList || isFull() || index < 0) 
            throw new Exception("Erro! A lista esta cheia!");
        
        for(int i = sizeList; i > index; i--) 
            list[i] = list[i-1];
        
        list[index] = data;
        sizeList++;
    }

    public void removeAtBeginning() throws Exception {
        if(isEmpty()) 
            throw new Exception("Erro! A lista esta vazia!");

        sizeList--;
        for(int i = 0; i < sizeList; i++) 
            list[i] = list[i+1];
    }

    public void removeAtTheEnd() throws Exception {
        if(isEmpty()) 
            throw new Exception("Erro! A lista esta vazia!");

        sizeList--;
    }

    public void remove(int index) throws Exception {
        if(index >= sizeList|| isEmpty() || index < 0) 
            throw new Exception("Erro! A lista esta vazia!");
        
        sizeList--;
        for(int i = index; i < sizeList; i++) 
            list[i] = list[i+1];
    }

    public void showList() {
        for(int i = 0; i < sizeList; i++) 
            System.out.println(list[i]);
    }

    public boolean isFull() { return (sizeList >= list.length); }

    public boolean isEmpty() { return (sizeList == 0); }
}
