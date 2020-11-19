

def lectura_villanos(fichero):
    file = open(fichero)
 
    lista_villanos=[]
    for line in file:
        line = line.strip()
        lista_villanos.append(line)
    file.close()
    return lista_villanos


def busqueda_lineal(lista_nombres, clave):
    i = 0
    while i < len(lista_nombres) and lista_nombres[i] != clave:
        i += 1
     
    if i < len(lista_nombres):
        print( "El nombre se encuentra en la posición", i)
    else:
        print( "El nombre no se encuentra en la lista." )
    



lista=lectura_villanos("super_villains.txt")
print(lista)

busqueda_lineal(lista,"raul")


