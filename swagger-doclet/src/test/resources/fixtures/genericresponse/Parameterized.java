package fixtures.genericresponse;

import java.util.Collections;
import java.util.List;

/**
 * The Parameterized represents a sample generic class
 * @version $Id$
 * @author conor.roche
 */
@SuppressWarnings("javadoc")
public class Parameterized<T, R> {

	private Object object;

	private T typed;
	private R rtype;

	private Parameterized2<R> parameterizedChild;

	public Object getObject() {
		return this.object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public T getTyped() {
		return this.typed;
	}

	public void setTyped(T typed) {
		this.typed = typed;
	}

	public List<R> getTypedCol() {
		return Collections.emptyList();
	}

	public R getRtype() {
		return this.rtype;
	}

	public Parameterized2<R> getParameterizedChild() {
		return this.parameterizedChild;
	}

	public void setParameterizedChild(Parameterized2<R> parameterizedChild) {
		this.parameterizedChild = parameterizedChild;
	}

}
