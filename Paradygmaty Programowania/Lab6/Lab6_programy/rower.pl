/*nierozkladalne*/
nierozkladalna(obrecz).
nierozkladalna(szprycha).
nierozkladalna(ramatylna).
nierozkladalna(kierownica).
nierozkladalna(przekladnia).
nierozkladalna(trzpien).
nierozkladalna(makretka).
nierozkladalna(widelec).

/*podzespoly*/
podzespol(rower, [kolo, kolo, rama]).
podzespol(kolo, [szprycha, obrecz, piasta]).
podzespol(rama, [ramatylna, ramaprzednia]).
podzespol(ramaprzednia, [kolowidelec, kierownica]).
podzespol(piasta, [przekladnia, os]).
podzespol(os, [trzpien, nakretka]).

/* d�ugo�� listy */
dl_listy([],0).
dl_listy([_|O],N):- dl_listy(O, N1), N is N1+1.

jest_na_liscie(X,[X|_]).  /* X jest r�wne g�owie listy */
jest_na_liscie(X,[_|Y]) :- jest_na_liscie(X,Y). /* lub znajduje si� w jej ogonie */

jest_czescia(Czesc,Podzespol) :- jest_na_liscie(Czesc,Podzespol).







