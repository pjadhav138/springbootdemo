package com.tap4lap.api.services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tap4lap.api.Utils;
import com.tap4lap.api.model.ImageData;
import com.tap4lap.api.repository.ImageRepository;

@Service
public class ImageService {
	
	@Autowired
	private ImageRepository repository;
	
	public String uploadImage(MultipartFile file) throws IOException {
		ImageData image = this.repository.save(ImageData.builder()
				.name(file.getOriginalFilename())
				.resource(file.getName())
				.type(file.getContentType())
				.image(Utils.compress(file.getBytes()))
				.build());
		Optional<ImageData> img = Optional.ofNullable(image);
		if(img.isPresent()) {
			System.out.println(file.getName());
			System.out.println(file.getOriginalFilename());
			return "File uploaded successfully " + file.getOriginalFilename();
			
		}
		return "Something went wrong!";
	}
	
	public byte[] downloadImage(String file) {
		Optional<ImageData> img = this.repository.findByName(file);
		byte[] images = Utils.decompress(img.get().getImage());
		return images;
	}

}