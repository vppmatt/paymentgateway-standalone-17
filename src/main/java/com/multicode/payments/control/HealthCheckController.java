package com.multicode.payments.control;

import com.multicode.payments.service.BootstrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class HealthCheckController {

    @Autowired
    BootstrapService bootstrapService;

    @GetMapping("/health")
    public Map<String,Object> systemIsHealthy()
    {
        Map<String,Object> result = new HashMap<>();
        result.put("status","ok");
        result.put("LastReset", bootstrapService.getLastReset());
        return result;
    }

    @PostMapping("/restart")
    public String restartSystem(@RequestBody Map<String, String> body, HttpServletRequest request) {
        if (body.containsKey("pw")) {
            if (!body.get("pw").equals("restartnow")) {
                return "{\"status\":\"error\", \"message\":\"Invalid password\"}";
            }
            else {
                String ipAddress = request.getRemoteAddr();
                System.out.println("Restart requested by: " + ipAddress);
                bootstrapService.resetNow();
                return "{\"status\":\"ok\"}";
            }
        }
        else {
            return "{\"status\":\"error\", \"message\":\"No password supplied\"}";
        }

    }


}
