package test.techoffice.example;

import com.techoffice.service.Test2Service;
import com.techoffice.util.DateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.text.SimpleDateFormat;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DateUtil.class})
public class Test2ServiceTest {

    @InjectMocks
    private Test2Service test2Service;

    @Test
    public void returnTestingString() throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String mockValue = "2020/02/25";
        PowerMockito.mockStatic(DateUtil.class);
        PowerMockito.when(DateUtil.getCurrentDate()).thenReturn(simpleDateFormat.parse(mockValue));
        String result = test2Service.returnTestingString();
        Assert.assertEquals("2020/02/25", result);
    }
}
