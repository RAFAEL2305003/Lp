// Calculadora de logaritmo na base 2 e 10
// Para compilar, use: gcc gcc CalculadoraDeLogs.c -o CalculadoraDeLogs -lm

#include <stdio.h>
#include <math.h>

double calcularLogs(int base, double logaritmo) {
	double result = 0;

	if(base == 2) {
		result = log(logaritmo) / log(base);
	} else if(base == 10) {
		result = log(logaritmo);
	} else {
		printf("Erro! valor digitado eh invalido!");
	}

	return result;
}

int main(void) {
	int base;
	printf("Digite a base do logaritmo a ser calculada (10 ou 2): ");
	scanf("%d", &base);

	double logaritmo;
	printf("Digite o numero a ser calculado: ");
	scanf("%lf", &logaritmo);

	float res = calcularLogs(base, logaritmo);
	printf("O resultado de %lf na base %d = %lf", logaritmo, base, res);

	return 0;
}
