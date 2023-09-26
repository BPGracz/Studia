import math
#zad1
"""
print ("Hello")
"""
#zad2
"""
a = 2
b = -10
c = 12
kwadrat = b**2-4*a*c
print (kwadrat)
"""
#zad4
"""
if kwadrat<0:
    print ("Brak rozwiązań")
elif kwadrat==0:
    x0=b/2*a
    print (f"Jest jedno rozwiązanie {x0}")
else:
    x1=(-b-math.sqrt(kwadrat))/(2*a)
    x2=(-b+math.sqrt(kwadrat))/(2*a)
    print (f"Są dwa rozwiązania {x1} {x2}")
"""
#zad5
"""
#range(od,do,krok)
for i in range(1,22,2):
    k = i**2
    s = i**3
    print ("{} {} {}".format(i,k,s))
"""
#zad8
"""
for i in range(12):
    x= i*math.pi/4
    
    if (x!=0):
        sinx = math.sin(x)/x
    else:
        sinx = 1
    
    sinx=1 if x==0 else math.sin(x)/x
    print (sinx)
"""
#zad14
"""
A = 105
B = 28

while A!=B:
    
    if A<B:
        B = B-A
    else:
        A = A-B
        
    
print(f"NWD {A}")

(a,b)=(105,28)
while a!=b:
    (a,b) = (a,b-a) if a<b else (a-b,b)
print(f"NWD {a}")
"""
#zad16
"""
a=105
b=28
while True:
    v = a%b
    a = b
    b = v
    if v==0:
        break
print(a)

a=105
b=28
while (v:=a%b)!=0:
    (a,b) = (b,v)
print(b)
"""
#zad18
e=0.00001
x=9
y=9
while math.fabs(y**2-x)>e:
    y = 0.5*(y+x/y)
    print (y)


    
 
