#------------------------------------------------------------
# CS 4386 - Compiler Design - Project 2 Phase 1
# Hilal Salahudeen
# Makefile
#------------------------------------------------------------

# Java tools
JAVA=java
JAVAC=javac

# JFlex and CUP tools
JFLEX=$(JAVA) -jar jflex-full-1.8.2.jar
CUPJAR=./java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR)

#------------------------------------------------------------
# Default target
#------------------------------------------------------------
default: run

.SUFFIXES: .java .class
.java.class:
	$(JAVAC) -cp $(CP) $*.java

#------------------------------------------------------------
# Files to compile
# IMPORTANT: Using exact filenames as they appear in directory
#------------------------------------------------------------
FILE=Lexer.java parser.java sym.java \
     ScannerTest.java \
     token.java program.java stmtlist.java stmt.java \
     expr.java assnstmt.java intlit.java varexpr.java binaryexpr.java

#------------------------------------------------------------
# Build and Run Targets
#------------------------------------------------------------

# Run on test input
run: all
	@echo "Testing Phase 1 parser..."
	@echo "x = 5;" | $(JAVA) -cp $(CP) ScannerTest
	@echo ""

# Compile everything
all: Lexer.java parser.java $(FILE:.java=.class)

#------------------------------------------------------------
# Cleanup
#------------------------------------------------------------
clean:
	rm -f *.class *~ *.bak Lexer.java parser.java sym.java

#------------------------------------------------------------
# File generation rules
#------------------------------------------------------------
Lexer.java: tokens.jflex
	$(JFLEX) tokens.jflex

parser.java sym.java: grammar.cup
	$(CUP) grammar.cup

#------------------------------------------------------------
# Testing targets
#------------------------------------------------------------
test1: all
	@echo "=== Test 1: Simple assignment ==="
	@echo "x = 5;" | $(JAVA) -cp $(CP) ScannerTest
	@echo ""

test2: all
	@echo "=== Test 2: Expression assignment ==="
	@echo "y = x + 3;" | $(JAVA) -cp $(CP) ScannerTest
	@echo ""

test3: all
	@echo "=== Test 3: Arithmetic with precedence ==="
	@echo "z = x + y * 2;" | $(JAVA) -cp $(CP) ScannerTest
	@echo ""

test4: all
	@echo "=== Test 4: Multiple statements ==="
	@printf "x = 5;\ny = x + 3;\nz = x * y;\n" | $(JAVA) -cp $(CP) ScannerTest
	@echo ""

testall: test1 test2 test3 test4
	@echo "=== All tests complete ==="
