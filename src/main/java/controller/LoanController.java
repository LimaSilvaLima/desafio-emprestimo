package controller;

import java.util.HashMap;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.hibernate.mapping.Map;
//import org.springframework.data.crossstore.HashMapChangeSet;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.CustomerRequestDTO;
import dto.LoanResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import service.LoanSevice;

//import java.util.Collection;
//import java.util.Iterator;
import java.util.Map;
//import java.util.Set;
//import java.util.Map.Entry;
//import java.util.Optional;
//import java.util.hashSet;
//import java.util.set;
//import java.util.LinkedHashSet;


@Getter
@Setter
@AllArgsConstructor
@RestController
@RequestMapping("/customer-loans")
public class LoanController {

    @Autowired
    private LoanSevice loanSevice;

	@PostMapping
    public Map<String, Object > getAvailableLoans(@RequestBody CustomerRequestDTO customerRequestDTO) {
       
        List<LoanResponseDTO> loans = loanSevice.determineLoans(customerRequestDTO);

        Map<String, Object> response = new HashMap<>();
        response.put("customer", customerRequestDTO.getName());
        response.put("loans", loans);

        return response;
    }
	        

}
