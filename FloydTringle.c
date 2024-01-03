#include <stdio.h>

int main(void) {
	int n, m = 1, num = 1;
	scanf("%d", &n);

	printf("\n");

	for(int i = 0; i < n; i++) {
		for(int j = 0; j < m; j++) {
			printf("%d ", num++);
		}
		m++;
		printf("\n");
	}
	return 0;
}


