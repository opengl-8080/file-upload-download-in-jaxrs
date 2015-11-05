package gl8080.fixed;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class FixedFileBuilderTest {
    
    public static class TestBase {
        
        public FixedFileDefinition definition;
        
        @Before
        public void _setup() throws Exception {
            definition = new FixedFileDefinition();
        }
    }
    
    public class 固定長ファイル出力 extends TestBase {
        
        @Test
        public void 数値項目は左詰めのゼロパディングされること() throws Exception {
            // setup
            FixedFileBuilder builder =
                    definition
                    .addNumberColumn(TestColumn.NUMBER, 5)
                    .newBuilder();
            
            builder.append(TestColumn.NUMBER, "123");
            
            // exercise
            String actual = builder.toString();
            
            // verify
            assertThat(actual, is("12300"));
        }
        @Test
        public void 半角文字列項目は右詰め半角スペースパディングされること() throws Exception {
            // setup
            FixedFileBuilder builder =
                    definition
                    .addHalfSizeColumn(TestColumn.HALF_SIZE, 5)
                    .newBuilder();
            
            builder.append(TestColumn.HALF_SIZE, "abc");
            
            // exercise
            String actual = builder.toString();
            
            // verify
            assertThat(actual, is("  abc"));
        }
    }
    
    private static enum TestColumn implements FixedFileColumn {
        NUMBER,
        HALF_SIZE
        ;
    }
}
