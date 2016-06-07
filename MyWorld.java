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
    Stack topOne, topTwo, topThree, topFour; 
    Stack botOne, botTwo, botThree, botFour, botFive, botSix, botSeven, botEight;

    Node aux;
    Node n;

    List<Cartas> todos;
    Cartas a;

    boolean listou;
    boolean salvarL;
    int pX, pY;
    boolean h1,h2,h3,h4;

    Node ho1,ho2,ho3,ho4;

    ArrayList<Cartas> rList;

    public MyWorld(){   
        super(800, 600, 1); 

        //Creating top stacks
        topOne = new Stack(); 
        topTwo = new Stack();
        topThree = new Stack();
        topFour = new Stack();

        //Creating bottom stacks
        botOne = new Stack();
        botTwo = new Stack();
        botThree = new Stack();
        botFour = new Stack();
        botFive = new Stack();
        botSix = new Stack();
        botSeven = new Stack();
        botEight = new Stack();
    }

    public void started(){
        rList = new ArrayList<Cartas>();
        listou = false;
        int espacamento = 70;

        for(int i = 1; i <= 13; i++)
        {
            Cartas c = new Cartas(i+"C", true);
            Cartas d = new Cartas(i+"D", false);
            Cartas h = new Cartas(i+"H", false);
            Cartas s = new Cartas(i+"S", true);

            rList.add(c);
            rList.add(d);
            rList.add(h);
            rList.add(s);
        }

        randomSpread();
        todos = getObjects(null);
        h1 = false;
        h2 = false;
        h3 = false;
        h4 = false;
    }

    public void act(){
        todos = getObjects(null);
        //" h1:"+h1+" ho1:"+ho1+" ho2:"+ho2+" ho3:"+ho3+" ho4:"+ho4
        if(Greenfoot.getMouseInfo() != null)
            System.out.println("x:"+Greenfoot.getMouseInfo().getX()+" y:"+Greenfoot.getMouseInfo().getY());

        if(Greenfoot.mouseDragged(null)){
            if(mostraObjects(Greenfoot.getMouseInfo()) != null){
                a = mostraObjects(Greenfoot.getMouseInfo());
                if(!salvarL){
                    pX = a.getX();
                    pY = a.getY();
                    salvarL = true;
                }
                if(a.isLast() && isBottom(a) && a.getStack() != null){
                    a.setLocation(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
                    aux = a.getStack().getNode();
                }
            }
        }

        if(Greenfoot.mouseDragEnded(a)){
            if(mostraObjects(Greenfoot.getMouseInfo()) != null && a.isLast()){
                /*Hold1*/if(Greenfoot.getMouseInfo().getX() > 125 && Greenfoot.getMouseInfo().getX() < 195 &&
                Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135 && !h1 && isBottom(a)){
                    //topOne.inserir(aux);
                    ho1 = aux;
                    a.getStack().remover();
                    aux.getCarta().setStack(null);
                    a.setLocation(160, 185);
                    h1 = !h1;
                }
                /*Hold2*/else if(Greenfoot.getMouseInfo().getX() > 195 && Greenfoot.getMouseInfo().getX() < 265 &&
                Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135 && !h2 && isBottom(a)){
                    //topTwo.inserir(aux);
                    ho2 = aux;
                    a.getStack().remover();
                    aux.getCarta().setStack(null);
                    a.setLocation(230, 185);
                    h2 = !h2;
                }
                /*Hold3*/else if(Greenfoot.getMouseInfo().getX() > 265 && Greenfoot.getMouseInfo().getX() < 335 &&
                Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135 && !h3 && isBottom(a)){
                    //topThree.inserir(aux);
                    ho3 = aux;
                    a.getStack().remover();
                    aux.getCarta().setStack(null);
                    a.setLocation(300, 185);
                    h3 = !h3;
                }
                /*Hold4*/else if(Greenfoot.getMouseInfo().getX() > 335 && Greenfoot.getMouseInfo().getX() < 405 &&
                Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135 && !h4 && isBottom(a)){
                    //topFour.inserir(aux);
                    ho4 = aux;
                    a.getStack().remover();
                    aux.getCarta().setStack(null);
                    a.setLocation(370, 185);
                    h4 = !h4;
                }
                /*TopOne*/else if(Greenfoot.getMouseInfo().getX() > 405 && Greenfoot.getMouseInfo().getX() < 475 &&
                Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135 && isBottom(a)){
                    topOne.inserir(aux);
                    a.getStack().remover();
                    aux.getCarta().setStack(topOne);
                    a.setLocation(440, 185);
                }
                /*TopTwo*/else if(Greenfoot.getMouseInfo().getX() > 475 && Greenfoot.getMouseInfo().getX() < 545 &&
                Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135 && isBottom(a)){
                    topTwo.inserir(aux);
                    a.getStack().remover();
                    aux.getCarta().setStack(topTwo);
                    a.setLocation(510, 185);
                }
                /*TopThree*/else if(Greenfoot.getMouseInfo().getX() > 545 && Greenfoot.getMouseInfo().getX() < 605 &&
                Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135 && isBottom(a)){
                    topThree.inserir(aux);
                    a.getStack().remover();
                    aux.getCarta().setStack(topThree);
                    a.setLocation(580, 185);
                }
                /*TopFour*/else if(Greenfoot.getMouseInfo().getX() > 605 && Greenfoot.getMouseInfo().getX() < 675 &&
                Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135 && isBottom(a)){
                    topFour.inserir(aux);
                    a.getStack().remover();
                    aux.getCarta().setStack(topFour);
                    a.setLocation(650, 185);
                }
                /*BotOne*/else if(Greenfoot.getMouseInfo().getX() > 125 && Greenfoot.getMouseInfo().getX() < 195 &&
                Greenfoot.getMouseInfo().getY() < botOne.getNode().getCarta().getY() + 50 && Greenfoot.getMouseInfo().getY() > botOne.getNode().getCarta().getY() - 50
                && isBottom(a) && a.getStack() != botOne){
                    n = botOne.getNode();
                    a.getStack().remover();
                    botOne.inserir(aux);
                    aux.getCarta().setStack(botOne);
                    a.setLocation(n.getCarta().getX(), n.getCarta().getY() + 20);
                }
                /*BotTwo*/else if(Greenfoot.getMouseInfo().getX() > 195 && Greenfoot.getMouseInfo().getX() < 265 &&
                Greenfoot.getMouseInfo().getY() < botTwo.getNode().getCarta().getY() + 50 && Greenfoot.getMouseInfo().getY() > botTwo.getNode().getCarta().getY() - 50
                && isBottom(a)  && a.getStack() != botTwo){
                    n = botTwo.getNode();
                    a.getStack().remover();
                    botTwo.inserir(aux);
                    aux.getCarta().setStack(botTwo);
                    a.setLocation(n.getCarta().getX(), n.getCarta().getY() + 20);
                }
                /*BotThree*/else if(Greenfoot.getMouseInfo().getX() > 265 && Greenfoot.getMouseInfo().getX() < 335 &&
                Greenfoot.getMouseInfo().getY() < botThree.getNode().getCarta().getY() + 50 && Greenfoot.getMouseInfo().getY() > botThree.getNode().getCarta().getY() - 50
                && isBottom(a) && a.getStack() != botThree){
                    n = botThree.getNode();
                    a.getStack().remover();
                    botThree.inserir(aux);
                    aux.getCarta().setStack(botThree);
                    a.setLocation(n.getCarta().getX(), n.getCarta().getY() + 20);
                }
                /*BotFour*/else if(Greenfoot.getMouseInfo().getX() > 335 && Greenfoot.getMouseInfo().getX() < 405 &&
                Greenfoot.getMouseInfo().getY() < botFour.getNode().getCarta().getY() + 50 && Greenfoot.getMouseInfo().getY() > botFour.getNode().getCarta().getY() - 50
                && isBottom(a) && a.getStack() != botFour){
                    n = botFour.getNode();
                    a.getStack().remover();
                    botFour.inserir(aux);
                    aux.getCarta().setStack(botFour);
                    a.setLocation(n.getCarta().getX(), n.getCarta().getY() + 20);
                }
                /*BotFive*/else if(Greenfoot.getMouseInfo().getX() > 405 && Greenfoot.getMouseInfo().getX() < 475 &&
                Greenfoot.getMouseInfo().getY() < botFive.getNode().getCarta().getY() + 50 && Greenfoot.getMouseInfo().getY() > botFive.getNode().getCarta().getY() - 50
                && isBottom(a) && a.getStack() != botFive){
                    n = botFive.getNode();
                    a.getStack().remover();
                    botFive.inserir(aux);
                    aux.getCarta().setStack(botFive);
                    a.setLocation(n.getCarta().getX(), n.getCarta().getY() + 20);
                }
                /*BotSix*/else if(Greenfoot.getMouseInfo().getX() > 475 && Greenfoot.getMouseInfo().getX() < 545 &&
                Greenfoot.getMouseInfo().getY() < botSix.getNode().getCarta().getY() + 50 && Greenfoot.getMouseInfo().getY() > botSix.getNode().getCarta().getY() - 50
                && isBottom(a) && a.getStack() != botSix){
                    n = botSix.getNode();
                    a.getStack().remover();
                    botSix.inserir(aux);
                    aux.getCarta().setStack(botSix);
                    a.setLocation(n.getCarta().getX(), n.getCarta().getY() + 20);
                }
                /*BotSeven*/else if(Greenfoot.getMouseInfo().getX() > 545 && Greenfoot.getMouseInfo().getX() < 615 &&
                Greenfoot.getMouseInfo().getY() < botSeven.getNode().getCarta().getY() + 50 && Greenfoot.getMouseInfo().getY() > botSeven.getNode().getCarta().getY() - 50
                && isBottom(a) && a.getStack() != botSeven){
                    n = botSeven.getNode();
                    a.getStack().remover();
                    botSeven.inserir(aux);
                    aux.getCarta().setStack(botSeven);
                    a.setLocation(n.getCarta().getX(), n.getCarta().getY() + 20);
                }
                /*BotEight*/else if(Greenfoot.getMouseInfo().getX() > 615 && Greenfoot.getMouseInfo().getX() < 685 &&
                Greenfoot.getMouseInfo().getY() < botEight.getNode().getCarta().getY() + 50 && Greenfoot.getMouseInfo().getY() > botEight.getNode().getCarta().getY() - 50
                && isBottom(a) && a.getStack() != botEight){
                    n = botEight.getNode();
                    a.getStack().remover();
                    botEight.inserir(aux);
                    aux.getCarta().setStack(botEight);
                    a.setLocation(n.getCarta().getX(), n.getCarta().getY() + 20);
                }else{
                    a.setLocation(pX, pY);
                }
                salvarL = false;
                listou = false;
            }
        }

        if(Greenfoot.isKeyDown("L") && !listou){
            topOne.listar();
            topTwo.listar();
            topThree.listar();
            topFour.listar();

            botOne.listar();
            botTwo.listar();
            botThree.listar();
            botFour.listar();
            botFive.listar();
            botSix.listar();
            botSeven.listar();
            botEight.listar();

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

    public int range(int min, int max)
    {
        int range = Math.abs(max - min) + 1;     
        return (int)(Math.random() * range) + (min <= max ? min : max);
    }

    public void randomSpread(){
        int randomIndex;
        int maxStackIndex;
        int stackIndex;
        for(int i = 0; i < 8 ;i++){
            maxStackIndex = 10-i;
            stackIndex = 0;
            int espaçamento = 0; 
            while(stackIndex < maxStackIndex){
                if(rList.size() == 0) break;

                randomIndex = range(0,rList.size()-1);
                Node a = new Node(rList.get(randomIndex));

                if(i == 0){
                    botOne.inserir(a);
                    rList.get(randomIndex).setStack(botOne);
                    addObject(a.getCarta(), 90 + 70, 285 + espaçamento);
                    espaçamento += 20;
                }else if(i == 1){
                    botTwo.inserir(a);
                    rList.get(randomIndex).setStack(botTwo);
                    addObject(a.getCarta(), 160 + 70, 285 + espaçamento);
                    espaçamento += 20;
                }else if(i == 2){
                    botThree.inserir(a);
                    rList.get(randomIndex).setStack(botThree);
                    addObject(a.getCarta(), 230 + 70, 285 + espaçamento);
                    espaçamento += 20;
                }else if(i == 3){
                    botFour.inserir(a);
                    rList.get(randomIndex).setStack(botFour);
                    addObject(a.getCarta(), 300 + 70, 285 + espaçamento);
                    espaçamento += 20;
                }else if(i == 4){
                    botFive.inserir(a);
                    rList.get(randomIndex).setStack(botFive);
                    addObject(a.getCarta(), 370 + 70, 285 + espaçamento);
                    espaçamento += 20;
                }else if(i == 5){
                    botSix.inserir(a);
                    rList.get(randomIndex).setStack(botSix);
                    addObject(a.getCarta(), 440 + 70, 285 + espaçamento);
                    espaçamento += 20;
                }else if(i == 6){
                    botSeven.inserir(a);
                    rList.get(randomIndex).setStack(botSeven);
                    addObject(a.getCarta(), 510 + 70, 285 + espaçamento);
                    espaçamento += 20;
                }else if(i == 7){
                    botEight.inserir(a);
                    rList.get(randomIndex).setStack(botEight);
                    addObject(a.getCarta(), 580 + 70, 285 + espaçamento);
                    espaçamento += 20;
                }

                rList.remove(rList.get(randomIndex));
                stackIndex++;
            }
        }
    }

    public boolean isBottom(Cartas c){
        if(c.getStack() == null){
            return false;
        }else if(c.getStack() != topOne && c.getStack() != topTwo && 
        c.getStack() != topThree && c.getStack() != topFour){
            return true;
        }else{
            return false;
        }
    }
}