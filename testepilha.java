/*
 * Created on 01/09/2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Robinson
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class testepilha {

    public static class PilhaArray implements Pilha {
        private int capacity;
        private Object[] a;
        private int t_t;
        private int t_p;
        private int t_v;

        public PilhaArray(int capacity) {
            this.capacity = capacity;
            this.t_t = 0;
            this.t_p = this.capacity;
            this.t_v = -1;
            this.a = new Object[this.capacity];
        }

        @Override
        public int size() {
            return this.t_t;
        }

        @Override
        public boolean isEmpty() {
            return this.t_t == 0;
        }

        @Override
        public boolean isEmpty_v() {
            return this.t_v == -1;
        }

        @Override
        public boolean isEmpty_p() {
            return this.t_p == this.capacity;
        }

        @Override
        public Object top_v() throws PilhaVaziaExcecao {
            if (isEmpty()) {
                throw new PilhaVaziaExcecao("A Pilha está vazia");
            }
            if (isEmpty_v()){
                throw new PilhaVaziaExcecao("Essa parte da pilha está vazia");
            }
            return this.a[this.t_v];
        }

        @Override
        public Object top_p() throws PilhaVaziaExcecao {
            if (isEmpty()) {
                throw new PilhaVaziaExcecao("A Pilha está vazia");
            }
            if (isEmpty_p()){
                throw new PilhaVaziaExcecao("Essa parte da pilha está vazia");
            }
            return this.a[this.t_p];
        }

        @Override
        public void push_v(Object o) {
            if (this.t_p - this.t_v == 1) {
                int old_capacity = this.capacity;
                this.capacity *= 2;
                Object b[] = new Object[this.capacity];
                for (int i = 0; i < this.t_v + 1; ++i) {
                    b[i] = this.a[i];
                }
                int qtdDir = old_capacity - this.t_p;
                int offset = this.capacity - qtdDir;
                for (int i = 0; i < qtdDir; i++) {
                    b[offset + i] = this.a[this.t_p + i];
                }
                this.t_p = offset;
                this.a = b;
            }
            this.a[++this.t_v] = o;
            ++this.t_t;
        }

        @Override
        public void push_p(Object o) {
            if (this.t_p - this.t_v == 1) {
                int old_capacity = this.capacity;
                this.capacity *= 2;
                Object b[] = new Object[this.capacity];
                for (int i = 0; i < this.t_v + 1; ++i) {
                    b[i] = this.a[i];
                }
                int qtdDir = old_capacity - this.t_p;
                int offset = this.capacity - qtdDir;
                for (int i = 0; i < qtdDir; i++) {
                    b[offset + i] = this.a[this.t_p + i];
                }
                this.t_p = offset;
                this.a = b;
            }
            this.a[--this.t_p] = o;
            ++this.t_t;
        }

        @Override
        public Object pop_v() throws PilhaVaziaExcecao {
            if (isEmpty()) {
                throw new PilhaVaziaExcecao("A Pilha está vazia");
            }
            if (isEmpty_v()){
                throw new PilhaVaziaExcecao("Essa parte da pilha está vazia");
            }
            Object last_value = this.a[this.t_v];
            --this.t_v;
            --this.t_t;
            if (this.t_t * 1.0 / this.capacity <= 1.0 / 3){
                int old_capacity = this.capacity;
                this.capacity /= 2;
                Object b[] = new Object[this.capacity];
                for(int i = 0; i < this.t_v + 1; ++i){
                    b[i] = this.a[i];
                }
                int qtdDir = old_capacity - this.t_p;
                int offset = this.capacity - qtdDir;
                for (int i = 0; i < qtdDir; i++) {
                    b[offset + i] = this.a[this.t_p + i];
                }
                this.t_p = offset;
                this.a = b;
            }
            return last_value;
        }

        @Override
        public Object pop_p() throws PilhaVaziaExcecao {
            if (isEmpty()) {
                throw new PilhaVaziaExcecao("A Pilha está vazia");
            }
            if (isEmpty_p()){
                throw new PilhaVaziaExcecao("Essa parte da pilha está vazia");
            }
            Object last_value = this.a[this.t_p];
            ++this.t_p;
            --this.t_t;
            if (this.t_t * 1.0 / this.capacity <= 1.0 / 3){
                int old_capacity = this.capacity;
                this.capacity /= 2;
                Object b[] = new Object[this.capacity];
                for(int i = 0; i < this.t_v + 1; ++i){
                    b[i] = this.a[i];
                }
                int qtdDir = old_capacity - this.t_p;
                int offset = this.capacity - qtdDir;
                for (int i = 0; i < qtdDir; i++) {
                    b[offset + i] = this.a[this.t_p + i];
                }
                this.t_p = offset;
                this.a = b;
            }
            return last_value;
        }
    }


	public static void main(String[] args) {			
		PilhaArray pp = new PilhaArray(1);
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
