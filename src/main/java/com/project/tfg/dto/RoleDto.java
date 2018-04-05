package com.project.tfg.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

public class RoleDto {
	
    public static final String ROLE_ADMIN = "role.admin";
    public static final String ROLE_SELLER_ADMIN = "role.seller.admin";
    public static final String ROLE_SELLER = "role.seller";
    public static final String ROLE_BUYER = "role.buyer";
	private String id;

    private String code;

    private List<PermissionDto> permissions = new ArrayList<>();

	public RoleDto(String roleBuyer) {
		this.id  = roleBuyer;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


    public String getCode() {
        return this.code;
    }

    public void setCode(String name) {
        this.code = name;
    }

    @JsonIgnore
	public List<PermissionDto> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PermissionDto> permissions) {
		this.permissions = permissions;
	}
	
	public static RoleDto Create_Admin(){
		return new RoleDto(RoleDto.ROLE_ADMIN);
	}
	
	public static RoleDto Create_Seller_Admin(){
		return new RoleDto(RoleDto.ROLE_SELLER_ADMIN);
	}
	
	public static RoleDto Create_Seller(){
		return new RoleDto(RoleDto.ROLE_SELLER);
	}
	
	public static RoleDto Create_Buyer(){
		return new RoleDto(RoleDto.ROLE_BUYER);
	}
	
	public static boolean checkUserIs_Admin(UserDto user){
		return checkUserType(user, RoleDto.Create_Admin());
	}
	
	public static boolean checkUserIs_Seller_Admin(UserDto user){
		return checkUserType(user, RoleDto.Create_Seller_Admin());
	}
	


	
	public static boolean checkUserType(UserDto user, RoleDto... roles){
		
		for(RoleDto checkRole : roles){
			
			if(user.getRoles().contains(checkRole))
				return true;
				
		}

		return false;
		
		
	}
	
	
	
}
