package pl.game.component;

import pl.game.GameEngine;
import pl.game.gameObjects.GameObject;
import pl.game.utility.Vector2D;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CompPhysics implements Component{

    public Vector2D position;
    public Vector2D size;
    private Vector2D velocity;
    public float bouncing;
    public float speed;
    public Vector2D forcetoAdd;
    public List<GameObject> collisionList = new ArrayList<>();

    private CompGraphics graph;
    private GameObject gameObject;

    public void clearCollision(){
        collisionList = new ArrayList<>();
    }

    public CompPhysics(GameObject gameObject){
        this.gameObject = gameObject;
        graph =  gameObject.GetComponent(CompGraphics.class);
        position = graph.getObjectPosition();
        size = graph.getObjectSize();

        velocity = new Vector2D(0,0);
        forcetoAdd = new Vector2D(0,0);
        bouncing = 0.5f;
        speed = 0;
    }
    public void addVelocity(int x, int y){
        velocity.add(x,y);
    }

    public void Update(JFrame window) {

        if(collisionList.isEmpty() == false){

            for(GameObject coll :collisionList) {
                CompGraphics gr2 = coll.GetComponent(CompGraphics.class);
                CompPhysics ph2 = coll.GetComponent(CompPhysics.class);

                Vector2D vect = new Vector2D(gr2.getObjectPosition().getX()- position.getX(),gr2.getObjectPosition().getY()-position.getY());
                double vectLength =  Math.sqrt(Math.pow(vect.getX(),2)+Math.pow(vect.getY(),2));
                double x = vect.getX()/vectLength;
                double y = vect.getY()/vectLength;

                double angle = Math.abs(Math.atan(y/x)*180/3.14);


                    if(angle <= 45)
                        if (gr2.getObjectPosition().getX() < position.getX() && gr2.getObjectPosition().getX() + gr2.getObjectSize().getX() > position.getX()) {
                            position.setX(gr2.getObjectPosition().getX() + gr2.getObjectSize().getX());
                        } else if (gr2.getObjectPosition().getX() < position.getX() + size.getX() && gr2.getObjectPosition().getX() + gr2.getObjectSize().getX() > position.getX() + size.getX()) {
                            position.setX(gr2.getObjectPosition().getX() - size.getX());
                        }

                    if(angle > 45)
                        if (gr2.getObjectPosition().getY() < position.getY() && gr2.getObjectPosition().getY() + gr2.getObjectSize().getY() > position.getY()) {
                            position.setY(gr2.getObjectPosition().getY() + gr2.getObjectSize().getY());

                        } else if (gr2.getObjectPosition().getY() < position.getY() + size.getY() && gr2.getObjectPosition().getY() + gr2.getObjectSize().getY() > position.getY() + size.getY()) {
                            position.setY(gr2.getObjectPosition().getY() - size.getY());
                            if(ph2.velocity.getX() > velocity.getX())
                                velocity.setX(ph2.velocity.getX());
                        }

                if (Math.abs(position.getY() - gr2.getObjectPosition().getY()) < gr2.getObjectSize().getY() + size.getY()) {
                    ph2.forcetoAdd.addY((int) (velocity.getY() * bouncing));
                    velocity.setY(((int) (-velocity.getY() * bouncing)));
                    //forcetoAdd.addY((int)(-velocity.getY() + (-velocity.getY() * bouncing)));
                }
                if (Math.abs(position.getX() - gr2.getObjectPosition().getX()) < gr2.getObjectSize().getX() + size.getX()) {
                    ph2.forcetoAdd.addX((int) (velocity.getX() * bouncing));
                    velocity.setX((int) (-velocity.getX() * bouncing));
                   // forcetoAdd.addX((int)(-velocity.getX() + (-velocity.getX() * bouncing)));
                }


            }
        }



        forcetoAdd.addY(1);



       /* if(position.getY()+size.getY()/2  > GameEngine.getHeight()/2)
            forcetoAdd.addY(-1);
        else
            if(position.getY()+size.getY()/2  < GameEngine.getHeight()/2)
            forcetoAdd.addY(1);*/

        if(position.getY()+size.getY() >= GameEngine.getHeight()){
            position.setY(GameEngine.getHeight()-size.getY());
            velocity.setY(0);
          //  velocity.setX(1);
          /*  if(position.getX()+size.getX()/2 > GameEngine.getWidth()/2)
                forcetoAdd.addX(-1);
            else if(position.getX()+size.getX()/2  < GameEngine.getWidth()/2)
                forcetoAdd.addX(1);*/
        }


        velocity.add(forcetoAdd);
        forcetoAdd = new Vector2D(0,0);
        graph.getObjectPosition().add(velocity);

    }

    public void Draw(JFrame window) {

    }

    public GameObject GetGameObject() {
        return gameObject;
    }

    public void SetGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public boolean isCollision(CompPhysics phys){

        boolean odp = false;

        this.position.add(this.velocity);
        phys.position.add(phys.velocity);

        if((    (this.position.getX() <= phys.position.getX() && this.position.getX() + this.size.getX() >= phys.position.getX() ) ||
                (this.position.getX() <= phys.position.getX()+phys.size.getX() && this.position.getX() + this.size.getX() >= phys.position.getX()+phys.size.getX()) ||
                (this.position.getX() >= phys.position.getX() && this.position.getX() + this.size.getX() <= phys.position.getX()+phys.size.getX())) &&

                ((this.position.getY() <= phys.position.getY() && this.position.getY() + this.size.getY() >= phys.position.getY() ) ||
                (this.position.getY() <= phys.position.getY()+phys.size.getY() && this.position.getY() + this.size.getY() >= phys.position.getY()+phys.size.getY()) ||
                (this.position.getY() >= phys.position.getY() && this.position.getY() + this.size.getY() <= phys.position.getY()+phys.size.getY())
                )){
            odp = true;
        }else
            odp = false;

        this.position.add(-this.velocity.getX(),-this.velocity.getY());
        phys.position.add(-phys.velocity.getX(),-phys.velocity.getY());

        return odp;
    }
}
