import java.util.ArrayList;
import java.lang.StringBuilder;


/**
 * An abstract syntax tree internal node.
 */
public class INode extends AST {
	public ArrayList<AST> children;
	
	public INode(ASTType type, int lineNo, Object... children) {
		super(type, lineNo);
		
		this.children = new ArrayList<AST>(children.length);
		
		for (int i = 0; i < children.length; i++) {
			if (children[i] == null)
				this.children.add(null);
			else
				this.children.add((AST) children[i]);
		}
	}
	
	/**
	 * Appends a given list of nodes to this node's list of children. 
	 * 
	 * @param nodes the list of nodes to be added
	 * @return this node
	 */
	public INode add(ArrayList<AST> nodes) {
		for (AST node : nodes)
			this.children.add(node);
		
		return this;
	}
	
	private void indent(int level) {
		for (int i = 0; i < level; i++)
			System.err.printf("  ");		
	}
	
	public void dump(int level) {
		indent(level);
		System.err.println(this.type.toString());
		
		if (children.size() > 0) {
			for (AST child : children) {
				if (child != null) {
					child.dump(level + 1);
				}
			}
		} else {
			indent(level + 1);
			System.err.println("  empty");
		}		
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		s.append("[" + this.lineNo + ": " + type.toString() + ": ");
		
		for (AST child : children)
			if (child != null)
				s.append(child.toString());
		
		s.append("]");

		return s.toString();
	}

	@Override
	public ASTValue eval(WordsEnvironment environment) throws WordsProgramException {
		switch(this.type) {
			case ADD:
				return evalAdd(environment);
			case ALIAS:
				return evalAlias(environment);
			case AND:
				return evalAnd(environment);
			case ASSIGN:
				return evalAssign(environment);
			case CLASS_STATEMENT_LIST:
				return evalClassStatementList(environment);
			case CREATE_CLASS:
				return evalCreateClass(environment);
			case CREATE_OBJ:
				return evalCreateObj(environment);
			case DEFINE_ACTION:
				return evalDefineAction(environment);
			case DEFINE_PROPERTY:
				return evalDefineProperty(environment);
			case EQUALS:
				return evalEquals(environment);
			case EXIT:
				return evalExit(environment);
			case EXPONENTIATE:
				return evalExponentiate(environment);
			case GEQ:
				return evalGEQ(environment);
			case GREATER:
				return evalGreater(environment);
			case IDENTIFIER_LIST:
				return evalIdentifierList(environment);
			case IF:
				return evalIf(environment);
			case LEQ:
				return evalLEQ(environment);
			case LESS:
				return evalLess(environment);
			case LISTENER_PERM:
				return evalListenerPerm(environment);
			case LISTENER_TEMP:
				return evalListenerTemp(environment);
			case MOVES_PREDICATE:
				return evalMovesPredicate(environment);
			case MULTIPLY:
				return evalMultiply(environment);
			case NEGATE:
				return evalNegate(environment);
			case NOT:
				return evalNot(environment);
			case OR:
				return evalOr(environment);
			case PARAMETER:
				return evalParameter(environment);
			case PARAMETER_LIST:
				return evalParameterList(environment);
			case POSITION:
				return evalPosition(environment);
			case QUEUE_ACTION:
				return evalQueueAction(environment);
			case QUEUE_ASSIGN:
				return evalQueueAssign(environment);
			case QUEUE_ASSIGN_PROPERTY:
				return evalQueueAssignProperty(environment);
			case QUEUE_ASSIGN_PROPERTY_LIST:
				return evalQueueAssignPropertyList(environment);
			case QUEUE_MOVE:
				return evalQueueMove(environment);
			case QUEUE_SAY:
				return evalQueueSay(environment);
			case QUEUE_STOP:
				return evalQueueStop(environment);
			case QUEUE_WAIT:
				return evalQueueWait(environment);
			case REFERENCE_LIST:
				return evalReferenceList(environment);
			case REMOVE:
				return evalRemove(environment);
			case REPEAT:
				return evalRepeat(environment);
			case RESET:
				return evalReset(environment);
			case RETRIEVE_PROPERTY:
				return evalRetrieveProperty(environment);
			case SAYS_PREDICATE:
				return evalSaysPredicate(environment);
			case STATEMENT_LIST:
				return evalStatementList(environment);
			case SUBJECT:
				return evalSubject(environment);
			case SUBTRACT:
				return evalSubtract(environment);
			case TOUCHES_PREDICATE:
				return evalTouchesPredicate(environment);
			case WAITS_PREDICATE:
				return evalWaitsPredicate(environment);
			case WHILE:
				return evalWhile(environment);
			default:
				throw new AssertionError("INode evaluated with unexpected AST node type " + this.type.toString());
		}
	}

	private ASTValue evalAdd(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");
	}

	private ASTValue evalAlias(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");
	}

	private ASTValue evalAnd(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");
	}

