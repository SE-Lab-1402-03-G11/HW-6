package MiniJava.scanner;

import MiniJava.scanner.lexicalAnalyzer;
import MiniJava.scanner.token.Token;

public class ScannerFacade {
    private final lexicalAnalyzer lexicalAnalyzer;

    public ScannerFacade(java.util.Scanner scanner) {
        lexicalAnalyzer = new lexicalAnalyzer(scanner);
    }

    public Token getNextToken() {
        return lexicalAnalyzer.getNextToken();
    }

}