
/* _ oznacza zmienn� bez nazwy */
imiona_meskie([bolek, lolek, olek, tolek, jurek, tomek]).
imiona_damskie([anka, kaska, danka, alka, aga, janka]).


member(X,[X|_]).  /* X jest r�wne g�owie listy */
member(X,[_|Y]) :- member(X,Y). /* lub znajduje si� w jej ogonie */

/* czy obiekt jest list� */

jest_lista([_|B]):- jest_lista(B).
jest_lista([]).

/* podaj d�ugo�� listy */

dl_listy([],0).
dl_listy([_|O],N):- dl_listy(O, N1), N is N1+1.

/* w prologu istnieje predefiniowany predykat length(X, N) */
/* do czego s�u�y zmienna N)  */

/*��czenie list */
lacz_listy([],L, L). /* do��czenie pustej listy do L daje L */
lacz_listy([H|L1], L2, [H|L3]):- lacz_listy(L1, L2, L3).

/* w programie rower.pl b�dzie u�ywany predefiniowany predykat append (L1, L2, L3) */
/* do czego s�u�y tutaj zmienna L3?) */


liczba_naturalna(1).
liczba_naturalna(X):- liczba_naturalna(Y), X is Y+1.


