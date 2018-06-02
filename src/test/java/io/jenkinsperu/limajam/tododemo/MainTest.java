package io.jenkinsperu.limajam.tododemo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class MainTest {

        @Test
        public void applicationStarts() {
            Application.main(new String[] {});
        }

}

