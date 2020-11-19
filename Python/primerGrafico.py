import pygame

dimensiones = (700, 500)
pantalla = pygame.display.set_mode(dimensiones)
pygame.display.set_caption("Mi primer juego")

# Definicion de colores
NEGRO  = (  0,   0,   0)
BLANCO = (255, 255, 255)
VERDE  = (0,   255,   0)
ROJO   = (255,   0,   0)
AZUL   = (50,   70, 255)

#Definicion de la variable Pi
pi = 3.141592653

#Itera hasta que el usuario pincha sobre el botón de cierre.
hecho = False
 
# Se usa para gestionar cuan rápido se actualiza la pantalla
reloj = pygame.time.Clock()

# -------- Bucle Principal del Programa -----------
while not hecho:
    
    #Limpiamos la pantalla
    pantalla.fill(BLANCO)
    
    # TODOS LOS EVENTOS DE PROCESAMIENTO DEBERÍAN IR DEBAJO DE ESTE COMENTARIO
    for evento in pygame.event.get(): # El usuario hizo algo
        if evento.type == pygame.QUIT:
            print("El usuario solicitó salir.")
            hecho = True # Esto que indica que hemos acabado y sale de este bucle
        elif evento.type == pygame.KEYDOWN:
            print("El usuario presionó una tecla.")
        elif evento.type == pygame.KEYUP:
            print("El usuario soltó una tecla.")
        elif evento.type == pygame.MOUSEBUTTONDOWN:
            print("El usuario presionó un botón del ratón")
            
    # TODOS LOS EVENTOS DE PROCESAMIENTO DEBERÍAN IR ENCIMA DE ESTE COMENTARIO
 
 
    # TODA LA LÓGICA DEL JUEGO DEBERÍA IR DEBAJO DE ESTE COMENTARIO
    pygame.draw.rect(pantalla, NEGRO, [20, 20, 250, 100], 2)    
    pygame.draw.arc(pantalla, VERDE, [100, 100, 250, 200], pi/2, pi, 2)
    pygame.draw.arc(pantalla, NEGRO, [100, 100, 250, 200], 0, pi/2, 2)
    pygame.draw.arc(pantalla, ROJO, [100, 100, 250, 200], 3*pi/2, 2*pi, 2)
    pygame.draw.arc(pantalla, AZUL, [100, 100, 250, 200], pi, 3*pi/2, 2)
    # TODA LA LÓGICA DEL JUEGO DEBERÍA IR ENCIMA DE ESTE COMENTARIO
 
 
    # TODO EL CÓDIGO DE DIBUJO DEBERÍA IR DEBAJO DE ESTE COMENTARIO
    
    # Avanza y actualiza la pantalla con lo que hemos dibujado.
    pygame.display.flip()
 
    # TODO EL CÓDIGO DE DIBUJO DEBERÍA IR ENCIMA DE ESTE COMENTARIO
 
    # Limita a 20 fotogramas por segundo (frames per second)
    reloj.tick(20)
    
#Cerramos el programa
pygame.quit()