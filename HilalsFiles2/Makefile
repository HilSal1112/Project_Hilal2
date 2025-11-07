#------------------------------------------------------------
# CS 4386 - Compiler Design - Project 1
# Makefile
# Hilal Salahudeen
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
#------------------------------------------------------------
FILE=Lexer.java LexerTest.java parser.java sym.java

#------------------------------------------------------------
# Build and Run Targets
#------------------------------------------------------------

# Run all test files
run: all
	@echo "Running lexical analysis on all .txt files in directory..."
	@for file in *.txt; do \
		if [ "$$file" != "example_output.txt" ]; then \
			output="$${file%.txt}-output.txt"; \
			echo "Analyzing $$file → $$output"; \
			$(JAVA) -cp $(CP) LexerTest $$file > $$output; \
		fi \
	done
	@echo "---------------------------------------------"
	@echo "Lexical analysis complete for all .txt files."
	@echo "---------------------------------------------"

# Compile everything
all: Lexer.java parser.java $(FILE:java=class)

#------------------------------------------------------------
# Cleanup
#------------------------------------------------------------
clean:
	rm -f *.class *~ *.bak Lexer.java parser.java sym.java *-output.txt

#------------------------------------------------------------
# File generation rules
#------------------------------------------------------------
Lexer.java: tokens.jflex
	$(JFLEX) tokens.jflex

parser.java sym.java: grammar.cup
	$(CUP) grammar.cup

