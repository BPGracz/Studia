/* _ oznacza zmienn¹ bez nazwy */

member(X,[X|_]).  /* X jest równe g³owie listy */
member(X,[_|Y]) :- member(X,Y). /* lub znajduje siê w jej ogonie */

/* czy obiekt jest list¹ */

jest_lista([A|B]):- jest_lista(B).
jest_lista([]).

/* d³ugoœæ listy */
dl_listy([],0).
dl_listy([G|O],N):- dl_listy(O, N1), N is N1+1.




