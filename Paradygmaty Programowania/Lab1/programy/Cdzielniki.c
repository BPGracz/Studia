#include <stdio.h>

void main() {
int N, i, liczDzielniki = 0;

printf("Jakie N? ");
scanf("%d",&N); 
printf("Dzielniki liczby %d", N);
printf(" to: ");

for (i=2; i < N; i++) {
if (N % i == 0) {
  printf(" %d, ", i);
  liczDzielniki++;
}
}
printf("\n Nietrywialnych podzielnikow jest %d", liczDzielniki);
}