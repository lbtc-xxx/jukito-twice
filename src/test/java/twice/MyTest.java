package twice;

import com.google.inject.AbstractModule;
import org.jukito.JukitoRunner;
import org.jukito.UseModules;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JukitoRunner.class)
@UseModules(MyTest.MyModule.class)
public class MyTest {

    private static int count = 0;

    @Test
    public void moduleShouldBeInstantiatedOnlyOnce() throws Exception {
        assertThat(count, is(1));
    }

    public static class MyModule extends AbstractModule {
        @Override
        protected void configure() {
            System.out.println("configure - this printed twice");
            count++;
        }
    }
}
