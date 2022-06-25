import org.antlr.v4.runtime.tree.ParseTree;

public class ConditionWatcherEvaluatorVisitor extends ConditionWatcherBaseVisitor {

    private Transazione transazione;

    private Boolean result;

    public boolean valutaTransazione(Transazione transazione, ParseTree parseTree) {
        this.transazione = transazione;

        this.result = true;

        this.visit(parseTree);

        return this.result;
    }

    @Override
    public Object visitPredicate(ConditionWatcherParser.PredicateContext ctx) {
        String variable = ctx.variable().getText();
        String comparisonOperator= ctx.comparison_operator.getText();
        String value = ctx.value().getText();

        String transazioneVariableValue;

        if (variable.equals("modalita_erogazione")) {
            transazioneVariableValue = transazione.getServizio().getModalitaErogazione().getNome();
        } else if (variable.equals("fonte_finanziamento")) {
            transazioneVariableValue = transazione.getBorsello().getFonteFinanziamento().getNome();
        } else {
            throw new RuntimeException("Unknown variable " + variable);
        }

        transazioneVariableValue = "\"" + transazioneVariableValue + "\"";

        boolean result;
        switch (comparisonOperator) {
            case "=":
                result = transazioneVariableValue.equals(value);
                break;
            case "!=":
                result = !transazioneVariableValue.equals(value);
                break;
            default:
                throw new RuntimeException("Unknown comparison operator: " + comparisonOperator);
        }

        System.out.println(variable + " " + comparisonOperator + " " + value + " evaluates to " + result);

        this.result = this.result && result;

        return this.visitChildren(ctx);
    }

}
