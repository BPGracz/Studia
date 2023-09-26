#zad1 Odczyt pliku
"""
plik = open('e:/Studia2023/NJiTP Laboratoria/Lab4.txt','r+t')
for line in plik:
    print(line)
"""
#zad2 Zapis pliku
"""
try:
    with open('e:/Studia2023/NJiTP Laboratoria/Lab4.txt','r+t') as plik:
        plik.write('Zapisany tekst')
except:
    print('Nie można wydrukowac pliku')
"""
#zad8
from functools import lru_cache
"""
def fibo(n):
    if n<=0:
        return 0
    elif n==1:
        return 1
    else:
        return fibo(n-1) + fibo(n-2)

for i in range(100):
    print(i, fibo(i))
"""
#zad10
from datetime import datetime
import math

def decorator(f):
    org_fun = f
    def inner(*args, **kwargs):
        poczatek = datetime.now()
        res = org_fun(*args, **kwargs)
        koniec = datetime.now()
        czas = koniec - poczatek
        print(czas.total_seconds())
        return res
    return inner
@decorator
def function():
    print('Hello')

"""
def CountPrimes(start, stop):
    count = 0
    for n in range(start, stop):
        nd = 0
        for d in range(1, n+1):
            if n%d == 0:
                nd += 1
        if nd==2:
            count += 1
    return count 
setSize = 1000
for i in range(10):
    print(i, CountPrimes(i*setSize, (i+1)*setSize))
"""
"""
@decorator
def CountPrimes(start, stop):
    count = 0
    for n in range(start, stop):
        nd = 0
        for i in range(2, n):
            if n%i == 0:
                nd = 1
                break
        if nd==0:
            count += 1
    return count 
setSize = 10000
for i in range(10):
    print(i, CountPrimes(i*setSize, (i+1)*setSize))
"""
@decorator
def CountPrimes(start, stop):
    count = 0
    for n in range(start, stop):
        nd = 0
        r = int(math.sqrt(n))
        for i in range(2, r+1):
            if n%i == 0:
                nd = 1
                break
        if nd==0:
            count += 1
    return count 
setSize = 10000
for i in range(10):
    print(i, CountPrimes(i*setSize, (i+1)*setSize))

