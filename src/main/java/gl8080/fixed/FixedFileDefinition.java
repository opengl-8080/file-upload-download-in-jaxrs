package gl8080.fixed;

import java.util.HashMap;
import java.util.Map;

public class FixedFileDefinition {
    
    private Map<FixedFileColumn, FixedFileColumnDefinition> definitionMap = new HashMap<FixedFileColumn, FixedFileColumnDefinition>();

    public FixedFileDefinition addNumberColumn(FixedFileColumn column, int length) {
        this.definitionMap.put(column, FixedFileColumnDefinition.number(length));
        return this;
    }

    public FixedFileDefinition addHalfSizeColumn(FixedFileColumn column, int length) {
        this.definitionMap.put(column, FixedFileColumnDefinition.halfSize(length));
        return this;
    }

    public FixedFileBuilder newBuilder() {
        return new FixedFileBuilder(this);
    }
}
