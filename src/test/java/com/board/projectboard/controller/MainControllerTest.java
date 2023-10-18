package com.board.projectboard.controller;

import com.board.projectboard.config.TestSecurityConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Import(TestSecurityConfig.class)
@DisplayName("View 루트 컨트롤러")
@WebMvcTest(MainController.class)
class MainControllerTest {

    private final MockMvc mvc;

    MainControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] 루트 페이지 -> 게시글 리스트 (게시판) 페이지 Redirection")
    @Test
    void givenNoting_whenRequestingRootPage_thenRedirectsToArticlesPage() throws Exception {
        //Given

        //When&Then
        mvc.perform(get("/"))
                .andExpect(view().name("forward:/articles"))
                .andExpect(forwardedUrl("/articles"));
    }
}