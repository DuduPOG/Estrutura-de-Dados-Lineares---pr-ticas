public class testeFila {
    public static class FilaArray implements Fila {
        private int size;
        private int capacity;
        private int primeiro;
        private int finalFila;
        private Object a[];

        public FilaArray(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            this.primeiro = 0;
            this.finalFila = this.primeiro + 1;
            this.a = new Object[capacity];
        }

        public int tamanho(){
            return this.size;
        }

        public boolean estaVazia(){
            return this.size == 0;
        }

        public boolean estaCheia(){
            return this.size - 1 == this.capacity;
        }

        public Object inicio() throws EFilaVazia {
            if (estaVazia()) {
                throw new EFilaVazia("A fila está vazia");
            }
            return this.a[this.primeiro];
        }

        public void enfileirar(Object o){
            if (estaCheia()){
                FilaArray b = new FilaArray(this.capacity *= 2);
                
            }
        }

        public Object desenfileirar() throws EFilaVazia {
            if (estaVazia()){
                throw new EFilaVazia("A fila está vazia");
            }
            return this.a[this.primeiro--];
        }
    }

    public static void main(String[] args) {			
		FilaArray pp = new FilaArray(1);
		System.out.println("inserindo");
		for(int f = 0; f < 16; f++){
		  System.out.println(f);		  
		  pp.push_v(f);
          pp.push_p(f);
		}
		System.out.println("retirando");
		for(int f = 0; f < 16; f++){
			  System.out.print(f);
			  System.out.println(" - " + pp.pop_v());
              System.err.print(f);
              System.out.println(" . " + pp.pop_p());
		}
	}
}
