package dto;


//{
//        "id": "string",
//        "name": "string",
//        "lastName": "string",
//        "email": "string",
//        "phone": "8868733815541",
//        "address": "string",
//        "description": "string"
//        }

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ContactDTO {
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String address;
    private String description;






}
