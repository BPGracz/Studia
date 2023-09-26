import math
import random
#zad 2
def pier(a, b, c):
    delta = (b**2)-(4*a*c)
    if delta>0:
        x1 = (-b-math.sqrt(delta))/(2*a)
        x2 = (-b+math.sqrt(delta))/(2*a)
        k = (x1, x2)
    elif delta == 0:
        x0 = -b/(2*a)
        k = (x0,)
    else:
        k = ()
    return k

print(pier(2,-10,12))
print(pier(1,2,1))
#zad 3:
pp = pier(1,2,1)
print(len(pp))

#zad 4
def silnia(do):
    suma = 1
    for i in range(1, do+1):
        suma = suma * i
    return suma

print(silnia(6))

#zad 5
def rek_sil(n):
    if n == 1:
        return 1
    else:
        return n*silnia(n-1)
    
print(rek_sil(8))

#zad 8
def NWD(a,b):
    while a!=b:
        if a>b:
            a = a-b
        else:
            b = b-a
    return a
    
print("1. ", NWD(105,28))
        
#zad 9
def rek_NWD(A,B):
    if A == B:
        return A
    elif A < B:
        return rek_NWD(B-A,A)
    else:
        return rek_NWD(A-B,B)

print("2. ",rek_NWD(105,28))

#zad 10
while True:
    a = random.randint(10,30)
    b = random.randint(10,30)
    if NWD(a,b) == 1:
        break
    
print(a,b)

#zad 11
