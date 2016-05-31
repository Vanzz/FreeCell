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

    Stack topOne, topTwo, topThree, topFour; 
    Stack botOne, botTwo, botThree, botFour, botFive, botSix, botSeven, botEight;

    List<Cartas> todos = getObjects(null);
    Cartas a;

    boolean listou;
    boolean removeu;

    ArrayList<Cartas> rList; 
    ArrayList<Node> stacksInferiores;

    public MyWorld(){   
        super(800, 600, 1); 

        //Creating top stacks
        topOne = new Stack(); 
        topTwo = new Stack();
        topThree = new Stack();
        topFour = new Stack();

        // //Creating bottom stacks
        botOne = new Stack();
        botTwo = new Stack();
        botThree = new Stack();
        botFour = new Stack();
        botFive = new Stack();
        botSix = new Stack();
        botSeven = new Stack();
        botEight = new Stack();

        // baralho = new Stack();
        // barAux = new Stack();
    }

    public void started(){
        rList = new ArrayList<Cartas>();
        listou = false;
        removeu = false;
        int espacamento = 70;

        inicializarStacks();

        for(int i = 1; i <= 13; i++)
        {
            Cartas c = new Cartas(i+"C", true);
            Cartas d = new Cartas(i+"D", true);
            Cartas h = new Cartas(i+"H", true);
            Cartas s = new Cartas(i+"S", true);

            rList.add(c);
            rList.add(d);
            rList.add(h);
            rList.add(s);
        }
        //System.out.println(""+rList.toString());

        randomSpread();
        
        // addObject(new Cartas(), 90 + espacamento, 285);
        // addObject(new Cartas(), 160 + espacamento, 285);
        // addObject(new Cartas(), 230 + espacamento, 285);
        // addObject(new Cartas(), 300 + espacamento, 285);
        // addObject(new Cartas(), 370 + espacamento, 285);
        // addObject(new Cartas(), 440 + espacamento, 285);
        // addObject(new Cartas(), 510 + espacamento, 285);
        // addObject(new Cartas(), 580 + espacamento, 285);
        
        // for(int i = 1; i <= 8; i++){
            // addObject(new Cartas(), 20 + (70*i) + espacamento, 285);
        // }

        // //Criação do baralho
        // for(int i = 1; i <= 13; i++){
        // Cartas c = new Cartas(i+"C", false);
        // Cartas d = new Cartas(i+"D", false);
        // Cartas h = new Cartas(i+"H", false);
        // Cartas s = new Cartas(i+"S", false);

        // Node node1 = new Node();
        // Node node2 = new Node();
        // Node node3 = new Node();
        // Node node4 = new Node();

        // node1.setCarta(c);
        // node2.setCarta(d);
        // node3.setCarta(h);
        // node4.setCarta(s);

        // baralho.inserir(node1);
        // baralho.inserir(node2);
        // baralho.inserir(node3);
        // baralho.inserir(node4);

        // addObject(c, 150+(i/2), 250+(i/2));
        // addObject(d, 150+(i/2), 250+(i/2));
        // addObject(h, 150+(i/2), 250+(i/2));
        // addObject(s, 150+(i/2), 250+(i/2));
        // }
    }

    public void act(){
        todos = getObjects(null);
        if(Greenfoot.getMouseInfo() != null)
        System.out.println("x:"+Greenfoot.getMouseInfo().getX()+" y:"+Greenfoot.getMouseInfo().getY());

        if(Greenfoot.mouseDragged(null)){
            if(mostraObjects(Greenfoot.getMouseInfo()) != null){
                a = mostraObjects(Greenfoot.getMouseInfo());
                if(a.isLast()){
                    a.setLocation(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
                    //aux = baralho.getNode();
                    removeu = false;
                }
            }
        }

        if(Greenfoot.mouseDragEnded(a) && !removeu){
            removeu = true;
            // if(!a.getFlipped()){
            // aux.getCarta().flip(true);
            // if(a.isCollider()){
            // barAux.inserir(aux);
            // baralho.remover();
            // a.setLocation(35, 50);
            // }
            // }
            listou = false;
            removeu = false;
        }

        if(Greenfoot.isKeyDown("L") && !listou){
            // baralho.listar();
            // barAux.listar();

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
            while(stackIndex <maxStackIndex){
                if(rList.size() == 0) break;

                randomIndex = range(0,rList.size()-1);
                stacksInferiores.get(i).getStack().inserir(new Node(rList.get(randomIndex)));
                addObject(rList.get(randomIndex),stacksInferiores.get(i).getX(),150);
                rList.remove(rList.get(randomIndex));

                if(i == 0){
                    Node a = new Node(rList.get(randomIndex));
                    botOne.inserir(a);
                    addObject(a.getCarta(), 90 + 70, 285);
                }
                
                stackIndex++;

                if(maxStackIndex == 3 && stackIndex == 2){
                    randomIndex = range(0,rList.size()-1);
                    stacksInferiores.get(i).getStack().inserir(new Node(rList.get(randomIndex)));
                    addObject(rList.get(randomIndex),/*x a ser modificado*/150, 150);
                    rList.remove(rList.get(randomIndex));
                }
            }
        }
    }

    public void inicializarStacks(){
        //stacks superiores
        //1 ( auxStack );
        //2 ( win-condition );
        //stacksInferiores
        stacksInferiores = new ArrayList<Node>();
        for(int i=1; i <= 8;i++){
            stacksInferiores.add(new Node(new Stack(),10 + (150*i), 100));
        }
    }
}