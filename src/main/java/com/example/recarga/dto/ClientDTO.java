package com.example.recarga.dto;
import com.example.recarga.entity.Client;

public class ClientDTO {

    private Long id;
    private String name;
    private Integer phone;

    public ClientDTO(Long id, Integer phone, String name) {
        this.id = id;
        this.phone = phone;
        this.name = name;
    }

    public ClientDTO(Client client) {
        id = client.getId();
        phone = client.getPhone();
        name = client.getName();
    }

    public Integer getPhone() {
        return phone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }
}
