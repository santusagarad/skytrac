"""FH=open("jos.txt","w")
a="vi"
b="jo"
FH.write(a)
FH.write("\n")
FH.write(b)
FH.close()
#data=FH.read()
#print(data)
"""
""""

FH=open("Captains.txt","r")
v=FH.readlines()

for i in range(2):
    print(v[i])
FH.close()
"""


FH=open("Captains.txt","r")
v=FH.readlines()
count=1
while count<=4:
    if count%2==1:
        print(v[count])
     else:
        print("even")
    count=count+1
FH.close()
