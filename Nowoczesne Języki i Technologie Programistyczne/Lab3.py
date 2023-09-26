#zad 11
"""
def calka(f,/,a,b,*,n=1000):
    h=(b-a)/n
    s=0
    for i in range(n):
        s += h*f(a+i*h)
    return s

c = calka(lambda x:x**2,3,6,1000)
print(c)
c2 = calka(b=6,f=lambda x:x**2,a=3,n=100)
print(c2)
"""
#zad 17
"""
def floatRangeH(a,b,h):
    while a <= b:
        yield a
        a+=h

for x in floatRangeH(0,2,0.1):
    print(x)
"""
#zad 18
"""
def floatRangeH(a,b,h=None):
    if h == None:
        h = b
        b = a
        a = 0
    while a <= b:
        yield a
        a+=h

for x in floatRangeH(2,0.1):
    print(x)
"""
#zad 18 hard level
"""
def floatRangeH(a,b=None,h=None):
    if b == None and h == None:
        b = a
        a = 0
        h = 0.1
    elif h == None:
        h = b
        b = a
        a = 0
        
    while a <= b:
        yield a
        a+=h

for x in floatRangeH(2):
    print(x)
"""
#zad dowolna liczba argumentów zmiennej
def sum(*a,b="suma"):
    if b == "iloczyn":
        x = 1
        for i in a:
            x *= i
        return x
    else:
        x = 0
        for i in a:
            x += i
        return x

print(sum(7))
print(sum(7,13,77,5)) #102
print(sum())
print(sum(7,13,77,5,b="iloczyn"))
