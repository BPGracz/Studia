/* fakty */
sekretarz(bierut, 1945, 1956).
sekretarz(gomulka, 1956, 1970).
sekretarz(gierek, 1970, 1980).
sekretarz(kania, 1980, 1981).
sekretarz(jaruzelski, 1981, 1989).
sekretarz(rakowski, 1989, 1990).

/*reguly*/
/* co to za pytanie?  */
przewodzil(X, Y) :- sekretarz(X, A, B), Y>=A, Y=<B.

/*co to za pytanie*/
ileprzewodzil(X,Ile) :- sekretarz(X, A, B), Ile is B - A.

/* ile lat upłynęło od końca sekretarza X do początku sekretarza Y? */

koniecprzewodzenia(X,Y,Z) :- sekretarz(X, A, B), sekretarz(Y, C, D), Z is C - B.


