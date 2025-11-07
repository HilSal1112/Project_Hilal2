/**
 * BlockStmt.java
 * Represents a block: { Stmts }
 */
public class BlockStmt extends Stmt {
    private StmtList stmts;

    public BlockStmt(StmtList stmts) {
        this.stmts = stmts;
    }

    @Override
    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        sb.append(getTabs(t)).append("{\n");
        if (stmts != null) {
            sb.append(stmts.toString(t + 1));
        }
        sb.append(getTabs(t)).append("}\n");
        return sb.toString();
    }
}

