#include <stdio.h>

int main() {
    int number = 23;
    int *p; // Declaring a pointer to int
  
    p = &number; // Assigning the address of number to the pointer
  
    printf("Value of number: %d\n", number);
    printf("Address of number: %p\n", &number);
    printf("Value pointed to by p: %d\n", *p);
    printf("Address stored in p: %p\n", p);
    printf("Address of p: %p", &p);
  
    return 0;
}