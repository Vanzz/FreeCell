public class Stack  
{
    private Node inicio;
    private String naipe;
    private String nome;

    public Stack(){
        this.inicio = null;
    }
    
    public Stack(String _nome){
        this.inicio = null;
        this.nome = _nome;
    }

    public void inserir(Node _node){
        if(isEmpty()){
            inicio = _node;
            inicio.getCarta().isLast(true);
        }else{
            Node aux = inicio;
            while(aux.getProximo() != null){
                aux = aux.getProximo();
            }
            aux.setProximo(_node);
            aux.getCarta().isLast(false);
            _node.getCarta().isLast(true);
        }
    }

    public void remover(){
        if(isEmpty()){
            System.out.println("Remover : Pilha vazia!");
        }else{
            Node aux = inicio;
            if(aux.getProximo() == null) {
                inicio = null;
            }else if (aux.getProximo().getProximo() == null){
                inicio.setProximo(null);
                inicio.getCarta().isLast(true);
            }else{
                while(aux.getProximo().getProximo() != null){
                    aux = aux.getProximo();
                }
                aux.setProximo(null);
                aux.getCarta().isLast(true);
            }
        }
    }

    public void listar(){
        Node aux = inicio;
        if(aux == null){
            System.out.println("Listar : Pilha vazia!");
        }else{
            System.out.print(""+nome+": ");
            while(aux.getProximo() != null){
                System.out.print(aux.getNode()+"->");
                aux = aux.getProximo();
            }
            System.out.print(aux.getNode()+"->null");
            System.out.println(" // size "+getSize());
        }
    }

    /**
     * Get last node
     */
    public Node getNode(){
        if(inicio != null){
            Node aux = inicio;
            while(aux.getProximo() != null){
                aux = aux.getProximo();
            }
            return aux;
        }
        return null;
    }

    public int getSize(){
        int size = 1;
        Node aux = inicio;

        if(isEmpty()){
            return 0;
        }else{
            while(aux.getProximo() != null){
                aux = aux.getProximo();
                size++;
            }
        }

        return size;
    }
    
    public void setNaipe(String _naipe){
        this.naipe = _naipe;
    }
    
    public String getNaipe(){
        return naipe;
    }

    public boolean isEmpty(){
        if(inicio == null){
            return true;
        }
        return false;
    }
    
    public String toString(){
        return ""+nome;
    }
}