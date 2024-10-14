package com.microsoft.hackathon.copilotdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;;


@SpringBootTest()
@AutoConfigureMockMvc 
class CopilotDemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
	void hello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello?key=world"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("hello world"));
	}

	@Test
	void helloWithoutKey() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("key has not been passed"));
	}

	@Test
	void helloWithEmptyKey() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello?key="))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("hello "));
	}

	@Test
	void helloWithMultipleKeys() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello?key=world&key=world2"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("hello world,world2"));
	}


}