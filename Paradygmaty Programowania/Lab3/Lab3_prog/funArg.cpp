#include <iostream>
#include <math.h>

void tester(double liczba, double (f)(double)) {
   	std::cout <<"Wynik: "<< (f)(liczba);
}


double pun(double li){
		return 4*li+1;
	}
double sinus(double x){
	return sin(x);
}	
int main(void) {
  double liczba = M_PI;
  liczba=liczba/6;
  tester(liczba, sinus);

    return 0;
/*wywolaj funkcję tester kolejno 
z funkcjami 	sinus,  pun, cos jako parametrami aktualnymi */
}