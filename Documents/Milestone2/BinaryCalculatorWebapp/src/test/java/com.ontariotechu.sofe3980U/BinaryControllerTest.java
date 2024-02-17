package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void getDefault() throws Exception {
        this.mvc.perform(get("/"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
			.andExpect(model().attribute("operand1", ""))
			.andExpect(model().attribute("operand1Focused", false));
    }
	
	@Test
    public void getParameter() throws Exception {
        this.mvc.perform(get("/").param("operand1","111"))
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
			.andExpect(model().attribute("operand1", "111"))
			.andExpect(model().attribute("operand1Focused", true));
    }
	@Test
	    public void postParameter() throws Exception {
        this.mvc.perform(post("/").param("operand1","111").param("operator","+").param("operand2","111"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "1110"))
			.andExpect(model().attribute("operand1", "111"));
    }


    //additional test cases for webapp 

    //Testing for zero 
    @Test 
    public void divideByZeroTest() throws Exception {
        this.mvc.perform(get("/divide")
            .param("operand1", "111")
            .param("operand2", "0"))
            .andExpect(status().isOk())
            .andExpect(content().string("Can't divide by 0"));
    }

    
    //testing the addition 
    @Test 
    public void additionTest() throws Exception { 
        this.mvc.perform(post("/")
            .param("operand1","101")
            .param("operator","+")
            .param("operand2","10"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "111"));
    }


    //testing for subtracting 
    @Test 
    public void subtractTest() throws Exception { 
        this.mvc.perform(post("/")
            .param("operand1","101")
            .param("operator","-")
            .param("operand2","10"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "011"));
    }


    //testing for divsion
    @Test 
    public void divisionTest() throws Exception { 
        this.mvc.perform(post("/")
            .param("operand1","10101")
            .param("operator","/")
            .param("operand2","10"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "01010 Remainder : 1"));
    }


    //testing for multiplication
    @Test 
    public void mulitiplicationTest() throws Exception { 
        this.mvc.perform(post("/")
            .param("operand1","101001")
            .param("operator","*")
            .param("operand2","100"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "010100100"));
    }


    //testing for bitwise AND
    @Test 
    public void andTest() throws Exception { 
        this.mvc.perform(post("/")
            .param("operand1","1101")
            .param("operator","&")
            .param("operand2","1011"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "1001"));
    }


    //etsting for bitwise OR 
    @Test 
    public void orTest() throws Exception { 
        this.mvc.perform(post("/")
            .param("operand1","1101")
            .param("operator","|")
            .param("operand2","1011"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("result", "1111"));
    }


}