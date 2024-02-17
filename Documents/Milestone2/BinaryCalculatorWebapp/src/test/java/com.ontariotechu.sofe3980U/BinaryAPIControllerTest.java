package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
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
@WebMvcTest(BinaryAPIController.class)


public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("10001"));
    }
	@Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }


    //Additional test cases


    //addition testing 
    @Test
    public void additionTest() throws Exception {
        this.mvc.perform(get("/add")
                .param("operand1", "101")
                .param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("101"));
    }


    //subtraction testing 
    @Test 
    public void subtractTest() throws Exception { 
        this.mvc.perform(get("/subtract")
            .param("operand1","101")
            .param("operand2","10"))
            .andExpect(status().isOk())
            .andExpect(content().string("011"));
    }


    //additional testing for division by 0
    @Test 
    public void divideByZeroTest() throws Exception {
        this.mvc.perform(get("/divide")
            .param("operand1", "111")
            .param("operand2", "0"))
            .andExpect(status().isOk())
            .andExpect(content().string("Can't divide by 0"));
    }


    //multiplying test 
    @Test 
    public void mulitiplicationTest() throws Exception { 
        this.mvc.perform(get("/multiply")
            .param("operand1","101001")
            .param("operand2","100"))
            .andExpect(status().isOk())
            .andExpect(content().string("010100100")); 
    }


    //bitwise AND test 
    @Test 
    public void andTest() throws Exception { 
        this.mvc.perform(get("/bitwise-and")
            .param("operand1","1101")
            .param("operand2","1011")) 
            .andExpect(status().isOk())
            .andExpect(content().string("1001")); 
    }


    //bitwise OR test 
    @Test 
    public void orTest() throws Exception { 
        this.mvc.perform(get("/bitwise-or")
            .param("operand1","1101")
            .param("operand2","1011")) 
            .andExpect(status().isOk())
            .andExpect(content().string("1111")); 
    }

}