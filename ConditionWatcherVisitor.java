// Generated from ConditionWatcher.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ConditionWatcherParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ConditionWatcherVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ConditionWatcherParser#watch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWatch(ConditionWatcherParser.WatchContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionWatcherParser#condition_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_expression(ConditionWatcherParser.Condition_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionWatcherParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(ConditionWatcherParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionWatcherParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(ConditionWatcherParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionWatcherParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(ConditionWatcherParser.ValueContext ctx);
}