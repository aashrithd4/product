package com.example.spbootProduct.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="product")
public class product implements Serializable {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="description")
    private String description;
    @Column(name="price")
    private int price;
    @Column(name="createtimestamp")
    @CreationTimestamp
    private Date createdAt;
    @Column(name="updatetimestamp")
    @UpdateTimestamp
    private Date updatedAt;
    @Column(name = "name")
    private String name;

}
