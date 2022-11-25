/* Mamy pusty dom, w kt�rym ukryto skarb. Poni�sze termy opisuj�, jak mo�na przechodzi� mi�dzy pokojami - d(a, b) znaczy, �e z pokoju a s� drzwi do pokoju b. */

d(a,b).
d(b,c).
d(d,e).
d(c,d).
d(c,h).
d(e,f).
d(i,g).
d(g,e).
d(b,i).
/* skarb znajduje si� w pokoju g */
skarb(g).

/* tu opisane s� tegu�y chodzenia po pokojach. T jest list� pokoj�w, do kt�rych nie nale�y wchodzi� (odwiedzonych),   predykat \+ member(Z, T) oznacza: Z nie jest (\+) na li�cie T */

go(X,X,T).
go(X,Y,T):- d(X,Z), \+ member(Z,T), go(Z,Y,[Z|T]) .
go(X,Y,T):- d(Z,X), \+ member(Z,T), go(Z,Y,[Z|T]).









