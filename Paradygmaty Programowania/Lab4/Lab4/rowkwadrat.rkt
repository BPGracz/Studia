#lang racket
(define (row_kwadrat a b c)
  (let (
       (pierw_delta_przez_2a (/ (sqrt (- (* b b) (* 4 a c))) (* 2 a)))
       (minus_b_przez_2a (/ (- 0 b) (* 2 a)))
        )
  (list (+ minus_b_przez_2a pierw_delta_przez_2a) (- minus_b_przez_2a pierw_delta_przez_2a))
  ))
