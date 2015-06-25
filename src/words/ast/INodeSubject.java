package words.ast;

import words.environment.*;
import words.exceptions.*;

public class INodeSubject extends INode {
	public INodeSubject(Object... children) {
		super(children);
	}

	/**
	 * Can return either a string, which is a class name
	 * or an object, which is an object. 
	 */
	public ASTValue eval(Environment environment) throws WordsRuntimeException {
		ASTValue className = children.get(0) == null ? null : children.get(0).eval(environment);
		AST referenceObject = children.get(1);
		AST identifier = children.get(2);
		
		if (className != null) {
			return new ASTValue(className.stringValue);
		} else {
			ASTValue property = lookupProperty(environment, referenceObject, identifier);
			if (property.type != ASTValue.Type.OBJ) {
				throw new InvalidTypeException(ASTValue.Type.OBJ.toString(), property.type.toString());
			}
			WordsObject object = property.objValue;
			return new ASTValue(object);
		}
	}
}