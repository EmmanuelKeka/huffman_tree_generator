//class that has the symbol and the frequency variable
public abstract class Huffman {
    private char symbol;
    private int frequency;
    public Huffman(char symbol, int frequency){
        this.symbol = symbol;
        this.frequency = frequency;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getFrequency() {
        return frequency;
    }
}
