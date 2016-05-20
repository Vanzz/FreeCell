import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Stack baralho;
    Stack barAux;
    Node aux;

    List<Cartas> todos = getObjects(null);
    Cartas a;

    boolean listou;
    boolean removeu;

    public MyWorld(){   
        super(800, 600, 1); 
        // precisa inserir 8 pilhas pra startar as cartas e 8 pra segurar as pilhas em ordem.
        baralho = new Stack();
        barAux = new Stack();
    }

    public void started(){
        listou = false;
        removeu = false;
        //Criação do baralho

        for(int i = 1; i <= 13; i++){
            Cartas c = new Cartas(i+"C", false);
            Cartas d = new Cartas(i+"D", false);
            Cartas h = new Cartas(i+"H", false);
            Cartas s = new Cartas(i+"S", false);

            Node node1 = new Node();
            Node node2 = new Node();
            Node node3 = new Node();
            Node node4 = new Node();

            node1.setCarta(c);
            node2.setCarta(d);
            node3.setCarta(h);
            node4.setCarta(s);

            baralho.inserir(node1);
            baralho.inserir(node2);
            baralho.inserir(node3);
            baralho.inserir(node4);

            addObject(c, 150+(i/2), 150+(i/2));
            addObject(d, 150+(i/2), 150+(i/2));
            addObject(h, 150+(i/2), 150+(i/2));
            addObject(s, 150+(i/2), 150+(i/2));
        }
    }
    
    public void act(){
        todos = getObjects(null);

        if(Greenfoot.mouseDragged(null)){
            if(mostraObjects(Greenfoot.getMouseInfo()) != null){
                a = mostraObjects(Greenfoot.getMouseInfo());
                if(a.isLast()){
                    a.setLocation(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
                    aux = baralho.getNode();
                    removeu = false;
                }
            }
        }

        if(Greenfoot.mouseDragEnded(a) && !removeu){
            removeu = true;
            if(!a.getFlipped()){
                aux.getCarta().flip(true);
                barAux.inserir(aux);
                baralho.remover();
            }
            listou = false;
            removeu = false;
        }

        if(Greenfoot.isKeyDown("L") && !listou){
            baralho.listar();
            barAux.listar();
            listou = true;
        }
    }

    public Cartas mostraObjects(MouseInfo m)
    {
        for(int i = 0; i < todos.size(); i++){       
            if(todos.get(i) != null){                
                if(todos.get(i).equals(m.getActor())){
                    return todos.get(i);
                }
            }        
        }
        return null;
    }
}