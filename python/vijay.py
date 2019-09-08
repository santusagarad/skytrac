
a=1
b=1
counter=0
while counter <12:
    a=a+b
    b=a+b
    if a%2==1:
        print(a)
        counter+=1
    if  b%2==1:
        print(b)
        counter+=1
        

