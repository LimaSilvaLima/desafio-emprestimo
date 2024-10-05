package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerRequestDTO {
    private int age ;
    private String cpf;
    private String name;
    private double income;
    private String location;
    
}
