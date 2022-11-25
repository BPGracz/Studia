#include<stdio.h>
#include<stdlib.h>

/* int[5]  gentab(int size) {
  int c[5];
  for(int j=0; j<size; j++) 
      c[j]=rand()%100;
  return c;}

void pokaz(int d[],int size)
{
   for(int j=0;j<size;j++)
        printf("%d ",d[j]);
    printf("\n");
} */


int main() {
  int p=5;
  int  *pp;
  pp=&p;
  printf("p= %d     ",p);
  printf("pp= %d", pp);
  *pp=15;
  printf("teraz p= %d     ",p);
 
  

  //int a[5];
 // int[] *p;
  //p=gentab(5);
  //pokaz(a, 5);
}

  

