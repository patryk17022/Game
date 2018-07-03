package pl.game.component;


import pl.game.gameObjects.GameObject;

//TODO 1: klasa ma implementować interfejs Component
public class CompMovement{

    private GameObject gameObject = null;

    //TODO 1: Ma byc konstruktor w którym możemy określać prędkość poruszania się

    //TODO 1: w klasie to do robimy poruszanie się postaci
    //TODO 1: zmienne x oraz y znajdują się w zmiennej position w CompGraphics ktory bedzie na pewno dołączony do gracza
    //TODO 1: aby się odwołać to trzeba zrobic tak gameObject.<CompGraphics>GetComponent() to nam zwroci CompGraphics w ktorym sa wektory
    //TODO 1: jesli zaimplementujesz poparawnie metody get i set z interfejsu to gameObject zostanie przypisany i nie bedzie nullerm
}
