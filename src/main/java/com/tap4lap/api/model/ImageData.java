package com.tap4lap.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_img")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class ImageData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String resource;
	private String type;
	
	// This array will be used to store binary data and to perform
	// operation on binary data, we need to annotate it with @Lob
	@Lob
	private byte[] image;
}
