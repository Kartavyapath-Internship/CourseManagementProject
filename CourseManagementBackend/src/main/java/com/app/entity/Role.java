package com.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Role extends BaseEntity {
	
	@Column(name = "name",nullable = false,length = 30)
	private String name;
	
	@Column(name = "description",nullable = false,length = 200)
	private String description;
	
	
	@ManyToMany
    @JoinTable(
        name = "role_permissions", // name of the join table
        joinColumns = @JoinColumn(name = "role_id"), // foreign key for the course
        inverseJoinColumns = @JoinColumn(name = "menu_id") // foreign key for the staff member
    )
	@JsonIgnore
	private List<MenuItems> menuitems;
	
}
