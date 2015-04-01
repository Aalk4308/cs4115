import java.util.LinkedList;

public abstract class WordsAction {
	public abstract boolean isExecutable();
	public final boolean isExpandable() { return !isExecutable(); }

	/**
	 * Execute the action if it is expandable.
	 */
	public final void execute(WordsObject object, WordsEnvironment environment) {
		boolean flag = !isExecutable();
		assert flag : "Attempted to execute non-executable action";
		doExecute(object, environment);
	};
	
	/**
	 * Expand the action if it is expandable.
	 * @throws WordsEnvironmentException 
	 */
	public final LinkedList<WordsAction> expand(WordsObject object, WordsEnvironment environment) throws WordsProgramException {
		boolean flag = !isExpandable();
		assert flag : "Attempted to expand non-expandable action";
		return doExpand(object, environment);
	};
	
	/**
	 * Actually execute the action.  Guaranteed to be called only on executable actions.  
	 */
	protected abstract void doExecute(WordsObject object, WordsEnvironment environment);
	
	/**
	 * Actually expand the action.  Guaranteed to be called only on expandable actions.  
	 * @throws WordsEnvironmentException 
	 * @throws WordsProgramException 
	 */
	protected abstract LinkedList<WordsAction> doExpand(WordsObject object, WordsEnvironment environment) throws WordsProgramException;
}