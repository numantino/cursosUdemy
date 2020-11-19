import pygame

NEGRO  = (  0,   0,   0)
BLANCO = (255, 255, 255)
VERDE  = (0,   255,   0)
ROJO   = (255,   0,   0)
AZUL   = (50,   70, 255)

def dibujar_hombredenieve(pantalla, x, y):
    # Dibuja un círculo para la cabeza
    pygame.draw.ellipse(pantalla,NEGRO, [35 + x, y, 25, 25])
    # Dibuja un círculo para la parte central del hombre
    pygame.draw.ellipse( pantalla,NEGRO, [23 + x, 20 + y, 50, 50])
    # Dibuja un círculo para la parte baja del hombre
    pygame.draw.ellipse( pantalla,NEGRO, [x, 65 + y, 100, 100])


def dibuja_hombrepalitos(pantalla, x, y):
    # Cabeza
    pygame.draw.ellipse(pantalla, NEGRO, [96 - 95 + x, 83 - 83 + y, 10, 10], 0)
 
    # Piernas
    pygame.draw.line(pantalla, NEGRO, [100 - 95 + x, 100 - 83 + y], [105 - 95 + x, 110 - 83 + y], 2)
    pygame.draw.line(pantalla, NEGRO, [100 - 95 + x, 100 - 83 + y], [95 - 95 + x, 110 - 83 + y], 2)
 
    # Cuerpo
    pygame.draw.line(pantalla, ROJO, [100 - 95 + x, 100 - 83 + y], [100 - 95 + x, 90 - 83 + y], 2)
 
    # Brazos
    pygame.draw.line(pantalla, ROJO, [100 - 95 + x, 90 - 83 + y], [104 - 95 + x, 100 - 83 + y], 2)
    pygame.draw.line(pantalla, ROJO, [100 - 95 + x, 90 - 83 + y], [96 - 95 + x, 100 - 83 + y], 2)
    
 
def main():
    """ Programa Principal. """
    #Inicializaciones
    dimensiones = (400, 400)
    #Inicializamos la pantalla
    pantalla = pygame.display.set_mode(dimensiones)
    #Titulo de la pantalla
    pygame.display.set_caption("Hombre moviendose")
    # Ocultar el cursor del ratón !!!!!!!!!!!!!!!!!
    #pygame.mouse.set_visible(False)
    
    #dibujar_hombredenieve(pantalla, 34,10)
    
    #Inicializaciones
    pos_hombre=(60,200)
    hecho = False
    reloj = pygame.time.Clock()
    
    # Velocidad en píxeles por fotograma
    x_speed = 0
    y_speed = 0
     
    # Posición actual
    x_coord = 10
    y_coord = 10


    #Inicio de la accion
    while not hecho:   
        #Limpiamos la pantalla
        pantalla.fill(BLANCO)
    
        #Control de eventos
        for evento in pygame.event.get(): # El usuario hizo algo
            if evento.type == pygame.QUIT:
                print("El usuario solicitó salir.")
                hecho = True # Esto que indica que hemos acabado y sale de este bucle
                # El usuario pulsa una tecla
            elif evento.type == pygame.KEYDOWN:
                # Resuelve que ha sido una tecla de flecha, por lo que
                # ajusta la velocidad.
                if evento.key == pygame.K_LEFT:
                    x_speed = -3
                if evento.key == pygame.K_RIGHT:
                    x_speed = 3
                if evento.key == pygame.K_UP:
                    y_speed = -3
                if evento.key == pygame.K_DOWN:
                    y_speed = 3
            # El usuario suelta la tecla
            elif evento.type == pygame.KEYUP:
                # Si se trata de una tecla de flecha, devuelve el vector a cero
                if evento.key == pygame.K_LEFT:
                    x_speed = 0
                if evento.key == pygame.K_RIGHT:
                    x_speed = 0
                if evento.key == pygame.K_UP:
                    y_speed = 0
                if evento.key == pygame.K_DOWN:
                    y_speed = 0
            elif evento.type == pygame.MOUSEBUTTONDOWN:
                pos_hombre=pygame.mouse.get_pos()
        
        x_coord += x_speed
        y_coord += y_speed
        
        if x_coord<0:
            x_coord=390
        elif x_coord>390:
            x_coord=0
        if y_coord<0:
            y_coord=370
        elif y_coord>370:
            y_coord=0
        #Redibujamos los objetos
        #Movimiento con el raton!!!!!!!!!!!!!!!!!!!!!!
        #dibuja_hombrepalitos(pantalla,pos_hombre[0],pos_hombre[1])        
        dibuja_hombrepalitos(pantalla,x_coord,y_coord)        
        pygame.display.flip()
     
        # Limita a 20 fotogramas por segundo (frames per second)
        reloj.tick(20)
             
if __name__ == "__main__":
    main()