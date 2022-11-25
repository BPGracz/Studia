#lang racket

; Zad 3 a
#|
(/ (* 3 (- 7 5)) (+ 2 1))
|#
; Zad 3 b
#|
(- (/ (* 7(+ 3 5 2 1))8)(* 7 3))
|#
; Zad 4
#|
(define pi 3.14159)(define r 4)
(* pi (* r r))
(/ pi 2)
|#
; Zad 5 i 6
(define (f3param x y z) (if (= z 0) 10000 (/ (+ (* x x) (* y y) ) (* 2 z) ) ) )
; Zad 7
(define (pole_trapezu a b h) (/(*(+ a b)h)2))
; Zad 8
(define (url a11 a12 c1 a21 a22 c2)
  (let (
        (wg (- (* a11 a22) (* a12 a21)))
        (wx (- (* c1 a22) (* c2 a12)))
        )
    (list
     (if (= 0 wg) "brak rozwiazan" (/ wx wg))
     )
    )
  )
; Zad 9
