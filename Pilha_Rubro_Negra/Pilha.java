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

public interface Pilha {

    public int size();

    public boolean isEmpty();

    public boolean isEmpty_v();

    public boolean isEmpty_p();

    public Object top_v() throws PilhaVaziaExcecao;

    public Object top_p() throws PilhaVaziaExcecao;

    public void push_v(Object o);

    public void push_p(Object o);

    public Object pop_v() throws PilhaVaziaExcecao;

    public Object pop_p() throws PilhaVaziaExcecao;

}
