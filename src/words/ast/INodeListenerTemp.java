package words.ast;

import words.environment.WordsEnvironment;
import words.exceptions.WordsRuntimeException;

public class INodeListenerTemp extends INode {
	public INodeListenerTemp(Object... children) {
		super(children);
	}

	@Override
	public ASTValue eval(WordsEnvironment environment) throws WordsRuntimeException {
		// TODO
		throw new AssertionError("Not yet implemented");
	}
}