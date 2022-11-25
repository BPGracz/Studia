/* Program opisuje czytelnik�w pewnej biblioteki, informacj� o us�ugach dost�pnych dla czytelnik�w. Dla bezgrzesznych czytelnik�w dost�pne s� wszystkie us�ugi,
 dla czytelnik�w, kt�rzy przetrzymuj� ksi��ki, us�ugi wypo�yczania oraz
 wypo�ycze� mi�dzybibliotecznych s� niedost�pne */

/* klienci pewnej biblioteki, zwr�� uwag�, na spos�b zapisu imion */

czytelnik('Bolek').
czytelnik('Lolek').
czytelnik('Tola').

/* fakty dotycz�ce przetrzymania ksi��ek */
przetrzymana_ksiazka('Tola', ks123).
przetrzymana_ksiazka('Bolek', ks124).
przetrzymana_ksiazka('Bolek', ks125).

/* fakty opisuj�ce us�ugi */
usluga_podstawowa(katalog).  /*dost�p do katalogu */
usluga_podstawowa(czytelnia).  /*dost�p do czytelni */
usluga_dodatkowa(wypozyczanie).  /*mo�liwo�� wypozyczania */
usluga_dodatkowa(pozyczki_miedzybiblioteczne).

/* predykaty opisuj�ce dost�pno�� us�ug dlaklient�w */
/* czytelnicy przetrzymuj�cy ksi��ki maj� dost�p tylko do us�ug podstawowych */
usluga(Osoba, Usluga) :-
   przetrzymana_ksiazka(Osoba,Ksiazka),!,
   usluga_podstawowa(Usluga).
/*dla bezgrzesznych czytelnik�w dost�pne s� wszystkie us�ugi */
usluga(Osoba, Usluga) :- dowolna_usluga(Usluga).

dowolna_usluga(X):- usluga_podstawowa(X).
dowolna_usluga(X):- usluga_dodatkowa(X).



