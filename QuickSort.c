#include <stdio.h>
#include <stdlib.h>

/* Procedimento para trocar os valores das posicoes do array */
void swap(int *i, int *j) {
    int temp = *i;
    *i = *j;
    *j = temp;
}

/* Procedimento de ordenacao propriamente dito */
void quicksort(int *array, int esq, int dir) {
    /* Indices para percorrer o array */
    int i = esq, j = dir;
    /* Escolhe o elemento do meio como pivo */
    int pivo = array[(dir + esq) / 2];
    while (i <= j) {
        /* Encontra um elemento a esquerda do pivo que eh maior ou igual ao pivo */
        while (array[i] < pivo) i++;
        /* Encontra um elemento a direita do pivo que eh menor ou igual ao pivo */
        while (array[j] > pivo) j--;
        if (i <= j) {
            /* Troca os elementos encontrados acima */
            swap(array + i, array + j);
            i++;
            j--;
        }
    }
    /* Recursivamente ordena a sublista a esquerda do pivo */
    if (esq < j) quicksort(array, esq, j);
    /* Recursivamente ordena a sublista a direita do pivo */
    if (i < dir) quicksort(array, i, dir);
}

/* Procedimento de ordenacao que vai ser chamado na main */
void quicksortM(int *array, int n) {
    quicksort(array, 0, n - 1);
}

/* Procedimento para mostrar os valores do array */
void show(int *array, int n) {
    for (int i = 0; i < n; i++) {
        printf("%d ", array[i]);
    }
}

int main() {
    int n = 0;
    printf("Digite o tamanho do array: ");
    scanf("%d", &n);
    int v[n];

    for(int i = 0; i < n; i++) {
        printf("Digite o valor da posicao %d: ", i);
        scanf("%d", &v[i]);
    }

    printf("\nArray:\n");
    show(v, n);

    quicksortM(v, n);
    printf("\n\nArray ordenado:\n");
    show(v, n);

    return 0;
}
