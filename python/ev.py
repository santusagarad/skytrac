a=1
b=1
count=0
while count <12:
    a=a+b
    b=a+b
    if a%2==1:
        print(a)
    if b%2==1:
        print(b)
    count+=1
