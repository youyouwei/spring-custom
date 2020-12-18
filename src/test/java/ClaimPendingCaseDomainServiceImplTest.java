
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ClaimPendingCaseDomainServiceImplTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Captor
    private ArgumentCaptor<ClaimsPendingCaseDO> captor;

    private ClaimPendingCaseDomainServiceImpl claimPendingCaseDomainService;

    @Mock
    private IClaimsPendingCaseDAO claimsPendingCaseDAO;

    @Before
    public void setUp() {
        claimPendingCaseDomainService = new ClaimPendingCaseDomainServiceImpl(claimsPendingCaseDAO);
    }


    @Test
    public void testSavePendingCase() {

        //准备mock对象数据

        //准备数据方法入参

        //Captor抓取中间数据

        //执行方法

        //capture验证中间数据

        //验证返回结果
        verify(claimsPendingCaseDAO, times(1)).insert(captor.capture());
        final ClaimsPendingCaseDO domain = captor.getValue();
        assertThat(domain, is(notNullValue()));
        assertThat(domain.getContent(), is("Test Case"));


    }

    @Test
    public void testSavePendingCaseParamIsNullException() {

        //预期异常 需要在待执行方法之前
        thrown.expect(Exception.class);
        thrown.expectMessage("param is null");

        //执行方法
    }

    @After
    public void tearDown() {

    }

    private class ClaimsPendingCaseDO {
        private String content;


        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    private class ClaimPendingCaseDomainServiceImpl {
        public ClaimPendingCaseDomainServiceImpl(IClaimsPendingCaseDAO claimsPendingCaseDAO) {
        }
    }

    private class IClaimsPendingCaseDAO {
        public void insert(ClaimsPendingCaseDO capture) {
        }
    }
}
