import com.example.SubmersibleProbe.model.Commands
import com.example.SubmersibleProbe.model.Direction
import com.example.SubmersibleProbe.model.SubmersibleProbeRequest

import com.example.SubmersibleProbe.service.ProbServiceImpl
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProbeTest {

    @Mock
    private ProbServiceImpl probTestImpl;

    @Before
    void setup(){
        probTestImpl= new ProbServiceImpl();
    }

    @Test
    void "visited co-ordinates"(){
        given:
        def commands= [ new Commands(1,1,Direction.NORTH,"Forward"),
                        new Commands(1,1,Direction.SOUTH,"Backward"),
                        new Commands(5,4,Direction.EAST,"Left"),
                        new Commands(-5,-4,Direction.EAST,"Right")]
        SubmersibleProbeRequest  submersibleProbeRequest = new SubmersibleProbeRequest(commands)
        when:
        def result = probTestImpl.executeCommands(null)
        then:
        result == null;

    }

    @Test
    void "visited co-ordinates cases"(){
        given:
        def commands= [ new Commands(1,1,Direction.NORTH,"Forward"),
                        new Commands(1,1,Direction.SOUTH,"Backward"),
                        new Commands(5,4,Direction.EAST,"Left"),
                        new Commands(-5,-4,Direction.EAST,"Right")]
        SubmersibleProbeRequest  submersibleProbeRequest = new SubmersibleProbeRequest(commands)
        when:
        def result = probTestImpl.executeCommands(submersibleProbeRequest)
        then:
         result.get(0) ==[2,2]
         result.get(1) ==[2,0]
         result.get(2) ==[6,5]
         result.get(3) ==[-4,-5]
    }
}
