/* Program opisuje czytelników pewnej biblioteki, informacjê o us³ugach dostêpnych dla czytelników. Dla bezgrzesznych czytelników dostêpne s¹ wszystkie us³ugi,
 dla czytelników, którzy przetrzymuj¹ ksi¹¿ki, us³ugi wypo¿yczania oraz
 wypo¿yczeñ miêdzybibliotecznych s¹ niedostêpne */

/* klienci pewnej biblioteki, zwróæ uwagê, na sposób zapisu imion */

czytelnik('Bolek').
czytelnik('Lolek').
czytelnik('Tola').

/* fakty dotycz¹ce przetrzymania ksi¹¿ek */
przetrzymana_ksiazka('Tola', ks123).
przetrzymana_ksiazka('Bolek', ks124).
przetrzymana_ksiazka('Bolek', ks125).

/* fakty opisuj¹ce us³ugi */
usluga_podstawowa(katalog).  /*dostêp do katalogu */
usluga_podstawowa(czytelnia).  /*dostêp do czytelni */
usluga_dodatkowa(wypozyczanie).  /*mo¿liwoœæ wypozyczania */
usluga_dodatkowa(pozyczki_miedzybiblioteczne).

/* predykaty opisuj¹ce dostêpnoœæ us³ug dlaklientów */
/* czytelnicy przetrzymuj¹cy ksi¹¿ki maj¹ dostêp tylko do us³ug podstawowych */
usluga(Osoba, Usluga) :-
   przetrzymana_ksiazka(Osoba,Ksiazka),!,
   usluga_podstawowa(Usluga).
/*dla bezgrzesznych czytelników dostêpne s¹ wszystkie us³ugi */
usluga(Osoba, Usluga) :- dowolna_usluga(Usluga).

dowolna_usluga(X):- usluga_podstawowa(X).
dowolna_usluga(X):- usluga_dodatkowa(X).



