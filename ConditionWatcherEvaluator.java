import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.InputStream;

public class ConditionWatcherEvaluator {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;

        CharStream inputCharStream = CharStreams.fromStream(inputStream);
        ConditionWatcherLexer lexer = new ConditionWatcherLexer(inputCharStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ConditionWatcherParser parser = new ConditionWatcherParser(tokens);

        ParseTree tree = parser.watch();

        FonteFinanziamento fonteFinanziamentoBuoniBenzina = new FonteFinanziamento() {{
            setId(5);
            setNome("Buoni Benzina");
        }};

        Borsello borsello = new Borsello() {{
            setId(1);
            setFonteFinanziamento(fonteFinanziamentoBuoniBenzina);
        }};

        ModalitaErogazione modalitaErogazioneBuono = new ModalitaErogazione(){{
            setId(1);
            setNome("BUONO");
        }};

        Servizio servizio = new Servizio() {{
            setId(155);
            setModalitaErogazione(modalitaErogazioneBuono);
        }};

        Transazione transazione = new Transazione() {{
            setId(74124);
            setServizio(servizio);
            setAmmontare(50.00f);
            setBorsello(borsello);
        }};

        ConditionWatcherEvaluatorVisitor visitor = new ConditionWatcherEvaluatorVisitor();
        boolean isSogliaDaConsiderare = visitor.valutaTransazione(transazione, tree);

        System.out.println("La soglia corrente è " + (isSogliaDaConsiderare ? "da" : "da NON") + " considerare");
    }
}
