#include <stdio.h>

void main() {
int N;
int silnia = 1;

printf("Jakie N? ");
scanf("%d",&N); 
printf("%d! = ", N);

for (int i=N; i > 0; i--) {
  silnia = silnia*i;
}
printf("%d \n", silnia);
printf("%i", i);
}

