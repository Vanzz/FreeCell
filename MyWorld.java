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

    List<Cartas> todos = getObjects(null);
    Cartas a;

    boolean listou;
    boolean salvarL;
    int pX, pY;

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
    }

    public void act(){
        todos = getObjects(null);

        // if(Greenfoot.getMouseInfo() != null)
        // System.out.println("x:"+Greenfoot.getMouseInfo().getX()+" y:"+Greenfoot.getMouseInfo().getY());

        if(Greenfoot.mouseDragged(null)){
            if(mostraObjects(Greenfoot.getMouseInfo()) != null){
                a = mostraObjects(Greenfoot.getMouseInfo());
                if(!salvarL){
                    pX = a.getX();
                    pY = a.getY();
                    salvarL = true;
                }
                if(a.isLast() && isBottom(a)){
                    a.setLocation(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
                    aux = a.getStack().getNode();
                }
            }
        }

        if(Greenfoot.mouseDragEnded(a)){
            if(mostraObjects(Greenfoot.getMouseInfo()) != null){
                if(Greenfoot.getMouseInfo().getX() > 409 && Greenfoot.getMouseInfo().getX() < 481 &&
                Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135){
                    topOne.inserir(aux);
                    a.getStack().remover();
                    aux.getCarta().setStack(topOne);
                    a.setLocation(440, 185);
                }else if(Greenfoot.getMouseInfo().getX() > 481 && Greenfoot.getMouseInfo().getX() < 546 &&
                Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135){
                    topTwo.inserir(aux);
                    a.getStack().remover();
                    aux.getCarta().setStack(topTwo);
                    a.setLocation(510, 185);
                }else if(Greenfoot.getMouseInfo().getX() > 551 && Greenfoot.getMouseInfo().getX() < 611 &&
                Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135){
                    topThree.inserir(aux);
                    a.getStack().remover();
                    aux.getCarta().setStack(topThree);
                    a.setLocation(580, 185);
                }else if(Greenfoot.getMouseInfo().getX() > 621 && Greenfoot.getMouseInfo().getX() < 681 &&
                Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135){
                    topFour.inserir(aux);
                    a.getStack().remover();
                    aux.getCarta().setStack(topFour);
                    a.setLocation(650, 185);
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
        if(c.getStack() != topOne && c.getStack() != topTwo && 
        c.getStack() != topThree && c.getStack() != topFour){
            return true;
        }else{
            return false;
        }
    }
}