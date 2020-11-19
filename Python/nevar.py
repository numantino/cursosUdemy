import pygame
import random

# Inicializamos el motor de juegos.
pygame.init()

dimensiones = (400, 400)
pantalla = pygame.display.set_mode(dimensiones)
pygame.display.set_caption("Esta Nevando")

# Definicion de colores
NEGRO  = (  0,   0,   0)
BLANCO = (255, 255, 255)

# Iteramos 50 veces y añadimos un copo de nieve en una ubicación (x,y) aleatoria.
lista_nieve=[]
for i in range(50):
    x = random.randrange(0, 400)
    y = random.randrange(0, 400)
    lista_nieve.append([x, y])

#Itera hasta que el usuario pincha sobre el botón de cierre.
hecho = False 
# Se usa para gestionar cuan rápido se actualiza la pantalla
reloj = pygame.time.Clock()

# -------- Bucle Principal del Programa -----------
while not hecho:
    
    # TODOS LOS EVENTOS DE PROCESAMIENTO DEBERÍAN IR DEBAJO DE ESTE COMENTARIO
    for evento in pygame.event.get(): # El usuario hizo algo
        if evento.type == pygame.QUIT:
            print("El usuario solicitó salir.")
            hecho = True # Esto que indica que hemos acabado y sale de este bucle
            
    # Establecemos el color de fondo.
    pantalla.fill(NEGRO)
 
    # Procesamos cada copo de la lista.
    for i in range(len(lista_nieve)):
    
        # Dibujamos el copo de nieve
        pygame.draw.circle(pantalla, BLANCO, lista_nieve[i], 2)
         
        # Desplazamos un píxel hacia abajo el copo de nieve.
        lista_nieve[i][1] += 1
         
        # Si el copo se escapa del fondo de la pantalla.
        if lista_nieve[i][1] > 400:
            # Lo movemos justo encima del todo
            y = random.randrange(-50, -10)
            lista_nieve[i][1] = y
            # Le damos una nueva ubicación x
            x = random.randrange(0, 400)
            lista_nieve[i][0] = x
             
    # Avanzamos y actualizamos con lo que hemos dibujado.
    pygame.display.flip()
    reloj.tick(60)
    
#Cerramos el programa
pygame.quit()