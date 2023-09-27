package com.chatapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String userName;

    private String firstName;

    private String lastName;

    private String gmail;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private Long age;
}
