program Fdzielniki
integer :: N, i

print * , "Jakie N?"
read *, N
dzielniki = 0
print *, "Dzielniki liczby", N, "to:"
do i=2, N-1
if (mod(N,i) == 0) then
  print *, i
  dzielniki=dzielniki+1
end if 
end do
print *, "Nietrywialnych podzielnikow jest", dzielniki
end