import java.util.Set;

public class CellAutomata {

    private Field field;
    private Set<Rule> rules;

    public CellAutomata(Field field, Set<Rule> rules) {
        this.field = field;
        this.rules = rules;
    }

    public void performLine(int line) {
        for (int i = 0; i < field.getxSize(); i++) {
            for (Rule r : rules) {
                field.apply(i, line, r);
            }
        }
    }
}
