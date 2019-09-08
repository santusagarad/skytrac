from calc import *
import sys
veg = int(sys.argv[1])
fru = int(sys.argv[1])
cash = 200
shopping_amount = add(veg,fru)
balance = sub(cash,shopping_amount)
print (balance)
