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

#Itera hasta que el usuario pincha sobre el botón de cierre.
hecho = False
 
# Se usa para gestionar cuan rápido se actualiza la pantalla
reloj = pygame.time.Clock()

# -------- Bucle Principal del Programa -----------


#Variables del cuadrado
rect_x=50
rect_y=50
rect_cambio_x = 5
rect_cambio_y = 5
    
    
while not hecho:
    
    #Limpiamos la pantalla
    pantalla.fill(NEGRO)
    
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
            
            #Ejemplo mio
            #if rect_cambio_x < 30:
            #    rect_cambio_x += 3
            #    rect_cambio_y += 3
            #else:
            #    rect_cambio_x = 5
            #    rect_cambio_y = 5
    # TODOS LOS EVENTOS DE PROCESAMIENTO DEBERÍAN IR ENCIMA DE ESTE COMENTARIO
 
 
    # TODA LA LÓGICA DEL JUEGO DEBERÍA IR DEBAJO DE ESTE COMENTARIO
    # TODA LA LÓGICA DEL JUEGO DEBERÍA IR ENCIMA DE ESTE COMENTARIO
 
    #ANIMACIONES
    #pygame.draw.rect(screen, color, (x,y,width,height), thickness)
    pygame.draw.rect(pantalla, BLANCO, [rect_x, rect_y, 50, 50])
    rect_x+=rect_cambio_x
    rect_y+=rect_cambio_y
    
    # Rebota al rectángulo si es necesario
    if rect_y > 450 or rect_y < 0:
        rect_cambio_y = rect_cambio_y * -1
    if rect_x > 650 or rect_x < 0:
        rect_cambio_x = rect_cambio_x * -1
 
    # TODO EL CÓDIGO DE DIBUJO DEBERÍA IR DEBAJO DE ESTE COMENTARIO
    
    # Avanza y actualiza la pantalla con lo que hemos dibujado.
    pygame.display.flip()
 
    # TODO EL CÓDIGO DE DIBUJO DEBERÍA IR ENCIMA DE ESTE COMENTARIO
 
    # Limita a 20 fotogramas por segundo (frames per second)
    reloj.tick(20)
    
#Cerramos el programa
pygame.quit()