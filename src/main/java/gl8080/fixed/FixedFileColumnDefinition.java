package gl8080.fixed;

public class FixedFileColumnDefinition {
    
    private final TYPE type;
    private final int length;
    
    public static FixedFileColumnDefinition number(int length) {
        return new FixedFileColumnDefinition(TYPE.NUMBER, length);
    }
    
    public static FixedFileColumnDefinition halfSize(int length) {
        return new FixedFileColumnDefinition(TYPE.HALF_SIZE, length);
    }
    
    public static FixedFileColumnDefinition fullSize(int length) {
        return new FixedFileColumnDefinition(TYPE.FULL_SIZE, length);
    }

    private FixedFileColumnDefinition(TYPE type, int length) {
        this.type = type;
        this.length = length;
    }

    public int getLength() {
        return length;
    }
    
    private static enum TYPE {
        NUMBER,
        HALF_SIZE,
        FULL_SIZE,
    }
}
