#Thabang Sambo
#Makefile compilation
#Makefile for NumberRangeSummarizer

JAVAC = javac
JAVA = java
JFLAGS = -g
CLASSES = ImplementNumberRangeSummarizer.class NumberRangeSummarizer.class
MAIN = ImplementNumberRangeSummarizer

all: compile

compile: $(CLASSES)

ImplementNumberRangeSummarizer.class: ImplementNumberRangeSummarizer.java NumberRangeSummarizer.java
	$(JAVAC) $(JFLAGS) ImplementNumberRangeSummarizer.java NumberRangeSummarizer.java

run: compile
	$(JAVA) $(MAIN)

clean:
	rm -f *.class

.PHONY: all compile run clean
