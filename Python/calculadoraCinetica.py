
try:
    millas_recorridas = float(input("Inserte el numero de millas recorridas:  ")) 
    galones_usados = float(input("Inserte el numero de galones usados:  ")) 
    
    #Realizamos la operacion
    print("Millas por galón:", millas_recorridas / galones_usados)
except ValueError:
    print("ERROR: Tiene que ser un valor numerico")
    