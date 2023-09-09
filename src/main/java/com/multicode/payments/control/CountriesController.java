package com.multicode.payments.control;

import com.multicode.payments.service.CCUtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
@CrossOrigin
public class CountriesController {

    @Autowired
    CCUtilsService service;

    @ResponseBody
    @GetMapping(produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<String> getAllCountries() {
        return service.getAllCountries();
    }
}
