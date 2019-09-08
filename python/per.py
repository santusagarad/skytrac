v=input("mat")
b=input("sci")
c=input("eng")
total= int(v)+int(b)+int(c)
per=total/300*100
if per>90:
    print("grade a")
elif per<80 :
    print("grade b")
elif per <35:
    print("fail")

