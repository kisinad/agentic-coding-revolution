package com.agentic.codingrevolution.controller;

import com.agentic.codingrevolution.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

/**
 * REST Controller that provides a simple endpoint returning "successful"
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SuccessController {

    /**
     * GET endpoint that returns a successful response
     * @return ApiResponse with "successful" message
     */
    @GetMapping("/success")
    public ResponseEntity<ApiResponse> getSuccess() {
        ApiResponse response = new ApiResponse(
                "successful",
                HttpStatus.OK.value(),
                Instant.now().toString()
        );
        return ResponseEntity.ok(response);
    }

    /**
     * POST endpoint that returns a successful response
     * @return ApiResponse with "successful" message
     */
    @PostMapping("/success")
    public ResponseEntity<ApiResponse> postSuccess() {
        ApiResponse response = new ApiResponse(
                "successful",
                HttpStatus.CREATED.value(),
                Instant.now().toString()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * PUT endpoint that returns a successful response
     * @return ApiResponse with "successful" message
     */
    @PutMapping("/success")
    public ResponseEntity<ApiResponse> putSuccess() {
        ApiResponse response = new ApiResponse(
                "successful",
                HttpStatus.OK.value(),
                Instant.now().toString()
        );
        return ResponseEntity.ok(response);
    }

    /**
     * DELETE endpoint that returns a successful response
     * @return ApiResponse with "successful" message
     */
    @DeleteMapping("/success")
    public ResponseEntity<ApiResponse> deleteSuccess() {
        ApiResponse response = new ApiResponse(
                "successful",
                HttpStatus.NO_CONTENT.value(),
                Instant.now().toString()
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    /**
     * PATCH endpoint that returns a successful response
     * @return ApiResponse with "successful" message
     */
    @PatchMapping("/success")
    public ResponseEntity<ApiResponse> patchSuccess() {
        ApiResponse response = new ApiResponse(
                "successful",
                HttpStatus.OK.value(),
                Instant.now().toString()
        );
        return ResponseEntity.ok(response);
    }
}
