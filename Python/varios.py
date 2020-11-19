for i in range(10):
    # Imprimimos espacios al principio de la línea
    for j in range(10-i):
        print (" ",end=" ")
    # Cuenta hacia adelante
    for j in range(1,i+1):
        print (j,end=" ")
    # Cuenta atrás
    for j in range(i-1,0,-1):
        print (j,end=" ")
    # Fila siguiente
    print()
