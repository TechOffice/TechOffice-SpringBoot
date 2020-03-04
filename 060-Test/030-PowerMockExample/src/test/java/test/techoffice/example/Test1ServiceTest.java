package test.techoffice.example;

import com.techoffice.service.Test1Service;
import com.techoffice.service.Test2Service;
import com.techoffice.util.DateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Date;

import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DateUtil.class})
public class Test1ServiceTest {

    @InjectMocks
    private Test1Service test1Service;

    @Mock
    private Test2Service test2Service;

    @Test
    public void testDoSomething(){
        PowerMockito.mockStatic(DateUtil.class);
        PowerMockito.when(DateUtil.getCurrentDate()).thenReturn(new Date());
        String mockValue = "2020/02/25";
        when(test2Service.returnTestingString()).thenReturn(mockValue);
        String result = test1Service.returnFromTest2Service();
        Assert.assertEquals(mockValue, result);

    }
}
