package test.techoffice.example;

import com.techoffice.service.Test1Service;
import com.techoffice.service.Test2Service;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class Test1ServiceTest {

    @InjectMocks
    private Test1Service test1Service;

    @Mock
    private Test2Service test2Service;

    @Test
    public void testDoSomething(){
        String mockValue = "Test";
        when(test2Service.returnTestingString()).thenReturn(mockValue);
        String result = test1Service.returnFromTest2Service();
        Assert.assertEquals(mockValue, result);
    }
}
