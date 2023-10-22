/**
 * Fila linear
 * @author Rafael Rodrigues Oliveira
 * @version 1 10/2023
**/

@SuppressWarnings("unchecked")
class Queue<T> {
    private int firstQueue ,lastQueue, maxSize;
    private T[] queue;

    public Queue(int size) {
        queue = (T[]) new Object[size];
        maxSize = size; firstQueue = lastQueue = 0;
    }

    public void enqueue(T data) throws Exception {
        if(isFull())
            throw new Exception("Erro! A fila esta cheia!");

        queue[lastQueue] = data;
        lastQueue = (lastQueue + 1) % (maxSize + 1);
    }

    public void dequeue() throws Exception {
        if (isEmpty()) 
            throw new Exception("Erro! A fila esta vazia!");
        
        firstQueue = (firstQueue + 1) % maxSize;
    }

    public T first() throws Exception {
        if(isEmpty()) 
            throw new Exception("Erro! A fila esta vazia!");

        return queue[firstQueue];
    }

    public void showQueue() {
        for(int i = firstQueue; i != lastQueue; i = ((i + 1) % maxSize)) 
            System.out.println(queue[i]);
    }

    public boolean isFull() { return (((lastQueue + 1) % maxSize) == firstQueue); }

    public boolean isEmpty() { return (lastQueue == 0); }
}