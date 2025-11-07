#------------------------------------------------------------
# CS 4386 - Compiler Design - Project 2 Phase 1
# Hilal Salahudeen
# Makefile
#------------------------------------------------------------

JAVA=java
JAVAC=javac

JFLEX=$(JAVA) -jar jflex-full-1.8.2.jar
CUPJAR=./java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR):./java-cup-11b-runtime.jar

# All your Java source files (AST + driver)
SRC = Token.java \
      Expr.java \
      IntLiteral.java \
      VarExpr.java \
      BinaryExpr.java \
      Stmt.java \
      StmtList.java \
      AssignStmt.java \
      Program.java \
      ScannerTest.java

default: run

# Generate the lexer
Lexer.java: tokens.jflex
	$(JFLEX) tokens.jflex

# Generate the parser + sym table
parser.java sym.java: grammar.cup
	$(CUP) -parser parser -symbols sym grammar.cup

# Compile everything
classes: Lexer.java parser.java sym.java $(SRC)
	$(JAVAC) -cp $(CP) Lexer.java parser.java sym.java $(SRC)

# Run ScannerTest (reads from stdin)
run: classes
	$(JAVA) -cp $(CP) ScannerTest

clean:
	rm -f *.class *~ *.bak Lexer.java parser.java sym.java

