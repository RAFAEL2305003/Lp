// Algoritmo para contar a quantidade de acaracteres de uma certa string
#include <stdio.h>

#define MAX_LENGTH 256

int counter(char *str) {
	int count = 0;

	for(; count < str[count] != '\0'; count++);

	return count;
}

int main(void) {
	char str[MAX_LENGTH];
	printf("Digite a string: ");
	scanf("%255[^\n]", str);

	int count = counter(str);
        printf("O comprimento da string eh = %d caracteres\n", count);

	return 0;
}
