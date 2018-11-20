package springpetclinic;

import guru.springframework.sfgpetclinic.SpringPetClinicApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringPetClinicApplication.class)
public class SpringPetClinicApplicationTests {

    @Test
    public void contextLoads() {
    }

}
