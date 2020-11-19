import pygame
from datetime import datetime

NEGRO  = (  0,   0,   0)
BLANCO = (255, 255, 255)
VERDE  = (0,   255,   0)
ROJO   = (255,   0,   0)
AZUL   = (50,   70, 255)

VELOCIDAD=2
DIMENSIONES = (400, 400)
TAM_CUADRO=10

class serpiente:
    def __init__(self, x, y):
        self.posX=x
        self.posY=y
        self.direccion=pygame.K_RIGHT
    
    def movimiento(self):
        if self.direccion == pygame.K_LEFT:
            self.posX += -VELOCIDAD
        if self.direccion == pygame.K_RIGHT:
            self.posX += VELOCIDAD
        if self.direccion == pygame.K_UP:
            self.posY += -VELOCIDAD
        if self.direccion == pygame.K_DOWN:
            self.posY += VELOCIDAD
    
    def movimiento_cuerpo(self):
        if self.direccion == pygame.K_LEFT:
            self.posX += -VELOCIDAD
        if self.direccion == pygame.K_RIGHT:
            self.posX += VELOCIDAD
        if self.direccion == pygame.K_UP:
            self.posY += -VELOCIDAD
        if self.direccion == pygame.K_DOWN:
            self.posY += VELOCIDAD
            
    def fin_juego(self):
        if self.posX==0 or self.posX==DIMENSIONES[0]-TAM_CUADRO or self.posY==0 or self.posY==DIMENSIONES[1]-TAM_CUADRO:
            return True
        else:
            return False
        
    def cambio_movimiento(self,d):
        self.direccion=d
     
def mostrar_puntuacion(ini):
    print()
    print("fin del juego")
    #Calculamos el nuevo tiempo
    instanteFinal = datetime.now()
    tiempo = instanteFinal - ini
    print(f"La partida duro {tiempo.seconds} segundos")
    
def main():
    """ 
        Programa Principal. 
    """
    print("INICIO JUEGO SNAKE")
    #Inicializaciones
    pantalla = pygame.display.set_mode(DIMENSIONES)
    pygame.display.set_caption("Juego de la serpiente")
    #pygame.mouse.set_visible(False)

    #Inicializamos el Timer
    instanteInicial = datetime.now()

    #Inicializaciones
    hecho = False
    reloj = pygame.time.Clock()
    dSerpienteCabeza=serpiente(DIMENSIONES[0]/2,DIMENSIONES[1]/2)
    dSerpiente=[serpiente((DIMENSIONES[0]/2)+TAM_CUADRO+1,DIMENSIONES[1]/2)]

    #Inicio de la accion
    while not hecho:   
        #Limpiamos la pantalla
        pantalla.fill(BLANCO)
        
        #Control de eventos
        for evento in pygame.event.get(): # El usuario hizo algo
            if evento.type == pygame.QUIT:
                print("El usuario solicitó salir.")
                hecho = True # Esto que indica que hemos acabado y sale de este bucle
            elif evento.type == pygame.KEYDOWN:
                dSerpienteCabeza.cambio_movimiento(evento.key)
                for ser in dSerpiente:
                    ser.cambio_movimiento(evento.key)
 
        #Generamos un nuevo movimiento
        dSerpienteCabeza.movimiento()
        pygame.draw.rect(pantalla, NEGRO, [dSerpienteCabeza.posX, dSerpienteCabeza.posY, TAM_CUADRO, TAM_CUADRO])
        for ser in dSerpiente:
            ser.movimiento_cuerpo()
            pygame.draw.rect(pantalla, NEGRO, [ser.posX, ser.posY, TAM_CUADRO, TAM_CUADRO])
        pygame.display.flip()
     
        if dSerpienteCabeza.fin_juego():
            mostrar_puntuacion(instanteInicial)
            hecho = True
            
        # Limita a 20 fotogramas por segundo (frames per second)
        reloj.tick(20)
    
if __name__ == "__main__":
    main()