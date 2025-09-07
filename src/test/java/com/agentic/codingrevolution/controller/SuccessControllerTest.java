package com.agentic.codingrevolution.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for SuccessController
 */
@WebMvcTest(SuccessController.class)
@DisplayName("SuccessController Tests")
class SuccessControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String BASE_URL = "/api/v1/success";

    @Nested
    @DisplayName("GET /api/v1/success")
    class GetSuccessTests {

        @Test
        @DisplayName("Should return successful response with 200 status")
        void shouldReturnSuccessfulResponseWithOkStatus() throws Exception {
            mockMvc.perform(get(BASE_URL)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.message").value("successful"))
                    .andExpect(jsonPath("$.status").value(HttpStatus.OK.value()));
        }

        @Test
        @DisplayName("Should return proper JSON structure")
        void shouldReturnProperJsonStructure() throws Exception {
            mockMvc.perform(get(BASE_URL))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.message").exists())
                    .andExpect(jsonPath("$.status").exists())
                    .andExpect(jsonPath("$.timestamp").exists());
        }

        @Test
        @DisplayName("Should handle multiple concurrent requests")
        void shouldHandleMultipleConcurrentRequests() throws Exception {
            // Simulate multiple requests
            for (int i = 0; i < 5; i++) {
                mockMvc.perform(get(BASE_URL))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.message").value("successful"));
            }
        }
    }

    @Nested
    @DisplayName("POST /api/v1/success")
    class PostSuccessTests {

        @Test
        @DisplayName("Should return successful response with 201 status")
        void shouldReturnSuccessfulResponseWithCreatedStatus() throws Exception {
            mockMvc.perform(post(BASE_URL)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.message").value("successful"))
                    .andExpect(jsonPath("$.status").value(HttpStatus.CREATED.value()));
        }

        @Test
        @DisplayName("Should return proper JSON structure")
        void shouldReturnProperJsonStructure() throws Exception {
            mockMvc.perform(post(BASE_URL))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.message").exists())
                    .andExpect(jsonPath("$.status").exists())
                    .andExpect(jsonPath("$.timestamp").exists());
        }
    }

    @Nested
    @DisplayName("PUT /api/v1/success")
    class PutSuccessTests {

        @Test
        @DisplayName("Should return successful response with 200 status")
        void shouldReturnSuccessfulResponseWithOkStatus() throws Exception {
            mockMvc.perform(put(BASE_URL)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.message").value("successful"))
                    .andExpect(jsonPath("$.status").value(HttpStatus.OK.value()));
        }
    }

    @Nested
    @DisplayName("DELETE /api/v1/success")
    class DeleteSuccessTests {

        @Test
        @DisplayName("Should return successful response with 204 status")
        void shouldReturnSuccessfulResponseWithNoContentStatus() throws Exception {
            mockMvc.perform(delete(BASE_URL)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNoContent())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.message").value("successful"))
                    .andExpect(jsonPath("$.status").value(HttpStatus.NO_CONTENT.value()));
        }
    }

    @Nested
    @DisplayName("PATCH /api/v1/success")
    class PatchSuccessTests {

        @Test
        @DisplayName("Should return successful response with 200 status")
        void shouldReturnSuccessfulResponseWithOkStatus() throws Exception {
            mockMvc.perform(patch(BASE_URL)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.message").value("successful"))
                    .andExpect(jsonPath("$.status").value(HttpStatus.OK.value()));
        }
    }

    @Nested
    @DisplayName("Edge Cases and Error Handling")
    class EdgeCaseTests {

        @Test
        @DisplayName("Should handle invalid paths")
        void shouldHandleInvalidPaths() throws Exception {
            mockMvc.perform(get("/api/v1/invalid"))
                    .andExpect(status().isNotFound());
        }

        @Test
        @DisplayName("Should handle requests with different content types")
        void shouldHandleRequestsWithDifferentContentTypes() throws Exception {
            // This should still work as our endpoints don't require specific content
            mockMvc.perform(get(BASE_URL)
                            .contentType(MediaType.TEXT_PLAIN))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.message").value("successful"));
        }

        @Test
        @DisplayName("Should handle requests with extra headers")
        void shouldHandleRequestsWithExtraHeaders() throws Exception {
            mockMvc.perform(get(BASE_URL)
                            .header("X-Custom-Header", "custom-value")
                            .header("Authorization", "Bearer token"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.message").value("successful"));
        }

        @Test
        @DisplayName("Should handle requests with query parameters")
        void shouldHandleRequestsWithQueryParameters() throws Exception {
            mockMvc.perform(get(BASE_URL + "?param1=value1&param2=value2"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.message").value("successful"));
        }

        @Test
        @DisplayName("Should handle OPTIONS requests for CORS")
        void shouldHandleOptionsRequestsForCors() throws Exception {
            mockMvc.perform(options(BASE_URL)
                            .header("Origin", "https://example.com")
                            .header("Access-Control-Request-Method", "GET"))
                    .andExpect(status().isOk());
        }
    }

    @Nested
    @DisplayName("Performance Tests")
    class PerformanceTests {

        @Test
        @DisplayName("Should respond within reasonable time")
        void shouldRespondWithinReasonableTime() throws Exception {
            long startTime = System.currentTimeMillis();
            
            mockMvc.perform(get(BASE_URL))
                    .andExpect(status().isOk());
            
            long endTime = System.currentTimeMillis();
            long responseTime = endTime - startTime;
            
            // Assert response time is under 1 second (1000ms)
            assert responseTime < 1000 : "Response time should be under 1 second, but was " + responseTime + "ms";
        }

        @Test
        @DisplayName("Should handle high load requests")
        void shouldHandleHighLoadRequests() throws Exception {
            // Test with more requests to ensure stability
            for (int i = 0; i < 50; i++) {
                mockMvc.perform(get(BASE_URL))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.message").value("successful"));
            }
        }
    }

    @Nested
    @DisplayName("Null and Empty Value Tests")
    class NullAndEmptyValueTests {

        @Test
        @DisplayName("Should handle GET request without body")
        void shouldHandleGetRequestWithoutBody() throws Exception {
            mockMvc.perform(get(BASE_URL))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.message").value("successful"));
        }

        @Test
        @DisplayName("Should handle POST request without body")
        void shouldHandlePostRequestWithoutBody() throws Exception {
            mockMvc.perform(post(BASE_URL))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.message").value("successful"));
        }

        @Test
        @DisplayName("Should handle PUT request without body")
        void shouldHandlePutRequestWithoutBody() throws Exception {
            mockMvc.perform(put(BASE_URL))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.message").value("successful"));
        }

        @Test
        @DisplayName("Should handle DELETE request without body")
        void shouldHandleDeleteRequestWithoutBody() throws Exception {
            mockMvc.perform(delete(BASE_URL))
                    .andExpect(status().isNoContent())
                    .andExpect(jsonPath("$.message").value("successful"));
        }

        @Test
        @DisplayName("Should handle PATCH request without body")
        void shouldHandlePatchRequestWithoutBody() throws Exception {
            mockMvc.perform(patch(BASE_URL))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.message").value("successful"));
        }
    }
}
