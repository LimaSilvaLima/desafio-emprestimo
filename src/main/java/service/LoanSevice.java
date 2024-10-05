package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dto.CustomerRequestDTO;
import dto.LoanResponseDTO;

@Service
public class LoanSevice {

    public List<LoanResponseDTO> determineLoans(CustomerRequestDTO customerRequestDTO){
       
       int age = customerRequestDTO.getAge();
       double income = customerRequestDTO.getIncome();
       String location = customerRequestDTO.getLocation();
       String cpf = customerRequestDTO.getCpf();
       String name = customerRequestDTO.getName();

       List<LoanResponseDTO> loans = new ArrayList<>();
       
       if (income <= 3000) {
        loans.add(new LoanResponseDTO("PERSONAL", 4));
        loans.add(new LoanResponseDTO("GUARANTEED", 3));
    }
        if (income <= 5000) {
            loans.add(new LoanResponseDTO("GUARANTEED", 3));
        }
        if (income >3000 && income <= 5000 &&  age < 30 && "SP".equalsIgnoreCase(location)) {
            loans.add(new LoanResponseDTO("PERSONAL", 4));
            loans.add(new LoanResponseDTO("GUARANTEED", 3));
        }

        return loans;
    }

}


