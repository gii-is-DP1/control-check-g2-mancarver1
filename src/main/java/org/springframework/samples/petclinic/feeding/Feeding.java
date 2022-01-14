package org.springframework.samples.petclinic.feeding;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Pet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "feedings")

public class Feeding extends BaseEntity{
	
	@Autowired
	@NotNull
	@NotEmpty
	@Column(name = "start_date")        
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate startDate;
	
	@Column(name = "weeks_duration")        
	@Min(1)
    private double weeksDuration;
	
	@Autowired
	@NotEmpty
	@NotNull
	@ManyToOne
     private Pet pet;   
	
	@ManyToOne
	@NotNull
	@JoinColumn(name="feeding_type_id")
	FeedingType feedingType;
}

