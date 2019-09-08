
def add(num1,num2):
    res = num1 + num2
    return res

def sub(num1,num2):
    res =num1 - num2
    return res

# main start from here
a = 10
b = 20
#c = 30
#d = 40
#total = add(a+b,c+d)
total=add(a,b)
print("sum :",total)

diff = sub(a,b)
print("sub :",diff)
print("sub",diff)

#
eng1 = 250
ind1= 220
eng2 = 180
eng_total = add(eng1,eng2)
india2 = sub(eng_total,ind1)
target =add(india2,1)
print (target)
    
#
veg = 120
fru = 45
cash = 200
shopping_amount = add(veg,fru)
balance = sub(cash,shopping_amount)
print (balance)
#
