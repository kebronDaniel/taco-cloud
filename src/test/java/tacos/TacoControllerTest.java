package tacos;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Contains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import tacos.Controller.TacoController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;


@WebMvcTest(TacoController.class)
public class TacoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testDesignView() throws Exception {

        mockMvc.perform(get("/design"))
                .andExpect(status().isOk())
                .andExpect(view().name("/design"))
                .andExpect(content().string(containsString("Design your taco")))
                .andExpect(content().string(containsString("wrap"))); // This is one of the dynamic contents
    }
}
