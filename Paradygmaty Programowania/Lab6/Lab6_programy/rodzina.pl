/*fakty*/

rodzic(elzbieta, karol).
rodzic(elzbieta,anna).
rodzic(filip,karol).
rodzic(filip, anna).
rodzic(diana, william).
rodzic(diana, harry).

kobieta(elzbieta).
kobieta(anna).
kobieta(diana).
kobieta(sarah).
kobieta(sophie).
kobieta(camilla).
kobieta(zara).
kobieta(beatrice).
kobieta(eugenie).
kobieta(louise).
kobieta(kelly).
mezczyzna(filip).
mezczyzna(charles).
mezczyzna(andrew).
mezczyzna(edward).
mezczyzna(mark).
mezczyzna(timothy).
mezczyzna(william).
mezczyzna(harry).
mezczyzna(severn).
mezczyzna(peter).
mezczyzna(karol).


/* regu³y */
/*X jest matk¹ Y */
matka(X,Y) :- rodzic(X,Y), kobieta(X).
ojciec(X,Y) :- rodzic(X,Y), mezczyzna(X).
/*X jest siostr¹ Y */
siostra(X,Y) :- kobieta(X), matka(Z,X), matka(Z,Y).
brat(X,Y) :- mezczyzna(X), matka(Z,X), matka(Z,Y).






