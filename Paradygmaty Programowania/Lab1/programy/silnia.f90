program silnia
integer :: N, silnia, i

print * , "Jakie N?"
read *, N
silnia = N
do i=N, 1,-1 
silnia=silnia*N
end
print *, "Silnia N wynosi", silnia