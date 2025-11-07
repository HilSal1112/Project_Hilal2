/**
 * Program.java
 * The Root node of the AST for Phase 1 (just a list of statements)
 * Phase 2 will put this in a class structure
 */
public class Program extends Token {
    private StmtList stmts;
    
    public Program(StmtList stmts) {
        this.stmts = stmts;
    }
    
    @Override
    public String toString(int t) {
        // For Phase 1, just print all statements at indentation 0
        if (stmts != null) {
            return stmts.toString(0);
        }
        return "";
    }
}





