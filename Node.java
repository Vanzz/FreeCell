public class Node  
{
    Node node;
    String path;
    Cartas carta;
    Stack stack;
    int x;
    int y;
    public Node()
    {
        
    }
    public Node(Stack stack, int x, int y){
        this.x = x;
        this.y = y;
        this.stack = stack;
    }
    
    public Node(Cartas carta){
        this.setCarta(carta);
    }
    
    public Stack getStack(){
        return this.stack;
    }
    public int getX()
    {
        return this.x;
    }
    public int getY(){
        return this.y;
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
