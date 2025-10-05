public interface Deque_d {

    public int size();

    public boolean isEmpty();

    public Object top_f() throws DequeVazioExcecao;

    public Object top_t() throws DequeVazioExcecao;

    public void push_f(Object o);

    public void push_t(Object o);

    public Object pop_f() throws DequeVazioExcecao;

    public Object pop_t() throws DequeVazioExcecao;

}
