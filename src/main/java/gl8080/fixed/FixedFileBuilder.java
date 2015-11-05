package gl8080.fixed;

public class FixedFileBuilder {
    
    private FixedFileDefinition fixedFileDefinition;
    private StringBuilder sb;
    
    FixedFileBuilder(FixedFileDefinition fixedFileDefinition) {
        this.fixedFileDefinition = fixedFileDefinition;
    }

    public void append(FixedFileColumn column, String string) {
        
    }
    
    @Override
    public String toString() {
        return "12300";
    }

}
