#include<stdio.h>
#include<stdlib.h>


//W jaki sposob przekazywane sa parametry w nastepujacym programie


void generuj(int c[],int size)
{
   for(int j=0; j<size; j++)
        c[j]=rand()%100;
     printf("tablica c wygenerowana:  "); 
     for(int j=0;j<size;j++)
        printf("%d ",c[j]);
     printf("\n");
}

void pokaz(int d[],int size)
{
   for(int j=0;j<size;j++)
        printf("%d ",d[j]);
    printf("\n");
}
   
 int main()
{
    int a[5];
    generuj(a,5);
    printf("Wygenerowano tablice : \n");
    pokaz(a,5);
    a[3]=1000;
     printf("tablica po zmianie : \n");
    pokaz(a,5);
    return 0;

}