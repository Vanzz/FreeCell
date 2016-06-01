public class Node  
{
    Node node;
    Cartas carta;
    
    public Node(){
        
    }
    
    public Node(Cartas carta){
        this.setCarta(carta);
    }
    
    public void setCarta(Cartas carta){
        this.carta = carta;
    }
    
    public Cartas getCarta(){
        return carta;
    }
    
    public Node getNode(){
        return this;
    }
    
    public void setProximo(Node _node){
        this.node = _node;
    }
    
    public Node getProximo(){
        return node;
    }
    
    public String toString(){
        return "["+carta.toString()+"]";
    }
}
