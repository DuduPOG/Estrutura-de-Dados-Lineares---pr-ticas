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

import src.Pilha;

public class testepilha {

    public class PilhaArray implements Pilha {
        private int capacity;
        private Object[] a;
        private int t_t;
        private int t_p;
        private int t_v;

        public PilhaArray(int capacity) {
            this.capacity = capacity;
            this.t_t = 0;
            this.t_p = capacity;
            this.t_v = -1;
            this.a = new Object[capacity];
        }

        public int size() {
            return t_t;
        }

        public boolean isEmpty() {
            return t_t == 0;
        }

        public Object top_v() throws PilhaVaziaExcecao {
            if (isEmpty()) {
                throw new PilhaVaziaExcecao("A Pilha está vazia");
            }
            if (t_v == -1){
                throw new PilhaVaziaExcecao("Essa parte da pilha está vazia");
            }
            return a[t_v];
        }

        public Object top_p() throws PilhaVaziaExcecao {
            if (isEmpty()) {
                throw new PilhaVaziaExcecao("A Pilha está vazia");
            }
            if (t_p == capacity){
                throw new PilhaVaziaExcecao("Essa parte da pilha está vazia");
            }
            return a[t_p];
        }

        public void push_v(Object o) {
            if (t_p - t_v == 1) {
                int old_capacity = capacity;
                capacity *= 2;
                Object b[] = new Pilha[capacity];
                for (int i = 0; i < t_v + 1; ++i) {
                    b[i] = a[i];
                }
                t_p = t_p * 2 + (old_capacity - t_p);
                for (int i = 1; old_capacity != t_p; ++i){
                    b[old_capacity * 2 + i] = a[old_capacity - 1];
                    --old_capacity;
                }
                a = b;
            }
            a[++t_v] = o;
            ++t_t;
        }

        public void push_p(Object o) {
            if (t_p - t_v == 1) {
                int old_capacity = capacity;
                capacity *= 2;
                Object b[] = new Pilha[capacity];
                for (int i = 0; i < t_v + 1; ++i) {
                    b[i] = a[i];
                }
                t_p = t_p * 2 + (old_capacity - t_p);
                for (int i = 1; old_capacity != t_p; ++i){
                    b[old_capacity * 2 + i] = a[old_capacity - 1];
                    --old_capacity;
                }
                a = b;
            }
            a[--t_p] = o;
            ++t_t;
        }

        public Object pop_v() throws PilhaVaziaExcecao {
            if (isEmpty()) {
                throw new PilhaVaziaExcecao("A Pilha está vazia");
            }
            if (t_v == -1){
                throw new PilhaVaziaExcecao("Essa parte da pilha está vazia");
            }
            int last_value = a[t_v];
            --t_v;
            --t_t;
            if (t_t / capacity <= 1/3){
                int old_capacity = capacity;
                capacity /= 2;
                int new_capacity = capacity;
                Object b[] = new Pilha[capacity];
                for(int i = 0; i < t_v + 1; ++i){
                    b[i] = a[i];
                }
                for(int i = old_capacity - 1; i >= t_p; --i){
                    b[new_capacity - 1] = a[i];
                    --new_capacity;
                }
            }
            return last_value;
        }

        public Object pop_p() throws PilhaVaziaExcecao {
            if (isEmpty()) {
                throw new PilhaVaziaExcecao("A Pilha está vazia");
            }
            if (t_p == capacity){
                throw new PilhaVaziaExcecao("Essa parte da pilha está vazia");
            }
            int last_value = a[t_p];
            ++t_p;
            --t_t;
            if (t_t / capacity <= 1/3){
                int old_capacity = capacity;
                capacity /= 2;
                int new_capacity = capacity;
                Object b[] = new Pilha[capacity];
                for(int i = 0; i < t_v + 1; ++i){
                    b[i] = a[i];
                }
                for(int i = old_capacity - 1; i >= t_p; --i){
                    b[new_capacity - 1] = a[i];
                    --new_capacity;
                }
            }
            return last_value;
        }
    }


	public static void main(String[] args) {		
		Integer[] b = new Integer[1];		
		PilhaArray pp = new PilhaArray(1);
		System.out.println("inserindo");
		for(int f = 0; f < 10; f++){
		  System.out.println(f);		  
		  pp.push(f);
		}
		System.out.println("retirando");
		for(int f = 0; f < 10; f++){
			  System.out.print(f);
			  System.out.println(" - " + pp.pop());
		}
	}
}
