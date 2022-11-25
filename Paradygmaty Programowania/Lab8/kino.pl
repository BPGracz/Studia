/* sformu�uj odpowiednie pytanie, nast�pnie przekszta�� je w regu�� */
/* do iliasa prze�lij plik *.pl z uzupe�nionym o odpowiedni� regu�� programem, oraz u�ywanymi zapytaniami w postaci komentarzy */
/* og�lnie predykat film(rezyser, tytulFilmu, rokProdukcji, ListaWazniejszychAktorow)*/

film(scorsese, infiltracja, 2006, [dicaprio, daemon, nicolson, sheen, farmiga]).
film(scorsese, taksowkarz, 1976, [foster, deniro, brooks, harris]).
film(scorsese, wilk_z_wall_street, 2013, [dicaprio, hill, reiner, chandler]).
film(cameron, titanic, 1997, [dicaprio, winslet, bates, fisher, zane, stuart]).
film(tarantino, django, 2010, [sljackson, waltz, dicaprio]).
film(daldry, lektor, 2008, [finnes, winslet, ganz, nicolson]).
film(tarantino, pulp_fiction,1994, [travolta, sljackson, wills,thurman]).

/* przyda Ci si�  standardowy predykat member(Element, Lista)*/
/* oraz standardowy predykat length(Lista, Dlugosc)  */

ile_aktorow(X,Y,D) :- film(X,Y,_,Z), length(Z,D).

/*
member(3,[1,2,5,3]).
true.

?- length([1,2,5,6,9],X).
X = 5.

ile_aktorow(scorsese, infiltracja,Lista,Dlugosc).
Lista = [dicaprio, daemon, nicolson, sheen, farmiga],
Dlugosc = 5.

*/
