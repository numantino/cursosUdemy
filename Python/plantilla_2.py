import pygame

NEGRO  = (  0,   0,   0)
BLANCO = (255, 255, 255)
VERDE  = (0,   255,   0)
ROJO   = (255,   0,   0)
AZUL   = (50,   70, 255)

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

    
    #Inicializaciones
    pos_hombre=(60,200)
    hecho = False
    reloj = pygame.time.Clock()


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
 
        pygame.display.flip()
     
        # Limita a 20 fotogramas por segundo (frames per second)
        reloj.tick(20)
             
if __name__ == "__main__":
    main()