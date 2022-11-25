#lang racket
#|
(define lista '(1 2 3 4 2 4 3 7))
(define (jest_na_liscie elt lista)
(cond
  ((null? lista) #f)
  ((eq? (car lista) elt) #t)
   (else (jest_na_liscie elt (cdr lista) ) ) ) )
|#
#|
(define (minimum lista)
(cond
  ((empty? lista) 10000)
  ((empty? (cdr lista)) (car lista))
  ((< (car lista) (minimum (cdr lista))) (car lista))
  (else (minimum (cdr lista)))))
|#
#|
(define lista '(1 3 5 3 7 2) )
(define (wyrzuc elt lista)
  (filter (lambda (elt) ()) (list))
  )
|#
(define (losuj n)
  (if (= n 0) '()
      (cons (random 50) (losuj (- n 1)))))