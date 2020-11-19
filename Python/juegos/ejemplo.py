import pygame
import random

NEGRO  = (  0,   0,   0)
BLANCO = (255, 255, 255)
VERDE  = (0,   255,   0)
ROJO   = (255,   0,   0)
AZUL   = (50,   70, 255)

#VARIABLES PARA LAS MEDIDAS DE LOS OBJETOS
TAM_PANT_X=400
TAM_PANT_Y=400
TAM_PATO_X=40
TAM_PATO_Y=40
#
MAX_NUM_PATOS=2
#
VELOCIDAD=4

class Pato:
    def __init__(self,ima,vel):
        self.pos_x=random.randint(0,(TAM_PANT_Y-TAM_PATO_Y))
        self.pos_y=(TAM_PANT_Y-TAM_PATO_Y)
        self.mostrar=False
        #
        if self.pos_x<100:
            self.direccion_x=1*vel
        elif self.pos_x<200:
            self.direccion_x=0.5*vel
        elif self.pos_x<300:
            self.direccion_x=-0.5*vel
        else:
            self.direccion_x=-1*vel
        #
        self.direccion_y=1*vel
        self.imagen=ima
        
    def mover(self):
        if self.pos_y < 0 or self.pos_y > (TAM_PANT_Y-TAM_PATO_Y) or self.pos_x<0 or self.pos_x>(TAM_PANT_Y-TAM_PATO_Y):
            self.mostrar=False
            return False
        else:
            self.pos_x+=self.direccion_x
            self.pos_y-=self.direccion_y
            return True
    
    def muerto(self,disp):
        if self.mostrar:
            print(f"Coordenadas del pato ({self.pos_x},{self.pos_y}), y las corrdenadas del disparo({disp[0]},{disp[1]})") 
            if (disp[0]-20) > self.pos_x:
                if (disp[1]-20) < self.pos_y and (disp[0]+20) > self.pos_y:
                    self.mostrar=False
                    return True
        else:
            return False
     
    
def main():
    """ Programa Principal. """
    #Inicializaciones
    #dimensiones = (1000,650)
    dimensiones = (TAM_PANT_X,TAM_PANT_Y)
    #inicializacion
    pygame.init()
    pantalla = pygame.display.set_mode(dimensiones)
    #pantalla = pygame.display.set_mode(dimensiones, pygame.FULLSCREEN)
    #Titulo de la pantalla
    pygame.display.set_caption("Juego de los Patos")
    # Ocultar el cursor del ratón !!!!!!!!!!!!!!!!!
    #pygame.mouse.set_visible(False)

    
    #Inicializaciones    
    reloj = pygame.time.Clock()

    #Cargamos las imagenes
    #imagen_defondo = pygame.image.load("saturn_family1.jpg").convert()   
    #EL tamaño de la imagen es 40x40
    imagen_pato = pygame.image.load(".\\img\\pato.png").convert()
    imagen_pato.set_colorkey(NEGRO)
    
    #Creamos lista de patos
    lista_patos=[]
    for i in range(MAX_NUM_PATOS):
        lista_patos.append(Pato(imagen_pato,VELOCIDAD))
    lista_patos[0].mostrar=True
    pato_mostrado=0
    
    patos_muertos=0
    patos_escapados=0

    #Inicio de la accion
    hecho = False
    while not hecho:   
        #Limpiamos la pantalla
        pantalla.fill(BLANCO)
    
        #Control de eventos
        for evento in pygame.event.get(): # El usuario hizo algo
            if evento.type == pygame.QUIT:
                print("El usuario solicitó salir.")
                hecho = True # Esto que indica que hemos acabado y sale de este bucle
                # El usuario pulsa una tecla
            elif evento.type == pygame.MOUSEBUTTONDOWN:
                if lista_patos[pato_mostrado].muerto(pygame.mouse.get_pos()):
                    print("Pato muerto")
                    pato_mostrado+=1
        

        #comprobamos la finalizacion del juego
        if (pato_mostrado) > MAX_NUM_PATOS:
            print("no tenemos mas patos")
            hecho = True
            
        #Movemos el pato
        if not lista_patos[pato_mostrado].mover():
            print("El pato escapo")
            patos_escapados+=1
            #generamos otro pato
            pato_mostrado+=1

        #Mostramos el pato
        pantalla.blit(lista_patos[pato_mostrado].imagen, [lista_patos[pato_mostrado].pos_x, lista_patos[pato_mostrado].pos_y])
        pygame.display.flip()
     
        # Limita a 60 fotogramas por segundo (frames per second)
        reloj.tick(60)
    

    print("FIN DEL JUEGO")
    print(f"********** PATOS MUERTOS={patos_muertos}")
    print(f"********** PATOS ESCAPADOS={patos_escapados}")

    
if __name__ == "__main__":
    main()