	private ASTValue evalAssign(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalClassStatementList(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");
	}

	private ASTValue evalCreateClass(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalCreateObj(WordsEnvironment environment) throws WordsProgramException {
		ASTValue objName = children.get(0).eval(environment);
		ASTValue className = children.get(1).eval(environment);
		ASTValue properties = children.get(2) != null ? children.get(2).eval(environment) : null;
		ASTValue position = children.get(3).eval(environment);

		try {
			WordsObject newObject = environment.createObject(objName.stringValue, className.stringValue, position.positionValue);
		} catch (WordsEnvironmentException e) {
			throw new WordsProgramException(this.lineNo, e);
		}
		// TODO
		if (properties != null) {
			// For each element of properties, add property to newObject
		}
		
		return null;
	}

	private ASTValue evalDefineAction(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalDefineProperty(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalEquals(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalExit(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalExponentiate(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalGEQ(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalGreater(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalIdentifierList(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalIf(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalLEQ(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalLess(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalListenerPerm(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalListenerTemp(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalMovesPredicate(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalMultiply(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalNegate(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalNot(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalOr(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalParameter(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");	
	}

	private ASTValue evalParameterList(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");
	}

	private ASTValue evalPosition(WordsEnvironment environment) throws WordsProgramException {
		ASTValue row = children.get(0).eval(environment).tryCoerceTo(ValueType.NUM);
		ASTValue col = children.get(1).eval(environment).tryCoerceTo(ValueType.NUM);
		
		if (row.type != ValueType.NUM) {
			throw new WordsProgramException(lineNo, new InvalidTypeException(ValueType.NUM.toString(), row.type.toString()));
		}
		
		if (col.type != ValueType.NUM) {
			throw new WordsProgramException(lineNo, new InvalidTypeException(ValueType.NUM.toString(), col.type.toString()));
		}
		
		return new ASTValue(new WordsPosition(row.numValue, col.numValue));
	}

	private ASTValue evalQueueAction(WordsEnvironment environment) {
		
		// TODO
		throw new AssertionError("Not yet implemented");
	}

	private ASTValue evalQueueAssign(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");
	}

	private ASTValue evalQueueAssignProperty(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");
	}

	private ASTValue evalQueueAssignPropertyList(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");
	}

	private ASTValue evalQueueMove(WordsEnvironment environment) throws WordsProgramException {
		ASTValue referenceObject = children.get(0).eval(environment);
		ASTValue identifier = children.get(1).eval(environment);
		ASTValue direction = children.get(2).eval(environment);
		AST distance = children.get(3);
		ASTValue doNow = children.get(4) != null ? children.get(4).eval(environment) : null;
		
		WordsObject object;
		if (referenceObject.type.equals(ValueType.OBJ)){
			WordsProperty property = referenceObject.objValue.getProperty(identifier.stringValue);
			if (property.type != WordsProperty.PropertyType.OBJECT) {
				throw new WordsProgramException(lineNo, new InvalidTypeException(ValueType.OBJ.toString(), property.type.toString()));
			}
			object = property.objProperty;
		} else {
			object = environment.getObject(identifier.stringValue);
			if (object == null) {
				throw new WordsProgramException(lineNo, new WordsObjectNotFoundException(identifier.stringValue));
			}
		}
		
		assert(direction.type == ValueType.DIRECTION) : "Expected direction";
		
		//TODO: Distance = 0 should create a wait method
		WordsMove action = new WordsMove(direction.directionValue, distance);
		
		if (doNow == null) {
			object.enqueueAction(action);
		} else {
			object.enqueueActionAtFront(action);
		}
		
		return null;
	}

	private ASTValue evalQueueSay(WordsEnvironment environment) throws WordsProgramException {
		ASTValue referenceObject = children.get(0).eval(environment);
		ASTValue identifier = children.get(1).eval(environment);
		ASTValue message = children.get(2).eval(environment).tryCoerceTo(ValueType.STRING);
		ASTValue doNow = children.get(3) != null ? children.get(3).eval(environment) : null;
		
		WordsObject object;
		if (referenceObject.type.equals(ValueType.OBJ)){
			WordsProperty property = referenceObject.objValue.getProperty(identifier.stringValue);
			if (property.type != WordsProperty.PropertyType.OBJECT) {
				throw new WordsProgramException(lineNo, new InvalidTypeException(ValueType.OBJ.toString(), property.type.toString()));
			}
			object = property.objProperty;
		} else {
			object = environment.getObject(identifier.stringValue);
		}
		
		if (message.type != ValueType.STRING) {
			throw new WordsProgramException(lineNo, new InvalidTypeException(ValueType.STRING.toString(), message.type.toString()));
		}
		WordsSay action = new WordsSay(message.stringValue);
		
		if (doNow == null) {
			object.enqueueAction(action);
		} else {
			object.enqueueActionAtFront(action);
		}
		
		return null;
	}

	private ASTValue evalQueueStop(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");
	}

	private ASTValue evalQueueWait(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");
	}

	private ASTValue evalReferenceList(WordsEnvironment environment) {
		// TODO
		//throw new AssertionError("Not yet implemented");
		return new ASTValue(ValueType.NOTHING);
	}

	private ASTValue evalRemove(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");
	}

	private ASTValue evalRepeat(WordsEnvironment environment) throws WordsProgramException {
		ASTValue times = children.get(0).eval(environment).tryCoerceTo(ValueType.NUM);
		AST statementList = children.get(1);
		
		if (times.type != ValueType.NUM) {
			throw new WordsProgramException(lineNo, new InvalidTypeException(ValueType.NUM.toString(), times.type.toString()));
		}
		
		for (int i = 0; i < times.numValue; i++) {
			statementList.eval(environment);
		}
		
		return null;
	}

	private ASTValue evalReset(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");
	}

	private ASTValue evalRetrieveProperty(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");
	}

	private ASTValue evalSaysPredicate(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");
	}

	private ASTValue evalStatementList(WordsEnvironment environment) {
		for (int i = 0; i < children.size(); i++) {
			try {
				children.get(i).eval(environment);
			} catch (WordsProgramException e) {
				System.err.println();
				System.err.println(e);
				System.out.print("> ");
			}
		}
		
		return null;
	}

	private ASTValue evalSubject(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");
	}

	private ASTValue evalSubtract(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");
	}

	private ASTValue evalTouchesPredicate(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");
	}

	private ASTValue evalWaitsPredicate(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");
	}

	private ASTValue evalWhile(WordsEnvironment environment) {
		// TODO
		throw new AssertionError("Not yet implemented");
	}
}
