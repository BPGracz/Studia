#include <stdio.h>
 
 int powiekszaj (int zm) {
   static  
int suma =0;
    suma=suma+zm;
    return  suma;    
  } 
int main() {
  
  int zmienna;
  zmienna=powiekszaj(1);
  printf("za pierwszym wywolaniem jest %d ", zmienna);
  zmienna=powiekszaj(3);
   printf("\n za drugim wywolaniem jest %d ", zmienna);
  zmienna=powiekszaj(5);
   printf("\n za trzecim wywolaniem jest %d%", zmienna);
    
}
