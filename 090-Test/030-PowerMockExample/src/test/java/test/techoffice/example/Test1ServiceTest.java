package test.techoffice.example;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import com.techoffice.service.Test1Service;
import com.techoffice.service.Test2Service;
import com.techoffice.util.DateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Date;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DateUtil.class, Test1Service.class})
public class Test1ServiceTest {

    @InjectMocks
    private Test1Service test1Service;

    @Mock
    private Test2Service test2Service;

    @Test
    public void testMockServiceMethod(){
        String mockValue = "2020/02/25";
        when(test2Service.returnTestingString()).thenReturn(mockValue);
        String result = test1Service.returnFromTest2Service();
        Assert.assertEquals(mockValue, result);
    }

    @Test
    public void testReturnFromPrivateMethod() throws Exception {
        Test1Service test1ServiceSpy = PowerMockito.spy(test1Service);
        String mockValue = "testing mock";
        PowerMockito.when(test1ServiceSpy,"privateMethod").thenReturn(mockValue);
        String result = test1ServiceSpy.returnFromPrivateMethod();
        Assert.assertEquals(mockValue, result);
    }


}
