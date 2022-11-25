#include <stdio.h>


void zamien(int a, int b) {
	int pom;
	pom = a;
	a = b;
	b = pom;	
	
}
void main() {	
  int zm =2, lista[5] = {1, 3, 5, 7, 9};
  
  zamien(zm, lista[0]);
  
  printf("zm = %d \n", zm);
  printf("lista: "); 
  for (int i=0; i<5; i++){
    printf("%d, ", lista[i]);
  }
  printf("\n");
  
  zamien(zm, lista[zm]);
  
  printf("zm = %d \n", zm);
  printf("lista: "); 
  for (int i=0; i<5; i++){
    printf("%d, ", lista[i]);
  }
  printf("\n");
}
