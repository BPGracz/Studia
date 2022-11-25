/* Mamy pusty dom, w którym ukryto skarb. Poni¿sze termy opisuj¹, jak mo¿na przechodziæ miêdzy pokojami - d(a, b) znaczy, ¿e z pokoju a s¹ drzwi do pokoju b. */

d(a,b).
d(b,c).
d(d,e).
d(c,d).
d(c,h).
d(e,f).
d(i,g).
d(g,e).
d(b,i).
/* skarb znajduje siê w pokoju g */
skarb(g).

/* tu opisane s¹ tegu³y chodzenia po pokojach. T jest list¹ pokojów, do których nie nale¿y wchodziæ (odwiedzonych),   predykat \+ member(Z, T) oznacza: Z nie jest (\+) na liœcie T */

go(X,X,T).
go(X,Y,T):- d(X,Z), \+ member(Z,T), go(Z,Y,[Z|T]) .
go(X,Y,T):- d(Z,X), \+ member(Z,T), go(Z,Y,[Z|T]).









