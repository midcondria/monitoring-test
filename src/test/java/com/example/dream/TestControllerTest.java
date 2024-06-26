package com.example.dream;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@ExtendWith(RestDocumentationExtension.class)
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("")
    @Test
    void test() throws Exception {
        mockMvc.perform(get("/api/hi/hi1"))
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("나는짱1"));
    }

    @DisplayName("")
    @Test
    void test2() throws Exception {
        mockMvc.perform(get("/api/hi/hi2"))
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("나는짱2"));
    }

    @DisplayName("")
    @Test
    void test3() throws Exception {
        TestDto request = TestDto.builder()
            .email("나는짱")
            .password("123")
            .build();
        String json = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/hi/hi3")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("나는짱3"));
    }
}