package by.peretz.spring.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
//@RequiredArgsConstructor
@NoArgsConstructor
public class Beer extends AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String name;

  @NonNull
  private Double volumeOfBottle;

  @NonNull
  private Integer numberOfBottle;

  @NotBlank
  private String description;

  @NonNull
  private BigDecimal price;

    @Override
  public String toString() {
    return String.format("Id: %d \nName: %s \nVolumeOfBottle: %2f \nNumberOfBottle: %d \nDescription: %s \nPrice: %.2f$\n\n",
            getId(), getName(), getVolumeOfBottle(), getNumberOfBottle(), getDescription(), getPrice());
  }
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Long id;
//
//  @NotEmpty
//  @NonNull
//  private String species;
//  @NotEmpty
//  @NonNull
//  private String sex;
//  @NotEmpty
//  @NonNull
//  private String name;
//
//  @NotNull
//  @DateTimeFormat(pattern = "yyyy-MM-dd")
//  private LocalDate birth;
//
//  @ManyToOne
//  private User animalOwner;
}
