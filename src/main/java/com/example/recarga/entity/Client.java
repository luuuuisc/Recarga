package com.example.recarga.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer phone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Recharge> recharge = new ArrayList<>();

    public Client(){

    }


    public Long getId() {
        return id;
    }

    public List<Recharge> getRecharge() {
        return recharge;
    }

    public Integer getPhone() {
        return phone;
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
