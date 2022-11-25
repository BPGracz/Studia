/* _ oznacza zmienn� bez nazwy */

member(X,[X|_]).  /* X jest r�wne g�owie listy */
member(X,[_|Y]) :- member(X,Y). /* lub znajduje si� w jej ogonie */

/* czy obiekt jest list� */

jest_lista([A|B]):- jest_lista(B).
jest_lista([]).

/* d�ugo�� listy */
dl_listy([],0).
dl_listy([G|O],N):- dl_listy(O, N1), N is N1+1.




