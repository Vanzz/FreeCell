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
    Stack hold1, hold2, hold3, hold4;
    Node aux;
    Node n;

    String[] clubs = {"1C", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "11C", "12C", "13C"};
    String[] diamonds = {"1D", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "11D", "12D", "13D"};
    String[] hearts = {"1H", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "11H", "12H", "13H"};
    String[] spades = {"1S", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "11S", "12S", "13S"};

    List<Cartas> todos;
    Cartas a, b;

    boolean listou;
    boolean salvarL;
    int pX, pY, cAux, dAux, hAux, sAux;
    boolean h1,h2,h3,h4;

    Node ho1,ho2,ho3,ho4;

    ArrayList<Cartas> rList;

    public MyWorld(){   
        super(800, 600, 1); 
        GreenfootImage background; 
        background = new GreenfootImage("images/background.jpg");
        setBackground(background);

        hold1 = new Stack("hold1");
        hold2 = new Stack("hold2");
        hold3 = new Stack("hold3");
        hold4 = new Stack("hold4");
        
        //Creating top stacks
        topOne = new Stack("topOne"); 
        topTwo = new Stack("topTwo");
        topThree = new Stack("topThree");
        topFour = new Stack("topFour");

        //Creating bottom stacks
        botOne = new Stack("botOne");
        botTwo = new Stack("botTwo");
        botThree = new Stack("botThree");
        botFour = new Stack("botFour");
        botFive = new Stack("botFive");
        botSix = new Stack("botSix");
        botSeven = new Stack("botSeven");
        botEight = new Stack("botEight");
    }

    public void started(){
        rList = new ArrayList<Cartas>();
        listou = false;
        int espacamento = 70;
        
        Cartas club = new Cartas("Backborder Club", false, null);
        Cartas diamond = new Cartas("Backborder Diamond", false, null);
        Cartas heart = new Cartas("Backborder Heart", false, null);
        Cartas spade = new Cartas("Backborder Spade", false, null);
        Cartas k = new Cartas();
        Cartas k1 = new Cartas();
        Cartas k2 = new Cartas();
        Cartas k3 = new Cartas();
        
        addObject(k, 160, 185);
        addObject(k1, 230, 185);
        addObject(k2, 300, 185);
        addObject(k3, 370, 185);
        addObject(club, 440, 185);
        addObject(diamond, 510, 185);
        addObject(heart, 580, 185);
        addObject(spade, 650, 185);

        for(int i = 1; i <= 13; i++)
        {
            Cartas c = new Cartas(i+"C", true, null);
            Cartas d = new Cartas(i+"D", false, null);
            Cartas h = new Cartas(i+"H", false, null);
            Cartas s = new Cartas(i+"S", true, null);

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
        if(victory()) {
            Cartas a = new Cartas("victory", false, null);
            a.getImage().scale(500, 500);
            addObject(a, 400,300);
            Greenfoot.stop();
        }
        //" h1:"+h1+" ho1:"+ho1+" ho2:"+ho2+" ho3:"+ho3+" ho4:"+ho4
        if(Greenfoot.getMouseInfo() != null){
            //System.out.println("x:"+Greenfoot.getMouseInfo().getX()+" y:"+Greenfoot.getMouseInfo().getY()+" actors:"+numberOfObjects());
            //System.out.println(a);
        }
        
        if(Greenfoot.getMouseInfo() != null && mostraObjects(Greenfoot.getMouseInfo()) != null){
            a = mostraObjects(Greenfoot.getMouseInfo());
            //System.out.println(a+":"+a.getStack()+":"+a.isLast());
            if(Greenfoot.mouseDragged(a) && a.getStack() != null){
                if(!salvarL){
                    pX = a.getX();
                    pY = a.getY();
                    salvarL = true;
                }

                if((a.isLast() && isBottom(a)) || (a.isLast() && !isBottom(a))){
                    a.setLocation(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
                    aux = a.getStack().getNode();
                }
            }

            if(Greenfoot.mouseDragEnded(a) && a.getStack() != null){
                if(a.isLast()){
                    Cartas carta = new Cartas(a.getImagem(), a.isBlack(), a.getStack());

                    /*Hold1*/
                    if(Greenfoot.getMouseInfo().getX() > 125 && Greenfoot.getMouseInfo().getX() < 195
                    && Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135 && hold1.isEmpty()){
                        managerHold(ho1, hold1, carta, 160, 185);
                        h1 = !h1;
                        removeObject(a);
                    }
                    /*Hold2*/
                    else if(Greenfoot.getMouseInfo().getX() > 195 && Greenfoot.getMouseInfo().getX() < 265
                    && Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135 && hold2.isEmpty()){
                        managerHold(ho2, hold2, carta, 230, 185);
                        h2 = !h2;
                        removeObject(a);
                    }
                    /*Hold3*/
                    else if(Greenfoot.getMouseInfo().getX() > 265 && Greenfoot.getMouseInfo().getX() < 335
                    && Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135 && hold3.isEmpty()){
                        managerHold(ho3, hold3, carta, 300, 185);
                        h3 = !h3;
                        removeObject(a);
                    }
                    /*Hold4*/
                    else if(Greenfoot.getMouseInfo().getX() > 335 && Greenfoot.getMouseInfo().getX() < 405
                    && Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135 && hold4.isEmpty()){
                        managerHold(ho4, hold4, carta, 370, 185);
                        h4 = !h4;
                        removeObject(a);
                    }else{
                        a.setLocation(pX, pY);
                    }

                    /*TopOne*/
                    if(Greenfoot.getMouseInfo().getX() > 405 && Greenfoot.getMouseInfo().getX() < 475
                    && Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135 && isBottom(a)){
                        if(a.getImagem().equalsIgnoreCase(clubs[cAux])){
                            managerTop(topOne, carta, 440, 185);
                            removeObject(a);
                            cAux++;
                        }
                    }
                    /*TopTwo*/
                    else if(Greenfoot.getMouseInfo().getX() > 475 && Greenfoot.getMouseInfo().getX() < 545
                    && Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135 && isBottom(a)){
                        if(a.getImagem().equalsIgnoreCase(diamonds[dAux])){
                            managerTop(topTwo, carta, 510, 185);
                            removeObject(a);
                            dAux++;
                        }
                    }
                    /*TopThree*/
                    else if(Greenfoot.getMouseInfo().getX() > 545 && Greenfoot.getMouseInfo().getX() < 605
                    && Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135 && isBottom(a)){
                        if(a.getImagem().equalsIgnoreCase(hearts[hAux])){
                            managerTop(topThree, carta, 580, 185);
                            removeObject(a);
                            hAux++;
                        }
                    }
                    /*TopFour*/
                    else if(Greenfoot.getMouseInfo().getX() > 605 && Greenfoot.getMouseInfo().getX() < 675
                    && Greenfoot.getMouseInfo().getY() < 240 && Greenfoot.getMouseInfo().getY() > 135 && isBottom(a)){
                        if(a.getImagem().equalsIgnoreCase(spades[sAux])){
                            managerTop(topFour, carta, 650, 185);
                            removeObject(a);
                            sAux++;
                        }
                    }else{
                        a.setLocation(pX, pY);
                    }

                    if(botOne.isEmpty() && Greenfoot.getMouseInfo().getX() > 125 && Greenfoot.getMouseInfo().getX() < 195
                    && Greenfoot.getMouseInfo().getY() > 240 && Greenfoot.getMouseInfo().getY() < 340){
                        managerEmptyBot(botOne, carta, 160, 285);
                        removeObject(a);
                    }
                    else if(botTwo.isEmpty() && Greenfoot.getMouseInfo().getX() > 195 && Greenfoot.getMouseInfo().getX() < 265
                    && Greenfoot.getMouseInfo().getY() > 240 && Greenfoot.getMouseInfo().getY() < 340){
                        managerEmptyBot(botTwo, carta, 230, 285);
                        removeObject(a);
                    }
                    else if(botThree.isEmpty() && Greenfoot.getMouseInfo().getX() > 265 && Greenfoot.getMouseInfo().getX() < 335
                    && Greenfoot.getMouseInfo().getY() > 240 && Greenfoot.getMouseInfo().getY() < 340){
                        managerEmptyBot(botThree, carta, 300, 285);
                        removeObject(a);
                    } 
                    else if(botFour.isEmpty() && Greenfoot.getMouseInfo().getX() > 335 && Greenfoot.getMouseInfo().getX() < 405
                    && Greenfoot.getMouseInfo().getY() > 240 && Greenfoot.getMouseInfo().getY() < 340){
                        managerEmptyBot(botFour, carta, 370, 285);
                        removeObject(a);
                    }
                    else if(botFive.isEmpty() && Greenfoot.getMouseInfo().getX() > 405 && Greenfoot.getMouseInfo().getX() < 475
                    && Greenfoot.getMouseInfo().getY() > 240 && Greenfoot.getMouseInfo().getY() < 340){
                        managerEmptyBot(botFive, carta, 440, 285);
                        removeObject(a);
                    }
                    else if(botSix.isEmpty() && Greenfoot.getMouseInfo().getX() > 475 && Greenfoot.getMouseInfo().getX() < 545
                    && Greenfoot.getMouseInfo().getY() > 240 && Greenfoot.getMouseInfo().getY() < 340){
                        managerEmptyBot(botSix, carta, 510, 285);
                        removeObject(a);
                    }
                    else if(botSeven.isEmpty() && Greenfoot.getMouseInfo().getX() > 545 && Greenfoot.getMouseInfo().getX() < 615
                    && Greenfoot.getMouseInfo().getY() > 240 && Greenfoot.getMouseInfo().getY() < 340){
                        managerEmptyBot(botSeven, carta, 580, 285);
                        removeObject(a);
                    }
                    else if(botEight.isEmpty() && Greenfoot.getMouseInfo().getX() > 615 && Greenfoot.getMouseInfo().getX() < 685
                    && Greenfoot.getMouseInfo().getY() > 240 && Greenfoot.getMouseInfo().getY() < 340){
                        managerEmptyBot(botEight, carta, 650, 285);
                        removeObject(a);
                    }
                    /*BotOne*/
                    else if(!botOne.isEmpty() && Greenfoot.getMouseInfo().getX() > 125 && Greenfoot.getMouseInfo().getX() < 195
                    && Greenfoot.getMouseInfo().getY() < botOne.getNode().getCarta().getY() + 50 
                    && Greenfoot.getMouseInfo().getY() > botOne.getNode().getCarta().getY() - 50
                    && isBottom(a) && a.getStack() != botOne){
                        managerBot(botOne, carta);
                        removeObject(a);
                    }
                    /*BotTwo*/
                    else if(!botTwo.isEmpty() && Greenfoot.getMouseInfo().getX() > 195 && Greenfoot.getMouseInfo().getX() < 265
                    && Greenfoot.getMouseInfo().getY() < botTwo.getNode().getCarta().getY() + 50 
                    && Greenfoot.getMouseInfo().getY() > botTwo.getNode().getCarta().getY() - 50
                    && isBottom(a)  && a.getStack() != botTwo){
                        managerBot(botTwo, carta);
                        removeObject(a);
                    }
                    /*BotThree*/
                    else if(!botThree.isEmpty() && Greenfoot.getMouseInfo().getX() > 265 && Greenfoot.getMouseInfo().getX() < 335
                    && Greenfoot.getMouseInfo().getY() < botThree.getNode().getCarta().getY() + 50 
                    && Greenfoot.getMouseInfo().getY() > botThree.getNode().getCarta().getY() - 50
                    && isBottom(a) && a.getStack() != botThree){
                        managerBot(botThree, carta);
                        removeObject(a);
                    }
                    /*BotFour*/
                    else if(!botFour.isEmpty() && Greenfoot.getMouseInfo().getX() > 335 && Greenfoot.getMouseInfo().getX() < 405
                    && Greenfoot.getMouseInfo().getY() < botFour.getNode().getCarta().getY() + 50 
                    && Greenfoot.getMouseInfo().getY() > botFour.getNode().getCarta().getY() - 50
                    && isBottom(a) && a.getStack() != botFour){
                        managerBot(botFour, carta);
                        removeObject(a);
                    }
                    /*BotFive*/
                    else if(!botFive.isEmpty() && Greenfoot.getMouseInfo().getX() > 405 && Greenfoot.getMouseInfo().getX() < 475
                    && Greenfoot.getMouseInfo().getY() < botFive.getNode().getCarta().getY() + 50 
                    && Greenfoot.getMouseInfo().getY() > botFive.getNode().getCarta().getY() - 50
                    && isBottom(a) && a.getStack() != botFive){
                        managerBot(botFive, carta);
                        removeObject(a);
                    }
                    /*BotSix*/
                    else if(!botSix.isEmpty() && Greenfoot.getMouseInfo().getX() > 475 && Greenfoot.getMouseInfo().getX() < 545 
                    && Greenfoot.getMouseInfo().getY() < botSix.getNode().getCarta().getY() + 50 
                    && Greenfoot.getMouseInfo().getY() > botSix.getNode().getCarta().getY() - 50
                    && isBottom(a) && a.getStack() != botSix){
                        managerBot(botSix, carta);
                        removeObject(a);
                    }
                    /*BotSeven*/
                    else if(!botSeven.isEmpty() && Greenfoot.getMouseInfo().getX() > 545 && Greenfoot.getMouseInfo().getX() < 615
                    && Greenfoot.getMouseInfo().getY() < botSeven.getNode().getCarta().getY() + 50 
                    && Greenfoot.getMouseInfo().getY() > botSeven.getNode().getCarta().getY() - 50
                    && isBottom(a) && a.getStack() != botSeven){
                        managerBot(botSeven, carta);
                        removeObject(a);
                    }
                    /*BotEight*/
                    else if(!botEight.isEmpty() && Greenfoot.getMouseInfo().getX() > 615 && Greenfoot.getMouseInfo().getX() < 685
                    && Greenfoot.getMouseInfo().getY() < botEight.getNode().getCarta().getY() + 50 
                    && Greenfoot.getMouseInfo().getY() > botEight.getNode().getCarta().getY() - 50
                    && isBottom(a) && a.getStack() != botEight){
                        managerBot(botEight, carta);
                        removeObject(a);
                    }else{
                        a.setLocation(pX, pY);
                    }
                    salvarL = false;
                    listou = false;
                }
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

        if(Greenfoot.isKeyDown("P")){
            for(int i = 0; i < 13; i++){
                topOne.inserir(new Node(new Cartas()));
                topTwo.inserir(new Node(new Cartas()));
                topThree.inserir(new Node(new Cartas()));
                topFour.inserir(new Node(new Cartas()));
            }
        }
    }

    public void managerHold(Node _node, Stack _stack, Cartas a, int x, int y){
        addObject(a, 0, 0);
        _stack.inserir(aux);
        _node = aux;
        a.getStack().remover();
        a.setStack(_stack);
        a.isLast(true);
        a.setLocation(x, y);
    }

    public void managerTop(Stack _stack, Cartas a, int x, int y){
        addObject(a, 0, 0);
        _stack.inserir(aux);
        a.getStack().remover();
        a.setStack(null);
        a.isLast(false);
        a.setLocation(x, y);
    }

    public void managerEmptyBot(Stack _stack, Cartas a, int x, int y){
        System.out.println("2");
        addObject(a, 0, 0);
        aux.setCarta(a);
        _stack.inserir(aux);
        a.getStack().remover();
        aux.getCarta().setStack(_stack);
        a.setLocation(x, y);
    }

    public void managerBot(Stack _stack, Cartas a){
        addObject(a, 0, 0);
        n = _stack.getNode();
        aux.setCarta(a);
        _stack.inserir(aux);
        a.getStack().remover();
        aux.getCarta().setStack(_stack);
        a.setLocation(n.getCarta().getX(), n.getCarta().getY() + 20);
    }

    public boolean victory(){
        return (topOne.getSize() >= 13 && topTwo.getSize() >= 13 && topThree.getSize() >= 13 && topFour.getSize() >= 13);
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

    public boolean isCarta(Cartas a){
        return (a != null);
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