#include <stdio.h>
#include <stdlib.h>

/* Celula */
typedef struct Celula{
    int data; /* Elemento inserido na celula */
    struct Celula *next; /* Aponta para a proxima celula */
} Celula;

Celula* newCelula(int data) {
    Celula* newC = (Celula*) malloc(sizeof(Celula));
    newC->data = data;
    newC->next = NULL;
    return newC;
}

/* Fila */
Celula* first = NULL;
Celula* last = NULL;

/* Pocedimento para inserir no fim da fila */
void insert(int data) {
    /* Se a fila estiver vazia, insira o novo elemento na primeira celula */
    if(first == NULL) {
      first = newCelula(data);
      last = first;
    } else {
      /* apontando o "last->next" para a nova celula */
      last->next = newCelula(data);
      /* mudando a posicao de "last" para a nova celula */
      last = last->next;
    }
}

/* Procedimento para remover no inicio da fila */
void delete() {
    /* checando se a fila nao esta vazia */
    if(last != first) {
        /* removendo o primeiro elemento e liberando a memoria alocada para ele */
        Celula* aux = first;
        first = first->next;
        aux->next = NULL;
        free(aux);
        aux = NULL;
    } else {
        printf("Erro ao remover");
    }
}

/* Procedimento para mostrar todos elementos da fila */
void show() {
    Celula* i;
    printf("\nMostrando todos elementos da fila: ");
    for(i = first; i != last->next; i = i->next)
        printf("%d ", i->data);
}

int main() {
  int v[5] = {1,2,3,4,5};
  /* Preenchendo a fila */
  for(int i = 0; i < 5; i++)
    insert(v[i]);

  /* Mostrando os elementos da fila */
  printf("Antes da remocao: \n");
  show();

  /* Apagando o primeiro elemento */
  delete();
  printf("\nDepois da remocao: ");
  show();
  return 0;
}

