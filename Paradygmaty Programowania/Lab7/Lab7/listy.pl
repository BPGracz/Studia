
/* _ oznacza zmienn¹ bez nazwy */
imiona_meskie([bolek, lolek, olek, tolek, jurek, tomek]).
imiona_damskie([anka, kaska, danka, alka, aga, janka]).


member(X,[X|_]).  /* X jest równe g³owie listy */
member(X,[_|Y]) :- member(X,Y). /* lub znajduje siê w jej ogonie */

/* czy obiekt jest list¹ */

jest_lista([_|B]):- jest_lista(B).
jest_lista([]).

/* podaj d³ugoœæ listy */

dl_listy([],0).
dl_listy([_|O],N):- dl_listy(O, N1), N is N1+1.

/* w prologu istnieje predefiniowany predykat length(X, N) */
/* do czego s³u¿y zmienna N)  */

/*³¹czenie list */
lacz_listy([],L, L). /* do³¹czenie pustej listy do L daje L */
lacz_listy([H|L1], L2, [H|L3]):- lacz_listy(L1, L2, L3).

/* w programie rower.pl bêdzie u¿ywany predefiniowany predykat append (L1, L2, L3) */
/* do czego s³u¿y tutaj zmienna L3?) */


liczba_naturalna(1).
liczba_naturalna(X):- liczba_naturalna(Y), X is Y+1.


