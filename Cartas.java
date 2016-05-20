import greenfoot.*;
public class Cartas extends Actor
{
    private boolean flipped = false;
    private String imagem ="";
    private boolean isLast = false;
    
    public Cartas(){
        
    }
    
    public Cartas(String imgid, boolean _flipped){
        this.imagem = imgid;
        this.flipped = _flipped;
        GreenfootImage img;
        
        if(flipped){
            img = new GreenfootImage("images/" +imgid+".png");
        }
        else{
            img = new GreenfootImage("images/Backborder.png");
        }
        
        setImage(img);
    }
    
    public void flip(boolean _flipped){
        this.flipped = _flipped;
        GreenfootImage img;
        
        if(flipped){
            img = new GreenfootImage("images/" +imagem+".png");
        }
        else{
            img = new GreenfootImage("images/Backborder.png");
        }
        
        setImage(img);
    }
    
    public boolean getFlipped(){
        return flipped;
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
}
