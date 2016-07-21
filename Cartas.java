import greenfoot.*;
public class Cartas extends Actor
{
    private boolean isLast = false;
    private boolean isBlack = false;
    private String imagem = "";
    private Stack stack;
    
    public Cartas(){
        GreenfootImage img;
        img = new GreenfootImage("images/Backborder.png");
        img.scale(70, 100);
        setImage(img);
    }
    
    public Cartas(String imgid, boolean _isBlack, Stack _stack){
        this.imagem = imgid;
        this.isBlack = _isBlack;
        this.stack = _stack;
        
        GreenfootImage img;
        img = new GreenfootImage("images/" +imgid+".png");
        img.scale(70, 100);
        setImage(img);
    }
    
    public boolean isBlack(){
        return isBlack;
    }
    
    public void setStack(Stack _stack){
        this.stack = _stack;
    }
    
    public Stack getStack(){
        return stack;
    }
    
    public String getImagem(){
        return imagem;
    }
    
    public void isLast(boolean a){
        this.isLast = a;
    }
    
    public boolean isLast(){
        return isLast;
    }
    
    public String toString(){
        return ""+imagem;
    }
    
    public boolean isCollider(){
        return isTouching(Cartas.class);
    }
}
