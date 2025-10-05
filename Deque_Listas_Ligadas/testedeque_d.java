public class testedeque_d {

    public static class DequeLinked implements Deque_d {
        private No head;
        private No tail;
        private class No {
            Object value;
            No next;
            No prev;

            public No() {
                this.value = 0;
                this.next = null;
                this.prev = null;
            }
        }
        private int size;
        private int t_f;
        private int t_t;

        public DequeLinked() {
            this.head = null;
            this.tail = null;
            this.size = 0;
            this.t_f = -1;
            this.t_t = size;
        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public boolean isEmpty() {
            return this.head == null;
        }


        @Override
        public Object top_f() throws DequeVazioExcecao {
            if (isEmpty()) {
                throw new DequeVazioExcecao("O Deque está vazio");
            }
            return this.head.value;
        }

        @Override
        public Object top_t() throws DequeVazioExcecao {
            if (isEmpty()) {
                throw new DequeVazioExcecao("O Deque está vazio");
            }
            return this.tail.value;
        }

        @Override
        public void push_f(Object o) {
            No novo_no = new No();
            novo_no.prev = null;
            novo_no.next = this.head;
            novo_no.value = o;
            if (isEmpty()){
                this.tail = novo_no;
            } else {
                this.head.prev = novo_no;    
            }
            this.head = novo_no;
            ++this.t_f;
            ++this.size;
        }

        @Override
        public void push_t(Object o) {
            No novo_no = new No();
            novo_no.prev = this.tail;
            novo_no.next = null;
            novo_no.value = o;
            if (isEmpty()){
                this.head = novo_no;
            } else {
                this.tail.next = novo_no;    
            }
            this.tail = novo_no;
            --this.t_t;
            ++this.size;
        }

        @Override
        public Object pop_f() throws DequeVazioExcecao {
            if (isEmpty()) {
                throw new DequeVazioExcecao("O Deque está vazio");
            }
            Object to_remove = this.head.value;
            this.head.next.prev = null;
            this.head = this.head.next;
            --this.size;
            --this.t_f;
            return to_remove;
            
        }

        @Override
        public Object pop_t() throws DequeVazioExcecao {
            if (isEmpty()) {
                throw new DequeVazioExcecao("O Deque está vazio");
            }
            Object to_remove = this.tail.value;
            this.tail.prev.next = null;
            this.tail = this.tail.prev;
            ++this.t_t;
            --this.size;
            return to_remove;
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
