package com.callforcode.eluf.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.callforcode.eluf.model.enums.Profile;
import com.callforcode.eluf.model.enums.TypeClient;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	@Column(unique = true)
	private String email;
	private String cpfOrCnpj;
	private Integer type;

	@JsonIgnore
	private String password;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Address> adresses = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "PHONE")
	private Set<String> phone = new HashSet<>();

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PROFILES")
	private Set<Integer> profiles = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
	
	public Client() {
		addProfile(Profile.CLIENT);
	}

	public Client(Integer id, String name, String email, String cpfOrCnpj, TypeClient type, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpfOrCnpj = cpfOrCnpj;
		this.type = (type == null) ? null : type.getCod();
		this.password = password;
		addProfile(Profile.CLIENT);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOrCnpj() {
		return cpfOrCnpj;
	}

	public void setCpfOrCnpj(String cpfOrCnpj) {
		this.cpfOrCnpj = cpfOrCnpj;
	}

	public TypeClient getTipo() {
		return TypeClient.toEnum(type);
	}

	public void setType(TypeClient type) {
		this.type = type.getCod();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Profile> getProfiles() {
		return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
	}

	public void addProfile(Profile profile) {
		profiles.add(profile.getCod());
	}

	public List<Address> getAddresses() {
		return adresses;
	}

	public void setAddresses(List<Address> adresses) {
		this.adresses = adresses;
	}

	public Set<String> getPhone() {
		return phone;
	}

	public void setPhone(Set<String> phone) {
		this.phone = phone;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
