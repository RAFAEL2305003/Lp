/**
 * Pilha linear
 * @author Rafael Rodrigues Oliveira
 * @version 1 10/2023
**/

@SuppressWarnings("unchecked")
class Stack<T> {
    private int topStack, maxSize;
    private T[] stack;

    public Stack(int size) {
        stack = (T[]) new Object[size];
        maxSize = size - 1; topStack = -1;
    }

    public void push(T data) throws Exception {
        if(topStack == maxSize) 
            throw new Exception("Erro! A pilha esta cheia!");

        stack[++topStack] = data;
    }

    public void pop() throws Exception{
        if(isEmpty()) 
            throw new Exception("Erro! A pilha esta vazia!");

        topStack--;
    }

    public T top() throws Exception { 
        if(isEmpty()) 
            throw new Exception("Erro! A pilha esta vazia!");

        return stack[topStack]; 
    }

    public int getTop() { return topStack; }
    
    public boolean isEmpty() { return (topStack == -1); }
}