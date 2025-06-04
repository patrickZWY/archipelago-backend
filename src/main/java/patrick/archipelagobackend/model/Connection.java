package patrick.archipelagobackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Connection {
    private Long id;
    private String toMovieIMDbId;
    private String fromMovieIMDbId;
    private String reason;
    private User user;

    @Builder.Default
    private double weight = 1.0;

}
