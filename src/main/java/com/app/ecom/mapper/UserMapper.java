package com.app.ecom.mapper;

import com.app.ecom.dto.AddressDto;
import com.app.ecom.dto.UserRequest;
import com.app.ecom.dto.UserResponse;
import com.app.ecom.model.Address;
import com.app.ecom.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserMapper {
    public static UserResponse mapToUserResponse(User user){
        UserResponse response=new UserResponse();
        response.setId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setRole(user.getRole());
        if(user.getAddress()!=null){
            AddressDto addressDto=new AddressDto();
            addressDto.setCity(user.getAddress().getCity());
            addressDto.setState(user.getAddress().getState());
            addressDto.setCountry(user.getAddress().getCountry());
            addressDto.setStreet(user.getAddress().getStreet());
            addressDto.setZipcode(user.getAddress().getZipcode());
            response.setAddress(addressDto);

        }
        return response;
    }
    public static void updateUserFromRequest(User user, UserRequest request){
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        if(request.getAddress()!=null){
            Address address=new Address();
            address.setCity(request.getAddress().getCity());
            address.setCountry(request.getAddress().getCountry());
            address.setStreet(request.getAddress().getStreet());
            address.setZipcode(request.getAddress().getZipcode());
            address.setState(request.getAddress().getState());
            user.setAddress(address);
        }
        }

}
