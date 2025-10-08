public class testeFila {
    public static class FilaArray implements Fila {
        private int tamanho;
        private int capacidade;
        private int primeiro;
        private int finalFila;
        private Object[] a;

        public FilaArray(int capacidade) {
            this.tamanho = 0;
            this.capacidade = capacidade;
            this.primeiro = 0;
            this.finalFila = this.primeiro + 1;
            this.a = new Object[capacidade];
        }

        public int tamanho(){
            return this.tamanho;
        }

        public boolean estaVazia(){
            return this.tamanho == 0;
        }

        public boolean estaCheia(){
            return this.tamanho + 1 == this.capacidade;
        }

        public Object inicio() throws EFilaVazia {
            if (estaVazia()) {
                throw new EFilaVazia("A fila está vazia");
            }
            return this.a[this.primeiro];
        }

        public void enfileirar(Object o){
            if (estaCheia()){
                this.capacidade *= 2;
                FilaArray b = new FilaArray(this.capacidade);
                for (int i = 0; i < this.tamanho; ++i){
                    b[i] = this.a[(this.primeiro + i) % this.tamanho];
                }
                this.primeiro = 0;
                ++this.tamanho;
                this.finalFila = (this.finalFila + 1) % this.tamanho;
            }
            this.a[this.tamanho] = o;
            ++this.tamanho;
            this.finalFila = (this.finalFila + 1) % this.tamanho;
        }

        public Object desenfileirar() throws EFilaVazia {
            if (estaVazia()){
                throw new EFilaVazia("A fila está vazia");
            }
            Object saindo = this.a[this.primeiro];
            this.primeiro = (this.primeiro + 1) % this.tamanho;
            --this.tamanho;
            return saindo;
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
