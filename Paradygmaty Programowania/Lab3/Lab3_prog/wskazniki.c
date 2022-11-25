#include <stdio.h>
#include <stdlib.h>

int main ()
  {
  int x, y, *wsk1, *wsk2;
  // x i y są zmiennymi calkowitoliczbowymi
 // wsk1, wsk2 są wskaznikami (adresami) na pewne zmienne calkowitoliczbowe w pamieci
 srand(5);
  x=7;
  wsk1=&x; //zmiennej wsk nadajemy wartosc adresu pod jakim zapisana jest zmienna x
  printf("x = %d   ",x);
  printf("adres x w pamieci = %d \n", wsk1);


  wsk2=wsk1;  //teraz na adres zm x wskazują wsk1 i wsk2
  *wsk2 = *wsk2 + 10;  //co tu jest powiększane o 10?
  printf("\n x = %d   ",x);
  printf("\n Powiekszono o 10 wartosc zmiennej spod adresu = %d \n", wsk2);
  
  //o tablicach
  //najprostsza deklaracja
  int tab[5];
  //wypelniam tablice liczbami losowymi
 printf("Oto piecioelementowa tablica: ");
  for (int i = 0; i<5; i++) {
     tab[i]=rand()%10;
     printf("%d, ",tab[i]); }
     
     printf("\n  adres tablicy tab: %d ", &tab);
     printf("\n  adres pierwszego elementu tablicy tab: %d ", &tab[0]);
     printf("\n  adres trzeciego elementu tablicy tab: %d ", &tab[2]);
     *wsk2=tab[3];   
     //jaką wartość ma teraz zmienna x i dlaczego?
	printf("\n adres wskaźnika wsk2 czyli tab[3] to %d ", &tab[3]);
    
  
  return 0;
}

  