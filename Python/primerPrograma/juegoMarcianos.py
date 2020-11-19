import pygame

NEGRO  = (  0,   0,   0)
BLANCO = (255, 255, 255)
VERDE  = (0,   255,   0)
ROJO   = (255,   0,   0)
AZUL   = (50,   70, 255)

def main():
    """ Programa Principal. """

    #Inicializaciones
    dimensiones = (700, 500)
    #inicializamos
    pygame.init()
    #Inicializamos la pantalla
    pantalla = pygame.display.set_mode(dimensiones)
    #Titulo de la pantalla
    pygame.display.set_caption("Espacio")
    # Ocultar el cursor del ratón !!!!!!!!!!!!!!!!!
    pygame.mouse.set_visible(False)
    
    #Cargamos las imagenes
    imagen_defondo = pygame.image.load("saturn_family1.jpg").convert()
    imagen_protagonista = pygame.image.load("player.png").convert()
    imagen_protagonista.set_colorkey(NEGRO)
    
    #Sonido
    pulsar_sonido = pygame.mixer.Sound("laser5.ogg")
    
    #Inicializaciones
    hecho = False
    reloj = pygame.time.Clock()

    posicion_jugador=[20,50]
    #Inicio de la accion
    while not hecho:      
        #Control de eventos
        for evento in pygame.event.get(): # El usuario hizo algo
            if evento.type == pygame.QUIT:
                print("El usuario solicitó salir.")
                hecho = True # Esto que indica que hemos acabado y sale de este bucle
            elif evento.type == pygame.MOUSEBUTTONDOWN:
                posicion_jugador=pygame.mouse.get_pos()
                pulsar_sonido.play()
 
        #impresion de los graficos
        pantalla.blit(imagen_defondo, [0, 0])
        pantalla.blit(imagen_protagonista, [posicion_jugador[0], posicion_jugador[1]])
        
        pygame.display.flip()
     
        # Limita a 20 fotogramas por segundo (frames per second)
        reloj.tick(20)
             
if __name__ == "__main__":
    main()