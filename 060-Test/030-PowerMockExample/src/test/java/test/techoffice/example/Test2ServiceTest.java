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

@RunWith(PowerMockRunner.class)
@PrepareForTest({DateUtil.class})
public class Test2ServiceTest {

    @InjectMocks
    private Test2Service test2Service;

    @Test
    public void returnTestingString(){
        PowerMockito.mockStatic(DateUtil.class);
        String result = test2Service.returnTestingString();
//        PowerMockito.verifyStatic(Mockito.ver);
    }
}
