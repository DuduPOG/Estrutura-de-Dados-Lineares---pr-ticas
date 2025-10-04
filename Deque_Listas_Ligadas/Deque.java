/*
 * Created on 19/09/2004
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

public interface Deque {

    public int size();

    public boolean isEmpty();

    public Object top_f() throws DequeVazioExcecao;

    public Object top_t() throws DequeVazioExcecao;

    public void push_f(Object o);

    public void push_t(Object o);

    public Object pop_f() throws DequeVazioExcecao;

    public Object pop_t() throws DequeVazioExcecao;

}
